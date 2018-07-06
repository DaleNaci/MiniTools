import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


class main {

    // Variable Declaration
    String encoded_message;

    public static boolean check_for_word(String word) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("words.txt"));
            System.out.println("hello");
            String str;
            while ((str = in.readLine()) != null) {
                if (str.indexOf(word) != -1) {
                    return true;
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
        return false;
    }

    public static boolean prompt() {
        System.out.println("Enter encoded message: ");
        Scanner sc = new Scanner(System.in);
        encoded_message = sc.nextLine();
        if (encoded_message < 2) {
            System.out.println("Too short");
            prompt();
        }
    }

    public static void main(String[] args) {
        prompt();
        

    }
}







