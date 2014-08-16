/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zhan.wordPhonePadMapping;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Write code to return all words in a dictionary that can be formed from a 
 * string of numbers (e.g. 34556), where the numbers map the same way they do 
 * on a phone.
 *
 * Basic idea:
 * 
 * I will assume all words are just 26 english letter and no special symbol
 * 
 * - read each from dictionary (txt file here and one word for each line)
 * - convert word to digit string
 * - put word into a hash table using its digit string as key
 * - if the key does not exist in hash table, create a list to hold the word
 * - if the key already exists in hash table, get the list and add the word into list
 * - finally you have the hash table to hold all the words from dictionary that 
 *   can be formed from the number with the phone pad mapping relations
 * 
 * @author mzhan
 */
public class DictionaryProcessor {
    
    private Map<String, List<String>> map = new HashMap<>();
    
    public DictionaryProcessor() {}
    
    public Map<String, List<String>> getMap() {
        return map;
    }

    public String mapWordToDigitString (String word) {

        StringBuilder sb = new StringBuilder();
        if (word != null && !word.isEmpty()) {
            char[] charArray = word.toUpperCase().toCharArray();
            for(char c : charArray) {
                int d = PhonePadUtil.charToPhoneDigit(c);
                sb.append(Integer.toString(d));
            }
        }
        return sb.toString();
    }

    public void addWord (String wordDigit, String word) {
        if (wordDigit != null && !wordDigit.isEmpty()) {
            if(!map.containsKey(wordDigit)) {
                List<String> wordList = new ArrayList<>();
                wordList.add(word);
                map.put(wordDigit, wordList);
            } else {
                List<String> existList = map.get(wordDigit);
                existList.add(word);
            }
        }
    }

    public void printMap() {
        Set<Map.Entry<String, List<String>>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            String key = (String) entry.getKey();
            List<String> valueList = (List<String>) entry.getValue();
            System.out.print("word digit = " + key);
            System.out.println(" has the following mapping words : ");
            for(String s : valueList) {
                System.out.println(s);
            }
        }
    }

    // This is just my draft idea, which I fiddle the resource path for a while to make it work
    public void processDictionaryMapping_draftIdea () {
        // working: using absolute path
//        File text = new File("/Users/mzhan/my_ws/studyAlg/study/algorithm/src/main/resources/all_words.txt");

        // not working
//        File text = new File("./../../../resources/all_words.txt");
//        File text = new File("/resources/all_words.txt");

        // The following is working after include study/algorithm/src/main/resources dir into project classpath
        // working: using URL 
//        URL url = getClass().getResource("/all_words.txt");
//        File text = new File(url.getPath());
        
        // working: using stream
        InputStream in = DictionaryProcessor.class.getResourceAsStream("/all_words.txt");
        Scanner scnr = new Scanner(in);

//        try {
//            Scanner scnr = new Scanner(text);
//            //Reading each line of file using Scanner class
//            int lineNumber = 1;
//            while(scnr.hasNextLine()){
//                String line = scnr.nextLine();
//                System.out.println("line " + lineNumber + " :" + line);
//                lineNumber++;
//            }
//        } catch (FileNotFoundException e){
//            System.out.print("error occurred during reading Dictionary file!");
//        }

//        try {
//            Scanner scnr = new Scanner(text);

            while(scnr.hasNextLine()){
                String word = scnr.nextLine();
                String key = mapWordToDigitString(word);
                addWord(key, word);
            }
            printMap();
//        } catch (FileNotFoundException e){
//            System.out.print("error occurred during reading Dictionary file!");
//        }
    }

    public void processDictionaryMapping () {
        // The following is working after include study/algorithm/src/main/resources dir into project classpath
        
        // working: using stream
        InputStream in = DictionaryProcessor.class.getResourceAsStream("/all_words.txt");
        Scanner scnr = new Scanner(in);
        
        while(scnr.hasNextLine()){
            String word = scnr.nextLine();
            String key = mapWordToDigitString(word);
            addWord(key, word);
        }
        printMap();
    }

    public static void main(String[] args) {
        DictionaryProcessor processor = new DictionaryProcessor();
        processor.processDictionaryMapping();
    }
    
}
