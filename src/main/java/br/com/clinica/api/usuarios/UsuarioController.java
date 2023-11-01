package br.com.clinica.api.usuarios;

import br.com.clinica.api.config.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticationDTO dados){
        var usernamePassword = new UsernamePasswordAuthenticationToken(dados.usuario(), dados.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateTocken((Usuario)  auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
    @PostMapping("/new_user")
    @Transactional
    public ResponseEntity cadastroUsuario (@RequestBody @Valid DadosCadastroUsuario dados){
        //if(this.usuarioRepository.findByUsuario(dados.usuario()) != null) return ResponseEntity.badRequest().build();

        Usuario novoUsuario = new Usuario(dados);
        this.usuarioRepository.save(novoUsuario);

        return ResponseEntity.ok().build();

    }
}
