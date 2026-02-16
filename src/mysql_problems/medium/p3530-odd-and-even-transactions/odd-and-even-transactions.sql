# Write your MySQL query statement below
select t.transaction_date, ifnull(todd.samount, 0) as odd_sum, ifnull(teven.samount, 0) as even_sum 
from (select distinct transaction_date from transactions) as t
    left join (select transaction_date, sum(amount) as samount from transactions
               where amount % 2 = 1 group by transaction_date) as todd
        on t.transaction_date = todd.transaction_date
    left join (select transaction_date, sum(amount) as samount from transactions
               where amount % 2 = 0 group by transaction_date) as teven
        on t.transaction_date = teven.transaction_date
order by t.transaction_date