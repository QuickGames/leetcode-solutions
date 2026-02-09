-- Write your PostgreSQL query statement below
select x, y, z,
    case when z < x + y
            and y < x + z
            and x < y + z then 'Yes'
        else 'No' end as triangle
from Triangle