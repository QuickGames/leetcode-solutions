/* Write your T-SQL query statement below */
select p.product_id, p.first_year, s.quantity, s.price
from (select product_id, min(Sales.year) as first_year from Sales group by product_id) as p
    left join Sales as s
        on p.product_id = s.product_id and p.first_year = s.year