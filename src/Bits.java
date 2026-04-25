package src;

public class Bits {

    public static int countBits(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static int rotateLeft(int n, int shift) {
        return Integer.rotateLeft(n, shift);
    }

    public static int rotateRight(int n, int shift) {
        return Integer.rotateRight(n, shift);
    }

    public static int bitReverse(int n) {
        return ~n;
    }

    public static int getBit(int n, int pos) {
        return (n >>> pos) & 1;
    }

    public static int setBit(int n, int pos) {
        return n | (1 << pos);
    }

    public static int clearBit(int n, int pos) {
        return n & ~(1 << pos);
    }

    public static int toggleBit(int n, int pos) {
        return n ^ (1 << pos);
    }

    public static boolean parityCheck(int n) {
        return countBits(n) % 2 != 0;
    }
}
