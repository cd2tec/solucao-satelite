package src;

public class Crypto {

    public static byte[] xorCipher(byte[] data, byte key) {
        byte[] result = new byte[data.length];
        for (int i = 0; i < data.length; i++) result[i] = (byte)(data[i] ^ key);
        return result;
    }

    public static String caesarEncrypt(String text, int shift) {
        shift = shift % 26;
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z') sb.append((char)(((c - 'A' + shift) % 26) + 'A'));
            else if (c >= 'a' && c <= 'z') sb.append((char)(((c - 'a' + shift) % 26) + 'a'));
            else sb.append(c);
        }
        return sb.toString();
    }

    public static String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - (shift % 26));
    }

    public static int checksum8(byte[] data) {
        int sum = 0;
        for (byte b : data) sum += (b & 0xFF);
        return sum & 0xFF;
    }
}
