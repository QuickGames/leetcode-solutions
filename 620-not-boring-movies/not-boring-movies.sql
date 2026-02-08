/* Write your PL/SQL query statement below */
select id, movie, description, rating
from Cinema
where id - round(id / 2) * 2 = -1 and description != 'boring'
order by rating desc