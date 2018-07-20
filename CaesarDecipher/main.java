import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class main {

    static String encoded;
    static String adjusted;
    static ArrayList<String> list = new ArrayList<String>();
    static int[] arr = new int[26];
    static ArrayList<Integer> tempList = new ArrayList<Integer>();

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

    public static void create_adjusted_list() {
        for (int i = 0; i < 26; i++) {
            shift_message();
            list.add(adjusted);
        }
        shift_message();
    }

    static public ArrayList<Integer> getIndecesofLargest(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> maxIndices = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max)
                maxIndices.add(i);
            else if (arr[i] > max) {
                maxIndices.clear();
                maxIndices.add(i);
                max = arr[i];
            }
        }
        return maxIndices;
    }

    public static void main(String[] args) {
        prompt();
        adjusted = encoded;
        create_adjusted_list();

        for (int i = 0; i < encoded.length(); i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = i + 3; k <= encoded.length(); k++) {
                    if (check_for_word(adjusted.substring(i, k))) {
                        System.out.println(adjusted);
                        arr[j]++;
                    }
                }
                shift_message();
            }
        }

        for (Integer i : getIndecesofLargest(arr)) {
            System.out.println(list.get(i));
        }
        for (int i = 0; i < 26; i++) {
            tempList.add(arr[i]);
        }
        System.out.println(list);
        System.out.println(tempList);

    }
}