package ut01.xml;

import java.io.Serializable;
import java.util.ArrayList;

public class Empleado implements Serializable{
	
    private static final long serialVersionUID = 4L;
    
	
	private String nombre;
	private String apellidos; 
	private String dni; 
	private String fechaNac;
	private int antiguedad;
	private ArrayList<String> direcciones;
	//private String direcciones;

	private int teleefonoFijo;
	private ArrayList<Integer> moviles;
	//private int moviles;

	public Empleado(String nombre, String apellidos, String dni,
			String fechaNac, int antiguedad, ArrayList<String> direcciones,
			int teleefonoFijo, ArrayList<Integer> moviles) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNac = fechaNac;
		this.antiguedad = antiguedad;
		this.direcciones = direcciones;
		this.teleefonoFijo = teleefonoFijo;
		this.moviles = moviles;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getDni() {
		return dni;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public ArrayList<String> getDirecciones() {
		return direcciones;
	}
	public int getTeleefonoFijo() {
		return teleefonoFijo;
	}
	public ArrayList<Integer> getMoviles() {
		return moviles;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public void setDirecciones(ArrayList<String> direcciones) {
		this.direcciones = direcciones;
	}
	public void setTeleefonoFijo(int teleefonoFijo) {
		this.teleefonoFijo = teleefonoFijo;
	}
	public void setMoviles(ArrayList<Integer> moviles) {
		this.moviles = moviles;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellidos=" + apellidos
				+ ", dni=" + dni + ", fechaNac=" + fechaNac + ", antiguedad="
				+ antiguedad + ", direcciones=" + direcciones
				+ ", teleefonoFijo=" + teleefonoFijo + ", moviles=" + moviles
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antiguedad;
		result = prime * result
				+ ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result
				+ ((direcciones == null) ? 0 : direcciones.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result
				+ ((fechaNac == null) ? 0 : fechaNac.hashCode());
		result = prime * result + ((moviles == null) ? 0 : moviles.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + teleefonoFijo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (antiguedad != other.antiguedad)
			return false;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (direcciones == null) {
			if (other.direcciones != null)
				return false;
		} else if (!direcciones.equals(other.direcciones))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (fechaNac == null) {
			if (other.fechaNac != null)
				return false;
		} else if (!fechaNac.equals(other.fechaNac))
			return false;
		if (moviles == null) {
			if (other.moviles != null)
				return false;
		} else if (!moviles.equals(other.moviles))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (teleefonoFijo != other.teleefonoFijo)
			return false;
		return true;
	}
	
	
	

}
