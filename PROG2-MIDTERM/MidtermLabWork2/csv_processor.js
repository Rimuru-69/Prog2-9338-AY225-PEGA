/**
 * Midterm Lab Work 2: CSV Dataset Processing
 * Student: Lord Clyde W. Pega
 * Problems: MP01, MP11, MP19
 */

const fs = require('fs');
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Enter the dataset file path: ', (filePath) => {
    try {
        const path = filePath.replace(/['"]+/g, '');
        const content = fs.readFileSync(path, 'utf8');
        const allLines = content.split(/\r?\n/);

        // Filter out empty lines and skip the 6 metadata lines
        const dataRows = allLines.filter(line => line.trim() !== '').slice(6);
        
        // Map rows into arrays
        const dataset = dataRows.map(row => row.split(/,(?=(?:(?:[^"]*"){2})*[^"]*$)/));

        console.log("\n====================================================");
        console.log("   LAB WORK 2 RESULTS (JS) - LORD CLYDE W. PEGA");
        console.log("====================================================");

        // MP01: Total Records
        const totalRecords = dataset.length - 1; 
        console.log(`[MP01] Total Student Records: ${totalRecords}`);

        // MP11: Frequency Count (Exam Type - Column Index 3)
        const freq = {};
        for (let i = 1; i < dataset.length; i++) {
            const exam = dataset[i][3]?.trim() || "Unknown";
            freq[exam] = (freq[exam] || 0) + 1;
        }
        console.log("\n[MP11] Frequency Count (Exam Type):");
        Object.entries(freq).forEach(([key, val]) => {
            console.log(`   - ${key.padEnd(15)} : ${val}`);
        });

        // MP19: Summary Report
        console.log("\n[MP19] Dataset Summary Report:");
        console.log(`   - Source: ${path}`);
        console.log(`   - Total File Lines: ${allLines.length}`);
        console.log(`   - Processed Records: ${totalRecords}`);
        console.log("====================================================\n");

    } catch (err) {
        console.log("Error: Could not process file.");
    } finally {
        rl.close();
    }
});