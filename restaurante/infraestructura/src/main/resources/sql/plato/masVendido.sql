SELECT d.*, count(dish_name) sales FROM dishe d JOIN sale s ON s.dish_id = d.dish_id GROUP BY dish_name ORDER BY sales DESC LIMIT 1;