package boxingclub.projettut.service;

import boxingclub.projettut.model.Utilisateur;
import boxingclub.projettut.model.Role;
import boxingclub.projettut.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Utilisateur register(Utilisateur user) {
        // On récupère le mot de passe clair, on le hache, et on le réinjecte
        user.setMotDePasse(passwordEncoder.encode(user.getMotDePasse()));
        // Par défaut, toute inscription web est un ADHERENT
        if (user.getRole() == null) {
            user.setRole(Role.ADHERENT);
        }
        return utilisateurRepository.save(user);
    }

    public Utilisateur creerAdmin(Utilisateur admin) {
        admin.setMotDePasse(passwordEncoder.encode(admin.getMotDePasse()));
        admin.setRole(Role.ADMIN);
        return utilisateurRepository.save(admin);
    }
}