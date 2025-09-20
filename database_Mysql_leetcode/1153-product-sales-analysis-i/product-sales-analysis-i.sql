select p.product_name , s.year , s.price
from Sales AS s
left join Product AS p ON 
s.product_id = p.product_id