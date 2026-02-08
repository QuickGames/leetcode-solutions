/* Write your PL/SQL query statement below */
select e.name
from (select managerId
        from Employee
        group by managerId
        having 5 <= count(*)) m
    inner join Employee e
        on m.managerId = e.id