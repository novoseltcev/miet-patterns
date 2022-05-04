import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        var text = readFile("interpreter/input.txt");
        var result = new Corrector().execute(text);
        System.out.print(result);
    }

    private static String readFile(String filename) throws IOException {
        BufferedReader fd = new BufferedReader(new FileReader(filename));
        var result = new StringBuilder();
        var line = "";
        while ((line = fd.readLine()) != null)
            result.append(line).append("\n");
        return result.toString();
    }
}
