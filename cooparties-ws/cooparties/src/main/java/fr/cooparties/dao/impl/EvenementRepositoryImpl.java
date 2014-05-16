package fr.cooparties.dao.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.CollectionUtils;

import fr.cooparties.dao.EvenementRepositoryCustom;
import fr.cooparties.domain.Evenement;

public class EvenementRepositoryImpl implements EvenementRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	private static final String SEARCH_EVENEMENTS = "from "
			+ Evenement.class.getName() + " e";

	@Override
	public List<Evenement> rechercher(String nomJeu, Integer idTypeJeu,
			String codePostal, String date) throws ParseException {

		String query = SEARCH_EVENEMENTS;
		List<String> whereClauses = new ArrayList<>();
		if (nomJeu != null) {
			whereClauses.add(" UPPER(e.jeu) like :nomJeu ");
		}

		if (idTypeJeu != null) {
			whereClauses.add(" e.typeJeu.id = :idJeu");
		}

		if (codePostal != null) {
			whereClauses.add(" e.codePostal = :codePostal");
		}

		if (date != null) {
			whereClauses.add(" e.date = :date ");
		}

		String resultString = query;

		if (!CollectionUtils.isEmpty(whereClauses)) {
			resultString = resultString + " where "
					+ StringUtils.join(whereClauses, " and ");
		}

		TypedQuery<Evenement> querySearch = entityManager.createQuery(
				resultString, Evenement.class);
		if (nomJeu != null) {
			querySearch
					.setParameter("nomJeu", "%" + nomJeu.toUpperCase() + "%");
		}
		if (idTypeJeu != null) {
			querySearch.setParameter("idJeu", idTypeJeu);
		}
		if (codePostal != null) {
			querySearch.setParameter("codePostal", codePostal);
		}
		if (date != null) {
			querySearch.setParameter("date",
					DateUtils.parseDate(date, "yyyy-MM-dd"));
		}

		List<Evenement> result = querySearch.getResultList();

		return result;
	}
}
