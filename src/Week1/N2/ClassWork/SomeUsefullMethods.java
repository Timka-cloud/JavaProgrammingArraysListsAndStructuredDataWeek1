package Week1.N2.ClassWork;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SomeUsefullMethods {
    public static void textFingerPrint(String s){ // find letters from word and count it
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
    }

    public static void simulate(int num){
        Random random = new Random();
        int[] counts = new int[13];
        for (int i = 0; i < num; i++) {
            int d1 = random.nextInt(6) + 1;
            int d2 = random.nextInt(6) + 1;
            counts[d1 + d2] += 1;
        }
        for (int i = 2; i <= 12; i++) {
            System.out.println(i + "'s=\t" + counts[i]);
        }
    }

    public static void main(String[] args) {
        simulate(100);
    }
}
