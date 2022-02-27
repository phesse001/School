--Query 0
SELECT 	'Query 0', fname, lname
FROM    Company_Employee
WHERE   lname like '%t%';

--Query 1
SELECT 	'Query 1',concat(lname, concat(',', fname)) AS FullName
FROM    Company_Employee
WHERE   lname like '%t%';

--Query 2
SELECT 	'Query 2',concat(lname, concat(',', fname)) AS FullName
FROM    Company_Employee
--WHERE   lname like  'Smythe';
WHERE soundex(lname) =  soundex('Smythe');


--Query 3
SELECT  'Query 03',E.fname, E.lname, S.fname, S.lname 
FROM    (Company_Employee E JOIN Company_Employee S ON E.superssn=S.ssn)
WHERE   E.salary > S.Salary;

--FNAME           LNAME           FNAME           LNAME         
----------------- --------------- --------------- ---------------
--Jenny           Vos             Josh            Zell           
--Lyle            Leslie          Jill            Jarvis         
--Jon             Kramer          Lyle            Leslie         
--Ray             King            Billie          King           
--Naveen          Drew            Gerald          Small          
--Sammy           Hall            Carl            Reedy          

--Query 4
SELECT  'Query 4',fname, lname, bdate
FROM    Company_Employee
WHERE   trunc (BDATE) >= to_date('01-01-1950','MM-DD-YYYY') and  
        trunc (BDATE) < to_date('01-01-1960','MM-DD-YYYY') and
        dno IN  (SELECT	dnumber	  
 				 FROM	COMPANY_DEPARTMENT
 				 WHERE 	dname='Research' );
--FNAME           LNAME           BDATE   
----------------- --------------- ---------
--Ramesh          Narayan         15-SEP-52
--John            Smith           09-JAN-55

--Query 5
SELECT  'Query 5',lname
FROM    Company_Employee
WHERE   NOT EXISTS (
            SELECT  *  
            FROM    Company_Project  
            WHERE   dnum=1 AND NOT EXISTS (
                                SELECT  *
                                FROM    Company_Works_On WO
                                WHERE   ssn=WO.essn AND WO.pno=pnumber));

--LNAME         
-----------------
--Wallace        
--Wong           
--Borg 


--Query 6
SELECT  'Query 6',lname 
FROM    Company_Employee
WHERE   NOT EXISTS (
                (SELECT Pnumber   
                FROM    Company_Project  
                WHERE   dnum=1)
           Minus
                (SELECT PNO
                FROM    Company_Works_On WO
                WHERE  ssn=WO.essn));
    
--LNAME         
-----------------
--Wallace        
--Wong           
--Borg 
