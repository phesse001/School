--Query 1
SELECT CUSTOMER_NUMBER, LAST, FIRST, CREDIT_LIMIT - BALANCE AS AVAILABLE_CREDIT 
FROM ProductDeals_CUSTOMER
WHERE CREDIT_LIMIT >= 1500
ORDER BY AVAILABLE_CREDIT DESC, LAST ASC;

--CUS LAST       FIRST      AVAILABLE_CREDIT
----- ---------- ---------- ----------------
--256 Samuels    Ann                  1478.5
--522 Nelson     Mary                1401.25
--405 William    Al                  1097.25
--412 Adams      Sally                 182.5

--Query 2
SELECT CUSTOMER_NUMBER, LAST, FIRST, BALANCE, SLSREP_NUMBER
FROM ProductDeals_CUSTOMER PDC1
WHERE PDC1.SLSREP_NUMBER <> 12 AND BALANCE > ANY (
    SELECT BALANCE
    FROM ProductDeals_CUSTOMER PDC2
    WHERE PDC2.SLSREP_NUMBER = 12);
    
--CUS LAST       FIRST         BALANCE SL
----- ---------- ---------- ---------- --
--412 Adams      Sally          1817.5 03
--622 Martin     Dan           1045.75 03
--124 Adams      Sally          818.75 03
--315 Daniels    Tom            770.75 06
--567 Dinh       Tran            402.4 06
--587 Galvez     Mara            114.6 06

--Query 3
SELECT CUSTOMER_NUMBER LAST, FIRST
FROM ProductDeals_Customer PDC
WHERE PDC.CUSTOMER_NUMBER NOT IN (
    SELECT CUSTOMER_NUMBER
    FROM ProductDeals_TRANS
    WHERE TRANS_DATE = '05-SEP-02');
    
--LAS FIRST     
----- ----------
--315 Tom       
--405 Al        
--587 Mara      
--622 Dan       
--311 Don       
--412 Sally     
--567 Tran      
--256 Ann   

--Query 4
SELECT DISTINCT PDC1.CUSTOMER_NUMBER, PDC2.CUSTOMER_NUMBER
FROM ProductDeals_CUSTOMER PDC1, ProductDeals_CUSTOMER PDC2
WHERE PDC1.FIRST = PDC2.FIRST AND PDC1.LAST = PDC2.LAST AND PDC1.CUSTOMER_NUMBER <> PDC2.CUSTOMER_NUMBER;

--CUS CUS
----- ---
--412 124
--124 412

--Query 5
SELECT CUSTOMER_NUMBER, LAST, FIRST
FROM ProductDeals_CUSTOMER
WHERE SLSREP_NUMBER = 12
UNION
SELECT CUSTOMER_NUMBER, LAST, FIRST
FROM ProductDeals_CUSTOMER PDC1
WHERE PDC1.CUSTOMER_NUMBER NOT IN (
    SELECT CUSTOMER_NUMBER
    FROM ProductDeals_TRANS);
    
--CUS LAST       FIRST     
----- ---------- ----------
--311 Charles    Don       
--405 William    Al        
--412 Adams      Sally     
--522 Nelson     Mary      
--567 Dinh       Tran      
--587 Galvez     Mara      
--622 Martin     Dan   

--Query 6
SELECT CUSTOMER_NUMBER, LAST, FIRST
FROM ProductDeals_CUSTOMER
WHERE SLSREP_NUMBER = 6 AND NOT CREDIT_LIMIT < ANY(
    SELECT CREDIT_LIMIT 
    FROM ProductDeals_CUSTOMER
    WHERE SLSREP_NUMBER = 6);
    
--CUS LAST       FIRST     
----- ---------- ----------
--256 Samuels    Ann    

--Query 7
SELECT C1.CUSTOMER_NUMBER, C1.LAST, C1.FIRST, C1.BALANCE, C1.SLSREP_NUMBER
FROM ProductDeals_CUSTOMER C1
WHERE C1.BALANCE > ALL(
    SELECT C2.BALANCE
    FROM ProductDeals_CUSTOMER C2
    WHERE C2.SLSREP_NUMBER = 12);
    
--CUS LAST       FIRST         BALANCE SL
----- ---------- ---------- ---------- --
--622 Martin     Dan           1045.75 03
--412 Adams      Sally          1817.5 03

--Query 8
SELECT CUSTOMER_NUMBER, LAST, FIRST
FROM ProductDeals_CUSTOMER PDC
WHERE NOT EXISTS (
    SELECT * 
    FROM ProductDeals_PART PDP
    WHERE UNIT_PRICE < 20 AND NOT EXISTS (
        SELECT *
        FROM ProductDeals_TRANSPART PDTP, ProductDeals_TRANS PDT
        WHERE PDT.CUSTOMER_NUMBER = PDC.CUSTOMER_NUMBER AND PDTP.PART_NUMBER = PDP.PART_NUMBER AND PDTP.TRANS_NUMBER = PDT.TRANS_NUMBER));


