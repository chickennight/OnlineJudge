-- 코드를 작성해주세요
SELECT COUNT(*) FISH_COUNT, MAX(IFNULL(LENGTH, 10)) MAX_LENGTH, FISH_TYPE
FROM FISH_INFO
GROUP BY FISH_TYPE
HAVING AVG(IFNULL(LENGTH,10)) >= 33
ORDER BY FISH_TYPE;