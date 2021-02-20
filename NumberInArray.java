package Array;

public class NumberInArray {

    public static void main(String[] args) {

        int[] arr = new int[10];

        for(int i = 0; i < 10; i++) {
            arr[i] = 1 + (int) (Math.random() * 10);
        }

        PrintArray(arr);
        CalSum(arr);
        CalAvg(arr);
        CalVar(arr);
    }

    static void PrintArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println("[" + i + "]: " + array[i]);
        }
    }

    static void CalSum(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Sum: " + sum);
    }

    static void CalAvg(int[] array) {
        double avg = 0;
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int len = array.length;
        avg = (double) sum / len;
        System.out.println("Average: " + avg);
    }

    static void CalVar(int[] array) {
        double avg = 0;
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int len = array.length;
        avg = (double) sum / len;

        double variance = 0;
        int squareSum = 0;
        for(int i = 0; i < array.length; i++) {
            squareSum += (array[i] - avg) * (array[i] - avg);
        }

        variance = (double) squareSum / len;
        System.out.println("Variance: " + variance);
    }
}
