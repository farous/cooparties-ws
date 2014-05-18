package fr.cooparties.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cooparties.dao.custom.EvenementRepositoryCustom;
import fr.cooparties.domain.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Integer>,
		EvenementRepositoryCustom {

	List<Evenement> findByOrganisateurId(Integer idUtilisateur);

}
