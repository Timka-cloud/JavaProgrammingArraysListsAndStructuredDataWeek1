package Week1.N3.TwoKey;

public class TestImprovedCaesarCipherWithTwoKeys {
    public static void main(String[] args) {
        ImprovedCaesarCipherWithTwoKeys twoKeys = new ImprovedCaesarCipherWithTwoKeys(3,4);
//        String encrypt1 = twoKeys.encryptWithTwoKeys("Heapere");
//        System.out.println(encrypt1);
//        String t = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";

//        String t = twoKeys.easyDecrypt(encrypt1);
//        System.out.println(t);
        String m = twoKeys.decryptFileWithTwoKeys();
        System.out.println(m);
 //       String mesa = twoKeys.decryptTwoKeys(m);
 //       System.out.println(mesa);
    }
}
