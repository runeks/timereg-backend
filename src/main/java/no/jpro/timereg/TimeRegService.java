package no.jpro.timereg;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * User: runeks
 * Date: 21.06.13
 * Time: 11:37
 */
@Path("api/")
public class TimeRegService {

    @Path("timeregistreringer")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String timeRegistreringer(@QueryParam("aar") String aar, @QueryParam("maaned") String maaned) {

        // TODO hente fra "DB" og lage JSON
        return "{\"id\": 123, \"dato\": \"2013-06-01T00:00:00Z\", \"timer\": 8, \"kommentar\": \"\"}";
    }

    @Path("timeregistrering/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Timeregistrering finnTimeregistering(@PathParam("id") String id) {
        return new Timeregistrering(id);
    }

    @Path("timeregistreringer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void timeReg() {

    }


}
