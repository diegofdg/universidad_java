package test;

import java.util.Scanner;

import dao.PersonaDAO;
import model.Persona;

public class OperacionesHibernateJPA {

	public static void main(String args[]) {
		// Variables generales
		PersonaDAO pDao = new PersonaDAO();
		Persona p1 = null;
		int opcion = -1;
		Scanner scanner = new Scanner(System.in);
		String idStr, nombre, apellido;

		// Presiona 0 para salir
		while (opcion != 0) {
			try {
				System.out.println(
						"Elige opcion:\n1.- Listar Personas" + 
						"\n2.- Buscar una persona por id " + 
						"\n3.- Agregar una persona" + 
						"\n4.- Modificar una persona\n" + 
						"5.- Eliminar una persona\n" + 
						"0.- Salir");

				opcion = Integer.parseInt(scanner.nextLine());

				// Ejemplo de switch case en Java
				switch (opcion) {
				case 1:
					System.out.println("\n1.Listado***********");
					pDao.listar();
					break;
				case 2:
					System.out.println("\n2.Buscar por id***********");
					System.out.println("Introduce el id de la persona a buscar:");
					idStr = scanner.nextLine();
					p1 = new Persona();
					p1.setIdPersona(new Integer(idStr));
					p1 = pDao.buscarPorId(p1);
					System.out.println("Objeto encontado:" + p1);
					break;
				case 3:
					System.out.println("\n3.Insertar***********");
					System.out.println("Introduce el nombre de la persona a agregar:");
					nombre = scanner.nextLine();
					System.out.println("Introduce el apellido de la persona a agregar:");
					apellido = scanner.nextLine();
					p1 = new Persona();
					p1.setNombre(nombre);
					p1.setApellido(apellido);
					// Guardamos el nuevo objeto
					pDao.insertar(p1);
					break;
				case 4:
					System.out.println("\n4.Modificar***********");
					// Primero buscamos la persona a modificar
					System.out.println("Introduce el id de la persona a buscar:");
					idStr = scanner.nextLine();
					p1 = new Persona();
					p1.setIdPersona(new Integer(idStr));
					p1 = pDao.buscarPorId(p1);
					System.out.println("Introduce el nombre de la persona a modificar:");
					nombre = scanner.nextLine();
					System.out.println("Introduce el apellido de la persona a modificar:");
					apellido = scanner.nextLine();
					// Modificamos algun valor
					p1.setNombre(nombre);
					p1.setApellido(apellido);
					pDao.actualizar(p1);
					break;
				case 5:
					System.out.println("\n5. Eliminar***********");
					// Primero buscamos la persona a eliminar
					System.out.println("Introduce el id de la persona a eliminar:");
					idStr = scanner.nextLine();
					p1 = new Persona();
					p1.setIdPersona(new Integer(idStr));
					p1 = pDao.buscarPorId(p1);
					// Eliminamos el objeto encontrado
					pDao.eliminar(p1);
					break;
				case 0:
					System.out.println("!Hasta pronto!");
					break;
				default:
					System.out.println("Opcion no reconocida");
					break;
				}
				System.out.println("\n");

			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}