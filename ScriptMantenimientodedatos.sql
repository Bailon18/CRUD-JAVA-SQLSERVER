
if Exists(Select * from sys.databases where name='CRUDIDAT')
   drop database CRUDIDAT
else	
  create database CRUDIDAT
Go


use CRUDIDAT
Go


Create table DocentesIDAT(
codigo int identity(1,1) Primary key not null, 
nombres varchar(100) not null,
apellidos varchar(100) not null,
idespecialidad int not null,
idpais int not null,
estado bit, -- 0 y 1
foto image
)
Go

Create table Especialidades(
idespecialidad int Primary Key not null,
nombresEsp varchar(100)
)
Go


Insert into Especialidades values(1,'Contabilidad');
Insert into Especialidades values(2,'Sistemas');
Insert into Especialidades values(3,'Base de Datos');
Go


Create table Pais(
idPais int Primary Key not null,
nombrePais varchar(100)
)
Go
Insert into Pais values(1,'Peru');
Insert into Pais values(2,'Colombia');
Insert into Pais values(3,'Brasil');
Go



/* =========================== PROCEDIMIENTO ALMACENADO ==================================*/

Create proc usp_listarespecialidades
As
Select 0 as IdEspecialidad, '--Seleccione--' as nombresEsp from Especialidades
union 
Select idespecialidad,nombresEsp from Especialidades
Go


Create proc usp_Paises
As
Select 0 as IdPais,'--Seleccione--' as nombrePais from Pais
union
Select idPais,nombrePais from Pais
Go

--Listado de Docentes IDAT
Create or alter proc usp_ListarDocentes
As
Select codigo,nombres,apellidos, e.nombresEsp, p.nombrePais,
estado,foto from DocentesIDAT d
inner join  Especialidades e on d.idespecialidad=e.idespecialidad inner join
Pais p on d.idpais=p.idPais 
Go
Exec usp_ListarDocentes
go

--Buscar Docentes IDAT
Create or alter proc usp_buscarDocente
@codigo int
As
Select codigo, nombres, apellidos, idespecialidad, idpais,
estado,foto from DocentesIDAT where codigo = @codigo
Go


--Registro de Docentes
Create or alter proc usp_RegistraDocente
@nombre varchar(100),@apellidos varchar(100),@idespecialidad int,
@idpais int,@estado bit,@foto image
As
Insert into DocentesIDAT values(@nombre,@apellidos,@idespecialidad,@idpais,
	@estado,@foto)
Go

--Actualizando los datos del Docente
Create or alter proc usp_ActualizarDatosDocente
@codigo int,@nombre varchar(100),@apellidos varchar(100),
@idespecialidad int, @idpais int,@estado bit
As
Update DocentesIDAT Set nombres=@nombre,apellidos=@apellidos,
   idespecialidad=@idespecialidad,
   idpais=@idpais,estado=@estado where codigo=@codigo
Go

/*Procedimiento para almacenar la foto*/
Create or alter proc usp_ActualizarFoto
@codigo int,@foto image
As
Update DocentesIDAT set foto=@foto
where codigo=@codigo
go


/* Procedimiento para eliminacion logico*/
Create or alter proc usp_CambiardeEstado
@codigo int,@estado bit
As
Update DocentesIDAT Set estado=@estado Where codigo=@codigo
Go

/* Procedimiento para eliminacion fisica*/
Create or alter proc usp_EliminacionFisica
@codigo int
As
Delete from DocentesIDAT where codigo=@codigo
Go
select * from DocentesIDAT
go


