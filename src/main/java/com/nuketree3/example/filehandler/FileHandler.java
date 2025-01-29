package com.nuketree3.example.filehandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nuketree3.example.model.Person;

import java.io.File;
import java.io.IOException;

public class FileHandler implements Writable, Readable {

    private final ObjectMapper objectMapper;

    public FileHandler() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Person readPersonFromFile(String filename) {
        Person person = null;
        try {
            person = objectMapper.readValue(new File(filename), objectMapper.getTypeFactory().constructType(Person.class));
            return person;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void writePersonInFile(Person person, String filename) {
        try{
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(filename),person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
