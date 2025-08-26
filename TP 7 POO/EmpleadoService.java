import java.util.ArrayList;
import java.util.List;

public class EmpleadoService {
    private static List<Empleado> empleados = new ArrayList<>();
    private static Integer nextLegajo = 1;
    
    public static Boolean agregar(Empleado empleado) throws EnteroPositivoException {
        if (empleado == null) {
            return false;
        }
        
        // Set legajo and this may throw EnteroPositivoException
        empleado.setLegajo(nextLegajo);
        nextLegajo++;
        
        empleados.add(empleado);
        return true;
    }
    
    public static Empleado mayorSueldo() throws CollectionVaciaException {
        if (empleados.isEmpty()) {
            throw new CollectionVaciaException("No hay empleados.");
        }
        
        Empleado empleadoMayorSueldo = empleados.get(0);
        for (Empleado empleado : empleados) {
            if (empleado.getSueldo() > empleadoMayorSueldo.getSueldo()) {
                empleadoMayorSueldo = empleado;
            }
        }
        return empleadoMayorSueldo;
    }
    
    public static Double sueldoPromedio() throws CollectionVaciaException {
        if (empleados.isEmpty()) {
            throw new CollectionVaciaException("No hay empleados.");
        }
        
        double suma = 0;
        for (Empleado empleado : empleados) {
            suma += empleado.getSueldo();
        }
        return suma / empleados.size();
    }
    
    public static void eliminar(String nombre) throws CollectionVaciaException, NoEncontradoException {
        if (empleados.isEmpty()) {
            throw new CollectionVaciaException("No hay empleados.");
        }
        
        boolean encontrado = false;
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNombre().equals(nombre)) {
                empleados.remove(i);
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            throw new NoEncontradoException("No se encontro el empleado.");
        }
    }
    
    // Métodos auxiliares para testing y gestión
    public static List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }
    
    public static void limpiarEmpleados() {
        empleados.clear();
        nextLegajo = 1;
    }
    
    public static int cantidadEmpleados() {
        return empleados.size();
    }
}