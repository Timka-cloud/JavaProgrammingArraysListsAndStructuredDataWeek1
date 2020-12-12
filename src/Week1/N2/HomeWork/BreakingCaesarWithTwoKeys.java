package Week1.N2.HomeWork;

import Week1.N1.classWork.CaesarCipher;
import edu.duke.FileResource;

public class BreakingCaesarWithTwoKeys {
    public int[] countLetters(String s){ // find letters from word and count it
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = alpha.indexOf(Character.toLowerCase(ch));
            if(index != - 1){
                counters[index] += 1;

            }

        }
        for (int i = 0; i < counters.length; i++) {
            System.out.println(alpha.charAt(i) + "\t" + counters[i]);
        }
        return counters;
    }

    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4; // 4 is E because it's the most popular letter in English
        if(maxDex < 4){
            dkey = 26 - (4 - maxDex);

        }
        return cc.encrypt(encrypted, 26-dkey);

    }

    public int maxIndex(int[] vals){
        int maxDex = 0;
        for (int i = 0; i < vals.length; i++) {
            if(vals[i] > vals[maxDex]){
                maxDex = i;
            }
        }
        System.out.println(maxDex);
        return maxDex;
    }

    public String halfOfString(String message, int start){
        String result = new String();
        for (int i = start; i < message.length(); i = i + 2) {
            result = result + message.charAt(i);
        }

        return result;

    }

    public void testhalfOfString() {
        String message = "Qbkm Zgis";
        String t = halfOfString(message, 0);
        System.out.println(t);
    }

    public int getKey(String s){
        int[] count = countLetters(s);
        int max = maxIndex(count);
        int dkey = max - 4;
        if(max < 4) {
            dkey = (26 - (4 - max));
        }
        return dkey;
    }

    public String decryptTwoKeys(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        String part_1 = halfOfString(encrypted, 0);
        String part_2 = halfOfString(encrypted, 1);

        int dkey2 = getKey(part_2);
        int dkey1 = getKey(part_1);

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



    public static void main(String[] args) {
        BreakingCaesarWithTwoKeys bbr = new BreakingCaesarWithTwoKeys();
//        CaesarCipher cc = new CaesarCipher();
//        String m = cc.encryptTwoKeys("Hello My Friend", 5,6);
//        System.out.println(m);
//        String s = bbr.decryptTwoKeys(m);
//        System.out.println(s);
//
        FileResource fr = new FileResource();
        String encrypted =fr.asString();
        System.out.println(bbr.decryptTwoKeys(encrypted));
    }
}
