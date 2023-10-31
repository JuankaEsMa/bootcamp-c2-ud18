package ej1;

import conexion.ConexionSQL;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionSQL sql = new ConexionSQL();
		
		sql.conectar();
		sql.createDB("Tienda_Informatica");
		sql.createTable("Tienda_Informatica", "Fabricante", "codigo int auto_increment primary key, nombre varchar(100)");
		sql.createTable("Tienda_Informatica", "Articulo", "codigo int auto_increment primary key,nombre nvarchar(100),precio int,fabricante int,foreign key (fabricante) references Fabricante(codigo)");
		sql.insertIntoTable("Tienda_Informatica", "Fabricante","(nombre)", "('Sony'),('Microsoft'),('Nintendo'),('Samsung'),('Apple')");
		sql.insertIntoTable("Tienda_Informatica", "Articulo","(nombre,precio,fabricante)", "('PS5', 650, 1),('XboxOne', 600, 2),('Nintendo Switch', 350, 3),('Samsung A10', 500, 4),('IPhoneX', 900, 5)");


	}

}
