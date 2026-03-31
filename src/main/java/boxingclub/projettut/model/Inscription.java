package boxingclub.projettut.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Utilisateur membre;

    @ManyToOne
    private Cours cours;

    private LocalDateTime datePaiement;

    public Inscription() {}

    // GETTERS ET SETTERS (Indispensables pour le Service !)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Utilisateur getMembre() { return membre; }
    public void setMembre(Utilisateur membre) { this.membre = membre; }

    public Cours getCours() { return cours; }
    public void setCours(Cours cours) { this.cours = cours; }

    public LocalDateTime getDatePaiement() { return datePaiement; }
    public void setDatePaiement(LocalDateTime datePaiement) { this.datePaiement = datePaiement; }
}