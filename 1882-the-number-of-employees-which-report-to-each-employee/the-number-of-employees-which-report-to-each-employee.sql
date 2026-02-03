# Write your MySQL query statement below
select e.employee_id, e.name, r.reports_count, round(r.average_age) as average_age
from Employees as e
    inner join (select reports_to, count(reports_to) as reports_count, avg(age) as average_age 
                from Employees
                where !isnull(reports_to)
                group by reports_to) as r
        on e.employee_id = r.reports_to
order by e.employee_id