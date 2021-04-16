select count(*)  from sale s, client c, dishe d
WHERE s.client_id = c.id
AND s.dish_id = d.dish_id
AND dni = :client;