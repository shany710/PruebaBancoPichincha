package com.petstore.utils;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LeerCSV<T> {

    private final Class<T> clase;

    public LeerCSV(Class<T> clase) {
        this.clase = clase;
    }

    public List<T> readCSVFile(String filePath) {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path rootProjectPath = Path.of(currentPath + filePath);
        try {
            return new CsvToBeanBuilder(new FileReader(rootProjectPath.toFile()))
                    .withType(clase)
                    .withSkipLines(1)
                    .withSeparator(';')
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
