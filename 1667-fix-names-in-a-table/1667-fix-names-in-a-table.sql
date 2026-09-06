# Write your MySQL query statement below
select user_id,
    concat(
        UPPER(LEFT(name,1)),
        LOWER(SUBSTRING(name,2))) as name
from Users

Order by user_id ASC;