package br.com.clinica.api.infra.security;

import br.com.clinica.api.domain.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthoruzationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuario;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuario.findByUsuario(username);
    }
}
