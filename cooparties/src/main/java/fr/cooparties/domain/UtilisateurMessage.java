package fr.cooparties.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur_messages")
public class UtilisateurMessage {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "sujet")
	private String sujet;

	@Column(name = "contenu")
	private String contenu;

	@ManyToOne
	@JoinColumn(name = "id_destinataire")
	private Utilisateur destinataire;

	@ManyToOne
	@JoinColumn(name = "id_expediteur")
	private Utilisateur expediteur;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Utilisateur getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Utilisateur destinataire) {
		this.destinataire = destinataire;
	}

	public Utilisateur getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(Utilisateur expediteur) {
		this.expediteur = expediteur;
	}

}
