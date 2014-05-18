package fr.cooparties.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.cooparties.domain.Utilisateur;

public interface UtilisateurRepository extends
		JpaRepository<Utilisateur, Integer> {

	Utilisateur findByUtilisateur(String utilisateur);

}
