package cooparties.ws;

import org.junit.Test;

import com.google.gson.Gson;

import fr.cooparties.ws.dto.EvenementDto;

public class WsTests {

	@Test
	public void generateTypeJeu() {
		EvenementDto evenement = new EvenementDto();
		evenement.setAdresse("10 avenue pasteur");
		evenement.setCodePostal("75011");
		evenement.setDate("2015-14-20");
		evenement.setEtat("CONFIRME");
		try {
			evenement.setHeure("20:11");
		} catch (Exception e) {
			e.printStackTrace();
		}
		evenement.setIdOrganisateur(1);
		evenement.setNomJeu("tekken");
		evenement.setModalites("modalisteeeees");
		evenement.setNbParticipantsMax(5);
		evenement.setIdSupport(1);
		evenement.setIdTypeJeu(1);
		evenement.setVille("paris");

		Gson gson = new Gson();
		String json = gson.toJson(evenement);
		System.out.println(json);
	}

}
