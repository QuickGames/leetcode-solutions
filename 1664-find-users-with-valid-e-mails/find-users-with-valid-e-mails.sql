# Write your MySQL query statement below
select *
from Users
where mail regexp '(?-i)^[a-zA-Z]+[a-zA-Z0-9\-._]*@leetcode\\.com$'