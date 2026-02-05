# Write your MySQL query statement below
select
    case
        when id % 2 = 1 then case when (select max(id) from Seat) = id then id else id + 1 end
        else id - 1
    end as id,
    student
from Seat
order by id
