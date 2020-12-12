package Week1.N1.classWork;

public class CharacterDemo {
    public void digitTest(){
        String text = "ABCabc0123456789';#!";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(Character.isDigit(c)){
                System.out.println(c + " is a digit");
            }
            if(Character.isAlphabetic(c)){
                System.out.println(c + " is a alphabetic");
            }
        }
    }

    public static void main(String[] args) {
        CharacterDemo ch = new CharacterDemo();
        ch.digitTest();
    }
}
