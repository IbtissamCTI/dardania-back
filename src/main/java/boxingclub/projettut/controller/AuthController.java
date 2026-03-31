package boxingclub.projettut.controller;

import boxingclub.projettut.model.Utilisateur;
import boxingclub.projettut.repository.UtilisateurRepository;
import boxingclub.projettut.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Utilisateur user) {
        if (utilisateurRepository.findByPseudo(user.getPseudo()).isPresent()) {
            return ResponseEntity.badRequest().body("Pseudo déjà pris !");
        }
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String pseudo = loginRequest.get("pseudo");
        String mdp = loginRequest.get("motDePasse");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(pseudo, mdp));

        Optional<Utilisateur> userOpt = utilisateurRepository.findByPseudo(pseudo);
        if (userOpt.isPresent()) {
            Utilisateur user = userOpt.get();
            Map<String, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("pseudo", user.getPseudo());
            response.put("role", user.getRole());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body("Erreur");
    }
}