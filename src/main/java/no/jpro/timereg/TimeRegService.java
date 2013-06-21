package no.jpro.timereg;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * User: runeks
 * Date: 21.06.13
 * Time: 11:37
 */
@Path("api/timeregistreringer")
public class TimeRegService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String timeRegistreringer(@QueryParam("aar") String aar, @QueryParam("maaned") String maaned) {

        // TODO hente fra "DB" og lage JSON
        return "{\"id\": 123, \"dato\": \"2013-06-01T00:00:00Z\", \"timer\": 8, \"kommentar\": \"\"}";
    }





}
