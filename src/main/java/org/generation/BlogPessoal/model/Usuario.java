package org.generation.BlogPessoal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

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

	@ApiModelProperty(example = "email@email.com.br")
	@Email(message = "O atributo Usuário deve ser um email válido!")
	@NotBlank(message = "O atributo Usuário é Obrigatório!")
	@Size(min = 2, max = 100)
	private String email;

	
	@ApiModelProperty(example = "email@email.com.br") //swagger
	//@Email
	@NotBlank(message = "O atributo Email é Obrigatório!")
	@Size(min = 2, max = 100)
	private String email;

	@NotNull
	@Size(min = 2, max = 100)
	private String senha;

<<<<<<< HEAD
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "tema" })
	private List<Postagem> minhasPostagens = new ArrayList<>();

=======
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem = new ArrayList<>();
	
	public List<Postagem> getPostagem() {
		return postagem;
	}
	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
>>>>>>> main
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

	public List<Postagem> getMinhasPostagens() {
		return minhasPostagens;
	}

	public void setMinhasPostagens(List<Postagem> minhasPostagens) {
		this.minhasPostagens = minhasPostagens;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

//@entity e o @Id ele permite que seja duas anotações pra criar no banco de dados. criação da classe
//Id é a anotação de chave primaria PK
//GenerateValue é autoincrement 