# Write your MySQL query statement below
select s.stock_name, ifnull(ss.sell, 0) - ifnull(sb.buy, 0) as capital_gain_loss
from (select distinct stock_name from Stocks) as s
    left join (select stock_name, sum(price) as buy from Stocks
               where operation = "Buy" group by stock_name) as sb
        on s.stock_name = sb.stock_name
    left join (select stock_name, sum(price) as sell from Stocks
               where operation = "Sell" group by stock_name) as ss
        on s.stock_name = ss.stock_name