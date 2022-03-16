-- A function that returns the number of employees in a given department
Create or Replace Function COMPANY_numEmps_Func(deptNum int) Return int
AS 
	numEmps int := 0;
	Begin
		Select Count(*) into numEmps from Company_Employee where dno = deptNum;
		If  (numEmps<0) Then
			 numEmps:=0;
		End If;
		Return  numEmps;
	End ;


/* 
can be invoked using the following (provided it contains no insert/update/delete statements)

Select COMPANY_numEmps_Func(8) from dual; 

-- more on the dual table http://www.adp-gmbh.ch/ora/misc/dual.html

OR

set serveroutput on;
declare
  x number;
begin
  x := COMPANY_numEmps_Func(8);
  DBMS_OUTPUT.PUT_LINE(x);
end;

*/
