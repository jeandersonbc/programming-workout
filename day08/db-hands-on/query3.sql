-- Retrieve all employees in department 5 whose salary is
-- between 60000 and 70000
select * from EMPLOYEES where (SALARY between 60000 and 70000) and DEP_ID = 5;

-- ...another way
select * from EMPLOYEES where SALARY >= 60000 and SALARY <= 70000 and DEP_ID = 5;
