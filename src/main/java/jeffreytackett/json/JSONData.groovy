package jeffreytackett.json

import jeffreytackett.datastore.Item

import javax.json.Json
import javax.json.JsonArrayBuilder
import javax.json.JsonObject
import javax.json.JsonObjectBuilder
import javax.json.JsonValue

/**
 * Created by Jeffrey on 2015-11-16.
 */
class JSONData {
    private JsonObjectBuilder rootObject
    private List<Map<String, Object>> dataItems

    enum Filter {
        CATEGORY,
        PARENT_CATEGORY,
        DEPARTMENT,
        BRAND,
        TITLE,
        UPC,
        IMAGE_URL,
        CREATE_DATE,
        MODIFIED_DATE,
        ITEM_ID,
        ACTIVE,
        ITEM_HASHINI64,
        POPULARITY_INDEX
    }

    JSONData() {}

    public addData(List<Item> items) {

        rootObject = Json.createObjectBuilder()
        dataItems = []

        for (Item item : items) {
            dataItems.add([category: item.category])
            dataItems.add([parentCategory: item.parentCategory])
            dataItems.add([department: item.department])
            dataItems.add([brand: item.brand])
            dataItems.add([title: item.title])
            dataItems.add([upc: item.upc])
            dataItems.add([imageUrl: item.imageUrl])
            dataItems.add([createDate: item.createdDate])
            dataItems.add([modifiedDate: item.modifiedDate])
            dataItems.add([itemId: item.itemId])
            dataItems.add([active: item.active])
            dataItems.add([itemHashint64: item.itemHashint64])
            dataItems.add([popularityIndex: item.popularityIndex])
        }
    }

    public String buildJSON(List<Filter> filters = null) {
        if (filters) {

        }
    }


}
