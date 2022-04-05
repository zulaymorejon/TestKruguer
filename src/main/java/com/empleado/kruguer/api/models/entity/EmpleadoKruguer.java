package com.empleado.kruguer.api.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="empleadosKruguer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EmpleadoKruguer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Pattern(regexp = "[0-9]+",message = "Solo permite valores numericos")
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(unique=true,length = 10, name="cedula")
	private String cedula;
	
	@Pattern(regexp = "[A-Za-z]+",message = "Solo se deben ingresar letras")
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(name = "nombre")
	private String nombre;
	
	@Pattern(regexp = "[A-Za-z]+",message = "Solo se deben ingresar letras")
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(name = "apellido")
	private String apellido;
	
	@NotEmpty(message = "El campo no puede ser vacio")
	@Email(message = "No cumple con el formato de un email")
	@Column(name = "email",unique = true)
	private String email;
	
	
	private static final long serialVersionUID = 4334455564095195932L;

}
