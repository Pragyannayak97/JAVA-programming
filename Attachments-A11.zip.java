import java.util.Scanner;

public class StringPrograms {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== STRING PROGRAMS =====");
            System.out.println("1. Compare Two Strings Lexicographically");
            System.out.println("2. Check Whether Two Strings Contain Same Data");
            System.out.println("3. Find Index of All Alphabet Characters");
            System.out.println("4. Check Whether a String is Palindrome");
            System.out.println("5. Find Second Most Frequent Character");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    compareStrings();
                    break;
                case 2:
                    checkSameData();
                    break;
                case 3:
                    findAlphabetIndex();
                    break;
                case 4:
                    checkPalindrome();
                    break;
                case 5:
                    secondMostFrequent();
                    break;
                case 0:
                    System.out.println("Program exited.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }

    // 1. Compare Two Strings Lexicographically
    static void compareStrings() {
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        int result = str1.compareTo(str2);

        if (result == 0) {
            System.out.println("Both strings are lexicographically equal.");
        } else if (result < 0) {
            System.out.println("String 1 is lexicographically smaller than String 2.");
        } else {
            System.out.println("String 1 is lexicographically greater than String 2.");
        }
    }

    // 2. Check Whether Two Strings Contain Same Data Without Comparison Methods
    static void checkSameData() {
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        boolean same = true;

        if (str1.length() != str2.length()) {
            same = false;
        } else {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println("Both strings contain the same data.");
        } else {
            System.out.println("Both strings do not contain the same data.");
        }
    }

    // 3. Find the Index of All Alphabet Characters
    static void findAlphabetIndex() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                System.out.println(ch + " = " + i);
            }
        }
    }

    // 4. Check Whether a String Is a Palindrome
    static void checkPalindrome() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        if (str.equals(rev)) {
            System.out.println("The given string is a palindrome.");
        } else {
            System.out.println("The given string is not a palindrome.");
        }
    }

    // 5. Find the Second Most Frequent Character
    static void secondMostFrequent() {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int max = 0;
        int secondMax = 0;
        char maxChar = ' ';
        char secondChar = ' ';

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isWhitespace(ch)) {
                continue;
            }

            boolean alreadyCounted = false;

            for (int k = 0; k < i; k++) {
                if (str.charAt(k) == ch) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (alreadyCounted) {
                continue;
            }

            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    count++;
                }
            }

            if (count > max) {
                secondMax = max;
                secondChar = maxChar;
                max = count;
                maxChar = ch;
            } else if (count > secondMax) {
                secondMax = count;
                secondChar = ch;
            }
        }

        if (secondMax == 0) {
            System.out.println("No second most frequent character.");
        } else {
            System.out.println("Second most frequent character: " + secondChar);
            System.out.println("Frequency: " + secondMax);
        }
    }
}
