package fr.cooparties.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.cooparties.domain.Evenement;

@Path("/evenement")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public interface EvenementWs {

	@Path("/creer")
	@POST
	public void save(@PathParam("evenement") Evenement evenement);

	// @Path("/rechercher/nomJeu/{nomJeu}/idTypeJeu/{idTypeJeu}/codePostal/{codePostal}/date/{date}")
	@Path("/rechercher")
	@GET
	List<Evenement> searchEvenement(@QueryParam("nomJeu") String nomJeu,
			@QueryParam("idTypeJeu") Integer idTypeJeu,
			@QueryParam("codePostal") String codePostal,
			@QueryParam("date") String date) throws Exception;

}
