public class QuickSortHoare {
    static int comparisons = 0;
    static int swaps = 0;

    public static void quickSort(int[] a, int left, int right, int depth) {
        if (left < right) {
            int pivotIndex = partition(a, left, right, depth);
            quickSort(a, left, pivotIndex, depth + 1);
            quickSort(a, pivotIndex + 1, right, depth + 1);
        }
    }

    private static int partition(int[] a, int left, int right, int depth) {
        int pivot = a[left];
        int i = left - 1, j = right + 1;
        indent(depth); System.out.println("Partition(" + left + ", " + right + "), pivot = " + pivot);
        while (true) {
            do { i++; comparisons++; } while (a[i] < pivot);
            do { j--; comparisons++; } while (a[j] > pivot);
            if (i >= j) {
                indent(depth); System.out.println(" -> Повертаємо j = " + j);
                return j;
            }
            int tmp = a[i]; a[i] = a[j]; a[j] = tmp; swaps++;
            indent(depth); System.out.println("  Обмін a[" + i + "] і a[" + j + "]: " + java.util.Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int[] a = {87, 79, 97, 82, 98, 40, 42, 88, 61};
        System.out.println("Початковий масив:");
        System.out.println(java.util.Arrays.toString(a));
        quickSort(a, 0, a.length - 1, 0);
        System.out.println("\nВідсортований масив:");
        System.out.println(java.util.Arrays.toString(a));
        System.out.println("\nКількість порівнянь: " + comparisons);
        System.out.println("Кількість обмінів: " + swaps);
    }

    private static void indent(int d) { for (int i = 0; i < d; i++) System.out.print("  "); }
}
