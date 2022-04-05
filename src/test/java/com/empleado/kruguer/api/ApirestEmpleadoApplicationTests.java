package com.empleado.kruguer.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.empleado.kruguer.api.models.entity.EmpleadoKruguer;
import com.empleado.kruguer.api.models.entity.UsuarioKruguer;
import com.empleado.kruguer.api.models.repository.IEmpleadoKruguerRepository;
import com.empleado.kruguer.api.models.repository.IUsuarioKruguerRepository;
import com.empleado.kruguer.api.models.service.EmpleadoKruguerService;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {ApirestEmpleadoApplicationTests.class})
@SpringBootTest
class ApirestEmpleadoApplicationTests {

	@InjectMocks
	private EmpleadoKruguerService service;
		
	@Mock
	private IEmpleadoKruguerRepository respository;
	
	/*@Autowired
	private IUsuarioKruguerRepository repo;*/
	
	@Test
	void findAllTotalRegistrosTest() {
		when(respository.findAll()).thenReturn(DatosPrueba.empleados);
		
		List<EmpleadoKruguer> empleado = service.findAll();
		assertEquals(2, empleado.size());
		assertNotNull(empleado);
		verify(respository,times(1)).findAll();
	}
	
	@Test
	void findAllVacioTest() {		
		List<EmpleadoKruguer> empleado = Collections.emptyList();
		when(respository.findAll()).thenReturn(empleado);
		List<EmpleadoKruguer> empleadoVacio = service.findAll();
		assertEquals(0, empleadoVacio.size());
		assertFalse(empleadoVacio==null);
		verify(respository,times(1)).findAll();
	}
	
	@Test
	void saveTest() {		
		when(respository.save(any(EmpleadoKruguer.class))).thenReturn(DatosPrueba.empleadoResponse);
		EmpleadoKruguer empleado = service.save(DatosPrueba.empleadoRequest());
		assertEquals("Zulay", empleado.getNombre());
		assertEquals("zulaymorejon@hotmail.com", empleado.getEmail());
		assertTrue(empleado.getApellido().contains("Morejon"));
		verify(respository,times(1)).save(any(EmpleadoKruguer.class));
	}
	
	@Test
	void deleteTest() {		
		respository.findById(anyLong());
		service.deleteById(1L);

		verify(respository,times(1)).deleteById(anyLong());
	}
	
	/*@Test
	void crearUsuario() {
		UsuarioKruguer usuario = new UsuarioKruguer();
		usuario.setNombre("zulay");
		usuario.setClave("123");
		
		UsuarioKruguer retorna = repo.save(usuario);
		
		assertTrue(retorna.getClave().equalsIgnoreCase(usuario.getClave()));
	}*/

}
