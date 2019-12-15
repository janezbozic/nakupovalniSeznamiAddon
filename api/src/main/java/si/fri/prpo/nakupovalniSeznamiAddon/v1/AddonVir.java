package si.fri.prpo.nakupovalniSeznamiAddon.v1;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@ApplicationScoped
@Path("priporocenArtikel")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AddonVir {

    HashMap<Integer, ArtikelData> mapa;

    @PostConstruct
    private void init(){
        mapa = new HashMap<>();
        ArtikelData a1 = new ArtikelData("Samsung galaxy s10", 899.99, 150, 1);
        ArtikelData a2 = new ArtikelData("Samsung galaxy s10+", 999.99,  120, 2);
        mapa.put(1, a2);
        mapa.put(2, a1);
    }

    @GET
    @Path("{id}")
    public Response pridobiNakupovalniSeznam(@PathParam("id") Integer id){

        if (id == 1)
            return Response.ok(mapa.get(1)).build();
        else
            return Response.ok(mapa.get(2)).build();

    }
}
