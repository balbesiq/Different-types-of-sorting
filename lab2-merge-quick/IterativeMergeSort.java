public class IterativeMergeSort {
    static int comparisons = 0;
    static int assignments = 0;

    public static void mergeSort(int[] a) {
        int n = a.length;
        for (int size = 1; size < n; size *= 2) {
            System.out.println("\n--- Розмір підмасиву = " + size + " ---");
            for (int left = 0; left < n - size; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                System.out.println("Об’єднуємо [" + left + ":" + mid + "] і [" + (mid + 1) + ":" + right + "]");
                merge(a, left, mid, right);
                printArray("Масив після злиття:", a);
            }
        }
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = a[left + i];
        for (int j = 0; j < n2; j++) R[j] = a[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) a[k++] = L[i++];
            else a[k++] = R[j++];
            assignments++;
        }
        while (i < n1) { a[k++] = L[i++]; assignments++; }
        while (j < n2) { a[k++] = R[j++]; assignments++; }
    }

    public static void main(String[] args) {
        int[] a = {87, 79, 97, 82, 98, 40, 42, 88, 61};
        System.out.println("Початковий масив:");
        printArray("", a);
        mergeSort(a);
        System.out.println("\nВідсортований масив:");
        printArray("", a);
        System.out.println("\nПорівнянь: " + comparisons + ", Присвоєнь: " + assignments);
    }

    private static void printArray(String msg, int[] arr) {
        System.out.print(msg + " [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
