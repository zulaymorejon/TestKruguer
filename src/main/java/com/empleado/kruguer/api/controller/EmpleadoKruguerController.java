package com.empleado.kruguer.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleado.kruguer.api.models.entity.EmpleadoKruguer;
import com.empleado.kruguer.api.models.service.IEmpleadoKruguerService;

@RestController
@RequestMapping("/api")
public class EmpleadoKruguerController {
	
	@Autowired
	private IEmpleadoKruguerService service;
	
	@GetMapping("/empleados")
	public List<EmpleadoKruguer> listarEmpleado(){
		return service.findAll();
	}
	
	@PostMapping("/empleados")
	public ResponseEntity<?> guardarEmpleado(@Valid @RequestBody EmpleadoKruguer empleado, BindingResult result){
		EmpleadoKruguer empleadoObj = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> resultError = result.getFieldErrors().stream().map(r-> "El campo '"+r.getField()+"' "+r.getDefaultMessage()).collect(Collectors.toList());
			response.put("error", resultError);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		try {
			empleadoObj = service.save(empleado);
		} catch (DataAccessException e) {
			response.put("error", e.getMostSpecificCause().getMessage());
			response.put("mensaje", "Se produjo un error en la aplicacion");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Empleado Kruguer creado con exito.");
		response.put("empleado", empleadoObj);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@PutMapping("/empleados/{id}")
	public ResponseEntity<?> actualizarEmpleado(@Valid @RequestBody EmpleadoKruguer empleado, BindingResult result, @PathVariable Long id){
		EmpleadoKruguer empleadoFinal = null;
		Map<String, Object> response = new HashMap<>();
		EmpleadoKruguer empleadoObj = service.findById(id);
		
		if(result.hasErrors()) {
			List<String> resultError = result.getFieldErrors().stream().map(r-> "El campo '"+r.getField()+"' "+r.getDefaultMessage()).collect(Collectors.toList());
			response.put("erros", resultError);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		if(empleadoObj == null) {
			response.put("mensaje", "No existe el empleado Kruguer con el id "+id);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			
			empleadoObj.setCedula(empleado.getCedula());
			empleadoObj.setNombre(empleado.getNombre());
			empleadoObj.setApellido(empleado.getApellido());
			empleadoObj.setEmail(empleado.getEmail());
				
			empleadoFinal = service.save(empleadoObj);
			
		} catch (DataAccessException e) {
			response.put("error", e.getMostSpecificCause().getMessage());
			response.put("mensaje", "Se produjo un error en la aplicacion");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Empleado actualizado con exito.");
		response.put("empleado", empleadoFinal);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		try {
			service.deleteById(id);
		} catch (DataAccessException e) {
			response.put("error", e.getMostSpecificCause().getMessage());
			response.put("mensaje", "Se produjo un error en la aplicacion");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Empleado eliminado con exito.");
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
	}

}
