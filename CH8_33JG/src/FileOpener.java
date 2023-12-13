import java.io.*;
/*
    Author: James Gwin

    Description: This class handles
    opening a file.

    Date Created: 21 February 2023

    Date Modified: 13 December 2023

    Overview: This class was made in a
    previous assignment in order to handle
    the process of opening a file. I simply
    reused it for this occasion. The desired
    file is opened with a BufferedReader and
    uses a StringBuilder to return the values
    inside a file.
 */
public class FileOpener {
    /**
     * This method handles the process
     * of opening and display a file's
     * contents.
     * @param cFilename The name of the file.
     * @return sb.toString() shows the results
     * of the StringBuilder(). The second return
     * is in case the search fails.
     */
    public static String fileReader(String cFilename) {
        try (BufferedReader br = new BufferedReader(new FileReader(cFilename + ".txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
                sb.append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Failed";
    }
}
