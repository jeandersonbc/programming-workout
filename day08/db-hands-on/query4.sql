-- Retrieve a list of employees ordered by department ID
select * from EMPLOYEES order by DEP_ID;

-- Retrieve a list of employees ordered in descending order by
-- department ID and within each department ordered alphabetically
-- in descending order by last name
select * from EMPLOYEES order by DEP_ID desc, L_NAME desc;
