# Write your MySQL query statement below
delete p from Person as p
    left join (select min(id) as min_id, email from Person group by email) as pm
        on p.id = pm.min_id
where pm.min_id is null