/* Write your T-SQL query statement below */
select l.num as ConsecutiveNums
from Logs as l
    inner join (select id + 1 as id1, num from Logs) as l1
        on l.id = l1.id1 and l.num = l1.num
    inner join (select id + 2 as id2, num from Logs) as l2
        on l.id = l2.id2 and l.num = l2.num
group by l.num
having 0 < count(*)