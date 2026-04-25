package src;

public class Math2 {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static int power(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) result *= base;
        return result;
    }

    public static int absVal(int n) {
        return n < 0 ? -n : n;
    }

    public static int clamp(int val, int min, int max) {
        if (val < min) return min;
        if (val > max) return max;
        return val;
    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
