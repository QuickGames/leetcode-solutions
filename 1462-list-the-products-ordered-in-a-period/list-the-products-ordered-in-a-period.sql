# Write your MySQL query statement below
select p.product_name as product_name, sum(o.unit) as unit
from Orders as o
    left join Products as p
        on o.product_id = p.product_id
where year(o.order_date) = 2020 and month(o.order_date) = 2
group by o.product_id
having 100 <= sum(o.unit)