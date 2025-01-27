package com.example.springboot.Repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springboot.Models.Class;
import com.example.springboot.Models.Class.ClassDTO;

@Repository
public class ClassRepository extends BaseRepository<Class> {
    public static String FILE_PATH = "DatabaseFiles/Classes.json";

    public Class GetClassById(int classId) {
        List<Class> classes = readData(FILE_PATH, Class.class);
        for (Class classObj : classes) {
            if (classObj.classId == classId) {
                return classObj;
            }
        }
        return null;
    }

    public void addClass(ClassDTO classDTO) {
        List<Class> classes = readData(FILE_PATH, Class.class);
        classes.add(classDTO.convertToClass(classDTO));
        writeData(FILE_PATH, classes);
    }
}
