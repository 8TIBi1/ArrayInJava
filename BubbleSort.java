package Array;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {2, 6, 4, 8, 10, 12, 89, 68, 45, 37};
        System.out.println("Data items in original order: ");
        String output = "";
        for(int i = 0; i < 10; i++) {
            output += "\t" + arr[i];
        }
        System.out.println(output);

        System.out.println("Data items in ascending order: ");
        sort(arr);
        String afterSorted = "";
        for(int i = 0; i < 10; i++) {
            afterSorted += "\t" + arr[i];
        }
        System.out.println(afterSorted);
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

}
