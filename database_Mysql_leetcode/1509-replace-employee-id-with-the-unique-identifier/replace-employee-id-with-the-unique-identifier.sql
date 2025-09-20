# Write your MySQL query statement below
select  euni.unique_id , e.name 
from Employees  AS e
LEFT JOIN EmployeeUNI  AS euni ON
euni.id = e.id