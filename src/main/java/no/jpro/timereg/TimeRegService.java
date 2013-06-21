package no.jpro.timereg;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * User: runeks
 * Date: 21.06.13
 * Time: 11:37
 */
@Path("api/")
public class TimeRegService {

    private static AtomicLong idGenerator = new AtomicLong();
    private static List<Timeregistrering> registreringer = new ArrayList<Timeregistrering>();


    @Path("timeregistreringer")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Timeregistrering> timeRegistreringer(@QueryParam("aar") String aar, @QueryParam("maaned") String maaned) {

        List<Timeregistrering> liste = new ArrayList<Timeregistrering>();
        liste.add(new Timeregistrering("1"));
        liste.add(new Timeregistrering("2"));
        return liste;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response timeReg(Timeregistrering registrering) {
        registrering.setId(String.valueOf(idGenerator.incrementAndGet()));
        registreringer.add(registrering);
        return Response.ok(registrering).build();
    }


}
