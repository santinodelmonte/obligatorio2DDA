INSERT INTO contenido (titulo, descripcion, categoria, duracion_minutos, anio_estreno, exclusivo_premium) VALUES
('Pelicula 1', 'Descripción de la película 1', 'Acción', 120, 2020, false),
('Serie 1', 'Descripción de la serie 1', 'Drama', 45, 2019, false),
('Pelicula Premium', 'Descripción de la película premium', 'Ciencia Ficción', 150, 2021, true);

INSERT INTO usuario (tipo_usuario, nombre_completo, email, fecha_registro) VALUES
('ESTANDAR', 'Usuario Estandar 1', 'estandar1@example.com', '2023-01-01'),
('ESTANDAR', 'Usuario Estandar 2', 'estandar2@example.com', '2023-02-01');

INSERT INTO usuario (tipo_usuario, nombre_completo, email, fecha_registro, fecha_inicio_premium) VALUES
('PREMIUM', 'Usuario Premium 1', 'premium1@example.com', '2023-03-01', '2023-03-01');

INSERT INTO reproduccion (usuario_id, contenido_id, fecha_hora, duracion_reproducida_minutos, calificacion) VALUES
(1, 1, '2023-10-01 10:00:00', 120, 5),
(1, 2, '2023-10-02 11:00:00', 45, 4),
(2, 1, '2023-10-03 12:00:00', 100, 3),
(3, 1, '2023-10-04 13:00:00', 120, 5),
(3, 3, '2023-10-05 14:00:00', 150, 5);