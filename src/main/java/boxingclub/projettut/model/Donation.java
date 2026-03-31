package boxingclub.projettut.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String donateurNom;
    private BigDecimal montant;
    private LocalDateTime dateDon;

    public Donation() { this.dateDon = LocalDateTime.now(); }

    // Getters / Setters
    public Long getId() { return id; }
    public BigDecimal getMontant() { return montant; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }
    public String getDonateurNom() { return donateurNom; }
    public void setDonateurNom(String donateurNom) { this.donateurNom = donateurNom; }
}