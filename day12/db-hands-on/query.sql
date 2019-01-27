-- Problem 7: Using INNER JOIN, find the minimum “Average Student Attendance”
-- for community area where hardship is 96
select min(S."Average_Student_Attendance") as min_avg_student_attendance
from CHICAGO_PUBLIC_SCHOOLS S
  inner join CENSUS_DATA D on S."Community_Area_Number" = D."Community_Area_Number"
where D."HARDSHIP_INDEX" = 96 
