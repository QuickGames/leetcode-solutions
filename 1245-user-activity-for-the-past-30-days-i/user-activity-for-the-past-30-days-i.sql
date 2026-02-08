-- Write your PostgreSQL query statement below
select activity_date as day, count(distinct user_id) as active_users
from Activity
where cast('2019-07-27' as date) - activity_date < 30
    and activity_date <= cast('2019-07-27' as date)
group by activity_date