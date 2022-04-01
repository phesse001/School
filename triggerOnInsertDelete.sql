-- WRITE ONE TRIGGER PER SQL SCRIPT FILE
CREATE or REPLACE TRIGGER COMPANY_INSERT_DELETE_TRIG
    AFTER INSERT OR DELETE ON Company_Employee
    For Each Row
	Begin 
        If INSERTING THEN
            UPDATE  COMPANY_DEPT_INFO 
            SET     NO_OF_EMPS=NO_OF_EMPS + 1,TOTAL_SAL = TOTAL_SAL+:NEW.salary 
            where   DEPT_NUM=:NEW.dno;    
        Else
            UPDATE  COMPANY_DEPT_INFO 
            SET     NO_OF_EMPS=NO_OF_EMPS - 1,TOTAL_SAL = TOTAL_SAL-:OLD.salary 
            where   DEPT_NUM=:OLD.dno;
        End If;
    End ;