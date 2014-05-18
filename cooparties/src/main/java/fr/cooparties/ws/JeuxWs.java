package fr.cooparties.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.cooparties.domain.Support;
import fr.cooparties.domain.TypeJeu;

@Path("/jeux")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public interface JeuxWs {

	@Path("/typeJeu/all")
	@GET
	List<TypeJeu> getTypesJeux();

	@Path("/support/all")
	@GET
	List<Support> getSupports();

}
