-- Write your PostgreSQL query statement below
select w.id
from Weather as w
    left join(select recordDate + 1 as recordDate, temperature from Weather) as w1
        on w.recordDate = w1.recordDate
where w1.temperature < w.temperature