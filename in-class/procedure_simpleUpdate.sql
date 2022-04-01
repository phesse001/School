-- A procedure that updates the name of a department given its number
Create or Replace Procedure COMPANY_updateDeptName_Proc(deptNum int, deptName Varchar)
  AS
	begin
		update Company_Department set Dname = deptName where dnumber = deptNum;
	End;

/* can be invoked using the following

execute COMPANY_updateDeptName_Proc(5,'TEST');

*/
