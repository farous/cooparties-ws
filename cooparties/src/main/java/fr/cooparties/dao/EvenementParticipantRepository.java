package fr.cooparties.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cooparties.dao.custom.EvenementParticipantRepositoryCustom;
import fr.cooparties.domain.EvenementParticipant;

public interface EvenementParticipantRepository extends JpaRepository<EvenementParticipant, Integer>, EvenementParticipantRepositoryCustom {

}
