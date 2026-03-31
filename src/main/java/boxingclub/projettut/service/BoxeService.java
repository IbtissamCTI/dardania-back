package boxingclub.projettut.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

import boxingclub.projettut.model.Cours;
import boxingclub.projettut.model.Utilisateur;
import boxingclub.projettut.model.Inscription;
import boxingclub.projettut.repository.CoursRepository;
import boxingclub.projettut.repository.UtilisateurRepository;
import boxingclub.projettut.repository.InscriptionRepository;



@Service
public class BoxeService {
    @Autowired private InscriptionRepository inscriptionRepo;
    @Autowired private UtilisateurRepository membreRepo;
    @Autowired private CoursRepository coursRepo;

    public void inscrireMembre(Long idCours, Long idMembre) {
        // .orElse(null) évite que ça plante si l'ID n'existe pas
        Utilisateur m = membreRepo.findById(idMembre).orElse(null);
        Cours c = coursRepo.findById(idCours).orElse(null);

        if (m != null && c != null) {
            Inscription ins = new Inscription();
            ins.setMembre(m);
            ins.setCours(c);
            ins.setDatePaiement(LocalDateTime.now());
            inscriptionRepo.save(ins);
        }
    }
}