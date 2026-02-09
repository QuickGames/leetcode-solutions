/* Write your T-SQL query statement below */
select teacher_id, count(distinct subject_id) cnt
from Teacher
group by teacher_id 