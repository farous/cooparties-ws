package fr.cooparties.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.cooparties.domain.Utilisateur;

@Path("/utilisateur")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public interface UtilisateurWs {

	@Path("/{utilisateur}/mdp/{mdp}")
	@GET
	Utilisateur getUtilisateur(@PathParam("utilisateur") String utilisateur,
			@PathParam("mdp") String mdp);

}
