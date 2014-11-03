package ut01.act06;


import java.util.ArrayList;

public class EmployeeManager {

	public static final String path = "./resources/employee.bin";
	private static final ArrayList<Employee> employeeList = new ArrayList();

	// Crear un fichero con al menos 10 empleados de prueba de tres departamentos diferentes
	private void dummy() {

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
	public ArrayList<Deparment> getDepartment (){
		return null;
	}
	
	// Crear un método que devuelva el sueldo medio de los empleados de un departamento recibido por parámetro
	public int averagePaymentDepartment (int idDep){
		return 0;
	}
	
	
}
