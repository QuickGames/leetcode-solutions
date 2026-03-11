/* Write your T-SQL query statement below */
select s.*
from Stadium as s
    left join (select id - 2 id from Stadium where 100 <= people) m2
        on s.id = m2.id
    left join (select id - 1 id from Stadium where 100 <= people) m1
        on s.id = m1.id
    left join (select id + 1 id from Stadium where 100 <= people) p1
        on s.id = p1.id
    left join (select id + 2 id from Stadium where 100 <= people) p2
        on s.id = p2.id
where 100 <= s.people
    and (m2.id is not null and m1.id is not null
    or m1.id is not null and p1.id is not null
    or p1.id is not null and p2.id is not null)