package boxingclub.projettut.model;

import jakarta.persistence.*;

@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Double prix;

    public Cours() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public Double getPrix() { return prix; }
    public void setPrix(Double prix) { this.prix = prix; }
}