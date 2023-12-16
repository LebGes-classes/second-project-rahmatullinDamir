package project;

public class ItemList {
    private int id;
    private static int idCounter = 0;
    private String name;
    private String description;
    private int size;
    private int buyerCost;
    private int srokOkonchZakyp;

    ItemList() {
        this.id = idCounter++;
    }
}
