-- Write your PostgreSQL query statement below
select d.name as Department, e.name as Employee, e.salary as Salary 
from Employee as e
    left join Department as d
        on e.departmentId = d.id 
where e.salary in(select salary
                  from Employee eg
                  where e.departmentId = eg.departmentId
                  group by departmentId, salary
                  order by salary desc
                  limit 3)