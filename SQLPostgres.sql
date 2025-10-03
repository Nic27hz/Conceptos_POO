DROP TABLE IF EXISTS inscripcion CASCADE;
DROP TABLE IF EXISTS cursoprofesor CASCADE;
DROP TABLE IF EXISTS curso CASCADE;
DROP TABLE IF EXISTS estudiante CASCADE;
DROP TABLE IF EXISTS profesor CASCADE;
DROP TABLE IF EXISTS programa CASCADE;
DROP TABLE IF EXISTS facultad CASCADE;
DROP TABLE IF EXISTS persona CASCADE;

-- Tabla persona
CREATE TABLE persona (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100),
  correo VARCHAR(100) NOT NULL UNIQUE,
  tipo VARCHAR(20) NOT NULL
);

INSERT INTO persona (id, nombre, apellido, correo, tipo) VALUES 
(1,'Alejandro','Piñeros','alejo@gmail.com','Estudiante'),
(2,'Sofia',NULL,'sofia@gmail.com','Estudiante'),
(3,'Profe',NULL,'profe@gmail.com','Profesor'),
(4,'Jose','Leona','jose@gmail.com','Profesor'),
(5,'Anyelo','Pineda','anyelo@gmail.com','Estudiante');

-- Tabla facultad
CREATE TABLE facultad (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  decano_id INT,
  FOREIGN KEY (decano_id) REFERENCES persona(id) ON DELETE SET NULL
);

INSERT INTO facultad (id, nombre, decano_id) VALUES 
(1,'Facultad de Ingeniería',3),
(2,'Facultad de Ciencias',4);

-- Tabla programa
CREATE TABLE programa (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  duracion DOUBLE PRECISION,
  registro DATE,
  facultad_id INT,
  FOREIGN KEY (facultad_id) REFERENCES facultad(id) ON DELETE SET NULL
);

INSERT INTO programa (id, nombre, duracion, registro, facultad_id) VALUES 
(1,'Ingeniería de Sistemas',5,'2020-01-15',1),
(2,'Matemáticas',4,'2019-06-10',2);

-- Tabla profesor
CREATE TABLE profesor (
  id INT PRIMARY KEY, -- PK es también FK
  facultad_id INT,
  tipo_contrato VARCHAR(50),
  FOREIGN KEY (id) REFERENCES persona(id) ON DELETE CASCADE,
  FOREIGN KEY (facultad_id) REFERENCES facultad(id) ON DELETE SET NULL
);

INSERT INTO profesor (id, facultad_id, tipo_contrato) VALUES 
(3,1,'Tiempo Completo'),
(4,2,'Medio Tiempo');

-- Tabla estudiante
CREATE TABLE estudiante (
  id INT PRIMARY KEY, -- PK es también FK
  codigo VARCHAR(20),
  programa_id INT,
  activo BOOLEAN,
  promedio DOUBLE PRECISION,
  FOREIGN KEY (id) REFERENCES persona(id) ON DELETE CASCADE,
  FOREIGN KEY (programa_id) REFERENCES programa(id) ON DELETE SET NULL
);

INSERT INTO estudiante (id, codigo, programa_id, activo, promedio) VALUES 
(1,'2025001',1,true,4.5),
(2,'2025002',2,true,3.9);

-- Tabla curso
CREATE TABLE curso (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  programa_id INT,
  activo BOOLEAN DEFAULT true,
  FOREIGN KEY (programa_id) REFERENCES programa(id) ON DELETE SET NULL
);

INSERT INTO curso (id, nombre, programa_id, activo) VALUES 
(1, 'Bases de Datos', 1, true),
(2, 'Álgebra Lineal', 2, true);

-- Tabla cursoprofesor
CREATE TABLE cursoprofesor (
  curso_id INT NOT NULL,
  profesor_id INT NOT NULL,
  anio INT,
  semestre INT,
  PRIMARY KEY (curso_id, profesor_id),
  FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE CASCADE,
  FOREIGN KEY (profesor_id) REFERENCES profesor(id) ON DELETE CASCADE
);

INSERT INTO cursoprofesor (curso_id, profesor_id, anio, semestre) VALUES 
(1,3,2025,1);

-- Tabla inscripcion
CREATE TABLE inscripcion (
  id SERIAL PRIMARY KEY,
  curso_id INT,
  anio INT,
  semestre INT,
  estudiante_id INT,
  FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE CASCADE,
  FOREIGN KEY (estudiante_id) REFERENCES estudiante(id) ON DELETE CASCADE
);

INSERT INTO inscripcion (id, curso_id, anio, semestre, estudiante_id) VALUES 
(1,1,2025,1,1);
