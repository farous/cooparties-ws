package fr.cooparties.dao.custom;

import java.util.List;

import fr.cooparties.domain.Evenement;

public interface EvenementParticipantRepositoryCustom {

	List<Evenement> rechercher(Integer idParticipant);

}
