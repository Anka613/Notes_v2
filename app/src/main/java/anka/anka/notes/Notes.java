package anka.anka.notes;

import java.util.Date;

public class Notes {
    private String name;
    private String description;
    private Date created;

    public Notes(String name, String description, Date created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreated() {
        return created;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
