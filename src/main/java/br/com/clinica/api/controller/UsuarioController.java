package br.com.clinica.api.controller;

import br.com.clinica.api.domain.usuarios.*;
import br.com.clinica.api.infra.security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

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

        Usuario novoUsuario = new Usuario(dados);
        this.usuarioRepository.save(novoUsuario);

        return ResponseEntity.ok().build();

    }

}
