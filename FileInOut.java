
import java.io.*;

public class FileInOut {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            System.out.println(line);
        }
        br.close();
        bw.close();
    }

}
