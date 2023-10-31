package ej8;

import conexion.ConexionSQL;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionSQL conexion = new ConexionSQL();
		
		conexion.conectar();
		
		conexion.createDB("Grandes_Almacenes");
		
		conexion.createTable("Grandes_Almacenes", "Cajero", "codigo int auto_increment primary key, nom_apels varchar(255)");
		
		conexion.createTable("Grandes_Almacenes", "Producto", "codigo int auto_increment primary key, nombre varchar(100), precio int");
		
		conexion.createTable("Grandes_Almacenes", "Maquina_registradora", "codigo int auto_increment primary key, piso int");
		
		conexion.createTable("Grandes_Almacenes", "Venta", "cajero int, maquina int, producto int, "
				+ "primary key (cajero, maquina, producto), "
				+ "foreign key (cajero) references Cajero(codigo),"
				+ "foreign key (maquina) references Producto(codigo),"
				+ "foreign key (producto) references Maquina_registradora(codigo)");
		
		conexion.insertIntoTable("Grandes_Almacenes", "Cajero", "(nom_apels)", "('Joan Carles')");
		conexion.insertIntoTable("Grandes_Almacenes", "Cajero", "(nom_apels)", "('Adrian Plasencia')");
		conexion.insertIntoTable("Grandes_Almacenes", "Cajero", "(nom_apels)", "('Marta Dolores Garcia')");
		
		conexion.insertIntoTable("Grandes_Almacenes", "Producto", "(nombre, precio)", "('Platanos', 2)");
		conexion.insertIntoTable("Grandes_Almacenes", "Producto", "(nombre, precio)", "('Cojin', 10)");
		conexion.insertIntoTable("Grandes_Almacenes", "Producto", "(nombre, precio)", "('Calcetines', 3)");
		
		conexion.insertIntoTable("Grandes_Almacenes", "Maquina_registradora", "(piso)", "(1)");
		conexion.insertIntoTable("Grandes_Almacenes", "Maquina_registradora", "(piso)", "(2)");
		conexion.insertIntoTable("Grandes_Almacenes", "Maquina_registradora", "(piso)", "(1)");

		conexion.insertIntoTable("Grandes_Almacenes", "Venta", "", "(1,1,1)");
		conexion.insertIntoTable("Grandes_Almacenes", "Venta", "", "(2,2,2)");
		conexion.insertIntoTable("Grandes_Almacenes", "Venta", "", "(3,3,3)");


	}

}
