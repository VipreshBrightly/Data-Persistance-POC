package org.acme;


import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/hello")
@ApplicationScoped

public class GreetingResource {

    @Inject
    Customerrepo cust;
    @GET
    public Uni<testEntity> hello()
    {
        return testEntity.findById(1);
    }

    @POST
    @Transactional
    public Uni<testEntity> postMethod(testEntity test) {
        return Panache.<testEntity>withTransaction(test::persist);
    }
}