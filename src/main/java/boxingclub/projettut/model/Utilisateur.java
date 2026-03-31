package boxingclub.projettut.model;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String pseudo;

    @Column(unique = true, nullable = false)
    private String email;

    private String motDePasse;
    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Utilisateur() {}

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPseudo() { return pseudo; }
    public void setPseudo(String pseudo) { this.pseudo = pseudo; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}