CREATE TABLE gestion_rural.fincas LIKE gestion_alquileres.fincas;
INSERT gestion_rural.fincas
SELECT *
FROM gestion_alquileres.fincas;
