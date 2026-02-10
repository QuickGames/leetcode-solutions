/* Write your PL/SQL query statement below */
select round(sum(case when d.order_date = d.customer_pref_delivery_date then 1 else 0 end) / count(*) * 100, 2) as immediate_percentage
from (select customer_id, min(order_date) order_date
        from Delivery
        group by customer_id) o
    left join Delivery d
        on o.customer_id = d.customer_id and o.order_date = d.order_date