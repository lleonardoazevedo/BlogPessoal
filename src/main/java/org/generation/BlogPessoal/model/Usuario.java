package org.generation.BlogPessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

/**
 * classe espelho da tabela usario no banco db_blogpessoal
 * 
 * @author usuario
 * @Table seria pra renomear no mysql a tabela -> tb_usuario
 */

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min = 2, max = 100)
	private String nome;

	@NotNull
	@Size(min = 2, max = 100)
	private String usuario;

	@NotNull
	@Size(min = 2, max = 100)
	private String senha;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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