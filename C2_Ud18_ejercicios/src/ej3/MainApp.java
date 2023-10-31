package ej3;

import conexion.ConexionSQL;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionSQL conexion = new ConexionSQL();
		
		conexion.conectar();
		
		conexion.createDB("Almacenes");
		
		conexion.createTable("Almacenes", "Almacen", "codigo int auto_increment primary key, lugar varchar(100), capacidad int");
		conexion.createTable("Almacenes", "Caja", "num_referencia char(5) primary key, contenido varchar(100), valor int,"
				+ " almacen int, foreign key (almacen) references Almacen(codigo)");
		
		conexion.insertIntoTable("Almacenes", "Almacen","(lugar, capacidad)", "('Reus', 100), ('Japon', 500), ('China', 1000), "
				+ "('Italia', 300), ('Rusia', 600)");
		
		conexion.insertIntoTable("Almacenes", "Caja","", "('12345', 'Muñecos', 10000, 1), ('13245', 'Figuras', 80000, 2), "
				+ "('34512', 'Ropa', 60000, 3), (45123, 'Ropa', 60000, 4), (51234, 'Vodka', 12000, 5)");

	}

}
