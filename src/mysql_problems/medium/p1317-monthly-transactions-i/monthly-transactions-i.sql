# Write your MySQL query statement below
select t.month as month, t.country as country,
        sum(t.trans_count) as trans_count, sum(t.approved_count) as approved_count,
        sum(t.trans_total_amount) as trans_total_amount, sum(t.approved_total_amount) as approved_total_amount
from (select
        date_format(trans_date, "%Y-%m") as month, country as country,
        1 as trans_count, 1 as approved_count,
        amount as trans_total_amount, amount as approved_total_amount
    from Transactions
    where state = "approved"
    union all
    select
        date_format(trans_date, "%Y-%m") as month, country as country,
        1 as trans_count, 0 as approved_count,
        amount as trans_total_amount, 0 as approved_total_amount
    from Transactions
    where state = "declined") as t
group by t.month, t.country