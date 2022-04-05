package com.empleado.kruguer.api.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.empleado.kruguer.api.models.entity.EmpleadoKruguer;


public interface IEmpleadoKruguerRepository extends PagingAndSortingRepository<EmpleadoKruguer, Long> {
	
}
