package com.example.appazkar.Model;

public class AzkarDetails {
    private String category;
    private int count;
    private String description;
    private int menuId;
    private String reference;
    private String zekr;

    public AzkarDetails(String category, int count, String description, int menuId, String reference, String zekr) {
        this.category = category;
        this.count = count;
        this.description = description;
        this.menuId = menuId;
        this.reference = reference;
        this.zekr = zekr;
    }

    public AzkarDetails() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getZekr() {
        return zekr;
    }

    public void setZekr(String zekr) {
        this.zekr = zekr;
    }
}
