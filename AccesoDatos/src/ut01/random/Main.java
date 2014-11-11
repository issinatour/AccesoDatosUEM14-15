package ut01.random;

public class Main {

	final static String csvFile = "./resources/employee.csv";
	final static String randomFile ="./resources/employee.bin";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeManager em = new EmployeeManager();
		
		em.readCSVfile(csvFile, randomFile);
		
		Employee nuevoEmpleado = new Employee(100,"Carlos",10,800);
		
		try {
			em.modifyEmployee(randomFile, nuevoEmpleado);
		} catch (Exception e) {
			
		}
		
		em.printEmployee(randomFile);
		
		Employee modificacionEmpleado = new Employee(4,"Juan",20,5000);
		
		//System.out.println(modificacionEmpleado);
		try {
			em.modifyEmployee(randomFile, modificacionEmpleado);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		
		Employee emp = new Employee();
		try {
			emp = em.getEmployee(randomFile, 4);
		} catch (Exception e1) {
		}
		System.out.println(emp);
		
		
		
	}

}
