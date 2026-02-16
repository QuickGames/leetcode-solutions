# Write your MySQL query statement below
select distinct *
from (select id, "Root" as type
        from Tree
        where p_id is null
        union all
        select t.id, case when t.p_id is null then "Root" else "Inner" end
        from Tree as t
            inner join Tree as tp
                on t.id = tp.p_id
        union all
        select t.id, "Leaf"
        from Tree t
            left join Tree tp
                on t.id = tp.p_id
        where t.p_id is not null and tp.p_id is null) as t