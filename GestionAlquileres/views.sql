CREATE OR REPLACE VIEW viewFincas
AS
SELECT id as Id, fincas.nombre AS 'Nombre de la finca', tipo AS Tipo, ubicacion AS Ubicacion, clientes.nombre AS Propietario
FROM clientes 
RIGHT JOIN fincas 
ON (clientes.dni = fincas.ref_propietario); 


DELIMITER |
CREATE OR REPLACE VIEW viewCuentas
AS
SELECT id, ref_cliente as Cliente, fecha, descripcion, debe, haber, @csum := @csum + (debe-haber) AS Saldo
FROM cuentas, SELECT(@csum := 0) foo
ORDER BY fecha;
|
DELIMITER ;


