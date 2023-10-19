package clase.MavenCRUD.controladores;

import java.sql.Connection;
import java.util.ArrayList;

import clase.MavenCRUD.dtos.LibroDto;
import clase.MavenCRUD.servicios.ConexionPostgre;
import clase.MavenCRUD.servicios.ConsultasPostgre;
import clase.MavenCRUD.servicios.IConexionPostgre;
import clase.MavenCRUD.servicios.IConsultasPostgre;
import clase.MavenCRUD.servicios.IMenu;
import clase.MavenCRUD.servicios.Menu;

public class Main {

	public static void main(String[] args) {
		
		IConexionPostgre conn = new ConexionPostgre();
		IConsultasPostgre consulta = new ConsultasPostgre();
		IMenu menu = new Menu();
		
		ArrayList<LibroDto> listaLibros = new ArrayList<>();

		try {
			Connection conexion = conn.generarConexion();
			int opcion;
			do {
				consulta.actualizar(conexion, listaLibros);
				
				opcion = menu.mostrarMenu();
				switch(opcion) {
				case 1:
					consulta.seleccionar(conexion, listaLibros);
					break;
				case 2:
					consulta.insertar(conexion, listaLibros);
					break;
				case 3:
					consulta.modificar(conexion, listaLibros);
					break;
				case 4:
					consulta.borrar(conexion);
					break;			
				}
			}while(opcion != 5);
			conexion.close();
			
		} catch (Exception e) {
			System.out.println("[ERROR-Main] Se ha producido un error al ejecutar la aplicación: " + e);
		}
	}

}
