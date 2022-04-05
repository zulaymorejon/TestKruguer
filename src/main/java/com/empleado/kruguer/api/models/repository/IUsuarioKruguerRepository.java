package com.empleado.kruguer.api.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.empleado.kruguer.api.models.entity.UsuarioKruguer;


public interface IUsuarioKruguerRepository extends PagingAndSortingRepository<UsuarioKruguer, Long> {

}
