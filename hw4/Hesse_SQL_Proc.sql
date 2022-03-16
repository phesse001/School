Create or Replace Procedure ProductDeals_Up_LIMIT_Proc(cnum int, pnum int)
    AS
        BEGIN
            UPDATE PRODUCTDEALS_CUSTOMER
            SET CREDIT_LIMIT = CREDIT_LIMIT + CREDIT_LIMIT * .1
            WHERE cnum IN (
                SELECT CUSTOMER_NUMBER
                FROM PRODUCTDEALS_TRANS PDT
                WHERE PDT.TRANS_NUMBER IN (
                    SELECT TRANS_NUMBER
                    FROM PRODUCTDEALS_TRANSPART
                    WHERE pnum = PART_NUMBER));
        END;
            
        
SELECT CREDIT_LIMIT FROM ProductDeals_CUSTOMER WHERE CUSTOMER_NUMBER='124';
EXEC ProductDeals_Up_LIMIT_Proc('124','AX12');
SELECT CREDIT_LIMIT FROM ProductDeals_CUSTOMER WHERE CUSTOMER_NUMBER='124';
SELECT CREDIT_LIMIT FROM ProductDeals_CUSTOMER WHERE CUSTOMER_NUMBER='124';
EXEC ProductDeals_Up_LIMIT_Proc('124', 'BZ66');
SELECT CREDIT_LIMIT FROM ProductDeals_CUSTOMER WHERE CUSTOMER_NUMBER='124';