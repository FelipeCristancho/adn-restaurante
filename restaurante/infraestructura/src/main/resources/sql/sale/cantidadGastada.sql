select SUM(price)  from sale s
join client c on c.id = s.client_id
join dishe d on d.dish_id = s.dish_id
where c.dni = :client;
