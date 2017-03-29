package com.endava.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by sbogdanschi on 29/03/2017.
 */
public class FileProcessor {

    List<String> dataStorage;

    public FileProcessor() {
        dataStorage = new ArrayList<>();
    }

    public FileProcessor(List<String> dataStorage) {
        this.dataStorage = new ArrayList<>(dataStorage);
    }

    public List<String> getDataStorage() {
        return dataStorage;
    }

    public void setDataStorage(List<String> dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void readFile(String location) throws NoSuchFileException{
        Path fileLocation = Paths.get(location);

        if(Files.isRegularFile(fileLocation) & Files.isReadable(fileLocation) & Files.isExecutable(fileLocation)) {
            try (Stream<String> stream = Files.lines(Paths.get(location))) {
                stream.forEach(dataStorage::add);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else throw new NoSuchFileException(location);
    }

    public void writeToFile(String location){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileProcessor that = (FileProcessor) o;
        return Objects.equals(dataStorage, that.dataStorage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataStorage);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FileProcessor{");
        sb.append("dataStorage=").append(dataStorage);
        sb.append('}');
        return sb.toString();
    }
}
