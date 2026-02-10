# Write your MySQL query statement below
select *
from Patients
where conditions regexp '(\\s|^)\\bDIAB1\\w*'