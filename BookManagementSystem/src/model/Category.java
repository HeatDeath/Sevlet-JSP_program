package model;

import javax.print.DocFlavor;

public class Category {
    private String id;
    private String catgoryName;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatgoryName() {
        return catgoryName;
    }

    public void setCatgoryName(String catgoryName) {
        this.catgoryName = catgoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
