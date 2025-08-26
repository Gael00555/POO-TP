public class Empleado {
    private String nombre;
    private Integer sueldo;
    private Integer legajo;
    
    // Constructor
    public Empleado(String nombre, Integer sueldo) throws StringException, EnteroPositivoException {
        setNombre(nombre);
        setSueldo(sueldo);
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public Integer getSueldo() {
        return sueldo;
    }
    
    public Integer getLegajo() {
        return legajo;
    }
    
    // Setters with exception handling
    public void setNombre(String nombre) throws StringException {
        if (nombre == null || nombre.length() < 3) {
            throw new StringException("El nombre del empleado debe tener 3 o mas caracteres.");
        }
        this.nombre = nombre;
    }
    
    public void setSueldo(Integer sueldo) throws EnteroPositivoException {
        if (sueldo == null || sueldo <= 0) {
            throw new EnteroPositivoException("El sueldo del empleado debe ser mayor a 0.");
        }
        this.sueldo = sueldo;
    }
    
    public void setLegajo(Integer legajo) throws EnteroPositivoException {
        if (legajo == null || legajo <= 0) {
            throw new EnteroPositivoException("El legajo del empleado debe ser mayor a 0.");
        }
        this.legajo = legajo;
    }
    
    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                ", legajo=" + legajo +
                '}';
    }
}