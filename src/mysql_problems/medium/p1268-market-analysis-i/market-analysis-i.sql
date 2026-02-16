# Write your MySQL query statement below
select u.user_id as buyer_id, u.join_date as join_date,
    sum(case when o.order_id is null then 0 else 1 end) as orders_in_2019
from Users as u
    left join Orders as o
        on u.user_id = o.buyer_id and year(o.order_date) = 2019
group by u.user_id, u.join_date