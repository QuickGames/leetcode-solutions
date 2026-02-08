/* Write your PL/SQL query statement below */
select round(players / (select count(distinct player_id) from Activity), 2) as fraction
from (select count(p.player_id) players
        from (select player_id, min(event_date) + 1 min_event_date
                from Activity
                group by player_id) p
            left join Activity a
                on p.player_id = a.player_id
        where p.min_event_date = a.event_date)
