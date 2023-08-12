package com.stage.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.stage.stage.*;


@Service
public class FormulaireService {
	private final FormulaireRepository formulaireRepository;

    @Autowired
    public FormulaireService(FormulaireRepository formulaireRepository) {
        this.formulaireRepository = formulaireRepository;
    }
    
    
    //fonction responsable de sauvegarder les donnees
    
    public Formulaire sauvegarderFormulaire(Formulaire formulaire) {
        return formulaireRepository.save(formulaire);
    }
    
    
    //fonction responsable d'afficher tous les donnees

    public List<Formulaire> obtenirTousLesFormulaires() {
        return formulaireRepository.findAll();
    }
    
    
    //fonction responsable de supprimer tous les donnees

    public void SupprimerFormulaire() {
    	 formulaireRepository.deleteAll();
    }
    
    
    //fonction responsable d'afficher les donnees selon un id 
    
    public Formulaire AfficherById(int id) {
        Optional<Formulaire> formulaireOptional = formulaireRepository.findById(id);
    	
        return formulaireOptional.get() ;
    }
    public boolean SupprimerById(int id) {
    	if(formulaireRepository.existsById(id)) {
    		formulaireRepository.deleteById(id);
    		return true;    	}
    	else 
    		return false;
    }
    
    
    //fonction responsable de modifier les donnees d'une formaulaire selon un id 

    public Formulaire ModifierFormualaire(Formulaire formulaire ,int id) {
    	
    	Optional<Formulaire> formulaireOptional = formulaireRepository.findById(id);
        if (formulaireOptional.isPresent()) {
            Formulaire formulaireExistant = formulaireOptional.get();
            formulaireExistant.setNom(formulaire.getNom());
            formulaireExistant.setPrenom(formulaire.getPrenom());
            formulaireExistant.setMessage(formulaire.getMessage());
            formulaireExistant.setOption(formulaire.getOption());
            formulaireExistant.setChoix_multiple(formulaire.getChoix_multiple());
            return formulaireRepository.save(formulaireExistant);
        } else {
            throw new IllegalArgumentException("Le formulaire n'existe pas ou a un ID invalide.");
        }
    }
}
