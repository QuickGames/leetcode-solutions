/* Write your T-SQL query statement below */
select d.name Department, e.name Employee, e.Salary
from (select departmentId, max(salary) max_salary from Employee group by departmentId) eg
    left join Employee e
        on eg.departmentId = e.departmentId and eg.max_salary = e.salary
    left join Department d
        on eg.departmentId = d.id