--CUS LAST       FIRST     
----- ---------- ----------
--522 Nelson     Mary   

--Query 9
SELECT CUSTOMER_NUMBER, LAST, FIRST
FROM ProductDeals_CUSTOMER PDC
WHERE NOT EXISTS (
    SELECT PART_NUMBER
    FROM ProductDeals_PART
    WHERE UNIT_PRICE < 20
    MINUS
    SELECT PART_NUMBER
    FROM ProductDeals_TRANSPART PDTP, ProductDeals_TRANS PDT
    WHERE PDTP.TRANS_NUMBER = PDT.TRANS_NUMBER AND PDT.CUSTOMER_NUMBER = PDC.CUSTOMER_NUMBER);
    
--CUS LAST       FIRST     
----- ---------- ----------
--522 Nelson     Mary      

--Query 10
SELECT TRANS_NUMBER, SUM( NUMBER_ORDERED * QUOTED_PRICE ) AS "tdv"
FROM PRODUCTDEALS_TRANSPART
GROUP BY TRANS_NUMBER
HAVING SUM( NUMBER_ORDERED * QUOTED_PRICE ) > 200;

--TRANS        tdv
------- ----------
--12494    1119.96
--12489     241.45
--12491     549.98
--12504     651.98

--Query 11
SELECT SUM( PDTP.NUMBER_ORDERED ) AS total_ordered, PDTP.PART_NUMBER
FROM ProductDeals_TRANSPART PDTP, ProductDeals_TRANS PDT
WHERE trunc(PDT.TRANS_DATE) >= to_date('09/01/2002','MM-DD-YYYY') 
  AND trunc(PDT.TRANS_DATE) < to_date('10/01/2002','MM-DD-YYYY')AND PDT.TRANS_NUMBER = PDTP.TRANS_NUMBER
GROUP BY PDTP.PART_NUMBER;

--TOTAL_ORDERED PART
--------------- ----
--            4 CB03
--            2 CX11
--            4 BA74
--            2 CZ81
--           11 AX12
--            2 AZ52
--            2 BT04
--            1 BZ66
--
--8 rows selected. 


--Query 12
SELECT CREDIT_LIMIT, COUNT(*) AS TOTAL_COUNT
FROM ProductDeals_CUSTOMER
WHERE SLSREP_NUMBER = 6
GROUP BY CREDIT_LIMIT
HAVING COUNT(*) > 1;

--CREDIT_LIMIT TOTAL_COUNT
-------------- -----------
--         750           2

--Query 13
SELECT CUSTOMER_NUMBER, LAST, FIRST
FROM ProductDeals_CUSTOMER
WHERE SLSREP_NUMBER = 6 AND CREDIT_LIMIT >= (
    SELECT MAX(CREDIT_LIMIT)
    FROM ProductDeals_CUSTOMER
    WHERE SLSREP_NUMBER = 6);
    
--CUS LAST       FIRST     
----- ---------- ----------
--256 Samuels    Ann     

--Query 14
SELECT PDP.PART_NUMBER, PDP.PART_DESCRIPTION, PDT.TRANS_NUMBER
FROM ProductDeals_PART PDP
LEFT OUTER JOIN PRODUCTDEALS_TRANSPART PDT ON PDP.PART_NUMBER = PDT.PART_NUMBER
ORDER BY PART_NUMBER;

--PART PART_DESCRIP TRANS
------ ------------ -----
--AX12 Iron         12489
--AZ52 Dartboard    12498
--BA74 Basketball   12498
--BH22 Cornpopper        
--BT04 Gas Grill    12491
--BT04 Gas Grill    12500
--BZ66 Washer       12491
--CA14 Griddle           
--CB03 Bike         12494
--CX11 Blender      12495
--CZ81 Treadmill    12504

--Query 15
UPDATE ProductDeals_PART PDP
SET UNITS_ON_HAND = UNITS_ON_HAND * 2
WHERE (SELECT 
       SUM(NUMBER_ORDERED)
       FROM ProductDeals_TRANSPART PDTP
       WHERE PDTP.PART_NUMBER = PDP.PART_NUMBER) > 10;
SELECT * FROM ProductDeals_Part;

--PART PART_DESCRIP UNITS_ON_HAND UNIT_PRICE
------ ------------ ------------- ----------
--AX12 Iron                   208      24.95
--AZ52 Dartboard               20      12.95
--BA74 Basketball              40      29.95
--BH22 Cornpopper              95      25.95
--BT04 Gas Grill               11     149.99
--BZ66 Washer                  52     399.99
--CA14 Griddle                 78      39.99
--CB03 Bike                    44     399.99
--CX11 Blender                112      22.95
--CZ81 Treadmill               68     349.95