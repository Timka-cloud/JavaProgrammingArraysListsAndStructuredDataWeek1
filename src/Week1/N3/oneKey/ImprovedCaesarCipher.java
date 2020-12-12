package Week1.N3.oneKey;

import edu.duke.FileResource;

public class ImprovedCaesarCipher {
    /**
     * It's the same code like previously but here I use OOP not procedure programming;'
     * I did some changes( here we have now fields, constructors and methods.
     * And I'm not starting this class in this class I use another class TestCaesarCipher
     */
    private final String alphabetUpper;
    private final String alphabetLower;
    private final String shiftedAlphabetUpper;
    private final String shiftedAlphabetLower;


    public ImprovedCaesarCipher(int key){
        alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabetLower = alphabetUpper.toLowerCase();
        shiftedAlphabetUpper = alphabetUpper.substring(key) + alphabetUpper.substring(0,key);
        shiftedAlphabetLower = shiftedAlphabetUpper.toLowerCase();

    }

    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < encrypted.length(); i++) {
            char ch = encrypted.charAt(i);
            if(Character.isUpperCase(ch)){
                int idxUpper = alphabetUpper.indexOf(ch);
                if(idxUpper != -1){
                    char currUpper = shiftedAlphabetUpper.charAt(idxUpper);
                    encrypted.setCharAt(i,currUpper);
                }
            } else if (Character.isLowerCase(ch)){
                int idxLower = alphabetLower.indexOf(ch);
                if(idxLower != -1){
                    char currLower = shiftedAlphabetLower.charAt(idxLower);
                    encrypted.setCharAt(i,currLower);
                }
            }

        }
        return encrypted.toString();
    } // this method encrypt the message

    public int getKey(String input) {
        int[] arr = countLetters(input);
        int max = maxDex(arr);
        int dkey = max - 4;

        if (max < 4) {
            dkey = 26 - (4 - max);
        }
        return dkey;
    } // it get a key that has encrypted the message

    private int[] countLetters(String s){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int index = alpha.indexOf(Character.toLowerCase(curr));
            if(index != -1){
                count[index] += 1;
            }
        }
        return count;
    } // countLetters in the message

    private int maxDex(int[] val){
        int maxDex = 0;
        for (int i = 0; i < val.length; i++) {
            if(val[i] > val[maxDex]){
                maxDex = i;
            }
        }
        return maxDex;
    } // find the biggest letter

    public String decrypt(int key, String encrypt){
        ImprovedCaesarCipher icc = new ImprovedCaesarCipher(26-key);
        return icc.encrypt(encrypt);


    } // decrypt the message

    public String encryptFile(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        return encrypt(message);

    } // it's allow encrypt all file




}
