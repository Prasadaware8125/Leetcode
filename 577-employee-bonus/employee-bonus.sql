# Write your MySQL query statement below
SELECT E.name, B.bonus FROM EMPLOYEE E
LEFT JOIN BONUS B
ON E.empID = B.empID
WHERE B.bonus < 1000 OR B.Bonus IS NULL;