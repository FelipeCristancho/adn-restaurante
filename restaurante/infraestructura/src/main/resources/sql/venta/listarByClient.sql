select s.id, s.sale_date, concat_ws(' ',name,last_name) as client, dish_name as dish, price, promotion  from sale s, client c, dishe d
WHERE s.client_id = c.id
AND s.dish_id = d.dish_id
AND dni = :client