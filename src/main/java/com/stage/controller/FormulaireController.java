package com.stage.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.stage.service.FormulaireService;
import com.stage.stage.Formulaire;
import com.stage.stage.FormulaireRepository;

import java.util.List;

@RestController
public class FormulaireController {

    private final FormulaireService formulaireService;
	private final FormulaireRepository formulaireRepository;

    @Autowired
    public FormulaireController(FormulaireService formulaireService,FormulaireRepository formulaireRepository) {
        this.formulaireService = formulaireService;
        this.formulaireRepository = formulaireRepository;
    }

    @PostMapping("/formulaire")
    public String traiterFormulaire(@RequestBody Formulaire formulaire) {
        String nom = formulaire.getNom();
        String prenom = formulaire.getPrenom();
        String message = formulaire.getMessage();
        String option = formulaire.getOption();
        List<String> choix_multiple = formulaire.getChoix_multiple();

        
        // Vérification des champs manquants
        
        if (nom == null) {
            return "Le champ Nom est manquant";
        }

        if (prenom == null) {
            return "Le champ Prénom est manquant";
        }

        if (message == null) {
            return "Le champ Message est manquant";
        }

        if (option == null) {
            return "Le champ Option 1 est manquant";
        }
        if (choix_multiple == null) {
            return "Le champ choix multiple est manquant";
        }

        // Tous les champs sont renseignés, traiter le formulaire ici
        
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Message : " + message);
        System.out.println("Option sélectionnée : " + option);
        System.out.println("Choix sélectionnées : " + choix_multiple);

        // Appeler le service pour sauvegarder le formulaire dans la base de données
        
        formulaireService.sauvegarderFormulaire(formulaire);
    	int id = formulaire.getId();
        System.out.println("id : " + id);

        return "Formulaire traité avec succès avec un id : " + id;
    }

 
    // Appeler le service pour afficher les formulaire de la base de données
    
    @GetMapping("/affichage")
    public ResponseEntity<?> obtenirTousLesFormulaires() {
        List<Formulaire> formulaires = formulaireService.obtenirTousLesFormulaires();
        
        if (formulaires.isEmpty()) {
            String message = "Aucun formulaire trouvé";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        } else {
            return ResponseEntity.ok(formulaires);
        }
    }

    // Appeler le service pour supprimer le formulaire de la base de données

    @DeleteMapping("/supprimer")
    public ResponseEntity<String> supprimerFormulaire() {
        long nombreFormulaires = formulaireRepository.count();

        if (nombreFormulaires == 0) {
            String message = "Aucun formulaire trouvé pour la suppression";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        } else {
            formulaireService.SupprimerFormulaire();
            return ResponseEntity.ok("Suppression terminée");
        }
    }


    // Appeler le service pour afficher le formulaire selon un id

    @GetMapping("/formulaire/{id}")
    public ResponseEntity<Formulaire> getFormulaireById(@PathVariable int id) {
    	
    	 Formulaire formulaire = formulaireService.AfficherById(id);

        if (formulaire != null) {
            return ResponseEntity.ok(formulaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Appeler le service pour supprimer le formulaire selon un id
    
    @DeleteMapping("/supprimer/{id}")
    public String SupprimerById(@PathVariable int id) {
    	
    	boolean test =  formulaireService.SupprimerById(id);
    	
    	if(test == true) {
    			return "formulaire supprimer avec succes"; }

    	else {  return "Formulaire n'exsite pas "; }
    	
    }
    
    // Appeler le service pour modifier une formulaire selon un id

    @PutMapping("modifier/{id}")
    public ResponseEntity<Object> modifierFormulaire(@PathVariable int id, @RequestBody Formulaire formulaire) {
        Formulaire formulaireModifie = formulaireService.ModifierFormualaire(formulaire, id);

        if (formulaireModifie != null) {
            return ResponseEntity.ok(formulaireModifie);
        } else {
            String message = "Formulaire  non trouvé";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    
}

