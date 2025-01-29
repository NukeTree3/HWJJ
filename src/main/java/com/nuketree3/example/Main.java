package com.nuketree3.example;

import com.nuketree3.example.filehandler.FileHandler;
import com.nuketree3.example.model.Person;
import com.nuketree3.example.service.DBService;


public class Main {
    public static void main(String[] args) {
        testDBService();
        testFileHandler();
    }
    public static void testDBService() {
        DBService dbService = new DBService();
        dbService.init();
        dbService.add(new Person("testName1", 24));
        dbService.add(new Person("testName2", 24));
        dbService.add(new Person("testName3", 24));
        dbService.add(new Person("testName4", 24));
        dbService.add(new Person("testName5", 24));

        dbService.delete(5);
        dbService.update(6, "новоеИмя", 30);
        System.out.println(dbService.getPerson(6).toString());
    }

    public static void testFileHandler(){
        Person person = new Person("testName1", 24);
        FileHandler fileHandler = new FileHandler();
        fileHandler.writePersonInFile(person, "testJsonFile.json");
        Person person2 = fileHandler.readPersonFromFile("testJsonFile.json");
    }
}