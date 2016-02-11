package jeffreytackett.search

import javax.json.Json
import javax.json.JsonArrayBuilder

/**
 * Created by Jeffrey on 2015-11-15.
 */
class Search {
    List<String> categories = []
    List<String> keywords = []
    boolean hasAutoClearRestrictions = true

    Search() {}

    boolean getHasAutoClearRestrictions() {
        return hasAutoClearRestrictions
    }

    void setHasAutoClearRestrictions(boolean isAutoClearRestrictions) {
        this.hasAutoClearRestrictions = isAutoClearRestrictions
    }

    public Search addCategoryRestriction(String category) {
        if (category) {
            categories.add(category)
        }

        return this
    }

    public void clearCategoryRestrictions() {
        categories.clear()
    }

    public Search addKeywordRestriction(String keyword) {
        if (keyword) {
            keywords.add(keyword)
        }

        return this
    }

    public void clearKeywordRestrections() {
        keywords.clear()
    }

    public void clearRestrictions() {
        clearCategoryRestrictions()
        clearKeywordRestrections()
    }

    public String listCategories() {
        String json

        if (hasAutoClearRestrictions) {
            clearRestrictions()
        }

        return json
    }

    public String getItems() {
        String json

        if (hasAutoClearRestrictions) {
            clearRestrictions()
        }

        return json
    }
}
