/* Write your T-SQL query statement below */
select query_name,
    round(sum(1.0 * rating / position) / count(*), 2) as quality,
    round(1.0 * sum(case when rating < 3 then 1 else 0 end) * 100 / count(*), 2) as poor_query_percentage
from Queries
group by query_name