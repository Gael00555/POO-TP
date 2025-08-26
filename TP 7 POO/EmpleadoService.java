package tp7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmpleadoService {

	private static List<Empleado> empleados = new ArrayList<Empleado>();

	public static Boolean agregar(Empleado empleado) throws EnteroPositivoException {
		if (empleado.getNombre() != null && empleado.getSueldo() != null 
				&& empleado.getSueldo() > 0) {
			// Generar un legajo automático (último + 1)
			Integer nuevoLegajo = empleados.size() + 1;
			empleado.setLegajo(nuevoLegajo);
			// agrego el empleado a la Collection
			return empleados.add(empleado);
		}
		return Boolean.FALSE;
	}

	// Devuelve el empleado de mayor sueldo
	public static Empleado mayorSueldo() throws CollectionVaciaException {
		if (empleados.isEmpty()) {
			throw new CollectionVaciaException("No hay empleados.");
		}
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
	public static Double sueldoPromedio() throws CollectionVaciaException {
		if (empleados.isEmpty()) {
			throw new CollectionVaciaException("No hay empleados.");
		}
		Double total = 0.0;
		for (Empleado empleado : empleados) {
			total += empleado.getSueldo();
		}
		return total / empleados.size();
	}

	public static void eliminar(String nombre) throws CollectionVaciaException, NoEncontradoException {
		if (empleados.isEmpty()) {
			throw new CollectionVaciaException("No hay empleados.");
		}
		
		boolean encontrado = false;
		Iterator<Empleado> iterador = empleados.iterator();
		while (iterador.hasNext()) {
			Empleado empl = iterador.next();
			if (empl.getNombre().equalsIgnoreCase(nombre)) {
				iterador.remove();
				encontrado = true;
			}
		}
		
		if (!encontrado) {
			throw new NoEncontradoException("No se encontro el empleado.");
		}
	}

	public static List<Empleado> getEmpleados() {		
		return empleados;
	}

}
