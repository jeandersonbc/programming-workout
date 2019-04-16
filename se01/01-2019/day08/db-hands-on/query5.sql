-- For each department ID retrieve the number of employees in the department
select DEP_ID, count(DEP_ID) from EMPLOYEES group by DEP_ID;

-- For each department retrieve the number of employees in the
-- department, and the average employees salary in the department.
select DEP_ID, count(DEP_ID) as num_employees, avg(SALARY) as avg_salary
from EMPLOYEES
group by DEP_ID;


-- Limit the result to departments with fewer than four employees
-- and order the result by the average salary.
select DEP_ID, count(*) as num_employees, avg(SALARY) as avg_salary
from EMPLOYEES
group by DEP_ID having count(*) < 4
order by avg_salary;
