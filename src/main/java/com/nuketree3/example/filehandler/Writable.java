package com.nuketree3.example.filehandler;

import com.nuketree3.example.model.Person;

public interface Writable {
    void writePersonInFile(Person person, String fileName);
}
