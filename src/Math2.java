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

    public static long power(int base, int exp) {
        long result = 1;
        long b = base;
        int e = exp;
        while (e > 0) {
            if ((e & 1) == 1) result *= b;
            b *= b;
            e >>= 1;
        }
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

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    public static int[] primesSieve(int limit) {
        boolean[] sieve = new boolean[limit + 1];
        java.util.Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        for (int i = 2; i * i <= limit; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= limit; j += i) sieve[j] = false;
            }
        }
        int count = 0;
        for (boolean b : sieve) if (b) count++;
        int[] primes = new int[count];
        int idx = 0;
        for (int i = 0; i <= limit; i++) if (sieve[i]) primes[idx++] = i;
        return primes;
    }

    public static int digitSum(int n) {
        n = Math.abs(n);
        int sum = 0;
        while (n > 0) { sum += n % 10; n /= 10; }
        return sum;
    }
}
