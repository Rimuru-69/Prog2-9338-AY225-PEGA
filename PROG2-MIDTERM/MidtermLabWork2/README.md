# Midterm Lab Work 2: CSV Dataset Processing

**Student Name:** Lordclyde Pega  
**Section:** BSCSIT 1203  
**Course:** BSCSIT 1203 Programming 2, UPHSD Molino Campus  
**Assignment:** Machine Problem Set (MP01, MP11, MP19)

---

## 📋 Assigned Machine Problems
1. **MP01** – Load dataset and display total number of records.
2. **MP11** – Frequency count for column values (Exam Types/Results).
3. **MP19** – Generate dataset summary report.

---

## ⚙️ Program Logic Explanation
The programs (implemented in both Java and JavaScript) begin by prompting the user for the absolute file path of the CSV dataset. To ensure data integrity, the logic specifically skips the first six rows of metadata/titles present in the provided file to reach the actual header on Line 7. The data is then parsed into structured collections (ArrayList in Java, Arrays in JS), where the program calculates the total student count, performs a frequency analysis on exam categories, and generates a final processing summary.

---

## 🚀 How to Run the Programs

### Java Version
1. Open your terminal in this folder.
2. Compile the code:
   ```powershell
   javac CSVProcessor.java