package Lesson_2.exceptions;

public class ExcMain {

    static String[] arr1 = new String[]{"1","2","3","4"};
    static String[] arr2 = new String[]{"5","6","7","8"};
    static String[] arr3 = new String[]{"9","10","11","12"};
    static String[] arr4 = new String[]{"13","14","15","16"};

    static String [][] arrays = new String [][] {arr1, arr2, arr3, arr4};

    public static void main(String[] args) {

        try {
            System.out.println(parseAndSum(arrays));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int parseAndSum(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        if (array.length != 4) throw new MyArraySizeException();

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i + 1, j + 1);
                }
            }
        }
        return sum;
    }
}