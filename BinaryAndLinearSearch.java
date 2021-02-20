package Array;

/*
*   本次测试采用的数据规模是10万，计算查找时间的单位是纳秒(ns)，因为之前用了毫秒(ms)，但有时候会出现 0 ms 的情况，所以改用纳秒。
*
*  某一次的运行时间对比：
*
*  Time of BinarySearch: 6800ns
*  One of the position of 1000 is 10047
*
*  Time of LinearSearch: 113100ns
*  One of the position of 1000 is 10045
*
 */


public class BinaryAndLinearSearch {

    public static void main(String[] args) {

        final int number = 100000;

        int[] array = new int[number];

        String printArr = "";
        for(int i = 0; i < number; i++) {
            array[i] = 1 + (int) (Math.random() * 10000);
            printArr += "\tarray[" + i + "]: " + array[i];
        }
//        System.out.println(printArr);

        sort(array);
//        System.out.print(array[0]);
//        for(int i = 1; i < array.length; i++) {
//            System.out.print("\t" + array[i]);
//        }

        int element = 1000;


        int position = BinarySearch(array, element);

        if(position >= 0)
            System.out.println("One of the position of " + element + " is " + position);
        System.out.println();
        int anotherPosition = LinearSearch(array, element);
        if(position >= 0)
            System.out.println("One of the position of " + element + " is " + anotherPosition);
    }

    static void sort(int[] array) {
        int n = array.length;
        for(int i = 0; i < (n - 1); i++) {
            for(int j = 0; j < (n - 1 - i); j++) {
                if(array[j] >= array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }


    static int BinarySearch(int[] array, int elem) {
        long startTime = System.nanoTime();
        int len = array.length;
        int lo = 0, hi = len - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(array[mid] > elem) {
                hi = mid - 1;
            }
            else if(array[mid] < elem) {
                lo = mid + 1;
            }
            else {
                long endTime = System.nanoTime();
                System.out.println("Time of BinarySearch: " + (endTime - startTime) + "ns");
                return mid;
            }
        }
        System.out.println("\n" + elem + " Not Found !!!");
        return -1;

    }


    static int LinearSearch(int[] array, int elem) {
        long startTime = System.nanoTime();
        int len = array.length;
        for(int i = 0; i < len; i++) {
            if(array[i] == elem) {
                long endTime = System.nanoTime();
                System.out.println("Time of LinearSearch: " + (endTime - startTime) + "ns");
                return i;
            }
        }
        System.out.println("\"" + elem + "\" Not Found !!!");
        return -1;
    }
}
