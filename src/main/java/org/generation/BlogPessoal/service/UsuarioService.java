package org.generation.BlogPessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.BlogPessoal.model.UserLogin;
import org.generation.BlogPessoal.model.Usuario;
import org.generation.BlogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Optional<Object>CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return repository.findByEmail(usuario.getEmail()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			usuario.setSenha(encoder.encode(usuario.getSenha()));
			return Optional.ofNullable(repository.save(usuario));
		});
	}

	public Optional<UserLogin> Logar(Optional<UserLogin> user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Usuario> usuario = repository.findByEmail(user.get().getEmail());

        if(usuario.isPresent()){
<<<<<<< HEAD
            if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
                String auth = user.get().getEmail() + ":" + user.get().getSenha();
=======
            if(encoder.matches(user.get().getSenha(), usuario.get().getEmail())) {
                String auth = user.get().getSenha() + ":" + usuario.get().getEmail();
>>>>>>> main
                byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodeAuth);

                user.get().setToken(authHeader);
                user.get().setNome(usuario.get().getNome());
<<<<<<< HEAD
                user.get().setId(usuario.get().getId());
				user.get().setSenha(usuario.get().getSenha());
				user.get().setEmail(usuario.get().getEmail());

=======
                user.get().setSenha(usuario.get().getSenha());
>>>>>>> main

                return user;
            }
        }
        return null;
	}

}