# Write your MySQL query statement below
select d.name as Department, e.name as Employee, em.Salary as Salary
from Employee as e
    inner join (select departmentId, max(salary) as Salary
               from Employee
               group by departmentId) as em
        on e.departmentId = em.departmentId and e.salary = em.Salary
    left join Department as d
        on e.departmentId = d.id

-- select d.name, max(e.salary) as Salary
-- from Employee as e
--     left join Department as d
--         on e.departmentId = d.id
-- group by e.departmentId