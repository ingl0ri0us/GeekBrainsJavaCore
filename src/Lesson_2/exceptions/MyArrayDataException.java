package Lesson_2.exceptions;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(int i, int j) {
        super("Cell in array[" + i + "][" + j + "] cannot be parsed");
    }
}
