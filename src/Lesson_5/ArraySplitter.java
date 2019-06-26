package Lesson_5;

public class ArraySplitter {
    private final static int SIZE = 1_000_000;
    private final static int h = SIZE / 2;

    public static void main(String[] args) {

        noSplitArrayCount();
        splitArrayCount();
    }
    private static void noSplitArrayCount() {

        float[] array = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            array[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i /2));
        }
        long b = System.currentTimeMillis();

        System.out.println(b - a);
    }
    private static void splitArrayCount() {

        float[] initialArray = new float[SIZE];
        float[] firstHalfArray = new float[h];
        float[] secondHalfArray = new float[h];
        float[] finalArray = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            initialArray[i] = 1;
        }

        long a = System.currentTimeMillis();

        System.arraycopy(initialArray,0, firstHalfArray, 0, h);
        System.arraycopy(initialArray, h , secondHalfArray, 0, h);

        Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    firstHalfArray[i] = (float)(firstHalfArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i /2));
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    secondHalfArray[i] = (float)(secondHalfArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i /2));
                }
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(firstHalfArray,0,finalArray,0,h);
        System.arraycopy(secondHalfArray,0,finalArray,h,h);

        long b = System.currentTimeMillis();

        System.out.println(b - a);
    }

}
