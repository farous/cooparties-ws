package fr.cooparties.ws.dto;


public class EvenementDto {

	private Integer idTypeJeu;

	private String nomJeu;

	private Integer idSupport;

	private Integer idOrganisateur;

	// format yyyy-MM-jj
	private String date;

	private String heure;

	private String adresse;

	private String codePostal;

	private String ville;

	private String modalites;

	private Integer nbParticipantsMax;

	private String etat;

	public Integer getIdTypeJeu() {
		return idTypeJeu;
	}

	public void setIdTypeJeu(Integer idTypeJeu) {
		this.idTypeJeu = idTypeJeu;
	}

	public String getNomJeu() {
		return nomJeu;
	}

	public void setNomJeu(String nomJeu) {
		this.nomJeu = nomJeu;
	}

	public Integer getIdSupport() {
		return idSupport;
	}

	public void setIdSupport(Integer idSupport) {
		this.idSupport = idSupport;
	}

	public Integer getIdOrganisateur() {
		return idOrganisateur;
	}

	public void setIdOrganisateur(Integer idOrganisateur) {
		this.idOrganisateur = idOrganisateur;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
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

	public Integer getNbParticipantsMax() {
		return nbParticipantsMax;
	}

	public void setNbParticipantsMax(Integer nbParticipantsMax) {
		this.nbParticipantsMax = nbParticipantsMax;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}
