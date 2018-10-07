import java.util.*;
import edu.duke.*;
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordFrequencies {
    ArrayList<String> myWords;
    ArrayList<Integer> myFreqs;
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        FileResource fr= new FileResource();
        for(String s : fr.words()) {
            int index = myWords.indexOf(s.toLowerCase());
            if(index == -1) {
                myWords.add(s.toLowerCase());
                myFreqs.add(1);
            }
            else {
                int value = myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
        }
    }
    public int findIndexOfMax () {
        int highestFreq = 0;
        int highIndex = 0;
        for(int i = 0; i<myFreqs.size();i++){
            if(i==0) {
                highestFreq = myFreqs.get(i);
                highIndex = i;
            }
            if(myFreqs.get(i) > highestFreq ) {
                highestFreq = myFreqs.get(i);
                highIndex = i;
            }
        }
        return highIndex;
    }
    public void tester() {
        findUnique();
        int unique = myWords.size();
        int highestFreq = findIndexOfMax();
        System.out.println("Number of unique words:" + unique);
        /*for(int i = 0;i<unique ; i++) {
            System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
        }*/
        System.out.println("The word that occurs most often and its count are:" + myWords.get(highestFreq) + " " + myFreqs.get(highestFreq));
    }   
}
