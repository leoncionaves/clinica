package br.com.clinica.api.domain.usuarios;

import br.com.clinica.api.domain.pessoa.Pessoa;
import br.com.clinica.api.domain.usuarios.DTOs.DadosCadastroUsuario;
import br.com.clinica.api.domain.usuarios.perfil.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
@SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", initialValue = 1, allocationSize = 1)
public class Usuario extends Pessoa implements UserDetails {

    private String usuario;
    private String senha;
    private Roles role;

    public Usuario(DadosCadastroUsuario dados) {
        super(dados.pessoa());
        this.usuario = dados.usuario();
        this.senha =  new BCryptPasswordEncoder().encode(dados.senha());
        this.role = dados.role();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (this.role == Roles.ADMIN) return List.of( new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
