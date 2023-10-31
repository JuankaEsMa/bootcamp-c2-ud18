package ej4;

import conexion.ConexionSQL;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionSQL conexion = new ConexionSQL();
		
		conexion.conectar();
		
		conexion.createDB("Peliculas_y_Salas");
		
		conexion.createTable("Peliculas_y_Salas", "Pelicula", "codigo int auto_increment primary key, "
				+ "nombre varchar(100), calificacion_edad int");
		
		conexion.createTable("Peliculas_y_Salas", "Sala", "codigo int auto_increment primary key, "
				+ "nombre varchar(100), pelicula int, foreign key (pelicula) references Pelicula(codigo)");
		
		conexion.insertIntoTable("Peliculas_y_Salas", "Pelicula", "(nombre, calificacion_edad)", "('Spiderman 1', 13), "
				+ "('Spiderman 2', 13), ('El señor de los anillos', 13),('Interestellar', 16), ('La llegada', 13) ");
		
		conexion.insertIntoTable("Peliculas_y_Salas", "Sala", "(nombre, pelicula)", "('Sala 1', 1), ('Sala 2', 2), "
				+ "('Sala 3', 3), ('Sala 4', 4), ('Sala 5', 5)");
	}

}
