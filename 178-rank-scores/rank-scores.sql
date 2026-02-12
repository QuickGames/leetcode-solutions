# Write your MySQL query statement below
select s.score, count(s.score) as 'rank'
from Scores as s
    left join (select distinct score from Scores) as su
        on s.score <= su.score
group by s.id
order by s.score desc