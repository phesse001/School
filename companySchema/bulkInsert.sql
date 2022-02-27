DROP TABLE company_dept_info CASCADE CONSTRAINTS;
CREATE TABLE  company_dept_info (
	dept_num    INTEGER,
	dept_name   VARCHAR(20),
	no_of_emps  INTEGER,
	total_sal   DECIMAL
	);
	
INSERT INTO company_dept_info(dept_num , dept_name, no_of_emps, total_sal)(
	SELECT		dnumber,dname, count(*), sum(salary)
	FROM		company_department, company_employee
	WHERE		dnumber=dno
	GROUP BY	dnumber,dname);
