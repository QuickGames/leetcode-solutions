# Write your MySQL query statement below
select u.user_id as id, um.num as num
from (select max(count_f) as num
            from (select user_id, count(*) as count_f
                    from (select requester_id as user_id from RequestAccepted
                            union all
                            select accepter_id from RequestAccepted) as u
                    group by user_id) as u) as um
    left join (select user_id, count(*) as count_f
                from (select requester_id as user_id from RequestAccepted
                        union all
                        select accepter_id from RequestAccepted) as u
                group by user_id) as u
        on um.num = u.count_f