-- Write your PostgreSQL query statement below
select s.category, coalesce(a.accounts_count, 0) as accounts_count 
from (select 'Low Salary' as category
      union all
      select 'Average Salary'
      union all
      select 'High Salary') as s
    left join (select a.category as category, count(a.category) as accounts_count
                from (select case when income < 20000 then 'Low Salary'
                            when 50000 < income then 'High Salary'
                            else 'Average Salary' end as category
                        from Accounts) as a
                group by a.category) as a
        on s.category = a.category