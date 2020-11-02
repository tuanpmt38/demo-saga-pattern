INSERT INTO car (model, year) VALUES ('BMW', 2000);
INSERT INTO car (model, year) VALUES ('BENZ', 2010);
INSERT INTO car (model, year) VALUES ('PORCHE', 2005);
INSERT INTO car (model, year) VALUES ('PORCHE', 2004);


CREATE PROCEDURE FIND_CARS_AFTER_YEAR(IN year_in INT)
LANGUAGE SQL
AS
$BODY$
    SELECT * FROM car WHERE year >= year_in ORDER BY year;
$BODY$;

