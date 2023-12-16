package project;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static Storage[] listOfStorage = new Storage[10000];
    private static Worker[] listOfWorkers = new Worker[10000];

    public static void main(String[] args) {
        listOfStorage[0] = new Warehouse("213123", 122, null);
        listOfStorage[1] = new Pvz("213122223", 121, null);
        listOfStorage[2] = new Warehouse("999213123", 132, null);
        welcomeUI();
    }

    public static void welcomeUI() {
        Scanner scan = new Scanner(System.in);
        String userAns = "";
        while (!(userAns.equals("0"))) {
            System.out.println(" 1.Склад \n 2.Пункт продаж \n 3.Поставщик \n 4.Товары \n 5.Сотрудники \n 0.Выход");
            userAns = scan.nextLine();
            switch (userAns) {
                case "1":
                    System.out.println(" 1.Список \n 2.Создать \n 3.Выбрать склад для изменения/просмотра товаров/закрытия ");
                    switch (scan.nextLine()) {
                        case "1":
                            for (Storage storage : listOfStorage) {
                                if (storage != null && storage.getClass().equals(Warehouse.class)) {
                                    storage.aboutStorage();
                                }
                            }
                            break;
                        case "2":
                            createStorage(true);
                            break;
                        case "3":
                            multiplyAction(true);
                            break;
                        case "4":

                            break;
                    }
                    break;
                case "2":
                    System.out.println(" 1.Список \n 2.Создать \n 3.Выбрать пункт продаж для изменения/просмотра товаров/закрытия");
                    switch (scan.nextLine()) {
                        case "1":
                            for (Storage storage : listOfStorage) {
                                if (storage != null && storage.getClass().equals(Pvz.class)) {
                                    storage.aboutStorage();
                                }
                            }
                            break;
                        case "2":
                            createStorage(false);
                            break;
                        case "3":
                            multiplyAction(false);
                            break;
                    }
                    break;
                case "3":
                    System.out.println(" 1.Закупка \n 2.Новый товар \n 3.Закрыть поставщика \n");
                    switch (scan.nextLine()) {
                        case "1":
                            break;
                        case "2":
                            break;
                        case "3":
                            break;
                    }
                    break;
                case "4":
                    System.out.println(" 1.Продажа \n 2.Изменение характеристик \n");
                    switch (scan.nextLine()) {
                        case "1":
                            break;
                        case "2":
                            break;
                    }
                    break;
                case "5":
                    System.out.println("1.Нанять \n 2.Уволить");
                    switch (scan.nextLine()) {
                        case "1":
                            System.out.println("На каком складе он будет работать? (номер)");
                            int idWarehouse = scan.nextInt();
                            System.out.println("Какая будет зарплата?");
                            int salary = scan.nextInt();
                            listOfWorkers[Worker.idCounter] = new Worker(idWarehouse, salary);
                            break;
                        case "2":
                            System.out.println("Выберите номер сотрудника");
                            for (int i = 0; i < listOfWorkers.length; i++) {
                                if (listOfWorkers[i] != null)
                                    System.out.println(i + "." + listOfWorkers[i]);
                            }

                        default:
                            System.out.println("Вы ввели неверные данные, попробуйте еще раз.");
                            break;
                    }
                    break;
                case "0":
                    break;
            }
        }
        // метод созранения состояния программы json jackson
        // 3.Изменить
        // 4.Закрыть
        // 5.Товары в наличии
    }

    private static void createStorage(boolean isWarehouse) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите адрес");
        String address = scan.nextLine();
        System.out.println("Введите вместимость хранилища");
        int capacity = scan.nextInt();
        Worker responsibleEmployee = null;

        if (isWarehouse) {
            listOfStorage[Storage.idCounter] = new Warehouse(address, capacity, responsibleEmployee);
        } else {
            listOfStorage[Storage.idCounter] = new Pvz(address, capacity, responsibleEmployee);
        }
    }

    private static void printStorage(int storageIndex) {
        listOfStorage[storageIndex].aboutStorage();
    }

    private static void deleteStorage(int storageIndex) {
        listOfStorage[storageIndex] = null;
    }

    private static void multiplyAction(boolean isWarehouse) {
        Scanner scan = new Scanner(System.in);
        Storage[] storageEx = new Storage[100000];
        System.out.println("Выберите хранилище");
        for (int i = 0; i < listOfStorage.length; i++) {
            if (listOfStorage[i] != null &&
                    listOfStorage[i].getClass() == (isWarehouse ? Warehouse.class : Pvz.class)) {
                System.out.println(i + "." + listOfStorage[i]);
                storageEx[i] = listOfStorage[i];
            }
        }
        int indexOfStorage = scan.nextInt();
        scan.nextLine();
        System.out.println("1.Изменить \n 2.Закрыть \n 3.Товары в наличии");
        switch (scan.nextLine()) {
            case "1":
                System.out.println("Введите адрес");
                storageEx[indexOfStorage].setAddress(scan.nextLine());
                System.out.println("Введите вместимость");
                storageEx[indexOfStorage].setCapacity(scan.nextInt());
                break;
            case "2":
                deleteStorage(storageEx[indexOfStorage].getId());
                break;
            case "3":

                break;
            default:
                System.out.println("Вы ввели неверные данные, попробуйте еще раз.");
                break;
        }
    }

}


//        listOfStorage[0] = new Pvz("", 1, null);
//                listOfStorage[1] = new Warehouse("", 1, null);
//                for (Storage key : listOfStorage) {
//                if (key.getClass().equals(Pvz.class)) {
//        System.out.println(true);
//        } else {
//        System.out.println(false);
//        }
//        }