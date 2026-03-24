const fs = require('fs');
const readline = require('readline');

const rl = readline.createInterface({ input: process.stdin, output: process.stdout });

rl.question('Enter the full path of the CSV dataset file: ', (filePath) => {
    try {
        const data = fs.readFileSync(filePath, 'utf8');
        // Split rows and skip first 6 rows of noise
        const rows = data.split('\n').slice(6).filter(row => row.trim() !== '');
        
        // Regex to split while respecting quotes
        const records = rows.map(row => row.split(/,(?=(?:(?:[^"]*"){2})*[^"]*$)/));

        console.log(`\n[MP01] Total Student Records: ${records.length - 1}`);

        // MP11: Frequency of PASS/FAIL (Column 8)
        const resultsFreq = {};
        for (let i = 1; i < records.length; i++) {
            const result = records[i][7]?.trim() || "Unknown";
            resultsFreq[result] = (resultsFreq[result] || 0) + 1;
        }
        console.log("\n[MP11] Frequency Count (PASS/FAIL):", resultsFreq);

        // MP19: Summary
        console.log("\n[MP19] Summary Report:");
        console.log(`- Header found: ${records[0][0]}`);
        console.log(`- Total Records: ${records.length - 1}`);
        console.log(`- File Path: ${filePath}`);

    } catch (err) {
        console.log("Error: Could not read file.");
    }
    rl.close();
});