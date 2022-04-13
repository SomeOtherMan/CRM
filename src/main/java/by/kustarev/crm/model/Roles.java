package by.kustarev.crm.model;

public enum Roles {
    PM ("PM"),
    BA ("BA"),
    DEV ("DEV"),
    ADMIN ("ADMIN");

    private final String name;

    private Roles(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
