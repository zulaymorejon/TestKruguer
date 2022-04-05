package com.empleado.kruguer.api.models.service;

import java.util.List;

import com.empleado.kruguer.api.models.entity.EmpleadoKruguer;

public interface IEmpleadoKruguerService {
	
	List<EmpleadoKruguer> findAll();
	EmpleadoKruguer save(EmpleadoKruguer persona);
	EmpleadoKruguer findById(Long id);
	void deleteById(Long id);

}
