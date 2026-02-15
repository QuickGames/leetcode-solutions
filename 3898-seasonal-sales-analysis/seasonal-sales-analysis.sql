# Write your MySQL query statement below
with temp_sales as (select season, category, sum(quantity) as total_quantity, sum(total_revenue) as total_revenue
from (select
        case
            when month(sale_date) = 12 || month(sale_date) = 1 || month(sale_date) = 2 then "Winter"
            when month(sale_date) = 3 || month(sale_date) = 4 || month(sale_date) = 5 then "Spring"
            when month(sale_date) = 6 || month(sale_date) = 7 || month(sale_date) = 8 then "Summer"
            else "Fall" end as season,
        p.category as category,
        s.quantity as quantity,
        s.quantity * s.price as total_revenue
    from sales as s
        left join products as p
            on s.product_id = p.product_id) as st
    group by season, category)

select t1.season, t2.category, sum(t2.total_quantity) as total_quantity, sum(t2.total_revenue) as total_revenue
from (select t1.season, t1.max_quantity as max_quantity, max(t2.total_revenue) as max_revenue
        from (select season, max(total_quantity) as max_quantity from temp_sales group by season) as t1
            left join temp_sales as t2
                on t1.season = t2.season and t1.max_quantity = t2.total_quantity
        group by t1.season) as t1
    left join temp_sales as t2
        on t1.season = t2.season and t1.max_quantity = t2.total_quantity and t1.max_revenue = t2.total_revenue
group by t1.season, t2.category
order by t1.season