package ej6;

import conexion.ConexionSQL;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionSQL conexion = new ConexionSQL();
		
		conexion.conectar();
		
		conexion.createDB("Piezas_y_proveedores");
		
		conexion.createTable("Piezas_y_proveedores", "Pieza", "codigo int auto_increment primary key, nombre varchar(100)");
		conexion.createTable("Piezas_y_proveedores", "Proveedor", "id char(4) primary key, nombre varchar(100)");
		conexion.createTable("Piezas_y_proveedores", "Suministra", "codigo_pieza int, id_proveedor char(4), precio int, "
				+ "primary key(codigo_pieza, id_proveedor), foreign key (codigo_pieza) references Pieza(codigo), "
				+ "foreign key (id_proveedor) references Proveedor(id)");
		conexion.insertIntoTable("Piezas_y_proveedores", "Pieza", "(nombre)", "('pieza 1'), ('pieza 2'), "
				+ "('pieza 3'), ('pieza 4'), ('pieza 5')");
		conexion.insertIntoTable("Piezas_y_proveedores", "Proveedor", "", "('AA01', 'Harvey LLC'), ('AA02', 'Gutkowski and DuBuque'), "
				+ "('AB01', 'Morar and Beer'),('AC01', 'Rice Inc'), ('AB02', 'Beahan and Hayes')");

	}

}
