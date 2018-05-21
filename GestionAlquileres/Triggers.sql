DELIMITER |
DROP TRIGGER IF EXISTS saldos;
CREATE TRIGGER saldos 
AFTER INSERT ON cuentas
FOR EACH ROW
BEGIN
	UPDATE clientes SET saldo = (select ROUND(sum(debe)-sum(haber),2) FROM cuentas WHERE ref_cliente = NEW.ref_cliente) WHERE dni = NEW.ref_cliente;
END;
|
DELIMITER ;





