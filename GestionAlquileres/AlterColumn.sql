ALTER TABLE fincas
ADD FOREIGN KEY refPropietario (REF_PROPIETARIO)
REFERENCES clientes(DNI)
ON DELETE RESTRICT
ON UPDATE CASCADE
;