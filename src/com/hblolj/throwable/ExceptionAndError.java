package com.hblolj.throwable;

import java.io.FileNotFoundException;

/**
 * Create With 昀尚智能.
 * Data : 2019/2/22
 * Time : 15:41
 */
public class ExceptionAndError {

    private void throwError(){
        throw new StackOverflowError();
    }

    private void throwRuntimeException(){
        throw new RuntimeException();
    }

    private void throwCheckedException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    public static void main(String[] args) throws FileNotFoundException {
        ExceptionAndError error = new ExceptionAndError();
        error.throwError();
        error.throwRuntimeException();
        error.throwCheckedException();
    }
}
