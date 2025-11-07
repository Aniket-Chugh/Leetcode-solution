-- Get user name and balance greater than 10000
SELECT 
    u.name AS name,
    SUM(t.amount) AS balance
FROM 
    Users u
JOIN 
    Transactions t 
ON 
    u.account = t.account
GROUP BY 
    u.account, u.name
HAVING 
    SUM(t.amount) > 10000;
