package Week1.N1.classWork;
import edu.duke.*;
public class CaesarCipher {
    public String encrypt(String input, int key){
        // Make a StringBuilder with message encrypted
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        // compute the shifted alphabet
        String shiftedAlphabetUpper = alphabetUpper.substring(key) + alphabetUpper.substring(0,key);
        String shiftedAlphabetLower = alphabetLower.substring(key) + alphabetLower.substring(0,key);
        //count from 0 to < length of encrypted, (call it i)
        for (int i = 0; i < encrypted.length(); i++) {
            // Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            if(Character.isUpperCase(currChar)){
                //Find the index of currChar in the alphabet (call it idx)
                int idx = alphabetUpper.indexOf(currChar);
                //If currChar is in the alphabet
                if(idx != -1){
                    // Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabetUpper.charAt(idx);

                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i,newChar);
                }
            } else if(Character.isLowerCase(currChar)){
                int idx1 = alphabetLower.indexOf(currChar);
                if(idx1 != -1){
                    char newChar1 = shiftedAlphabetLower.charAt(idx1);
                    encrypted.setCharAt(i,newChar1);
                }
            }





            // Otherwise do nothing
        }
        // Your answer is the String inside of encrypted
        return encrypted.toString();

    }
    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);

        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";

        String shiftedAlphabetUpper1 = alphabetUpper.substring(key1) + alphabetUpper.substring(0, key1);
        String shiftedAlphabetLower1 = alphabetLower.substring(key1) + alphabetLower.substring(0, key1);

        String shiftedAlphabetUpper2 = alphabetUpper.substring(key2) + alphabetUpper.substring(0, key2);
        String shiftedAlphabetLower2 = alphabetLower.substring(key2) + alphabetLower.substring(0, key2);

        for (int i = 0; i < encrypted.length(); i++) {
            // Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            if (Character.isUpperCase(currChar)) {
                //Find the index of currChar in the alphabet (call it idx)
                int idx = alphabetUpper.indexOf(currChar);
                //If currChar is in the alphabet
                if (idx != -1 && i % 2 == 0) {
                    // Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabetUpper1.charAt(idx);

                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);

                } else if (idx != -1 && i % 2 == 1) {
                    char newChar = shiftedAlphabetUpper2.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }


            } else if (Character.isLowerCase(currChar)) {
                int idx1 = alphabetLower.indexOf(currChar);
                if (idx1 != -1 && i % 2 == 0) {
                    char newChar1 = shiftedAlphabetLower1.charAt(idx1);
                    encrypted.setCharAt(i, newChar1);
                } else if (idx1 != -1 && i % 2 == 1) {
                    char newChar1 = shiftedAlphabetLower2.charAt(idx1);
                    encrypted.setCharAt(i, newChar1);
                }
            }



        }
        return encrypted.toString();
    }
    public String testCaesar(){
        int key2 = 21;
        int key1 = 3;
        FileResource fr = new FileResource();
        String message  = fr.asString();
        String encrypted = encrypt(message, key1);
        System.out.println(encrypted);
//        String decrypted = encrypt(encrypted, 26-key1);
//        System.out.println(decrypted);

        return encrypted;

    }

    public static void main(String[] args) {
//        CaesarCipher cc = new CaesarCipher();
//        cc.testCaesar();
//       String s = cc.encryptTwoKeys("First Legion",23,17);
//        System.out.println(s);
    }
}
