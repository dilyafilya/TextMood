import java.util.ArrayList;
import java.io.*;
import java.util.regex.*;

public class test {
    public static void main(String[] args) {
        int ratioWords = 0;

        Mood positive = new Mood("Positive");
        Mood negative = new Mood("Negative");

        ArrayList<Word> wordList = new ArrayList<Word>();

        wordList.add(new Word("support", positive, +1));
        wordList.add(new Word("ok", positive, +1));
        wordList.add(new Word("happy", positive, +1));
        wordList.add(new Word("fantastic", positive, +1));
        wordList.add(new Word("opportunity", positive, +4));
        wordList.add(new Word("yes", positive, +1));

        wordList.add(new Word("don't", negative, -1));
        wordList.add(new Word("never", negative, -1));
        wordList.add(new Word("danger", negative, -3));
        wordList.add(new Word("cry", negative, -2));
        wordList.add(new Word("depression", negative, -2));
        wordList.add(new Word("error", negative, -1));
        wordList.add(new Word("harassment", negative, -1));
        wordList.add(new Word("hate", negative, -1));
        wordList.add(new Word("stupid", negative, -1));
        wordList.add(new Word("no", negative, -1));

        String fileName = "C://Users//mukas//OneDrive//Рабочий стол//git_exercise//data.txt";
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        String tempString;
        int counter = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));

            while ((tempString = in.readLine()) != null) {
                for (Word item : wordList) {
                    Pattern p = Pattern.compile(item.getSpelling());
                    Matcher m = p.matcher(tempString);
                    counter = 0;

                    while (m.find()) {
                        counter++;
                    }

                    if(counter > 0) {
                        ratioWords += item.getRatio() * counter;
                    }
                }
            }
            System.out.println("RatingText: " + ratioWords);
            in.close();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }
}
