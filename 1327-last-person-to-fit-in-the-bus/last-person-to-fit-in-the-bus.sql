-- Write your PostgreSQL query statement below
select d.person_name
from (select q.person_name, sum(qt.weight) as all_weight
        from Queue as q
            left join Queue as qt
            on qt.turn <= q.turn
        group by q.person_name
        having sum(qt.weight) <= 1000) as d
order by all_weight desc
limit 1