-- 코드를 작성해주세요
SELECT D.DEPT_ID, DEPT_NAME_EN, ROUND(AVG(SAL),0) AS AVG_SAL
FROM HR_DEPARTMENT D RIGHT JOIN HR_EMPLOYEES E
ON D.DEPT_ID = E.DEPT_ID
GROUP BY 1
ORDER BY 3 DESC;
