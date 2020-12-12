package Week1.N1.homeWork;

public class WordPlay {
    public static boolean isVowel(char ch){
        char[] arr = {'a','e','i','o','u','A','E','I','O','U'};
        for (int i = 0; i < arr.length; i++) {
            if(ch == arr[i]) return true;
        }
        return false;
    }

    public static String replaceVowel(String phrase, char ch){
        StringBuilder newString = new StringBuilder(phrase);

        for (int i = 0; i < newString.length(); i++) {
            char temp = newString.charAt(i);
            boolean b = isVowel(temp);
            if(b){
                newString.setCharAt(i,ch);
            }
        }
        return newString.toString();
    }

    public static String emphasize(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        char c = Character.toUpperCase(ch);
        for (int i = 0; i < sb.length(); i++) {
            char temp = sb.charAt(i);
            if(temp == ch || temp == c){
                if(i % 2 == 0){
                    sb.setCharAt(i, '*');
                }
                else{
                    sb.setCharAt(i, '+');
                }

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = replaceVowel("Hello World", '*');
        System.out.println(s);
        String s1 = emphasize("Mary Bella Abracadabra",'a');
        System.out.println(s1);
    }
}
