import java.util.*;
import edu.duke.*;
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<String> realNames;
    private ArrayList<Integer> nameCounter;
    private ArrayList<Integer> realNamesCounter;
    public CharactersInPlay() {
        names = new ArrayList<String>();
        realNames = new ArrayList<String>();
        nameCounter = new ArrayList<Integer>();
        realNamesCounter = new ArrayList<Integer>();
    }
    public void update(String person) {
        int index= names.indexOf(person);
        if(index==-1) {
            names.add(person);
            nameCounter.add(1);
        }
        else {
            int value = nameCounter.get(index);
            nameCounter.set(index,value+1);
        }
    }
    public void findAllCharacters() {
        names.clear();
        nameCounter.clear();
        FileResource fr = new FileResource();
        for(String s : fr.lines()) {
            int periodIndex = s.indexOf(".");
            int startIndex = 0;
            for(int i = 0; i <s.length(); i++) {
                StringBuilder sb = new StringBuilder(s);
                char alphabetic = sb.charAt(i);
                if(Character.isAlphabetic(alphabetic)){
                    startIndex=i;
                    break;
                }
            }
            if(periodIndex != -1) {
                String person = s.substring(startIndex,periodIndex);
                update(person);
            }
        }
    }
    public void charactersWithNumParts(int num1,int num2) {
        realNames.clear();
        realNamesCounter.clear();
        for(int i =0 ; i <nameCounter.size(); i++) {
            if(nameCounter.get(i) >= num1 && nameCounter.get(i) <= num2) {
                realNames.add(names.get(i));
                realNamesCounter.add(nameCounter.get(i));
            }
        }
    }
    public void tester () {
        findAllCharacters();
        charactersWithNumParts(10, 15);
        int highestCounter = 0;
        String highest = "";
        int realHighestCounter = 0;
        String realHighest = "";
        for(int i = 0; i<names.size();i++) {
            if(i==0) {
                highest = names.get(i);
                highestCounter = nameCounter.get(i);
            }
            if(nameCounter.get(i) > highestCounter) {
                highest = names.get(i);
                highestCounter = nameCounter.get(i);
            }
            //System.out.println(names.get(i) + "\t" + nameCounter.get(i));
        }
        System.out.println(highest + "\t" + highestCounter);
        System.out.println("-                                 -                             -");     
        for(int i = 0; i<realNames.size();i++) {
            if(i==0) {
                realHighest = realNames.get(i);
                realHighestCounter = realNamesCounter.get(i);
            }
            if(realNamesCounter.get(i) > realHighestCounter) {
                realHighest = realNames.get(i);
                realHighestCounter = realNamesCounter.get(i);
            }
            //System.out.println(realNames.get(i) + "\t" + realNamesCounter.get(i));
        }
        System.out.println(realHighest + "\t" + realHighestCounter);
    }
}
