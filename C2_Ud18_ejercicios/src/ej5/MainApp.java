package ej5;

import conexion.ConexionSQL;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionSQL conexion = new ConexionSQL();
		
		conexion.conectar();
		
		conexion.createDB("Directores");
		
		conexion.createTable("Directores", "Despacho", "numero int auto_increment primary key, capacidad int");
		
		conexion.createTable("Directores", "Director", "dni varchar(8) primary key, nom_apels varchar(255), dni_jefe varchar(8), despacho int, "
				+ "foreign key (dni_jefe) references Director(dni), foreign key (despacho) references Despacho(numero)");
		
		conexion.insertIntoTable("Directores", "Despacho", "(capacidad)", "(1),(2),(5),(3),(4)");
		conexion.insertIntoTable("Directores", "Director", "", "('54687912','Jose Luis Macarron',null,1),"
				+ "('89762142', 'Luisa Martinez', '54687912', 2), ('75361249', 'Alexis Serrin', '54687912',2),"
				+ "('39654812', 'Carla Sanchez', '89762142', 3), ('26985341', 'Lanzarote Orejote', '39654812', 4)");

	}

}
