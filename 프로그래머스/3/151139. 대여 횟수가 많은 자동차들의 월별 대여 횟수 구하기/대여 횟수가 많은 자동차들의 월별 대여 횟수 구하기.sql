-- 코드를 입력하세요
SELECT MONTH(start_date) 'MONTH', car_id, COUNT(history_id) 'RECORDS'
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE start_date >= "2022-08-01" AND start_date < "2022-11-01" AND car_id IN (
    SELECT car_id FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE start_date >= "2022-08-01" AND start_date < "2022-11-01" GROUP BY car_id HAVING COUNT(history_id)>4) 
GROUP BY month, car_id
HAVING records > 0
ORDER BY month, car_id DESC;