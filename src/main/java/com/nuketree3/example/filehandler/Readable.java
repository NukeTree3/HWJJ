package com.nuketree3.example.filehandler;

import com.nuketree3.example.model.Person;

public interface Readable {
    Person readPersonFromFile(String filename);
}
