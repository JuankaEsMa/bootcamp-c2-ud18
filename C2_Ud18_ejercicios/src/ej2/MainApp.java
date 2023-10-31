package ej2;

import conexion.ConexionSQL;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionSQL conexion = new ConexionSQL();
		conexion.conectar();
		conexion.createDB("Empleados");
		
		conexion.createTable("Empleados","Departamento","codigo int auto_increment primary key, "
				+ "nombre varchar(100), presupuesto int");
		
		conexion.createTable("Empleados","Empleado","dni varchar(8) primary key, "
				+ "nombre varchar(100), apellidos varchar(255), departamento int, "
				+ "foreign key (departamento) references Departamento(codigo)");
		
		conexion.insertIntoTable("Empleados", "Departamento", "(nombre, presupuesto)", "('Financiero', 10000),"
				+ "('Recursos Humanos', 50000), ('Marketing', 100000), ('Comercial', 20000), ('Compras', 15000)");
		
		conexion.insertIntoTable("Empleados", "Empleado", "", "('45612345','Yoana', 'Garcia', '1'),"
				+ "('84675912','Adrian', 'Plasencia', '2'), ('54723658','Francisco', 'Martinez', '3'),"
				+ "('75862143','Aaron', 'Escobar', '4'), ('45682157','Marta', 'Cabrera', '5')");
	}

}
