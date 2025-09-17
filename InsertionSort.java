public class Main {
    public static void main(String[] args) {
        int[] arr = {47, 50, 61, 41, 53, 12, 68, 63, 3};

        System.out.print("\n\tUnsorted array:\n");
        printArray(arr);

        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];

            //шукаємо місце для currentValue серед вже відсортованих елементів
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > currentValue) {
                    arr[j + 1] = arr[j]; // здвигаємо вправо
                } else {
                    break; // брейк коли знайшли місце
                }
            }

            arr[j + 1] = currentValue;
        }

        System.out.print("\n\tSorted array:\n");
        printArray(arr);
    }

    public static void printArray(int[] arr) { // метод для виведення масиву
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}

