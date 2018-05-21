CREATE TABLE IF NOT EXISTS articulos (
	ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	DESCRIPCION VARCHAR(50) NOT NULL,
	PRECIO_HORA DOUBLE(3,2) NOT NULL DEFAULT 0,
	PRECIO_M2 DOUBLE(3,2) NOT NULL DEFAULT 0
	);