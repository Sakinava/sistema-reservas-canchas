-- Roles iniciales
INSERT INTO rol (nombre) VALUES ('ADMIN'), ('USUARIO');

-- Estados de Reserva iniciales
INSERT INTO estado_reserva (nombre) VALUES ('CONFIRMADA'), ('PENDIENTE'), ('CANCELADA');

-- Tipos de Cancha iniciales
INSERT INTO tipo_cancha (nombre) VALUES ('Indoor'), ('Outdoor');

-- Horarios básicos
INSERT INTO horario (hora_inicio, hora_fin) VALUES ('08:00', '10:00'), ('10:00', '12:00'), ('14:00', '16:00');
