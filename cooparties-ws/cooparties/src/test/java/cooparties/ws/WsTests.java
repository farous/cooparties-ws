package cooparties.ws;

import org.junit.Test;

import com.google.gson.Gson;

import fr.cooparties.domain.TypeJeu;

public class WsTests {

	@Test
	public void generateTypeJeu() {
		TypeJeu typeJeu = new TypeJeu();
		typeJeu.setId(1);
		typeJeu.setLibelle("toto");
		Gson gson = new Gson();
		String json = gson.toJson(typeJeu);
		System.out.println(json);
	}

}
