package project;

public class Worker extends Human {
    private int id;
    public static int idCounter = 0;
    private int idWarehouse;
    private int salary;
    Worker(){}
    Worker(int idWarehouse, int salary){
        this.id = idCounter++;
        this.idWarehouse = 0;
        this.salary = salary;
    }
}
