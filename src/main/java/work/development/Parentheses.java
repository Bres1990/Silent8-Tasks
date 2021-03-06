package work.development;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * Created by Adam Poterałowicz
 */
public class Parentheses {

    static char OPEN_SQUARE_BRACKET = '[';
    static char CLOSED_SQUARE_BRACKET = ']';
    static char OPEN_ROUND_BRACKET = '(';
    static char CLOSED_ROUND_BRACKET = ')';

    public static void main(String[] args) {
        String input = null;

        try {
            input = FileUtils.readFileToString(new File(Parentheses.class.getClassLoader().getResource("parentheses.txt").getFile()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Parentheses are organized in an orderly fashion: " + isBalanced(input));
    }

    public static boolean isBalanced(String input) {
        System.out.println("Tested expression is of length " + input.length());
        int round_counter = 0;
        int square_counter = 0;
        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            if (c == OPEN_ROUND_BRACKET) {
                round_counter++;
            } else if (c == OPEN_SQUARE_BRACKET) {
                square_counter++;
            } else if (c == CLOSED_ROUND_BRACKET) {
                if (round_counter == 0) {
                    return false;
                } else {
                    round_counter--;
                }
            } else if (c == CLOSED_SQUARE_BRACKET) {
                if (square_counter == 0) {
                    return false;
                } else {
                    square_counter--;
                }
            }
        }

        return round_counter == 0 && square_counter == 0;
    }
}
