package fr.cooparties.ws.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.cooparties.dao.UtilisateurRepository;
import fr.cooparties.domain.Utilisateur;
import fr.cooparties.ws.UtilisateurWs;

@Service
public class UtilisateurWsImpl implements UtilisateurWs {

	@Resource
	private UtilisateurRepository utilisateurRepository;

	@Override
	public Utilisateur getUtilisateur(String utilisateur, String mdp) {
		Utilisateur u = utilisateurRepository.findByUtilisateur(utilisateur);
		return u;
	}
}
