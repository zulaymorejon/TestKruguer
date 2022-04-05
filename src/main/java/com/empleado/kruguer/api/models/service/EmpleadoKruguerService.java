package com.empleado.kruguer.api.models.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empleado.kruguer.api.models.entity.EmpleadoKruguer;
import com.empleado.kruguer.api.models.repository.IEmpleadoKruguerRepository;

@Service
public class EmpleadoKruguerService implements IEmpleadoKruguerService {
	
	@Autowired
	private IEmpleadoKruguerRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<EmpleadoKruguer> findAll(){
		return (List<EmpleadoKruguer>) repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public EmpleadoKruguer findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public EmpleadoKruguer save(EmpleadoKruguer persona) {
		return repository.save(persona);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
