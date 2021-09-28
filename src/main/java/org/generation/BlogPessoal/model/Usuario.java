package org.generation.BlogPessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * classe espelho da tabela usario no banco db_blogpessoal
 * 
 * @author usuario
 * @Table seria pra renomear no mysql a tabela -> tb_usuario
 */

@Entity
public class Usuario {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idUsaurio;
	private String nome;
	private String email;
	private String senha;

	public Long getIdUsaurio() {
		return idUsaurio;
	}

	public void setIdUsaurio(Long idUsaurio) {
		this.idUsaurio = idUsaurio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

//@entity e o @Id ele permite que seja duas anotações pra criar no banco de dados. criação da classe
//Id é a anotação de chave primaria PK
//GenerateValue é autoincrement 