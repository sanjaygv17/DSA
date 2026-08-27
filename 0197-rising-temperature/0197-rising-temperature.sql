# Write your MySQL query statement below
SELECT 
    Today.id 
FROM Weather Today
JOIN Weather yest
    ON DATEDIFF(Today.recordDate, yest.recordDate) = 1
WHERE Today.temperature > yest.temperature;
