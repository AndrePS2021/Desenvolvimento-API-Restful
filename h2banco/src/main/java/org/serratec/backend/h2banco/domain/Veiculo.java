package org.serratec.backend.h2banco.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 7)
	@NotBlank(message = "Preencha a placa")
	@Column(nullable = false, length = 7)
	@ApiModelProperty(value = "Placa do veículo")
	private String placa;
	
	@Size(max = 30)
	@NotBlank(message = "Preencha a marca")
	@Column(nullable = false, length = 30)
	@ApiModelProperty(value = "Marca do veículo", required = true)
	private String marca;
	
	@Size(max = 40)
	@NotBlank(message = "Preencha o modelo")
	@Column(nullable = false, length = 40)
	private String modelo;
	
	@Embedded
	private Caracteristica caracteristica;
	
	@OneToOne
	@JoinColumn(name = "id_proprietario")
	private Proprietario proprietario;
	
	@OneToMany(mappedBy = "veiculo")
	private List<Manutencao> manutencoes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public List<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(List<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	}
}
