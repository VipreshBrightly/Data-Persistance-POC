package org.acme;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/author")
@ApplicationScoped
public class GreetingResource {

    @POST
    public Uni<String> addAuthor(Author author) {
       return Panache.<Author>withTransaction(author::persist).onItem()
               .transform(inserted->inserted.id.toString());
    }

    @GET
    @Path("/{id}")
    public Uni<Author> findAuthor(long id){
        return Author.findById(id);
    }

}