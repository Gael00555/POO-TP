package tp7;

public class Empleado {

	private String nombre;
	private Integer sueldo;
	private Integer legajo;	
	
	public Empleado() {
		super();
	}

	public Empleado(String nombre, Integer sueldo) throws StringException, EnteroPositivoException {
		super();
		this.setNombre(nombre);
		this.setSueldo(sueldo);
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

	public void setNombre(String nombre) throws StringException {
		if (nombre == null || nombre.length() < 3) {
			throw new StringException("El nombre del empleado debe tener 3 o mas caracteres.");
		}
		this.nombre = nombre;
	}

	public Integer getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) throws EnteroPositivoException {
		if (sueldo == null || sueldo <= 0) {
			throw new EnteroPositivoException("El sueldo del empleado debe ser mayor a 0.");
		}
		this.sueldo = sueldo;
	}
	
	public Integer getLegajo() {
		return legajo;
	}
	
	public void setLegajo(Integer legajo) throws EnteroPositivoException {
		if (legajo == null || legajo <= 0) {
			throw new EnteroPositivoException("El legajo del empleado debe ser mayor a 0.");
		}
		this.legajo = legajo;
	}
	
	public String getSueldoString() {
		return "$" + sueldo;
	}

	@Override
	public String toString() {
		return this.getNombre() + " - " + this.getSueldoString();
	}
}
