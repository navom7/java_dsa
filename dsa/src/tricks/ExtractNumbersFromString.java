package tricks;


import java.util.regex.*;
import java.util.*;



public class ExtractNumbersFromString {
    public static void main(String[] args) {
        String input = "1-401--349--abc-90--88";
        List<Integer> numbers = extractNumbers(input);
        System.out.println(numbers);
    }

    public static List<Integer> extractNumbers(String input) {
        List<Integer> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+"); // Match sequences of digits
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            result.add(Integer.parseInt(matcher.group())); // Convert to integer and add to list
        }
        return result;
    }
}
