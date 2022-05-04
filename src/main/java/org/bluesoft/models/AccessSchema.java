package org.bluesoft.models;

import java.util.ArrayList;
import java.util.List;

public class AccessSchema {
    public String icon;
    public String path;
    public String title;
    public List<AccessSchema> items = new ArrayList<>();
    public AccessSchema(String icon, String path, String title, List<AccessSchema> items) {
        this.icon = icon;
        this.path = path;
        this.title = title;
        this.items = items;
    }
    public AccessSchema() {
    }
    @Override
    public String toString() {
        return "AccessSchema [icon=" + icon + ", items=" + items + ", path=" + path + ", title=" + title + "]";
    }
    
}
