package jeffreytackett.datastore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Jeffrey on 2015-11-16.
 */
@Entity
@Table(name = "Inventory")
public class Item {
    /*
    * Hibernate entity that matches the H2 database table Inventory.
    * */
    String category;
    String itemId;
    String parentCategory;
    String title;
    String imageUrl;
    int itemHashint64;
    int upc;
    Date modifiedDate;
    Date createdDate;
    String department;
    String popularityIndex;
    String brand;
    boolean isActive;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Id
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(String parentCategory) {
        this.parentCategory = parentCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getItemHashint64() {
        return itemHashint64;
    }

    public void setItemHashint64(int itemHashint64) {
        this.itemHashint64 = itemHashint64;
    }

    public int getUpc() {
        return upc;
    }

    public void setUpc(int upc) {
        this.upc = upc;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPopularityIndex() {
        return popularityIndex;
    }

    public void setPopularityIndex(String popularityIndex) {
        this.popularityIndex = popularityIndex;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
