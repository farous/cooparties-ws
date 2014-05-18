package fr.cooparties.ws.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import fr.cooparties.dao.EvenementParticipantRepository;
import fr.cooparties.dao.EvenementRepository;
import fr.cooparties.dao.SupportRepository;
import fr.cooparties.dao.TypeJeuRepository;
import fr.cooparties.dao.UtilisateurRepository;
import fr.cooparties.domain.Evenement;
import fr.cooparties.domain.Evenement.EtatEvenementPrincipalEnum;
import fr.cooparties.domain.Support;
import fr.cooparties.domain.TypeJeu;
import fr.cooparties.domain.Utilisateur;
import fr.cooparties.ws.EvenementWs;
import fr.cooparties.ws.dto.EvenementDto;

@Service
public class EvenementWsImpl implements EvenementWs {

	@Resource
	private EvenementRepository evenementRepository;

	@Resource
	private SupportRepository supportRepository;

	@Resource
	private TypeJeuRepository typeJeuRepository;

	@Resource
	private UtilisateurRepository utilisateurRepository;

	@Resource
	private EvenementParticipantRepository evenementParticipantRepository;

	@Override
	public void save(EvenementDto evenementDto) {
		Utilisateur organisateur = utilisateurRepository.findOne(evenementDto.getIdOrganisateur());
		Support support = supportRepository.findOne(evenementDto.getIdSupport());
		TypeJeu typeJeu = typeJeuRepository.findOne(evenementDto.getIdTypeJeu());

		Evenement evenement = new Evenement();
		evenement.setAdresse(evenementDto.getAdresse());
		evenement.setCodePostal(evenementDto.getCodePostal());
		evenement.setDateCreation(new Date());
		evenement.setEtat(EtatEvenementPrincipalEnum.valueOf(evenementDto.getEtat()));
		try {
			evenement.setDate(DateUtils.parseDate(evenementDto.getDate(), "yyyy-MM-dd"));
			evenement.setHeure(DateUtils.parseDate(evenementDto.getHeure(), "hh:mm"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		evenement.setOrganisateur(organisateur);
		evenement.setJeu(evenementDto.getNomJeu());
		evenement.setModalites(evenementDto.getModalites());
		evenement.setNbParticipantsMax(evenementDto.getNbParticipantsMax());
		evenement.setSupport(support);
		evenement.setTypeJeu(typeJeu);
		evenement.setVille(evenementDto.getVille());

		evenementRepository.save(evenement);
	}

	@Override
	public List<Evenement> searchEvenement(String nomJeu, Integer idTypeJeu, String codePostal, String date) throws Exception {
		return evenementRepository.rechercher(nomJeu, idTypeJeu, codePostal, date);
	}

	@Override
	public List<Evenement> getByOrganisateur(Integer idUtilisateur) {
		List<Evenement> result = evenementRepository.findByOrganisateurId(idUtilisateur);
		return result;
	}

	@Override
	public List<Evenement> getByParticipant(Integer idUtilisateur) {
		List<Evenement> result = evenementParticipantRepository.rechercher(idUtilisateur);
		return result;
	}
}