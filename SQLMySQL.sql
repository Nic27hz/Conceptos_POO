create database dbuniversidad;
use dbuniversidad;
DROP TABLE IF EXISTS persona;
CREATE TABLE persona (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100),
  correo VARCHAR(100) NOT NULL UNIQUE,
  tipo VARCHAR(20) NOT NULL
);

INSERT INTO persona VALUES 
(1,'Alejandro','Piñeros','alejo@gmail.com','Estudiante'),
(2,'Sofia',NULL,'sofia@gmail.com','Estudiante'),
(3,'Profe',NULL,'profe@gmail.com','Profesor'),
(4,'Jose','Leona','jose@gmail.com','Profesor'),
(5,'Anyelo','Pineda','anyelo@gmail.com','Estudiante');

DROP TABLE IF EXISTS facultad;
CREATE TABLE facultad (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  decano_id INT,
  FOREIGN KEY (decano_id) REFERENCES persona(id) ON DELETE SET NULL
);

INSERT INTO facultad VALUES 
(1,'Facultad de Ingeniería',3),
(2,'Facultad de Ciencias',4);

DROP TABLE IF EXISTS programa;
CREATE TABLE programa (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  duracion DOUBLE,
  registro DATE,
  facultad_id INT,
  FOREIGN KEY (facultad_id) REFERENCES facultad(id) ON DELETE SET NULL
);

INSERT INTO programa VALUES 
(1,'Ingeniería de Sistemas',5,'2020-01-15',1),
(2,'Matemáticas',4,'2019-06-10',2);

DROP TABLE IF EXISTS profesor;
CREATE TABLE profesor (
  id INT PRIMARY KEY, -- PK es también FK
  facultad_id INT,
  tipo_contrato VARCHAR(50),
  FOREIGN KEY (id) REFERENCES persona(id) ON DELETE CASCADE,
  FOREIGN KEY (facultad_id) REFERENCES facultad(id) ON DELETE SET NULL
);

INSERT INTO profesor VALUES 
(3,1,'Tiempo Completo'),
(4,2,'Medio Tiempo');

DROP TABLE IF EXISTS estudiante;
CREATE TABLE estudiante (
  id INT PRIMARY KEY, -- PK es también FK
  codigo VARCHAR(20),
  programa_id INT,
  activo BOOLEAN,
  promedio DOUBLE,
  FOREIGN KEY (id) REFERENCES persona(id) ON DELETE CASCADE,
  FOREIGN KEY (programa_id) REFERENCES programa(id) ON DELETE SET NULL
);

INSERT INTO estudiante VALUES 
(1,'2025001',1,TRUE,4.5),
(2,'2025002',2,TRUE,3.9);

DROP TABLE IF EXISTS curso;
CREATE TABLE curso (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  programa_id INT,
  activo BOOLEAN DEFAULT TRUE,
  FOREIGN KEY (programa_id) REFERENCES programa(id) ON DELETE SET NULL
);

INSERT INTO curso (id, nombre, programa_id, activo) VALUES 
(1, 'Bases de Datos', 1, TRUE),
(2, 'Álgebra Lineal', 2, TRUE);

DROP TABLE IF EXISTS cursoprofesor;
CREATE TABLE cursoprofesor (
  curso_id INT NOT NULL,
  profesor_id INT NOT NULL,
  anio INT,
  semestre INT,
  PRIMARY KEY (curso_id, profesor_id),
  FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE CASCADE,
  FOREIGN KEY (profesor_id) REFERENCES profesor(id) ON DELETE CASCADE
);

INSERT INTO cursoprofesor VALUES 
(1,3,2025,1);

DROP TABLE IF EXISTS inscripcion;
CREATE TABLE inscripcion (
  id INT AUTO_INCREMENT PRIMARY KEY,
  curso_id INT,
  anio INT,
  semestre INT,
  estudiante_id INT,
  FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE CASCADE,
  FOREIGN KEY (estudiante_id) REFERENCES estudiante(id) ON DELETE CASCADE
);

INSERT INTO inscripcion VALUES 
(1,1,2025,1,1);
