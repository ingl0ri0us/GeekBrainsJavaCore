package Lesson_2.exceptions;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Wrong array size(4 by 4 needed)");
    }
}
