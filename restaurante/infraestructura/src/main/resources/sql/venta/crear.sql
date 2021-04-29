INSERT INTO SALE (client_id, dish_id, sale_date, promotion) Select id, dish_id, CURDATE(),:promocion
from client, dishe where dni = :cliente and  dish_id = :plato;