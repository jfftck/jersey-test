package jeffreytackett.rest;

import jeffreytackett.search.Search;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by Jeffrey on 2015-11-14.
 */
@Path("/search/category/{category}")
@Produces("application/json")
public class Category {
    @GET
    public String getItemsByCategory(@PathParam("category") String category) {
        return new Search().addCategoryRestriction(category).getItems();
    }
}
