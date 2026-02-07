-- Write your PostgreSQL query statement below
select c.visited_on as visited_on, sum(ca.sum) as amount, round(sum(ca.sum) / count(c.visited_on), 2) as average_amount
from (select visited_on from Customer group by visited_on) as c
    left join (select visited_on, sum(amount) as sum
                from Customer
                group by visited_on) as ca
        on 0 <= c.visited_on - ca.visited_on and c.visited_on - ca.visited_on <= 6
group by c.visited_on
having 6 < count(c.visited_on)
order by c.visited_on