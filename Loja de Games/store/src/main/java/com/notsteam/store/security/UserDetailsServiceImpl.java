package com.notsteam.store.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.notsteam.store.model.Usuario;
import com.notsteam.store.repository.UsuarioRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = userRepository.findByUsuario(username);

		usuario.orElseThrow(()-> new UsernameNotFoundException(username + "Usuário não encontrado"));
		
		return null;
	}
}