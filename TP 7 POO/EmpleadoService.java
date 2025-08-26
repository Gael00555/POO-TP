package tp7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmpleadoService {

	private static List<Empleado> empleados = new ArrayList<Empleado>();

	public static Boolean agregar(Empleado empleado) {
		if (empleado.getNombre() != null && empleado.getSueldo() != null 
				&& empleado.getSueldo() > 0) {
			// agrego el empleado a la Collection
			return empleados.add(empleado);
		}
		return Boolean.FALSE;
	}

	// Devuelve el empleado de mayor sueldo
	public static Empleado mayorSueldo() {
		Empleado mayor = new Empleado(0);
		Iterator<Empleado> iterador = empleados.iterator();
		while (iterador.hasNext()) {
			Empleado empleado = iterador.next();
			if (mayor.getSueldo() <= empleado.getSueldo()) {
				mayor = empleado;
			}
		}
		return mayor;
	}

	//Devuelve el sueldo promedio
	public static Double sueldoPromedio() {
		Double total = 0.0;
		for (Empleado empleado : empleados) {
			total += empleado.getSueldo();
		}
		return total / empleados.size();
	}

	public static void eliminar(String nombre) {
		Iterator<Empleado> iterador = empleados.iterator();
		while (iterador.hasNext()) {
			Empleado empl = iterador.next();
			if (empl.getNombre().equalsIgnoreCase(nombre)) {
				iterador.remove();
			}
		}
	}

	public static List<Empleado> getEmpleados() {		
		return empleados;
	}

}
