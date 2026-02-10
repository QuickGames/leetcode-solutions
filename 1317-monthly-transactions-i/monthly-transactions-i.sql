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

-- select
--     a.trans_date as month,
--     a.country as country,
--     a.trans_count + ifnull(d.trans_count, 0) as trans_count,
--     a.trans_count as approved_count,
--     a.trans_amount + ifnull(d.trans_amount, 0) as trans_total_amount,
--     a.trans_amount as approved_total_amount
-- from (select date_format(trans_date, "%Y-%m") as trans_date, country,
--             count(*) as trans_count, sum(amount) as trans_amount
--         from Transactions
--         where state = "approved"
--         group by country, date_format(trans_date, "%Y-%m")) as a
--     full outer join (select date_format(trans_date, "%Y-%m") as trans_date, country,
--                 count(*) as trans_count, sum(amount) as trans_amount
--             from Transactions
--             where state = "declined"
--             group by country, date_format(trans_date, "%Y-%m")) as d
--         on a.trans_date = d.trans_date and a.country = d.country