-- used to specify comments in sql scripts

-- EMPLOYEE
DROP TABLE company_employee CASCADE CONSTRAINTS;
CREATE TABLE company_employee (
  fname    varchar(15) not null, 
  minit    varchar(1),
  lname    varchar(15) not null,
  ssn      char(9),
  bdate    date,
  address  varchar(50),
  sex      char check (sex  in ('M','F')),
  salary   decimal(10,2),
  superssn char(9),
  dno      integer,
  primary key (ssn)
);

-- DEPARTMENT
DROP TABLE company_department CASCADE CONSTRAINTS;
CREATE TABLE company_department (
  dname        varchar(25) not null,
  dnumber      integer,
  mgrssn       char(9) not null, 
  mgrstartdate date,
  primary key (dnumber),
  unique (dname),
  Constraint FK_Department foreign key (mgrssn) references company_employee(ssn)
) ;

-- ADD FOREIGN KEY CONSTRAINST TO EMPLOYEE: superssn references ssn and dno references dnumber
Alter Table company_employee ADD CONSTRAINT FK_Employee1 foreign key (superssn) references company_employee(ssn);
Alter Table company_employee ADD CONSTRAINT FK_Employee2 foreign key (dno) references company_department(dnumber);

-- DEPENDENT
DROP TABLE company_dependent CASCADE CONSTRAINTS;
CREATE TABLE company_dependent (
  essn           char(9),
  dependent_name varchar(15),
  sex            char,
  bdate          date,
  relationship   varchar(8),
  primary key (essn,dependent_name),
  Constraint FK_Dependent foreign key (essn) references company_employee(ssn)
);

-- DEPT_LOCATIONS
DROP TABLE company_dept_locations CASCADE CONSTRAINTS;
CREATE TABLE company_dept_locations (
  dnumber   integer,
  dlocation varchar(15), 
  primary key (dnumber,dlocation),
  Constraint FK_Dept_Locations foreign key (dnumber) references company_department(dnumber)
);

-- PROJECT
DROP TABLE company_project CASCADE CONSTRAINTS;
CREATE TABLE company_project (
  pname      varchar(25) not null,
  pnumber    integer,
  plocation  varchar(15),
  dnum       integer,
  primary key (pnumber),
  unique (pname),
  Constraint FK_Project foreign key (dnum) references company_department(dnumber)
);

-- WORKS_ON
DROP TABLE company_works_on CASCADE CONSTRAINTS;
CREATE TABLE company_works_on (
  essn   char(9),
  pno    integer,
  hours  decimal(4,1),
  primary key (essn,pno),
  Constraint FK_Works_on1 foreign key (essn) references company_employee(ssn),
  Constraint FK_Works_on2 foreign key (pno) references company_project(pnumber)
);

