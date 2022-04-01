Create or Replace Function ProductDeals_Cust_Trans_Func(CN int) Return int
AS
    numTrans int := 0;
        Begin
            Select Count(*) into numTrans from PRODUCTDEALS_TRANS PDT where CN= PDT.CUSTOMER_NUMBER;
            If  (numTrans<0) Then
                 numTrans:=0;
            End If;
            Return  numTrans;
        End ;
        
SELECT * FROM ProductDeals_TRANS WHERE CUSTOMER_NUMBER='124';
SELECT ProductDeals_CUST_TRANS_Func('124') from DUal;
SELECT * FROM ProductDeals_TRANS WHERE CUSTOMER_NUMBER='111';
SELECT ProductDeals_CUST_TRANS_Func('111')  from DUal;

--TRANS TRANS_DAT CUS
------- --------- ---
--12489 02-SEP-02 124
--12500 05-SEP-02 124
--
--
--PRODUCTDEALS_CUST_TRANS_FUNC('124')
-------------------------------------
--                                  2
--
--no rows selected
--
--PRODUCTDEALS_CUST_TRANS_FUNC('111')
-------------------------------------
--                                  0