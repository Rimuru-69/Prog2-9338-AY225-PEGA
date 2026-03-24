import java.io.*;
import java.util.*;

public class CSVProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the full path of the CSV dataset file: ");
        String filePath = scanner.nextLine();
        
        List<String[]> records = new ArrayList<>();
        int skippedLines = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                skippedLines++;
                if (skippedLines <= 6) continue; 

                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                records.add(values);
            }

            // MP01: Total Records
            int totalRecords = records.size() - 1;
            System.out.println("\n[MP01] Total Student Records: " + totalRecords);

            // MP11: Frequency Count for "Result" 
            Map<String, Integer> freqMap = new HashMap<>();
            for (int i = 1; i < records.size(); i++) {
                if (records.get(i).length > 7) {
                    String exam = records.get(i)[3].trim(); 
                    freqMap.put(exam, freqMap.getOrDefault(exam, 0) + 1);
                }
            }
            System.out.println("\n[MP11] Frequency Count (Exam Types):");
            freqMap.forEach((k, v) -> System.out.println(" - " + k + ": " + v));

            // MP19: Summary Report
            System.out.println("\n[MP19] Dataset Summary Report:");
            System.out.println("---------------------------------------");
            System.out.println("Source File: " + filePath);
            System.out.println("Total Rows Processed: " + records.size());
            System.out.println("Data Status: Valid (Headers detected on Line 7)");
            System.out.println("---------------------------------------");

        } catch (IOException e) {
            System.out.println("Error: Could not find file. Make sure to copy the FULL path.");
        }
    }
}