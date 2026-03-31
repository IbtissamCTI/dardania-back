package boxingclub.projettut.service;

import boxingclub.projettut.model.Utilisateur;
import boxingclub.projettut.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository repository;

    @Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
        // On cherche l'utilisateur par son pseudo dans ta BDD
        Utilisateur user = repository.findByPseudo(pseudo)
                .orElseThrow(() -> new UsernameNotFoundException("Pseudo non trouvé : " + pseudo));

        // On retourne un objet User que Spring Security comprend
        return new org.springframework.security.core.userdetails.User(
                user.getPseudo(),
                user.getMotDePasse(),
                Collections.emptyList() // On gérera les rôles/autorisations plus tard
        );
    }
}