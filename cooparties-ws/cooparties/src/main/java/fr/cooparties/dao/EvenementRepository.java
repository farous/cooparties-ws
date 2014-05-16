package fr.cooparties.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cooparties.domain.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Integer>,
		EvenementRepositoryCustom {

}
