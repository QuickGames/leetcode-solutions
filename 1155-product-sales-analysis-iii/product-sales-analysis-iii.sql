-- Write your PostgreSQL query statement below
select sm.product_id, sm.min_year first_year, s.quantity, s.price
from (select product_id, min(year) min_year from Sales group by product_id) sm
    left join Sales s
        on sm.product_id = s.product_id and sm.min_year = s.year