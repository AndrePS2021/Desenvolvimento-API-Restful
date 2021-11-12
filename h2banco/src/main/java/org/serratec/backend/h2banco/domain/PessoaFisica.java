package org.serratec.backend.h2banco.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class PessoaFisica extends Fornecedor {
	@Column
	private String rg;
	
	@Column
	private String orgaoEmissor;
	
	@Column(name = "cpf", nullable = false, length = 11)
	@CPF(message = "CPF inválido")
	private String cpf;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

}
