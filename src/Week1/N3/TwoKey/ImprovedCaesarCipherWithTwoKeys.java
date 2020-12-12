package Week1.N3.TwoKey;

import Week1.N1.classWork.CaesarCipher;
import edu.duke.FileResource;

public class ImprovedCaesarCipherWithTwoKeys {
    private final String alphabetUpper;
    private final String alphabetLower;
    private final String shiftedAlphabetUpper1;
    private final String shiftedAlphabetLower1;
    private final String shiftedAlphabetUpper2;
    private final String shiftedAlphabetLower2;
    private int keyFor1;
    private int keyFor2;

    public ImprovedCaesarCipherWithTwoKeys(int key1, int key2) {
        alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabetLower = alphabetUpper.toLowerCase();
        shiftedAlphabetUpper1 = alphabetUpper.substring(key1) + alphabetUpper.substring(0, key1);
        shiftedAlphabetLower1 = alphabetLower.substring(key1) + alphabetLower.substring(0, key1);

        shiftedAlphabetUpper2 = alphabetUpper.substring(key2) + alphabetUpper.substring(0, key2);
        shiftedAlphabetLower2 = alphabetLower.substring(key2) + alphabetLower.substring(0, key2);
        keyFor1 = key1;
        keyFor2 = key2;

    }

    public String encryptWithTwoKeys(String input) {
        StringBuilder encrypted = new StringBuilder(input);
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

    public String encryptFileWithTwoKeys(){ // считывает предложение с файла и затем отправляет их на шифрование
        FileResource fr = new FileResource();
        String message = fr.asString();
        return encryptWithTwoKeys(message);

    }

    public String decryptFileWithTwoKeys(){ // считывает уже зашифрованное предложение с файла и затем отправляет их на расшифрование
        FileResource fr = new FileResource();
        String message = fr.asString();
        return decryptTwoKeys(message);


    }

    private int[] countLetters(String s){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = alpha.indexOf(Character.toLowerCase(ch));
            if(index != - 1){
                count[index] += 1;
            }

        }
        return count;
    }

    private int maxIndex(int[] val){
        int maxDex = 0;
        for (int i = 0; i < val.length; i++) {
            if(val[i] > val[maxDex]){
                maxDex = i;
            }
        } return maxDex;
    }

    public int getKeys(String s){
        int[] count = countLetters(s);
        int max = maxIndex(count);
        int dkey = max - 4;
        if(dkey < 0){
            return dkey + 26;
        }
        return dkey;

    }

    private String halfOfString(String message, int start){
        String result = new String();
        for (int i = start; i < message.length(); i = i + 2) {
            result = result + message.charAt(i);
        }
        return result;
    } // делить строку на четные или нечетный берет четные потом нечетный

    public String decryptTwoKeys(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        String part_1 = halfOfString(encrypted, 0);
        String part_2 = halfOfString(encrypted, 1);

        int dkey2 = getKeys(part_2);
        int dkey1 = getKeys(part_1);

        System.out.println("The two keys are " + dkey1 + " and " + dkey2);

        String newinput1 = cc.encrypt(part_1, 26-dkey1);
        String newinput2 = cc.encrypt(part_2, 26-dkey2);



        int n1 = newinput1.length();
        int n2 = newinput2.length();

        String newinput = new String();
        if (n1 > n2) {
            for (int i = 0; i < n2; i++) {
                newinput = newinput + newinput1.substring(i, i+1);
                newinput = newinput + newinput2.substring(i, i+1);
            }
            newinput = newinput + newinput1.substring(n1-1, n1);
        }

        if (n1 == n2) {
            for (int i = 0; i < n2; i++) {
                newinput = newinput + newinput1.substring(i, i+1);
                newinput = newinput + newinput2.substring(i, i+1);
            }
        }

        if (n1 < n2) {
            for (int i = 0; i < n1; i++) {
                newinput = newinput + newinput1.substring(i, i+1);
                newinput = newinput + newinput2.substring(i, i+1);
            }
            newinput = newinput + newinput2.substring(n2-1, n2);
        }

        return(newinput);


    }
    public String easyDecrypt(String input){  // it's easy when you know the keys
        ImprovedCaesarCipherWithTwoKeys cc = new ImprovedCaesarCipherWithTwoKeys(26 - keyFor1, 26-keyFor2);
        String decrypt = cc.encryptWithTwoKeys(input);
        return decrypt;
    }


}
