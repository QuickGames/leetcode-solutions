/* Write your PL/SQL query statement below */
select t.contest_id, t.percentage
from (select r.contest_id,
            round(count(r.user_id) / (select count(*) from Users) * 100, 2) as percentage
        from Register r
        group by r.contest_id) t
order by t.percentage desc, t.contest_id