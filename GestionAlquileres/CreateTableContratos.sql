CREATE TABLE IF NOT EXISTS contratos (
	ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	REF_FINCA INTEGER,
	REF_INQUILINO VARCHAR(11) NOT NULL,
	FECHA_INICIO DATE NOT NULL,
	FECHA_FIN DATE NOT NULL,
	FECHA_FIRMA DATE NOT NULL,
	REF_DOC VARCHAR(25) NOT NULL DEFAULT 'Sin referencia',
	TIPO_CONTRATO enum('Temporal','Indefinido') NOT NULL DEFAULT 'Temporal',
	PRECIO_INICIAL DOUBLE(10,2) NOT NULL DEFAULT 0,
	REVISION enum('Mensual','Trimestral','Semestral','Anual')
	);
	
INSERT INTO contratos (REF_FINCA, REF_INQUILINO, FECHA_INICIO, FECHA_FIN, FECHA_FIRMA, TIPO_CONTRATO, PRECIO_INICIAL, REVISION)
VALUES (3, '12345678A', '2018-01-01', '2020-12-31', '2017-12-27', 'Temporal', 1128.32, 'Anual');