package com.endava.main;

import com.endava.excepctions.ExceptionFact;
import com.endava.excepctions.MyException;
import com.endava.util.FileProcessor;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sbogdanschi on 29/03/2017.
 */
public class Main {
    public static void main(String[] args) {

        Map<Integer, Throwable> exceptionMap =  new LinkedHashMap<Integer, Throwable>() {{
            put(1, new MyException());
            put(2, new IndexOutOfBoundsException());
            put(3, new ClassCastException());
        }
        };
        FileProcessor fileProcessor = new FileProcessor();

        ExceptionFact exceptionFact = new ExceptionFact();


        List<Object> list = new ArrayList<Object>() {
            {
                add(10);
                add(50);
            }
        };

        List<Integer> listInt = new ArrayList<Integer>() {
            {
                add(10);
                add(50);
            }
        };

        System.out.println(exceptionFact.recursiveSumWithAssertion(listInt, 4, listInt.size() - 1));

        try {
            try {
                fileProcessor.readFile("C:///Users//sbogdanschi//IdeaProjects//JuneExceptions//txt.txt");
                exceptionFact.createFileNotFoundException("C:///Users//sbogdanschi//IdeaProjects//JuneExceptions//file.txt");
            } catch (NoSuchFileException ex) {
                throw new MyException(ex);
            }
        } catch (MyException myException) {
            //myException.printStackTrace();
            myException.handleException();
        }

        fileProcessor.getDataStorage().forEach(System.out::println);

        try {
            try {
                exceptionFact.createArrayException(list);
            } catch (IndexOutOfBoundsException ex) {
                throw new MyException(ex);
            }
        } catch (MyException myException) {
            //myException.printStackTrace();
            myException.handleException();
        }

        try {
            try {
                exceptionFact.createClassCastException(list);
            } catch (ClassCastException ex) {
                throw new MyException(ex);
            }
        } catch (MyException myException) {
            //myException.printStackTrace();
            myException.handleException();
        }

        try {
            try {
                throw exceptionFact.throwRandomException(exceptionMap);
            } catch (Throwable ex) {
                throw new MyException(ex);
            }
        }catch (MyException myExcp) {
            myExcp.handleException();
        }
    }
}
