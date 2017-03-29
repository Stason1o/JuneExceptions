package com.endava.main;

import com.endava.exepctions.ExceptionFact;
import com.endava.exepctions.MyException;
import com.endava.util.FileProcessor;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbogdanschi on 29/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();

        ExceptionFact exceptionFact = new ExceptionFact();
        List<Object> list = new ArrayList<Object>() {
            {
                add(10);
                add(50);
            }
        };

        try {

            try {
                fileProcessor.readFile("C:///Users//sbogdanschi//IdeaProjects//JuneExceptions//txt.txt");
                exceptionFact.createFileNotFoundException("C:///Users//sbogdanschi//IdeaProjects//JuneExceptions//file.txt");
            } catch (NoSuchFileException ex) {
                throw new MyException(ex);
            }
        } catch (MyException myException) {
            myException.printStackTrace();
            myException.handleException();
        }

        fileProcessor.getDataStorage().forEach(System.out::println);

//        try {
//            try {
//                exceptionFact.createArrayException(list);
//            } catch (IndexOutOfBoundsException ex) {
//                throw new MyException(ex);
//            }
//        } catch (MyException myException) {
//            myException.printStackTrace();
//            myException.handleException();
//        }
//
//        try {
//            try {
//                exceptionFact.createClassCastException(list);
//            } catch (ClassCastException ex) {
//                throw new MyException(ex);
//            }
//        } catch (MyException myException) {
//            myException.printStackTrace();
//            myException.handleException();
//        }

        try{
            exceptionFact.throwRandomException();
        }catch (Throwable  ex){
            if (ex instanceof ClassCastException)
                System.err.println("EXCEPTION ClassCastException!!!!!!!!");
            else if(ex instanceof ArrayIndexOutOfBoundsException)
                System.err.println("EXCEPTION ArrayIndexOutOfBoundException!!!!!!!");
            else if(ex instanceof MyException)
                System.err.println("MyException EXCEPTION!!!!!!");
        }
    }
}
