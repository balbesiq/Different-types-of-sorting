public class RecursiveMergeSort {
    static int comparisons = 0;
    static int assignments = 0;

    public static void mergeSort(int[] a, int left, int right, int depth) {
        if (left < right) {
            int mid = (left + right) / 2;
            indent(depth); System.out.println("Розділяємо [" + left + ":" + right + "] → [" + left + ":" + mid + "] і [" + (mid + 1) + ":" + right + "]");
            mergeSort(a, left, mid, depth + 1);
            mergeSort(a, mid + 1, right, depth + 1);
            merge(a, left, mid, right, depth);
        }
    }

    private static void merge(int[] a, int left, int mid, int right, int depth) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = a[left + i];
        for (int j = 0; j < n2; j++) R[j] = a[mid + 1 + j];
        int i = 0, j = 0, k = left;
        indent(depth); System.out.println("  Злиття: " + java.util.Arrays.toString(L) + " + " + java.util.Arrays.toString(R));
        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) a[k++] = L[i++];
            else a[k++] = R[j++];
            assignments++;
        }
        while (i < n1) { a[k++] = L[i++]; assignments++; }
        while (j < n2) { a[k++] = R[j++]; assignments++; }
        indent(depth); System.out.println("  Результат: " + java.util.Arrays.toString(java.util.Arrays.copyOfRange(a, left, right + 1)));
    }

    public static void main(String[] args) {
        int[] a = {87, 79, 97, 82, 98, 40, 42, 88, 61};
        System.out.println("Початковий масив:");
        printArray(a);
        mergeSort(a, 0, a.length - 1, 0);
        System.out.println("\nВідсортований масив:");
        printArray(a);
        System.out.println("\nПорівнянь: " + comparisons + ", Присвоєнь: " + assignments);
    }

    private static void indent(int depth) { for (int i = 0; i < depth; i++) System.out.print("  "); }
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
