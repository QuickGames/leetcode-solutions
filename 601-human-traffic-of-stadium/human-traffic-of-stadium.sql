# Write your MySQL query statement below
select s.id as id, s.visit_date as visit_date, s.people as people
from (select id, visit_date, people from Stadium where 100 <= people) as s
    left join (select id - 1 as id, 1 as ok from Stadium where 100 <= people) as sm1
        on s.id = sm1.id
    left join (select id - 2 as id, 1 as ok from Stadium where 100 <= people) as sm2
        on s.id = sm2.id
    left join (select id + 1 as id, 1 as ok from Stadium where 100 <= people) as sp1
        on s.id = sp1.id
    left join (select id + 2 as id, 1 as ok from Stadium where 100 <= people) as sp2
        on s.id = sp2.id
where (ifnull(sm2.ok, 0) = 1 and ifnull(sm1.ok, 0) = 1
    or ifnull(sm1.ok, 0) = 1 and ifnull(sp1.ok, 0) = 1
    or ifnull(sp1.ok, 0) = 1 and ifnull(sp2.ok, 0) = 1) = 1
order by s.visit_date 