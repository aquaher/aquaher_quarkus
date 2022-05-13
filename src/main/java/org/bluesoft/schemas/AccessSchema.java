package org.bluesoft.schemas;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class AccessSchema {
    private String name;
    private String icon;
    private String to;
    private String title;
    private List<AccessSchema> items = new ArrayList<>();

    
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


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getIcon() {
        return icon;
    }


    public void setIcon(String icon) {
        this.icon = icon;
    }


    public String getTo() {
        return to;
    }


    public void setTo(String to) {
        this.to = to;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public List<AccessSchema> getItems() {
        return items;
    }


    public void setItems(List<AccessSchema> items) {
        this.items = items;
    }
    
    
}
