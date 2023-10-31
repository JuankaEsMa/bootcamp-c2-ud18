package ej9;

import conexion.ConexionSQL;

public class MainApp {
	public static void main(String[] args) {
		ConexionSQL conexion = new ConexionSQL();
		
		conexion.conectar();
		conexion.createDB("Investigadores");
		
		conexion.createTable("Investigadores", "Facultad", "codigo int auto_increment primary key, nombre varchar(100)");
		conexion.createTable("Investigadores", "Investigador", "dni varchar(8) primary key, nom_apels varchar(255), facultad int, "
				+ "foreign key (facultad) references Facultad(codigo)");
		conexion.createTable("Investigadores", "Equipo", "num_serie char(4) primary key, nombre varchar(100), facultad int, "
				+ "foreign key (facultad) references Facultad(codigo)");
		conexion.createTable("Investigadores", "Reserva", "dni varchar(8) primary key, num_serie char(4), comienzo date, fin date,"
				+ "foreign key (dni) references Investigador(dni), foreign key (num_serie) references Equipo(num_serie)");
		
		conexion.insertIntoTable("Investigadores", "Facultad", "(nombre)", "('Medicina')");
		conexion.insertIntoTable("Investigadores", "Facultad", "(nombre)", "('Matematicas')");
		conexion.insertIntoTable("Investigadores", "Facultad", "(nombre)", "('Quimica')");

		conexion.insertIntoTable("Investigadores", "Investigador", "", "('39976231', 'Joan Carles Escobar', 1)");
		conexion.insertIntoTable("Investigadores", "Investigador", "", "('32145698', 'Adrian Chillón Sanchez', 2)");
		conexion.insertIntoTable("Investigadores", "Investigador", "", "('56986212', 'Alex Torres Martín', 3)");

		conexion.insertIntoTable("Investigadores", "Equipo", "", "('AAAA', 'Equipo 1', 1)");
		conexion.insertIntoTable("Investigadores", "Equipo", "", "('JSDA', 'Equipo 2', 2)");
		conexion.insertIntoTable("Investigadores", "Equipo", "", "('KJFD', 'Equipo 3', 3)");
		
		conexion.insertIntoTable("Investigadores", "Reserva", "", "('39976231', 'AAAA', 20230601,20230804)");	
		conexion.insertIntoTable("Investigadores", "Reserva", "", "('32145698', 'JSDA', 20230101,20230716)");	
		conexion.insertIntoTable("Investigadores", "Reserva", "", "('56986212', 'KJFD', 20221001,20230804)");	
		
	}
}
