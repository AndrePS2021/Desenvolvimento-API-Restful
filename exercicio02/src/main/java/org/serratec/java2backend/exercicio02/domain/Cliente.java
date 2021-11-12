package org.serratec.java2backend.exercicio02.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_cliente")
		private Long id;
	    
	    @Column(name = "nome", nullable = false, length = 60)
		private String nome;
	    
	    @CPF(message = "CPF inválido")
	    @Column(name = "cpf", nullable = false, length = 11)
		private String cpf;
	    
	    @Email(message = "Email inválido")
	    @Column(name = "email", nullable = false, length = 50)
		private String email;
	    
	    @Column(name = "data_nascimento")
		@Temporal(TemporalType.DATE)
		private Date dataNascimento;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

}
