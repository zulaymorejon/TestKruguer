package com.empleado.kruguer.api;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import com.empleado.kruguer.api.models.entity.EmpleadoKruguer;
import com.empleado.kruguer.api.models.entity.UsuarioKruguer;

public class DatosPrueba {
	
	public static final List<EmpleadoKruguer> empleados = Arrays.asList(new EmpleadoKruguer(1L, "0929008316", "Zulay", "Morejon", "zulaymorejon@hotmail.com"),
			new EmpleadoKruguer(2L, "0929008324", "Zaidy", "Morejon", "zadmorejon@gmail.com"));
	
	public static final EmpleadoKruguer empleadoResponse= new EmpleadoKruguer(1L, "0929008316", "Zulay", "Morejon", "zulaymorejon@hotmail.com");
	
	public static EmpleadoKruguer empleadoRequest() {
		EmpleadoKruguer empleado = new EmpleadoKruguer();
		return empleado.builder()
		.cedula("0929008316")
		.nombre("Zulay")
		.apellido("Morejon")
		.email("zulaymorejon@hotmail.com")
		.build();
		
	}
	
	/*public static UsuarioKruguer usuarioRequest(){
		UsuarioKruguer usuario = new UsuarioKruguer();
		return usuario.builder()
				.nombre("zulay")
				.clave("123")
				.build();
	}*/

}
