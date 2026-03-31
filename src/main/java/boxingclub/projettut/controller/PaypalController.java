package boxingclub.projettut.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import boxingclub.projettut.service.BoxeService;

@RestController
@RequestMapping("/api/paypal")
public class PaypalController {
    @Autowired private BoxeService boxeService;

    @PostMapping("/capture-paiement")
    public ResponseEntity<String> valider(@RequestParam Long idCours, @RequestParam Long idMembre) {
        boxeService.inscrireMembre(idCours, idMembre);
        return ResponseEntity.ok("Paiement reçu et inscription validée !");
    }
}
