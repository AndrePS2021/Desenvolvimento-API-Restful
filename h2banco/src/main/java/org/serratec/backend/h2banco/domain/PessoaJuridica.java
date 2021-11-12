package org.serratec.backend.h2banco.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class PessoaJuridica extends Fornecedor {
	
	@Column
	private String razaoSocial;
	
	@Column(name = "cnpj", nullable = false, length = 14)
	@CNPJ(message = "CNPJ inválido")
	private String cnpj;
	
	@Column
	private String inscEstadual;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}
	
	

}
