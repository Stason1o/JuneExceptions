package com.endava.exepctions;

import com.endava.util.FileProcessor;

import java.nio.file.NoSuchFileException;
import java.util.*;

/**
 * Created by sbogdanschi on 29/03/2017.
 */
public class ExceptionFact {

    private static FileProcessor fileProcessor;
    private static Map<Integer, Throwable> exceptionMap;

    static {
        fileProcessor = new FileProcessor();
        exceptionMap = new LinkedHashMap<Integer, Throwable>() {{
                put(1, new MyException());
                put(2, new ArrayIndexOutOfBoundsException());
                put(3, new ClassCastException());
            }
        };
    }

    public ExceptionFact() {
        //empty constructor
    }

    public void createArrayException(List<Object> list) throws IndexOutOfBoundsException{
        System.out.println(list.get(list.size() + 1));
    }

    public void createFileNotFoundException(String path) throws NoSuchFileException {
        fileProcessor.readFile(path);
    }

    public void createClassCastException(List<Object> list) throws ClassCastException{
        System.out.println((String)list.get(0));
    }

    public void throwRandomException() throws Throwable{
        throw  exceptionMap.get((int)(Math.random() * 3) + 1);
    }
}
