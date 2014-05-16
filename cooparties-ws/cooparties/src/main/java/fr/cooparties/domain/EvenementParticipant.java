package fr.cooparties.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evenement_participant")
public class EvenementParticipant {

	public enum EtatEvenementParticipantEnum {
		ACCEPTE, ATTENTE, REFUSE, ANNULE;
	}

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "etat")
	private EtatEvenementParticipantEnum etat;

	@ManyToOne
	@JoinColumn(name = "id_participant")
	private Utilisateur participant;

	@ManyToOne
	@JoinColumn(name = "id_evenement")
	private Evenement evenement;

	public EtatEvenementParticipantEnum getEtat() {
		return etat;
	}

	public void setEtat(EtatEvenementParticipantEnum etat) {
		this.etat = etat;
	}

	public Utilisateur getParticipant() {
		return participant;
	}

	public void setParticipant(Utilisateur participant) {
		this.participant = participant;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

}
