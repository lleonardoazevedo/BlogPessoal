package org.generation.BlogPessoal.repository;

import java.util.List;
import java.util.Optional;

import org.generation.BlogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/**
	 * Metodo utilizado para realizar pesquisa pela coluna email da tabela usuario
	 * 
	 * @param email
	 * @return Optional com Usuario
	 * @author Turma34
	 * @since 1.0
	 * 
	 */
	public Optional<Usuario> findByEmail(String email);

	/**
	 * Metodo utilizado para realizar spesquisa pela coliuna nome da tabela usuario
	 * 
	 * @param nome
	 * @return List com Usuario
	 * @author Turma34
	 * @since 1.0
	 * 
	 */
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

}
