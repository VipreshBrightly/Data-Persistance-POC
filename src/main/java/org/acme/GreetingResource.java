package org.acme;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/author")
@ApplicationScoped
public class GreetingResource {

    @POST
    public Uni<String> addAuthor(Author author) {
        System.out.println(author.book.title);
       return Panache.<Author>withTransaction(author::persist).onItem()
               .transform(inserted->inserted.id.toString());
    }


}