Create or Replace function COMPANY_isSmallDept_Func(deptNum int, minLimit int) Return INTEGER
  AS
    numEmps int :=0;
    answer int := 0;
	Begin
		Select Count(*) into numEmps from Company_Employee where dno = deptNum;
		If  (numEmps<minLimit) Then
			answer := 1;
		End If;
		Return  answer;
	End ;
/* can be invoked using the following:
select COMPANY_isSmallDept_Func(1,2) from dual;
*/

