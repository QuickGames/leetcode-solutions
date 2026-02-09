-- Write your PostgreSQL query statement below
select p.product_id, case when pe.price is null then 10 else pe.price end as price
from (select distinct product_id from Products) as p
    left join (select p.product_id, p.new_price as price
                from (select product_id, max(change_date) as change_date
                        from Products
                        where change_date <= cast('2019-08-16' as date)
                        group by product_id) as pe
                    left join Products as p
                        on pe.product_id = p.product_id and pe.change_date = p.change_date) as pe
        on p.product_id = pe.product_id
