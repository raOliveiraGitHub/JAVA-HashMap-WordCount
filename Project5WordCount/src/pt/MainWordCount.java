package pt;
//IDE: IntelliJ@Jetbrains
//User: raOliveira
//Number: @ispg2019100463
//Date: 17/12/2020
//Time: 18:13
//Course: Informatic Engineering

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class MainWordCount {

    //separator
    public static void separator() {
        char x = '=';
        char [] separator = new char[35];
        Arrays.fill(separator, x);
        System.out.println(separator);
    }

    //characters count
    public static void charactersCount(String line) throws IOException {
        File file = new File("teste.txt"); //object to open file
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);

        int characterCount = 0;
        while((line = reader.readLine()) != null) {
            if(line.equals("")) {
                continue;
            } else {
                characterCount += line.length();
            }
        }
        System.out.println("Total number of characters = " + characterCount);
    }

    public static void main(String[] args) throws IOException {

        File file = new File("teste.txt"); //object to open file
        Scanner input = new Scanner(file);

        //treemap
        TreeMap<String, Integer> wordCount = new TreeMap<String, Integer>();

        int count = 0;
        while (input.hasNext()) {
            String word = input.next().toLowerCase();
            word = word.replace(",", " ").replace(".", " ").replace("-", " ");
            if (!wordCount.containsKey(word)) wordCount.put(word, 1);
            else wordCount.put(word, wordCount.get(word) + 1);
            count++;
        }

        // show results
        separator();
        for (String word : wordCount.keySet()) {
            System.out.println("WORD '" + word + "' APPEARS " + wordCount.get(word) + " time(s)");
        }
        separator();
        String line = "";
        System.out.println("THE FILE HAS: ");
        System.out.println("Total of words: " + count);
        System.out.println("Total of different words: "+ wordCount.size());
        charactersCount(line);
        separator();

    }
}

