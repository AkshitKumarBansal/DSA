# Write your MySQL query statement below
select t1.firstname, t1.lastname, t2.city, t2.state
from Person t1
left join Address t2 using (personid);