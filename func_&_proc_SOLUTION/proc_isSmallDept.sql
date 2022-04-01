Create or Replace procedure COMPANY_isSmallDept_Proc(deptNum int, minLimit int,  answer OUT integer)
AS
    	numEmps int :=0;
Begin
	answer := 0;
	Select Count(*) into numEmps from Company_Employee where dno = deptNum;
	If  (numEmps<minLimit) Then
            answer := 1;
	End If;
End; 

set serveroutput on;
declare 
  xy Integer;
begin
  COMPANY_isSmallDept_Proc(1,2,xy);
  DBMS_OUTPUT.PUT_LINE(xy);
end;
