CREATE OR REPLACE VIEW COMPANY_WORKS_ON_TOTALS_View AS
	SELECT		SSN,FNAME,LNAME,Sum(Hours) as TotalHours
	FROM 		Company_Employee,Company_Works_On
	WHERE 		SSN=ESSN 
	GROUP BY	SSN, FNAME,LNAME
	ORDER BY 	LNAME;
