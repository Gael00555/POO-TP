package tp7;

public class Empleado {

	private String nombre;
	private Integer sueldo;	
	
	public Empleado() {
		super();
	}

	public Empleado(String nombre, Integer sueldo) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
	}

	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Empleado(Integer sueldo) {
		super();
		this.sueldo = sueldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}
	
	public String getSueldoString() {
		return "$" + sueldo;
	}

	@Override
	public String toString() {
		return this.getNombre() + " - " + this.getSueldoString();
	}
}
