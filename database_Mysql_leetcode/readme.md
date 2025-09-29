
# 📘 LeetCode MySQL Solutions – Cheat Sheet

This repo contains MySQL solutions to LeetCode database problems.  
Use this as a **quick reference** for interviews & practice.

---



## 🧠 MySQL Topics + Syntax

### 🔹 Basic DML
- **SELECT** – `SELECT col1, col2 FROM table WHERE condition;`
- **INSERT** – `INSERT INTO table (col1, col2) VALUES (val1, val2);`
- **UPDATE** – `UPDATE table SET col=val WHERE condition;`
- **DELETE** – `DELETE FROM table WHERE condition;`

### 🔹 Filtering
- `WHERE col = val`
- `AND / OR` → combine multiple conditions
- `BETWEEN x AND y` → range filter  
- `IN (v1,v2,...)` → match multiple values  
- `IS NULL / IS NOT NULL` → check for null

### 🔹 Sorting & Limiting
- `ORDER BY col ASC|DESC`
- `LIMIT n OFFSET m`

### 🔹 Aggregate Functions
- `COUNT(col)` → row count  
- `MAX(col)` / `MIN(col)` → highest/lowest value  
- `AVG(col)` → average  
- `SUM(col)` → total

### 🔹 Grouping
- `GROUP BY col1, col2`
- `HAVING condition` → filter after grouping

### 🔹 Joins
- `INNER JOIN` → match rows in both tables  
- `LEFT JOIN` → keep left table even if no match  
- `RIGHT JOIN` → keep right table even if no match  
- `SELF JOIN` → join table with itself

### 🔹 Subqueries
- **Scalar:** `WHERE col > (SELECT MAX(col) FROM table)`
- **Correlated:** `WHERE col > (SELECT MAX(col) FROM table t2 WHERE t2.x=t1.x)`

### 🔹 Set Operations
- `UNION` → combine result sets (unique)
- `UNION ALL` → combine result sets (with duplicates)

### 🔹 Ranking & Window Functions
- `ROW_NUMBER() OVER (ORDER BY col)`
- `RANK() OVER (PARTITION BY dept ORDER BY salary DESC)`
- `DENSE_RANK() OVER (ORDER BY score DESC)`
- `SUM(salary) OVER (PARTITION BY dept)`

### 🔹 Null Handling
- `IFNULL(col, 0)` → replace null with 0  
- `COALESCE(col1, col2, 0)` → first non-null value

### 🔹 Date Functions
- `DATEDIFF(d1, d2)` → difference in days  
- `DATE_SUB(date, INTERVAL n DAY)` → subtract days  
- `YEAR(date)` / `MONTH(date)` → extract year/month

### 🔹 String Functions
- `CONCAT(col1, col2)` → join strings  
- `LIKE 'A%'` → starts with A

### 🔹 Conditional
- `CASE WHEN condition THEN val ELSE default END`

---

## 💡 Quick Example
```sql
SELECT e.name, e.salary, d.name AS dept
FROM Employee e
INNER JOIN Department d ON e.deptId=d.id
WHERE e.salary = (
    SELECT MAX(salary)
    FROM Employee
    WHERE deptId=e.deptId
);
