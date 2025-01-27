package com.example.springboot.Repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseRepository<T> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    // Method to read data from file
    public List<T> readData(String filePath, Class<T> clazz) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return objectMapper.readValue(file,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
            } else {
                return new ArrayList<>(); // Return an empty list if file doesn't exist
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON file", e);
        }
    }

    // Method to write data to file
    public void writeData(String filePath, List<T> data) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to JSON file", e);
        }
    }
}
