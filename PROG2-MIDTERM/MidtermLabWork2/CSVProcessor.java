/**
 * Midterm Lab Work 2: CSV Dataset Processing
 * Student: Lord Clyde W. Pega
 * Problems: MP01, MP11, MP19
 */
import java.io.*;
import java.util.*;

public class CSVProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the dataset file path: ");
        String filePath = scanner.nextLine().replace("\"", "");

        List<String[]> records = new ArrayList<>();
        int lineCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip 6 lines of metadata
            for (int i = 0; i < 6; i++) { 
                br.readLine(); 
                lineCount++; 
            }

            while ((line = br.readLine()) != null) {
                lineCount++;
                if (line.trim().isEmpty()) continue;
                
                // Regex to split by comma but ignore commas inside quotes
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                records.add(values);
            }

            // Display Results
            printResults(records, lineCount, filePath);

        } catch (Exception e) {
            System.out.println("Error: File not found or could not be read.");
        } finally {
            scanner.close();
        }
    }

    public static void printResults(List<String[]> data, int totalLines, String path) {
        String dash = "=".repeat(52);
        System.out.println("\n" + dash);
        System.out.println("   LAB WORK 2 RESULTS - LORD CLYDE W. PEGA");
        System.out.println(dash);

        // MP01: Total Records (minus header)
        int totalRecords = data.size() - 1;
        System.out.println("[MP01] Total Student Records: " + totalRecords);

        // MP11: Frequency Count for Exam Type (Column Index 3)
        Map<String, Integer> freqMap = new HashMap<>();
        for (int i = 1; i < data.size(); i++) {
            String exam = data.get(i)[3].trim();
            freqMap.put(exam, freqMap.getOrDefault(exam, 0) + 1);
        }
        System.out.println("\n[MP11] Frequency Count (Exam Type):");
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.printf("   - %-15s : %d%n", entry.getKey(), entry.getValue());
        }

        // MP19: Summary Report
        System.out.println("\n[MP19] Dataset Summary Report:");
        System.out.println("   - Source Path: " + path);
        System.out.println("   - File Line Count: " + totalLines);
        System.out.println("   - Valid Records: " + totalRecords);
        System.out.println(dash + "\n");
    }
}