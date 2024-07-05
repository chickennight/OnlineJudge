SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS like '%통풍시트%' OR OPTIONS like '%열선시트%' OR OPTIONS like '%가죽시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE