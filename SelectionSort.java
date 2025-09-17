public class Main {
    public static void main(String[] args) {
        int[] arr = {47, 50, 61, 41, 53, 12, 68, 63, 3};

        System.out.print("\n\tUnsorted array: \n");
        printArray(arr);

        for(int i = 0; i < arr.length - 1; i++) { /*зовнішній цикл, прогоняємо по всім елементам крім останнього,
                                                   бо останній елемент у будь якому випадку буде свапатися з іншим*/
            int tempMinIndex = i;
            for(int j = i + 1; j < arr.length; j++) {  // внутрішній цикл для знаходження мінімума
                if(arr[j] < arr[tempMinIndex]) {
                    tempMinIndex = j;
                }
            }

            int temp = arr[i];      // бульбашка (●'◡'●)
            arr[i] = arr[tempMinIndex];
            arr[tempMinIndex] = temp;
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

