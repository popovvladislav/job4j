package ru.job4j.tracker;

/**
 * Class formation filings.
 */
public class Item {
    private String name;
    private String description;
    private String id;
    private String comments;
    private long created;


    public Item() {
    }

    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComments() {
        return this.comments;
    }

    public long getCreated() {
        return this.created;
    }
    @Override
    public String toString() {
        return "Item{"
                + "name='" + name + '\''
                + ", description='" + description + '\'' + '}';
    }
}
