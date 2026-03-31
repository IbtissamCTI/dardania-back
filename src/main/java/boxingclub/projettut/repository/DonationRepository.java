package boxingclub.projettut.repository;

import boxingclub.projettut.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    // Cette interface héritant de JpaRepository,
    // elle possède déjà les méthodes .findAll() et .save()
}