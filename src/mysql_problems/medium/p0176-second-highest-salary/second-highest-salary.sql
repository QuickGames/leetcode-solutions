# Write your MySQL query statement below
select max(e.salary) as SecondHighestSalary
from Employee as e
    inner join (select max(salary) as max_salary from Employee) as em
        on e.salary < em.max_salary
