/* Write your PL/SQL query statement below */
select a.machine_id, round(sum(ate.timestamp - ats.timestamp) / count(*), 3) as processing_time
from (select machine_id, process_id
        from Activity
        group by machine_id, process_id) a
    left join (select machine_id, process_id, timestamp
               from Activity
               where activity_type = 'start') ats
        on a.machine_id = ats.machine_id and a.process_id = ats.process_id
    left join (select machine_id, process_id, timestamp
               from Activity
               where activity_type = 'end') ate
        on a.machine_id = ate.machine_id and a.process_id = ate.process_id
group by a.machine_id