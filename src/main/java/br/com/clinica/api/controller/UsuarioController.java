package br.com.clinica.api.controller;

import br.com.clinica.api.domain.usuarios.DTOs.AutenticationDTO;
import br.com.clinica.api.domain.usuarios.DTOs.DadosCadastroUsuario;
import br.com.clinica.api.domain.usuarios.DTOs.LoginResponseDTO;
import br.com.clinica.api.domain.usuarios.Usuario;
import br.com.clinica.api.domain.usuarios.UsuarioRepository;
import br.com.clinica.api.infra.security.TokenService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticationDTO dados){
        var usernamePassword = new UsernamePasswordAuthenticationToken(dados.usuario(), dados.senha());
        try {
            var auth = authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateTocken((Usuario)  auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
    @PostMapping("/new_user")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    //@PreAuthorize("hasAuthotity('READ')")
    @Transactional
    public ResponseEntity cadastroUsuario (@RequestBody @Valid DadosCadastroUsuario dados){
        //if(this.usuarioRepository.findByUsuario(dados.usuario()) != null) return ResponseEntity.badRequest().build();
        var usuario = repository.findByUsuario(dados.usuario());

        if (usuario != null) return ResponseEntity.badRequest().build();

        Usuario novoUsuario = new Usuario(dados);
        repository.save(novoUsuario);

        return ResponseEntity.ok().build();

    }

}
