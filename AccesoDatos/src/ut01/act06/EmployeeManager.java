package ut01.act06;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EmployeeManager {

	public static final String path = "./resources/employee.bin";
	private static final ArrayList<Employee> employeeList = new ArrayList();

	// Crear un fichero con al menos 10 empleados de prueba de tres departamentos diferentes
	private void dummy() {
		Employee e;
		// Listado de empleados
		employeeList.add(new Employee(7902, "Norris", "Chuck", "empleado",
				"17/12/1990", 5000, 0, 1145));
		employeeList.add(new Employee(7888, "Hogan", "Hulk", "vendedor",
				"1/01/1990", 1500, 0, 1378));
		employeeList.add(new Employee(7567, "Ronaldo", "Cristiano",
				"aparca_coches", "29/05/1991", 999999, 0, 1454));
		employeeList.add(new Employee(7499, "Diaz", "Marujita", "vendedor",
				"20/02/1990", 1500, 0, 1378));
		employeeList.add(new Employee(7499, "Hermida", "Jesus", "pica_teclas",
				"20/06/1989", 2500, 0, 500));
		employeeList.add(new Employee(6700, "Chocolatero", "Paquito",
				"cantante", "20/06/1989", 400, 0, 1145));

		ObjectOutputStream streamSalida = null;
		ObjectInputStream streamEntrada = null;
		try {
			// escribimos
			streamSalida = new ObjectOutputStream(new FileOutputStream(path));

			for (Employee emp : employeeList)
				streamSalida.writeObject(emp);

			if (streamSalida != null)
				streamSalida.close();

			// leemos

			streamEntrada = new ObjectInputStream(new FileInputStream(path));

			e = (Employee) streamEntrada.readObject();
			while (e != null) {

				// System.out.println(e.toString());
				e = (Employee) streamEntrada.readObject();
			}

			if (streamEntrada != null)
				streamEntrada.close();
		} catch (FileNotFoundException e1) {

		} catch (EOFException e1) {

		} catch (IOException e1) {

		} catch (ClassNotFoundException e1) {

		}

	}
	
	// Load binary file in memory
	public void LoadFile() {
	}
	
	// crea un método que liste un empleado por su id. 
	
	public Employee getEmployee (int idEmp){
		return null;
	}
	
	// Crear un método que modifique el salario de un empleado con el id que recibe y el nuevo salario por parámetro
	
	public boolean getEmployee (int idEmp, double newSalary){
		return false;
	}
	// Crear un método que elimine un empleado con el id que recibe por parámetro
	public boolean deleteEmployee (int id){
		return false;
	}
	
	// Crear un método que añada un nuevo empleado recibiendo los datos por parámetro
	public boolean addEmployee (Employee e){
		return false;
	}
	
	// Crear un método que devuelva los empleados ordenados por apellido en un ArrayList
	public ArrayList<Employee> listEmployee (Employee e){
		return null;
	}
	
	// Crear un método que devuelva el número de empleados de un departamento
	public int numEmployeeDepartment (int idDep){
		return 0;
	}
	// Crear un método que devuelva la lista de departamentos sin repetir en un ArrayList
	public ArrayList<Department> getDepartment (){
		return null;
	}
	
	// Crear un método que devuelva el sueldo medio de los empleados de un departamento recibido por parámetro
	public int averagePaymentDepartment (int idDep){
		return 0;
	}
	
	
}
