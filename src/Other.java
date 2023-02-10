// package whatever; // don't place package name!

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Write a program that parses a sentence and replaces each word with the following:
1) The first letter of the word
2) The number of distinct characters between first and last character
3) The last letter of the word.
For example, Smooth would become S3h.
Words are separated by spaces or non-alphabetic characters and these separators should be maintained in their original form and location in the answer.
A few of the things we will be looking at is accuracy, efficiency, solution completeness.
*/
class Other {

/*    public static String wordWithCharacter(String temp) {
    StringBuilder result = new StringBuilder();
    String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
    StringBuilder currentWord = new StringBuilder();

    for (char c : temp.toCharArray()) {
        if (specialCharacters.indexOf(c) != -1) {
            if (currentWord.length() > 0) {
                result.append(normalWord(currentWord.toString()));
                currentWord.setLength(0);
            }
            result.append(c);
        } else {
            currentWord.append(c);
        }
    }

    if (currentWord.length() > 0) {
        result.append(normalWord(currentWord.toString()));
    }

    return result.toString();
}*/


    //Creativity is thinking-up new things. Innovation is doing new things!
    //expected: C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!

    //Creativity is thinking---up-next new things. Innovation is doing new things!
    //expected: C6y is t4g---up-n2t n1w t4s. I6n is d3g n1w t4s!

    //Hello my Friend. Cardona and you? Amazing:::do you think?
    // expected:  H2o my F4d. C5a a1d y1u? A5g:::do y1u t3k?

    //That is amazing***or***what do you think?
    // expected: T2t is a5g***or***w2t do y1u t3k?

    //That is amazing**??or*??**what do you think?
    // expected: T2t is a5g**??or*??**w2t do y1u t3k?


/*
    public static String wordParser(String input) {

        ArrayList<String> wordsList =  new ArrayList<>(Arrays.asList(input.trim().split("\\s")));

        StringBuilder returnedWord = new StringBuilder();

        for (String word : wordsList){
            if (word.length() > 2) {

                Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(word);
                boolean b = m.find();

                if(b){
                    returnedWord.append(wordWithCharacter(word) + " ");
                }else{
                    returnedWord.append( normalWord(word) + " " );
                }

            }
            else{
                returnedWord.append(word + " ");
            }
        }

        return returnedWord.toString();
    }*/

    public static void main (String[] args) {
       /* String output = wordParser("Creativity is thinking-up new things. Innovation is doing new things!");
        System.out.println(output);*/
        //Creativity is thinking-up new things. Innovation is doing new things!
        //expected: C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!

        //Creativity is thinking---up-next new things. Innovation is doing new things!
        //expected: C6y is t4g---up-n2t n1w t4s. I6n is d3g n1w t4s!

        //Hello my Friend. Cardona and you? Amazing:::do you think?
        // expected:  H2o my F4d. C5a a1d y1u? A5g:::do y1u t3k?

        //That is amazing***or***what do you think?
        // expected: T2t is a5g***or***w2t do y1u t3k?

        //That is amazing**??or*??**what do you think?
        // expected: T2t is a5g**??or*??**w2t do y1u t3k?
    }
}