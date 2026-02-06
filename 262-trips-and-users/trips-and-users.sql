-- Write your PostgreSQL query statement below
select ta.request_at as Day, coalesce(round(1.0 * coalesce(cn.res, 0) / (coalesce(c.res, 0) + cn.res), 2), 0) as "Cancellation Rate"
from (select request_at from Trips where '2013-10-01' <= request_at and request_at <= '2013-10-03' group by request_at order by request_at) as ta
    left join (select t.request_at, count(*) as res
                from Trips as t
                    left join Users as uc
                        on t.client_id = uc.users_id
                    left join Users as ud
                        on t.driver_id = ud.users_id
                where uc.banned <> 'Yes' and ud.banned <> 'Yes' and t.status = 'completed'
                group by t.request_at) as c
        on ta.request_at = c.request_at
    left join (select t.request_at, count(*) as res
                from Trips as t
                    left join Users as uc
                        on t.client_id = uc.users_id
                    left join Users as ud
                        on t.driver_id = ud.users_id
                where uc.banned <> 'Yes' and ud.banned <> 'Yes' and t.status <> 'completed'
                group by t.request_at) as cn
        on ta.request_at = cn.request_at
where c.res is not null or cn.res is not null