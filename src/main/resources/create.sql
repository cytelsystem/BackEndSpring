create table if not exists domicilios (
    id int auto_increment primary key,
    calle varchar(255),
    numero int,
    localidad varchar (255),
    provincia varchar(255)
    );

create table if not exists pacientes (
    id int auto_increment primary key,
    nombre varchar(255),
    apellido varchar(255),
    dni varchar (255),
    fecha_ingreso varchar(255),
    id_domicilio int
    );


create table if not exists odontologos (
    id int auto_increment primary key,
    nombre varchar(255),
    apellido varchar(255),
    numeroMatricula varchar(255)
    );



-- Pueden agregar acá sentencias Insert para precargar datos.
--INSERT INTO domicilios(calle, numero, localidad, provincia) VALUES('Test1', 1, 'Localidad Test1', 'Provincia Test1');
--INSERT INTO pacientes(apellido, nombre, dni, fecha_ingreso, id_domicilio) VALUES('Apellido1', 'Nombre1', '101', '2022-05-31', 1);
--INSERT INTO odontologos(nombre, apellido, numeroMatricula ) VALUES('Carlos', 'Perez', 'MO030622');