package ut01.random;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * JavaBean 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int dep;
	private double salary;
	
	public Employee() {
		id = 0;
		name = new String();
		dep = 0;
		salary = 0.0;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param dep
	 * @param salary
	 */
	public Employee(int id, String name, int dep, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.dep = dep;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getDep() {
		return dep;
	}
	public double getSalary() {
		return salary;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDep(int dep) {
		this.dep = dep;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dep=" + dep
				+ ", salary=" + salary + "]";
	}
	
	
	

}
