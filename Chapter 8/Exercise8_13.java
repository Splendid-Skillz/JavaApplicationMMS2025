public class Exercise8_13 {

    // IntegerSet class
    static class IntegerSet {

        private boolean[] set; // index 0–100

        // Constructor (empty set)
        public IntegerSet() {
            set = new boolean[101];
        }

        // Insert element
        public void insertElement(int k) {
            if (k >= 0 && k <= 100)
                set[k] = true;
            else
                throw new IllegalArgumentException("Value must be between 0 and 100");
        }

        // Delete element
        public void deleteElement(int m) {
            if (m >= 0 && m <= 100)
                set[m] = false;
            else
                throw new IllegalArgumentException("Value must be between 0 and 100");
        }

        // Union
        public static IntegerSet union(IntegerSet set1, IntegerSet set2) {
            IntegerSet result = new IntegerSet();

            for (int i = 0; i < 101; i++) {
                result.set[i] = set1.set[i] || set2.set[i];
            }

            return result;
        }

        // Intersection
        public static IntegerSet intersection(IntegerSet set1, IntegerSet set2) {
            IntegerSet result = new IntegerSet();

            for (int i = 0; i < 101; i++) {
                result.set[i] = set1.set[i] && set2.set[i];
            }

            return result;
        }

        // Check equality
        public boolean isEqualTo(IntegerSet other) {
            for (int i = 0; i < 101; i++) {
                if (this.set[i] != other.set[i])
                    return false;
            }
            return true;
        }

        // toString
        public String toString() {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < 101; i++) {
                if (set[i]) {
                    result.append(i).append(" ");
                }
            }

            return result.length() == 0 ? "---" : result.toString();
        }
    }

    // Test program
    public static void main(String[] args) {

        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        // Insert elements into set1
        set1.insertElement(1);
        set1.insertElement(2);
        set1.insertElement(3);

        // Insert elements into set2
        set2.insertElement(2);
        set2.insertElement(3);
        set2.insertElement(4);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        // Union
        IntegerSet unionSet = IntegerSet.union(set1, set2);
        System.out.println("\nUnion: " + unionSet);

        // Intersection
        IntegerSet intersectionSet = IntegerSet.intersection(set1, set2);
        System.out.println("Intersection: " + intersectionSet);

        // Delete element
        set1.deleteElement(2);
        System.out.println("\nSet1 after deleting 2: " + set1);

        // Equality check
        System.out.println("Set1 equals Set2? " + set1.isEqualTo(set2));

        // Empty set test
        IntegerSet emptySet = new IntegerSet();
        System.out.println("\nEmpty set: " + emptySet);
    }
}