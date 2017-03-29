package com.endava.excepctions;

import com.endava.util.FileProcessor;

import java.nio.file.NoSuchFileException;
import java.util.*;

/**
 * Created by sbogdanschi on 29/03/2017.
 */
public class ExceptionFact {

    private static FileProcessor fileProcessor;

    static {
        fileProcessor = new FileProcessor();
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

    public Throwable throwRandomException(Map<Integer, Throwable> exceptionMap) throws Throwable{
        return exceptionMap.get((int)(Math.random() * 3) + 1);
    }

    public int recursiveSumWithAssertion(List<Integer> list, int position, int length){
        assert !(position >= length);

        if(!(position >= length - 1))
            return list.get(position);
        else {
            return list.get(position) + recursiveSumWithAssertion(list, position + 1, length );
        }
    }
}
