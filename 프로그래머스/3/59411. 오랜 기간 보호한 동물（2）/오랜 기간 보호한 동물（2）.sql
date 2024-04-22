SELECT o.ANIMAL_ID, o.NAME
FROM animal_ins AS i
    JOIN animal_outs AS o ON i.animal_id = o.animal_id
WHERE o.datetime IS NOT NULL
ORDER BY o.datetime - i.datetime DESC LIMIT 2;