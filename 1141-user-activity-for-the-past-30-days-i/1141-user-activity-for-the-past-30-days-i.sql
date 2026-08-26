# Write your MySQL query statement below
select 
Activity_date as day,
Count(distinct user_id) as active_users
from Activity
where Activity_date between '2019-06-28' And '2019-07-27'
group by Activity_date;