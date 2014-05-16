package fr.cooparties.dao;

import java.text.ParseException;
import java.util.List;

import fr.cooparties.domain.Evenement;

public interface EvenementRepositoryCustom {

	List<Evenement> rechercher(String nomJeu, Integer idTypeJeu,
			String codePostal, String date) throws ParseException;

}
