--Query 1 --- Inner Joins 
SELECT  e.lname, d.dname
FROM    COMPANY_EMPLOYEE e, COMPANY_DEPARTMENT d
WHERE   e.ssn = d.mgrssn;

SELECT  e.lname, d.dname
FROM    (COMPANY_EMPLOYEE e JOIN COMPANY_DEPARTMENT d on e.ssn = d.mgrssn);

--Query 1 --- Outer Joins 

SELECT  e.lname, d.dname
FROM    (COMPANY_EMPLOYEE e LEFT OUTER JOIN COMPANY_DEPARTMENT d on e.ssn = d.mgrssn);

SELECT  e.lname, d.dname
FROM    (COMPANY_EMPLOYEE e LEFT JOIN COMPANY_DEPARTMENT d on e.ssn = d.mgrssn);

SELECT  distinct essn, dependent_name
FROM    (COMPANY_WORKS_ON NATURAL LEFT JOIN COMPANY_DEPENDENT) ;

SELECT  e.lname, d.dname
FROM    COMPANY_EMPLOYEE e, COMPANY_DEPARTMENT d
WHERE   e.ssn = d.mgrssn (+);