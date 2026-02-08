/* Write your PL/SQL query statement below */
select s.student_id as student_id, s.student_name as student_name, s.subject_name as subject_name, sum(case when e.subject_name is null then 0 else 1 end) as attended_exams
from (select s.student_id, s.student_name, p.subject_name
from Students s, Subjects p) s
    left join Examinations e
        on s.student_id = e.student_id and s.subject_name = e.subject_name
group by s.student_id, s.student_name, s.subject_name
order by s.student_id, s.subject_name
