package Week1.N2.HomeWork;

import Week1.N1.classWork.CaesarCipher;

public class BreakingCaesarCipher {
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
        int dkey = maxDex - 4;
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

    public static void main(String[] args) {
        BreakingCaesarCipher b = new BreakingCaesarCipher();
        CaesarCipher cc = new CaesarCipher();
//
//        String encrypted = cc.testCaesar();
        System.out.println(b.decrypt("Mjqqt Rd Kwnjsi"));
    }
}
