-- Problem 1: Find the total number of records for each of the tables
select count(*) as num_records from CENSUS_DATA;
select count(*) as num_records from CHICAGO_CRIME_DATA;
select count(*) as num_records from CHICAGO_PUBLIC_SCHOOLS;

-- Problem 2: Find average college enrollments by community area
select "Community_Area_Number" as community_code,
	   avg("College_Enrollment__number_of_students_") as avg_enrollment
from CHICAGO_PUBLIC_SCHOOLS
group by "Community_Area_Number"
order by avg_enrollment desc;

-- Problem 3: Find the number of schools that are healthy school certified
select count("Name_of_School") as num_schools_certified
from CHICAGO_PUBLIC_SCHOOLS
where lcase("Healthy_Schools_Certified_") = 'yes';

-- Problem 4: How many observations have a Location Description value of GAS STATION?
select count("Location_Description") as freq_crimes
from CHICAGO_CRIME_DATA
where lcase("Location_Description") = 'gas station';

-- Problem 5: Retrieve a list of the top 10 community areas which have most
-- number of schools and sorted in descending order.
select "Community_Area_Name", count("School_ID") as num_schools
from CHICAGO_PUBLIC_SCHOOLS
group by "Community_Area_Name"
order by num_schools desc
limit 10;

-- Problem 6: How many observations have value MOTOR VEHICLE THEFT in the
-- Primary Type variable (this is the number of crimes related to Motor vehicles)
select count("Primary_Type") as count_motor_vehicle_thef
from CHICAGO_CRIME_DATA
where lcase("Primary_Type") = 'motor vehicle theft';
