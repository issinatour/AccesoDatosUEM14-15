package ut01.random;

public class Main {

	final static String csvFile = "./resources/employee.csv";
	final static String randomFile ="./resources/employee.bin";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeManager em = new EmployeeManager();
		
		em.readCSVfile(csvFile, randomFile);
		
		em.printEmployee(randomFile);
	}

}
