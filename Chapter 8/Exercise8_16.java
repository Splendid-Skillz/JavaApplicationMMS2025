public class Exercise8_16 {

    public static void main(String[] args) {
        HugeInteger h1 = new HugeInteger();
        HugeInteger h2 = new HugeInteger();

        h1.parse("9999999999999999999999999999999999999999");
        h2.parse("1");

        System.out.println("H1: " + h1);
        System.out.println("H2: " + h2);

        HugeInteger sum = h1.add(h2);
        HugeInteger diff = h1.subtract(h2);

        System.out.println("\nSum: " + sum);
        System.out.println("Difference: " + diff);

        System.out.println("\nComparisons:");
        System.out.printf("h1 == h2: %b%n", h1.isEqualTo(h2));
        System.out.printf("h1 != h2: %b%n", h1.isNotEqualTo(h2));
        System.out.printf("h1 > h2: %b%n", h1.isGreaterThan(h2));
        System.out.printf("h1 < h2: %b%n", h1.isLessThan(h2));
        System.out.printf("h1 >= h2: %b%n", h1.isGreaterThanOrEqualTo(h2));
        System.out.printf("h1 <= h2: %b%n", h1.isLessThanOrEqualTo(h2));
        System.out.printf("h2 is zero: %b%n", h2.isZero());
    }
}

class HugeInteger {
    private int[] digits = new int[40]; // 40-digit number

    // Parse string into array
    public void parse(String number) {
        // Reset array
        for (int i = 0; i < digits.length; i++) {
            digits[i] = 0;
        }

        int len = number.length();
        int start = digits.length - len;

        for (int i = 0; i < len; i++) {
            char c = number.charAt(i);

            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Invalid digit in input");
            }

            digits[start + i] = c - '0';
        }
    }

    // Convert to String
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        // Skip leading zeros
        while (i < digits.length - 1 && digits[i] == 0) {
            i++;
        }

        for (; i < digits.length; i++) {
            sb.append(digits[i]);
        }

        return sb.toString();
    }

    // Add two HugeIntegers
    public HugeInteger add(HugeInteger other) {
        HugeInteger result = new HugeInteger();
        int carry = 0;

        for (int i = 39; i >= 0; i--) {
            int sum = this.digits[i] + other.digits[i] + carry;
            result.digits[i] = sum % 10;
            carry = sum / 10;
        }

        return result;
    }

    // Subtract (assumes this >= other)
    public HugeInteger subtract(HugeInteger other) {
        if (this.isLessThan(other)) {
            throw new ArithmeticException("Negative result not supported");
        }

        HugeInteger result = new HugeInteger();
        int borrow = 0;

        for (int i = 39; i >= 0; i--) {
            int diff = this.digits[i] - other.digits[i] - borrow;

            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.digits[i] = diff;
        }

        return result;
    }

    // Comparison helpers
    private int compare(HugeInteger other) {
        for (int i = 0; i < 40; i++) {
            if (this.digits[i] > other.digits[i]) return 1;
            if (this.digits[i] < other.digits[i]) return -1;
        }
        return 0;
    }

    public boolean isEqualTo(HugeInteger other) {
        return compare(other) == 0;
    }

    public boolean isNotEqualTo(HugeInteger other) {
        return compare(other) != 0;
    }

    public boolean isGreaterThan(HugeInteger other) {
        return compare(other) > 0;
    }

    public boolean isLessThan(HugeInteger other) {
        return compare(other) < 0;
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger other) {
        return compare(other) >= 0;
    }

    public boolean isLessThanOrEqualTo(HugeInteger other) {
        return compare(other) <= 0;
    }

    // Check if zero
    public boolean isZero() {
        for (int digit : digits) {
            if (digit != 0) return false;
        }
        return true;
    }
}