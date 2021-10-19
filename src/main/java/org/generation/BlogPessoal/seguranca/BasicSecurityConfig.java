package org.generation.BlogPessoal.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Override
<<<<<<< HEAD
	protected void configure(AuthenticationManagerBuilder auth)
	throws Exception {
	auth.userDetailsService(userDetailsService);
	auth.inMemoryAuthentication()
	.withUser("root")
	.password(passwordEnconder().encode("root"))
	.authorities("ROLE_USER");
	
=======
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		
		auth.inMemoryAuthentication().withUser("admin").password(passwordEnconder().encode("admin"))
		.authorities("ROLE_ADMIN");
>>>>>>> main
	}

	@Bean
	public PasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
<<<<<<< HEAD
		.antMatchers("/api/v1/usuarios/logar").permitAll()
		.antMatchers("/api/v1/usuarios/cadastrar").permitAll()
		.antMatchers("/api/v1/usuarios/todes").permitAll()
		.antMatchers("/swagger-ui").permitAll()	
=======
		.antMatchers("api/v1/usario/logar").permitAll()
		.antMatchers("api/v1/usario/cadastrar").permitAll()
>>>>>>> main
		.antMatchers(HttpMethod.OPTIONS).permitAll()
				.anyRequest().authenticated()
				.and().httpBasic()
				.and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().cors()
				.and().csrf().disable();
		

	}
}