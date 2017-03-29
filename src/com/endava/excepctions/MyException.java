package com.endava.excepctions;

import java.nio.file.NoSuchFileException;

/**
 * Created by sbogdanschi on 29/03/2017.
 */
public class MyException extends Throwable {

    Object myException;

    public MyException() {
        //empty Constructor
    }

    public MyException(Object myException) {
        this.myException = myException;
    }

    public void handleException() {
        if (myException instanceof IndexOutOfBoundsException) {
            //((IndexOutOfBoundsException) myException).printStackTrace();
            System.err.println("You're trying to access index, that is not in array : " + ((IndexOutOfBoundsException) myException).getMessage());
        }

        if (myException instanceof NoSuchFileException) {
            //((NoSuchFileException) myException).printStackTrace();
            System.err.println("There's no such file");
        }

        if (myException instanceof ClassCastException) {
           // ((ClassCastException) myException).printStackTrace();
            System.err.println("You cannot cast to type you want! " + ((ClassCastException) myException).getMessage());
        }

        if(myException instanceof MyException){
            System.err.println("Exception MyException was catch here");
        }
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println("Overridden method printStackTrace");
    }
}
