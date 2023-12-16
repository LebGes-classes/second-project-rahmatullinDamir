package project;

import java.util.Scanner;

public class Storage {
    private int id;
    public static int idCounter = 0;
    private String address;
    private int capacity;
    private Worker responsibleEmployee;

//    Storage() {
//        this.id = idCounter++;
//    }
    Storage(String address, int capacity, Worker responsibleEmployee) {
        this.id = idCounter++;
        this.address = address;
        this.capacity = capacity;
        this.responsibleEmployee = responsibleEmployee;
    }

    public Storage() {
    }

    protected void moveItem(int idWarehouse, int idPvz){

    }
    protected void changeResponsibleEmployee(Worker responsibleEmployee){}

    protected void hireEmployee(Human newEmployee){}

    protected void fireEmployee(Worker employee){}

    protected void aboutStorage(){
        System.out.println("ID " + this.id + '\n' +
                "Адрес " + this.address + '\n' +
                "Вместительность " + this.capacity + '\n' +
                "Ответственный " + this.responsibleEmployee);
    }

    protected void aboutItems(){}

//    protected void closeStorage(){}
//
//    protected void openStorage(){}

//    protected void createStorage(){
//
////        responsibleEmployee = Worker.;
//    }
//
//    protected void removeStorage(){
//
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public void setResponsibleEmployee(Worker responsibleEmployee){
        this.responsibleEmployee = responsibleEmployee;
    }
}
