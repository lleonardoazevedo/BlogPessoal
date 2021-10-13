package org.generation.BlogPessoal.seguranca;

import java.util.Optional;

import org.generation.BlogPessoal.model.Usuario;
import org.generation.BlogPessoal.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;
	
	@Override 
	public UserDetails loadUserByUsername(String userName) {
		Optional<Usuario> user = userRepository.findByUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found. "));
		
		return user.map(UserDetailsImpl::new).get();
	}
}
//ele pega um usuario ou devolve not found
//Usuario ele puxa da classe model usuario
//throws lança uma exceção