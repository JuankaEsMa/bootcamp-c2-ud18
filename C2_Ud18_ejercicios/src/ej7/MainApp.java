package ej7;

import conexion.ConexionSQL;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionSQL conexion = new ConexionSQL();
		
		conexion.conectar();
		
		conexion.createDB("Cientificos");
		
		conexion.createTable("Cientificos", "Cientifico", "dni varchar(8) primary key, nom_apels varchar(255)");
		conexion.createTable("Cientificos", "Proyecto", "id char(4) primary key, nombre varchar(255), horas int");
		conexion.createTable("Cientificos", "Asignado_a", "cientifico varchar(8), proyecto char(4), "
				+ "primary key(cientifico, proyecto), foreign key (cientifico) references Cientifico(dni), "
				+ "foreign key (proyecto) references Proyecto(id)");
		
		conexion.insertIntoTable("Cientificos", "Cientifico", "", "('54789621', 'Francisco Javier'),('84562172', 'Jesus Javier Barrientos'),"
				+ "('65231472', 'Faustino Bustamante'),('12345678', 'Soledad Wang'),('39976231', 'Ramona Espin')");
		conexion.insertIntoTable("Cientificos", "Proyecto", "", "('1111', 'Proyecto 1', 200),('1234', 'Proyecto 2', 180),"
				+ "('2314', 'Proyecto 3', 250),('3451', 'Proyecto 4', 300),('5023', 'Proyecto 5', 500)");
		conexion.insertIntoTable("Cientificos", "Asignado_a", "", "('54783621','1111'),('84562172','1234')Y,"
				+ "('65231472','2314'),('12345678','3451'),('39976231','5023')");


	}

}
