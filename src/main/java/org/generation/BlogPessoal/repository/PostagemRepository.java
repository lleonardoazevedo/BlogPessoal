package org.generation.BlogPessoal.repository;

import java.util.List;

import org.generation.BlogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);

	//public List<Postagem> getByTituloContainingIgnoreCase(String titulo);
}
// aqui é a comunicação com o banco de dados
// contain é como se fosse o like do sql
// ignore case é pra nao levar consideração maiscula e minuscula,
//	a busca vai ser tudo minusculo pelo titulo
