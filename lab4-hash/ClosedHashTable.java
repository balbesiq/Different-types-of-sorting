public class ClosedHashTable {
    static final int M = 13;
    static final double A = (Math.sqrt(5) - 1) / 2;

    static class Pair {
        int key;
        String value;
        Pair(int key, String value) { this.key = key; this.value = value; }
        public String toString() { return "(" + key + ", " + value + ")"; }
    }

    Pair[] table = new Pair[M];

    static final java.util.Map<Character, Integer> alphabet = java.util.Map.ofEntries(
        java.util.Map.entry('А',1), java.util.Map.entry('Б',2), java.util.Map.entry('В',3), java.util.Map.entry('Г',4),
        java.util.Map.entry('Ґ',5), java.util.Map.entry('Д',6), java.util.Map.entry('Е',7), java.util.Map.entry('Є',8),
        java.util.Map.entry('Ж',9), java.util.Map.entry('З',10), java.util.Map.entry('И',11), java.util.Map.entry('І',12),
        java.util.Map.entry('Ї',13), java.util.Map.entry('Й',14), java.util.Map.entry('К',15), java.util.Map.entry('Л',16),
        java.util.Map.entry('М',17), java.util.Map.entry('Н',18), java.util.Map.entry('О',19), java.util.Map.entry('П',20),
        java.util.Map.entry('Р',21), java.util.Map.entry('С',22), java.util.Map.entry('Т',23), java.util.Map.entry('У',24),
        java.util.Map.entry('Ф',25), java.util.Map.entry('Х',26), java.util.Map.entry('Ц',27), java.util.Map.entry('Ч',28),
        java.util.Map.entry('Ш',29), java.util.Map.entry('Щ',30), java.util.Map.entry('Ь',31), java.util.Map.entry('Ю',32),
        java.util.Map.entry('Я',33)
    );

    int keyFromWord(String word) {
        int sum = 0;
        for (char ch : word.toUpperCase().toCharArray())
            if (alphabet.containsKey(ch)) sum += alphabet.get(ch);
        return sum;
    }

    int hashDivision(int key) { return key % M; }

    int hashMultiplication(int key) {
        double fractional = (key * A) % 1;
        return (int) Math.floor(16 * fractional);
    }

    void insert(String word, boolean useDivision) {
        int key = keyFromWord(word);
        int index = useDivision ? hashDivision(key) : hashMultiplication(key);
        int i = 0;
        while (table[(index + i) % M] != null) i++;
        table[(index + i) % M] = new Pair(key, word);
    }

    void printTable() {
        for (int i = 0; i < M; i++) {
            System.out.print("Індекс " + i + ": ");
            System.out.println(table[i] == null ? "[]" : table[i]);
        }
    }

    public static void main(String[] args) {
        ClosedHashTable h = new ClosedHashTable();
        String[] words = {"Не", "хвали", "день", "до", "вечора", "а", "хліб", "до", "вечері"};

        for (String w : words)
            h.insert(w, true); // true = метод ділення

        h.printTable();
    }
}
