# Write your MySQL query statement below
SELECT player_id, Min(event_date) as first_login from Activity Group BY player_id;