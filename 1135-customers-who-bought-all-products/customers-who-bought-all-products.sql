# Write your MySQL query statement below
Select c.customer_id from Customer c group by customer_id having count(distinct product_key) = (Select count(*) from Product);