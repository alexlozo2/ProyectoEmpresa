import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Empleados empleado = null;
		System.out.println("CAMBIO DOS");
		
		List<Empleados> empleados =  new ArrayList<Empleados>(Arrays.asList(
									 	new Empleados(12314, "Omar", "TI", 244534.56f),
									 	new Empleados(12315, "Antonio", "TI", 224534.56f),
									 	new Empleados(12316, "Blanca", "RH", 234534.56f),
									 	new Empleados(12317, "Miguel", "Soporte", 224534.56f),
									 	new Empleados(12318, "Oscar", "Seguridad", 214534.56f)
									 ));

		//Libreria conjunto de clases desarrollados por alguien mas, ayuda a evitar mas desarrollo
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int numEmp, menuPri, subMenu, indice;
		String nombre, departamento;
		float sueldo;
		
		do {
				System.out.println("Bienvenido al sistema");
				System.out.println("1.-Alta");
				System.out.println("2.-Mostrar");
				System.out.println("3.-Buscar");
				System.out.println("4.-Editar");
				System.out.println("5.-Eliminar");
				System.out.println("6.-Buscar por nombre");
				System.out.println("7.-Buscar por departamento");
				System.out.println("8.-Calculaar total de dinero a pagar");
				System.out.println("9.-Eliminar buscando por numero de empleado");
				System.out.println("10.-Salir");
			
			menuPri = scanner.nextInt();
			
			switch (menuPri) {
			case 1:
				
				try {
					System.out.println("Ingrese numero empleado");
					scanner = new Scanner(System.in);
					numEmp = scanner.nextInt();
					
					System.out.println("Ingrese nombre");
					scanner = new Scanner(System.in);
					nombre = scanner.nextLine();
					
					System.out.println("Ingrese departamento");
					scanner = new Scanner(System.in);
					departamento = scanner.nextLine();
					
					System.out.println("Ingrese salario");
					scanner = new Scanner(System.in);
					sueldo = scanner.nextFloat();
					
					empleado = new Empleados(numEmp, nombre, departamento, sueldo);
					
					empleados.add(empleado);
					
					System.out.println("Registrado \n");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error "+e);
				}
				
				break;
				
			case 2:
				if(empleados.size()>0) {
					System.out.println("Lista de empleados ");
					
						empleados.forEach(ep -> System.out.println(ep));
					
					System.out.println();
				}else {
					
					System.out.println("No hay datos en la lista \n");
					
				}
				
				break;
				
			case 3:
				
				if(empleados.size()>0) {
					
					System.out.println("Ingrese el indice");
					scanner = new Scanner(System.in);
					indice = scanner.nextInt();
					
					empleado = empleados.get(indice);
					
					System.out.println(empleado);
					
					
				}else {
					
					System.out.println("No hay datos");
					
				}
				
				break;
				
			case 4:
				
				try {
					System.out.println("Ingrese el indice a registrar");
					scanner = new Scanner(System.in);
					indice = scanner.nextInt();
					
					empleado = empleados.get(indice);
					System.out.println("Nombre del empleado a actualizar "+empleado.getNombre());
					
					do {
						System.out.println("Sub menu para editar");
						System.out.println("1.- Nombre");
						System.out.println("2.- Sueldo");
						System.out.println("3.- Regresar");
						scanner = new Scanner(System.in);
						subMenu = scanner.nextInt();
						
						switch (subMenu) {
						case 1:
							System.out.println("Ingrese el nuevo nombre");
							scanner = new Scanner(System.in);
							nombre = scanner.nextLine();
							
							//Actualiar
							empleado.setNombre(nombre);
							System.out.println("Nombre actualizado");
							
							break;
							
						case 2:
							System.out.println("ingresar nuevo sueldo");
							scanner = new Scanner(System.in);
							sueldo = scanner.nextFloat();
							
							//Actualizar
							empleado.setSueldo(sueldo);
							System.out.println("Sueldo actualizado");
							
							break;
						case 3: 
							
							System.out.println("cambios echos");
							
							break;

						}
						
					} while (subMenu < 3);
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error "+e);
				}
				
				break;
				
			case 5:
				try {
					
					System.out.println("Ingrese el indice");
					scanner = new Scanner(System.in);
					indice = scanner.nextInt();
					
					empleados.remove(indice);
					
					System.out.println("Empleado eliminado");
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error "+e);
				}
				break;
				
			case 6:
				//Algoritmo
				//Pedir el nombre
				//Rescorres la lista
				//verificar que sean iguales
				
				boolean bandera = false;
				
				System.out.println("Ingrese el nombre ");
				scanner = new Scanner(System.in);
				nombre = scanner.nextLine();
				
				for(Empleados em: empleados) {
					
					if(em.getNombre().equals(nombre)) {
						System.out.println(em);
						bandera = true;
						break;
					}
					
				}
				
				if(bandera != true) {
					System.out.println("No existe ese empleado");
				}
				
				break;
			case 7:
				
				bandera = false;
				
				System.out.println("Ingreas departamento");
				scanner = new Scanner(System.in);
				departamento = scanner.nextLine();
				
				for(int i = 0; i < empleados.size();i++) {
					
					if(empleados.get(i).getDepartamento().equals(departamento)) {
						
						System.out.println(empleados.get(i));
						bandera = true;
					}
					
				}
				
				if(bandera != true) {
					System.out.println("No existe ese empleado");
				}
				
				break;
			case 8:
				
				System.out.println("Total a pagar: ");
				float total = 0;
//				for(Empleados em: empleados) {
//					
//					total += em.getSueldo();
//					
//				}
				
				for(int i = 0; i < empleados.size();i++) {
					
					total += empleados.get(i).getSueldo();
					
				}
				
				System.out.println("Cantidad de empleados "+empleados.size());
				System.out.println("Total a pagar "+total);
				
				break;
			case 9:
				
				
				
				if(empleados.size()>0) {
					
					bandera = false;
					
					System.out.println("Ingrese el numero del empleado");
					scanner = new Scanner(System.in);
					numEmp = scanner.nextInt();
					//int numero = numEmp;
					
					//empleados.removeIf(em -> em.getNumEmpleado() == numero);
					for(int i = 0; i < empleados.size();i++) {
						
						if(empleados.get(i).getNumEmpleado() == numEmp) {
							empleados.remove(i);
							break;
						}
						
					}
					
					if(bandera != true) {
						System.out.println("No existe ese empleado");
					}
					
				}else {
					System.out.println("No hay empleados registrados");
				}
				
				
				
				break;
			default:
				break;

			}
						
			scanner = new Scanner(System.in);
			
		}while(menuPri < 10);
		
		
		
		
		

	}

}
