package boxingclub.projettut.config;

import boxingclub.projettut.model.Utilisateur;
import boxingclub.projettut.model.Role;
import boxingclub.projettut.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // On vérifie si un admin existe déjà pour ne pas le créer en double
        if (utilisateurRepository.findByPseudo("admin").isEmpty()) {
            Utilisateur admin = new Utilisateur();
            admin.setPseudo("admin");
            admin.setPrenom("Admin");
            admin.setNom("Dardania");
            admin.setEmail("admin@dardania.com");

            // On hache le mot de passe !
            admin.setMotDePasse(passwordEncoder.encode("admin123"));
            admin.setRole(Role.ADMIN);

            utilisateurRepository.save(admin);
            System.out.println("✅ Compte Admin créé par défaut : admin / admin123");
        }
    }
}