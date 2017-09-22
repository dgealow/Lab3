import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
/**
 *
 * @author dgealow2
 *
 */
public class AnythingYouLike {
    /**
     * Woah it's a main.
     * @param unused unused input parameters.
     */
    public static void main(final String[] unused) {
        String hamlet = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String leisureChart = urlToString("https://www.bls.gov/tus/charts/chart9.txt");
        String forecast = urlToString("http://tgftp.nws.noaa.gov/"
                + "data/raw/fz/fzus53.klot.srf.lot.txt");
        System.out.println("Word count of Hamlet: " + countWords(hamlet));
        System.out.println("Word count of leisure chart: " + countWords(leisureChart));
        System.out.println("Word count of weather forecast: " + countWords(forecast));
    }

    /**
     * Counts words.
     * @param input the string whose words you'd like to count
     * @return the number of words in the string
     */
    public static int countWords(final String input) {
        String s = input.trim();
        if (s == "") {
            return 0;
        }
        int wordCount = 1;
        for (int i = 1; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i)) && !Character.isWhitespace(s.charAt(i - 1))) {
                wordCount++;
            }
        }
        return wordCount;
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url URL to retrieve contents from
     * @return the contents from the URL as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
