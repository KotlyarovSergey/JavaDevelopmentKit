package hw1.server;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class LogToFile {
    private String logFileName;

    public LogToFile(String logFileName) {
        this.logFileName = logFileName;
    }

    public List<String> load(){
        List<String> log = new LinkedList<>();
        try(FileReader fReader = new FileReader(new File(logFileName))){
            BufferedReader bReader = new BufferedReader(fReader);
            String line = bReader.readLine();
            while (line != null) {
                log.add(line);
                line = bReader.readLine();
            }
        } catch (Exception e) {
            return log;
        }

        return log;
    }

    public void save(List<String> log){
        try (FileWriter fWriter = new FileWriter(new File(logFileName))) {
            // BufferedWriter bWriter = new BufferedWriter(fWriter);
            for (String line : log) {
                // bWriter.write(line);
                fWriter.append(line);
                fWriter.append("\n");
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
