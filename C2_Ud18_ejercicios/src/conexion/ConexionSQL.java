package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionSQL {
	
	
	public Connection conexion;
	public ConexionSQL(){
	
	}
	
	public void conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", "root", "84268426");
			System.out.println("Conectado");
		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void conectar(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+name, "root", "84268426");
		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage() + "Fallo al connectar");
		}
	}
	
	public void desconectar() {
		try {
			conexion.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void createDB(String name) {
		try {
			String query = "CREATE DATABASE " + name;
			Statement st = conexion.createStatement();
			st.execute("drop database if exists "+ name);
			st.executeUpdate(query);
			desconectar();
			conectar(name);
			System.out.println("Se ha creado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fallo al crear");
			System.out.println(e.getMessage());
		}
	}
	
	public void createTable(String db, String table, String atributos) {
		try {
			desconectar();
			conectar(db);
			String query = "create table " + table + " (" + atributos + ");";
			Statement st = conexion.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fallo al crear");
			System.out.println(e.getMessage());
		}
	}
	public void insertIntoTable(String db, String table,String campos, String tuplas) {
		try {
			desconectar();
			conectar(db);
			String query = "insert into " + table + campos + " values " + tuplas;
			Statement st = conexion.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fallo al crear");
			System.out.println(e.getMessage());
		}
	}
}
