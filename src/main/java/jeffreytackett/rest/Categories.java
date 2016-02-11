package jeffreytackett.rest;

import jeffreytackett.search.Search;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Jeffrey on 2015-11-14.
 */
@Path("/search/category")
@Produces("application/json")
public class Categories {
    @GET
    public String listCategories() {
        return new Search().listCategories();
    }

}
