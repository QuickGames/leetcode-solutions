# Write your MySQL query statement below
select s.user_id, ifnull(round(ifnull(confirmed, 0) / (ifnull(timeout, 0) + ifnull(confirmed, 0)), 2), 0) as confirmation_rate
from Signups as s
    left join (select user_id, count(*) as timeout
            from Confirmations
            where action = "timeout"
            group by user_id) as t
        on s.user_id = t.user_id
    left join (select user_id, count(*) as confirmed
            from Confirmations
            where action = "confirmed"
            group by user_id) as c
        on s.user_id = c.user_id