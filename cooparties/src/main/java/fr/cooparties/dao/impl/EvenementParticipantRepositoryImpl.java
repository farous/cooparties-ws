package fr.cooparties.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.cooparties.dao.custom.EvenementParticipantRepositoryCustom;
import fr.cooparties.domain.Evenement;
import fr.cooparties.domain.EvenementParticipant;

public class EvenementParticipantRepositoryImpl implements EvenementParticipantRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	private static final String SEARCH_EVENEMENTS_PARTICIPANT = "select ep.evenement from " + EvenementParticipant.class.getName()
			+ " ep where ep.participant.id = :idParticipant";

	@Override
	public List<Evenement> rechercher(Integer idParticipant) {
		String query = SEARCH_EVENEMENTS_PARTICIPANT;
		TypedQuery<Evenement> querySearch = entityManager.createQuery(query, Evenement.class);
		querySearch.setParameter("idParticipant", idParticipant);
		List<Evenement> result = querySearch.getResultList();
		return result;
	}
}
