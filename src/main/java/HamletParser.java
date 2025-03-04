import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public void changeHamletToLeon() {
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(hamletData);
        StringBuffer sb = new StringBuffer();
        String replacementText = "Leon";
        //String matchedText;
        while (matcher.find()) {
            //matchedText = matcher.group();
            matcher.appendReplacement(sb, replacementText);
        }
        matcher.appendTail(sb);
        hamletData = sb.toString();

        pattern = Pattern.compile("HAMLET");
        matcher = pattern.matcher(hamletData);
        sb = new StringBuffer();
        String replacementText2 = "LEON";
        //matchedText;
        while (matcher.find()) {
            //matchedText = matcher.group();
            matcher.appendReplacement(sb, replacementText2);
        }
        matcher.appendTail(sb);

        hamletData = sb.toString();
    }

    public void changeHoratioToTariq() {
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(hamletData);
        StringBuffer sb = new StringBuffer();
        String replacementText = "Tariq";
        //String matchedText;
        while (matcher.find()) {
            //matchedText = matcher.group();
            matcher.appendReplacement(sb, replacementText);
        }
        matcher.appendTail(sb);
        hamletData = sb.toString();

        pattern = Pattern.compile("HORATIO");
        matcher = pattern.matcher(hamletData);
        sb = new StringBuffer();
        String replacementText2 = "TARIQ";
        //matchedText;
        while (matcher.find()) {
            //matchedText = matcher.group();
            matcher.appendReplacement(sb, replacementText2);
        }
        matcher.appendTail(sb);

        hamletData = sb.toString();
    }

    public int findHoratio() {
        Pattern pattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public int findHamlet() {
        Pattern pattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
