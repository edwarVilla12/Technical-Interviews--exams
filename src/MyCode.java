// package whatever; // don't place package name!

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Write a program that parses a sentence and replaces each word with the following:

        1) The first letter of the word.
        2) The number of distinct characters between first and last character.
        3) The last letter of the word.

    For example, Smooth would become S3h.
    Words are separated by spaces or non-alphabetic characters and these separators should be maintained in their original form and location in the answer.
    A few of the things we will be looking at is accuracy, efficiency, solution completeness.
*/

class MyCode {

    /*
     * Name:       normalizeWord.
     * Author:     Edwar Andres Villarreal F.
     *
     * Attributes: Word to be normalized.
     *
     * Description: Performs the following actions:
     *              Creates a substring of word by taking all characters except the first and last  c6s.
     *              This substring is stored in a variable named tempWord.
     *              Initializes a set called letters to store unique characters from tempWord.
     *              Loops over each character in tempWord and adds it to letters.
     *              Concatenates the first character of word, the size of letters converted to a string,
     *              and the last character of word and stores the result in a variable named wordCorrect.
     *
     * Return: Returns "wordCorrect" as the result of the method.
     */
    public static String normalizeWord(String word) {  // "t5g-up"
        String tempWord = word.substring(1, word.length() - 1);
        Set<Character> letters = new HashSet<>();

        for (char c : tempWord.toCharArray()) {
            letters.add(c);
        }
        return word.charAt(0) + "" + letters.size() + "" + word.charAt(word.length() - 1);
    }

    /*
     * Name:       wordWithSpecialCharacters.
     * Author:     Edwar Andres Villarreal F.
     *
     * Attributes: Word to be parsed
     *
     * Description: Splits the letters of the words based on whether they
     *              are special characters or not. Words with more than two letters are processed by the
     *              <normalizeWord> method and the final result is returned as a string.
     * Return: The word with the first and last letter but inside with the number of distinct letters.
     */
    public static String wordWithSpecialCharacters(String word) {
        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
        StringBuilder result = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();

        for (char c : word.toCharArray()) {
            if(specialCharacters.indexOf(c) != -1){
                result.append(processWord(currentWord.toString())).append(c);
                currentWord.setLength(0);
            }else{
                currentWord.append(c);
            }
        }
        return result.append(processWord(currentWord.toString())).toString();
    }

    /*
     * Name:       processWord.
     * Author:     Edwar Andres Villarreal F.
     *
     * Attributes: Word to be parsed.
     *
     * Description: If the length of word is 2 or less, it returns word as it is.
     *              If the length of word is greater than 2, it calls the method <normalizeWord> on word.
     * Return:      Parsed word.
     */
    private static String processWord(String word) {
        if (word.length() <= 2) {
            return word;
        }
        return normalizeWord(word);
    }

    /*
       * Name:       wordParser.
       * Author:     Edwar Andres Villarreal F.
       *
       * Attributes: String input.
       *
       * Description: Takes a string input as an argument and do the following:
                          1 - Trims the input string and splits it into individual words using a regular expression
                              pattern that matches whitespace characters.
                          2 - Initializes a StringBuilder object called "returnedWord".
                          3 - Compiles a regular expression pattern that matches characters that are not alphanumeric or spaces.
                          4 - Loops through the array of words, and for each word:
                                  * If the word's length is greater than 2, it uses the compiled pattern to check if the
                                    word contains any non-alphanumeric characters.
                                  * If the word contains non-alphanumeric characters, the method calls the
                                    <wordWithSpecialCharacters> method and appends the result to the "returnedWord" object.
                                  * If the word does not contain any non-alphanumeric characters, the method calls the
                                    <normalizeWord> method and appends the result to the "returnedWord" object.
                                  * If the word's length is less than or equal to 2, it appends the word to the "returnedWord" object.

       * Return: Returns the string representation of the "returnedWord" object, which will contain the
                 parsed version of the input string.
    */
    public static String wordParser(String input) {
        String[] words = input.trim().split("\\s");
        StringBuilder returnedWord = new StringBuilder();
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);

        for (String word : words) {
            if (word.length() > 2) {
                Matcher m = p.matcher(word);
                if (m.find()) {
                    returnedWord.append(wordWithSpecialCharacters(word)).append(" ");
                } else {returnedWord.append(normalizeWord(word)).append(" ");}
            } else { returnedWord.append(word).append(" ");}
        }
        return returnedWord.toString();
    }

    public static void main (String[] args) {
        String output = wordParser(" Creativity is thinking-up new things. Innovation is doing new things! ");
        System.out.println(output);     // expected: C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!

    }
}