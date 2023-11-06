public class Main {
    public static void main(String[] args) {
        nato('z');
    }

    public static void nato(char theChar) {
        String theNatoString = "";

        switch (theChar) {
            case 'a':
                theNatoString = "Able";
                break;
            case 'b':
                theNatoString = "Baker";
                break;
            case 'c':
                theNatoString = "Charlie";
                break;
            case 'd':
                theNatoString = "Dog";
                break;
            case 'e':
                theNatoString = "Easy";
                break;
            default : {
                System.out.println(theChar + " not found.");
            }
        }
        System.out.println("'" + theChar + "'" + " NATO string: " + theNatoString);
    }
}