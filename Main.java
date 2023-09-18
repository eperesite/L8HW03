import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        Pattern digitPattern = Pattern.compile("\\d+");
        Matcher digitMatcher = digitPattern.matcher(input);
        int maxDigitsCount = 0;

        while (digitMatcher.find()) {
            String digits = digitMatcher.group();
            if (digits.length() > maxDigitsCount) {
                maxDigitsCount = digits.length();
            }
        }

        System.out.println("Наибольшее количество идущих подряд цифр: " + maxDigitsCount);

        String[] words = input.split("\\s+");
        String longestWord = "";
        String shortestWord = words.length > 0 ? words[0] : "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            }
        }
        
        input = input.replaceFirst("\\b" + longestWord + "\\b", shortestWord);
        input = input.substring(0, input.lastIndexOf(shortestWord)) + longestWord + input.substring(input.lastIndexOf(shortestWord) + shortestWord.length());

        System.out.println("Строка после замены: " + input);

        Pattern punctuationPattern = Pattern.compile("[.,!?;:()]");
        Matcher punctuationMatcher = punctuationPattern.matcher(input);
        int punctuationCount = 0;

        while (punctuationMatcher.find()) {
            punctuationCount++;
        }

        System.out.println("Знаков препинания в строке: " + punctuationCount);

        scanner.close();
    }
}