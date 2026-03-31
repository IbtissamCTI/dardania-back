package boxingclub.projettut.controller;

import boxingclub.projettut.model.*;
import boxingclub.projettut.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired private UtilisateurRepository utilisateurRepository;
    @Autowired private EventRepository eventRepository;
    @Autowired private DonationRepository donationRepository;

    // Récupérer les adhérents
    @GetMapping("/members")
    public List<Utilisateur> getMembers() {
        return utilisateurRepository.findByRole(Role.ADHERENT);
    }

    // Récupérer les événements (pour l'admin et le public)
    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Ajouter un événement
    @PostMapping("/events")
    public Event addEvent(@RequestBody Event event) {
        if (event.getImage() == null || event.getImage().isEmpty()) {
            event.setImage("/accueil.jpg"); // Image par défaut
        }
        return eventRepository.save(event);
    }

    // Supprimer un événement
    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
    }

    // Récupérer les dons
    @GetMapping("/donations")
    public List<Donation> getDonations() {
        return donationRepository.findAll();
    }
}