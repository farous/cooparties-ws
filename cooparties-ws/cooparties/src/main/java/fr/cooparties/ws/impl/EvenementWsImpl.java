package fr.cooparties.ws.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.cooparties.dao.EvenementRepository;
import fr.cooparties.domain.Evenement;
import fr.cooparties.ws.EvenementWs;

@Service
public class EvenementWsImpl implements EvenementWs {

	@Resource
	private EvenementRepository evenementRepository;

	@Override
	public void save(Evenement evenement) {
		evenementRepository.save(evenement);
	}

	@Override
	public List<Evenement> searchEvenement(String nomJeu, Integer idTypeJeu,
			String codePostal, String date) throws Exception {
		return evenementRepository.rechercher(nomJeu, idTypeJeu, codePostal,
				date);
	}

}