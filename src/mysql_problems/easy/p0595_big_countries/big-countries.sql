# Write your MySQL query statement below
select distinct a.name, a.population, a.area
from (select name, population, area
    from World
    where 3000000 <= area
    union all
    select name, population, area
    from World
    where 25000000 <= population) as a