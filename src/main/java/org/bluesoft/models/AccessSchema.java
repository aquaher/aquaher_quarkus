package org.bluesoft.models;

import java.util.ArrayList;
import java.util.List;

public class AccessSchema {
    public String name;
    public String icon;
    public String to;
    public String title;
    public List<AccessSchema> items = new ArrayList<>();

    
    public AccessSchema(String name, String icon, String to, String title, List<AccessSchema> items) {
        this.name = name;
        this.icon = icon;
        this.to = to;
        this.title = title;
        this.items = items;
    }


    public AccessSchema() {
    }


    @Override
    public String toString() {
        return "AccessSchema [icon=" + icon + ", items=" + items + ", name=" + name + ", title=" + title + ", to=" + to
                + "]";
    }
    
    
}
