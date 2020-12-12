package Week1.N3.oneKey;

import Week1.N3.oneKey.ImprovedCaesarCipher;

public class TestCaesarCipher {
    public static void main(String[] args) {
        ImprovedCaesarCipher icc = new ImprovedCaesarCipher(15);
        String encrypt = icc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        int key = icc.getKey(encrypt);
        System.out.println(encrypt);
        System.out.println("Key is + " + key);
        String decrypt = icc.decrypt(key,encrypt);
        System.out.println(decrypt);
//        String encryptMessage = icc.encryptFile();
//        String decryptMessage = icc.decrypt(key,encryptMessage);
//        System.out.println(encryptMessage);
//        System.out.println(decryptMessage);





    }
}
