import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class main {

    static boolean valid;
    static String encoded;
    static String adjusted;

    public static boolean check_for_word(String word) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("words.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                if (str.indexOf(word) == 0) {
                    return true;
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
        return false;
    }

    public static void prompt() {
        System.out.println("Enter encoded message: ");
        Scanner sc = new Scanner(System.in);
        encoded = sc.nextLine();
        if (encoded.length() < 2) {
            System.out.println("Too short");
            prompt();
        }
        encoded = encoded.toLowerCase();
    }

    public static void shift_message() {
        for (int i = 0; i < adjusted.length(); i++) {
            char c = adjusted.charAt(i);
            if (96 < c && c < 123) {
                if (c == 'z')
                    c-= 25;
                else
                    c++;
            }
            adjusted = adjusted.substring(0, i) + c + adjusted.substring(i+1, adjusted.length());
        }
    }


    public static void main(String[] args) {
        prompt();

        valid = false;
        adjusted = encoded;
        shift_message();

        for (int i=0; i<25; i++) {
            for (int j=3; j<=encoded.length(); j++) {
                if (check_for_word(adjusted.substring(0, j))) {
                    System.out.println(adjusted);
                    j=encoded.length();
                }
            }
            shift_message();
        }
    }
}