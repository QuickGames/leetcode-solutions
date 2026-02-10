# Write your MySQL query statement below
select min(u.name) as results
from (select max(movie_count) as max_movie_count from (select count(distinct movie_id) as movie_count from MovieRating group by user_id) as a) as mc
    left join (select user_id, count(distinct movie_id) as movie_count from MovieRating group by user_id) as um
        left join Users u
            on um.user_id = u.user_id
        on mc.max_movie_count = um.movie_count
union all
select min(m.title)
from (select max(amr.avg_rating) as max_avg_rating from (select movie_id, avg(rating) as avg_rating from MovieRating where year(created_at) = 2020 and month(created_at) = 2 group by movie_id) as amr) as mmr
    left join (select movie_id, avg(rating) as avg_rating from MovieRating where year(created_at) = 2020 and month(created_at) = 2 group by movie_id) as amr
        left join Movies as m
            on amr.movie_id = m.movie_id
        on mmr.max_avg_rating = amr.avg_rating
