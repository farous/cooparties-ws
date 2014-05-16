package fr.cooparties.domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evenement")
public class Evenement {

	public enum EtatEvenementPrincipalEnum {
		CONFIRME, ANNULE, ATTENTE
	}

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_type_jeu")
	private TypeJeu typeJeu;

	@Column(name = "jeu")
	private String jeu;

	@ManyToOne
	@JoinColumn(name = "id_support")
	private Support support;

	@ManyToOne
	@JoinColumn(name = "id_organisateur")
	private Utilisateur organisateur;

	@Column(name = "date")
	private Date date;

	@Column(name = "heure")
	private Time heure;

	@Column(name = "date_creation")
	private Date dateCreation;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "code_postal")
	private String codePostal;

	@Column(name = "ville")
	private String ville;

	@Column(name = "modalites")
	private String modalites;

	@Column(name = "nb_participants_max")
	private int nbParticipantsMax;

	@Enumerated(EnumType.STRING)
	@Column(name = "etat")
	private EtatEvenementPrincipalEnum etat;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypeJeu getTypeJeu() {
		return typeJeu;
	}

	public void setTypeJeu(TypeJeu typeJeu) {
		this.typeJeu = typeJeu;
	}

	public String getJeu() {
		return jeu;
	}

	public void setJeu(String jeu) {
		this.jeu = jeu;
	}

	public Support getSupport() {
		return support;
	}

	public void setSupport(Support support) {
		this.support = support;
	}

	public Utilisateur getOrganisateur() {
		return organisateur;
	}

	public void setOrganisateur(Utilisateur organisateur) {
		this.organisateur = organisateur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getHeure() {
		return heure;
	}

	public void setHeure(Time heure) {
		this.heure = heure;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getModalites() {
		return modalites;
	}

	public void setModalites(String modalites) {
		this.modalites = modalites;
	}

	public int getNbParticipantsMax() {
		return nbParticipantsMax;
	}

	public void setNbParticipantsMax(int nbParticipantsMax) {
		this.nbParticipantsMax = nbParticipantsMax;
	}

	public EtatEvenementPrincipalEnum getEtat() {
		return etat;
	}

	public void setEtat(EtatEvenementPrincipalEnum etat) {
		this.etat = etat;
	}

}
