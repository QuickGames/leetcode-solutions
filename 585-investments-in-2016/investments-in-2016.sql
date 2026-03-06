/* Write your T-SQL query statement below */
select round(sum(i.tiv_2016), 2) tiv_2016
from Insurance i
    inner join (select tiv_2015
                from Insurance
                group by tiv_2015
                having 1 < count(*)) t
        on i.tiv_2015 = t.tiv_2015
    inner join (select lat, lon
                from Insurance
                group by lat, lon
                having 1 = count(*)) ll
        on i.lat = ll.lat and i.lon = ll.lon