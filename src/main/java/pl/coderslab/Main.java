package pl.coderslab;

import morfologik.stemming.WordData;
import morfologik.stemming.polish.PolishStemmer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception{


        PolishStemmer stemmer = new PolishStemmer();
        List<WordData> words1 = stemmer.lookup("samochodowy");

        for (WordData word : words1) {
            System.out.println(word.getTag() + " " + word.getWord() + " " + word.getStem());
        }
        /*List<String> lines = Files.readAllLines(Paths.get("wulgaryzmy.txt"));

        Set<String> baseForms = new HashSet<>();

        for (String line : lines) {

            List<WordData> words = stemmer.lookup(line);

            for (WordData word : words) {
                baseForms.add(""+word.getStem());
            }
        }

        int index = 1;
        for (CharSequence word : baseForms) {
            System.out.println(index + ". " + word);
            index++;
        }
*/
    }
}
