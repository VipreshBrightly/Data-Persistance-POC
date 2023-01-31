package org.acme;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Customerrepo implements PanacheRepositoryBase<testEntity, Integer>
{

}
