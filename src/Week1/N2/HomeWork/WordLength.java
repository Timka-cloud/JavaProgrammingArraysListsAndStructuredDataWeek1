package Week1.N2.HomeWork;

import edu.duke.FileResource;

import java.util.Arrays;

public class WordLength {


    public int[] countWordLength(FileResource fr, int[] counts){
        for(String word : fr.words()){
            int index = 0;
            int n = word.length();


            for (int i = 0; i < n; i++) {
                if(Character.isLetter(word.charAt(i))){
                    index++;
                }
            }

            if(index <= counts.length & index != 0){
                counts[index - 1] += 1;
            }
            else {
                System.out.println("erorr");
            }
        }
        return counts;




    }
    public int indexOfMax(int [] values) {
        int maxvalue = 0;
        int position = 0;
        for (int i = 0; i < values.length; i++) {
            if (maxvalue == 0) maxvalue = values[i];
            else {
                if (maxvalue < values[i]) {
                    maxvalue = values[i];
                    position = i;
                }
            }
        }
        return position+1;
    }

    public static void main(String[] args) {
        WordLength wl = new WordLength();
        FileResource fr = new FileResource();

        int[] count = new int[31];
        int[] result = wl.countWordLength(fr, count);
        for (int i = 0; i < 31; i++) {
            System.out.println(result[i] + " words of length "+ (i+1));
        }
        int maxlength = wl.indexOfMax(result);
        System.out.println("The most common word length in the index "+maxlength);
    }
}
