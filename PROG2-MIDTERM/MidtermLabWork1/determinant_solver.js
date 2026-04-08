/**
 * Midterm Lab Work 1: 3x3 Matrix Determinant Solver
 * Student: Lord Clyde W. Pega
 * Section: BSCSIT 1203
 */

// ── Assigned Matrix ───────────────────────────────────────
const matrix = [
    [3, 2, 1],   
    [5, 8, 2],   
    [4, 6, 9]    
];

// ── Matrix Printer (Strict Alignment) ─────────────────────
function printMatrix(m) {
    // Top bracket: 6 spaces + corner + 16 spaces + corner
    console.log("      ┌                ┐"); 
    m.forEach(row => {
        // padStart(2) ensures single digits have a leading space.
        // The total string between │ │ is exactly 16 characters.
        const col1 = row[0].toString().padStart(2);
        const col2 = row[1].toString().padStart(2);
        const col3 = row[2].toString().padStart(2);
        console.log(`      │  ${col1}   ${col2}   ${col3}  │`);
    });
    // Bottom bracket
    console.log("      └                ┘");
}

function computeMinor(a, b, c, d) {
    return (a * d) - (b * c);
}

function solveDeterminant(m) {
    const line = "=".repeat(52);

    console.log(line);
    console.log("  3x3 MATRIX DETERMINANT SOLVER");
    console.log("  Student: Lord Clyde W. Pega");
    console.log("  Assigned Matrix:");
    console.log(line);
    printMatrix(m);
    console.log(line);

    // Step-by-step logic
    const m11 = computeMinor(m[1][1], m[1][2], m[2][1], m[2][2]);
    const m12 = computeMinor(m[1][0], m[1][2], m[2][0], m[2][2]);
    const m13 = computeMinor(m[1][0], m[1][1], m[2][0], m[2][1]);

    const c11 =  m[0][0] * m11;
    const c12 = -m[0][1] * m12;
    const c13 =  m[0][2] * m13;
    const det = c11 + c12 + c13;

    console.log(`\nExpanding along Row 1:`);
    console.log(`  Step 1 - Minor M11: det([${m[1][1]},${m[1][2]}],[${m[2][1]},${m[2][2]}]) = ${m11}`);
    console.log(`  Step 2 - Minor M12: det([${m[1][0]},${m[1][2]}],[${m[2][0]},${m[2][2]}]) = ${m12}`);
    console.log(`  Step 3 - Minor M13: det([${m[1][0]},${m[1][1]}],[${m[2][0]},${m[2][1]}]) = ${m13}`);

    console.log(`\n  Cofactor C11 = (+1) * ${m[0][0]} * ${m11} = ${c11}`);
    console.log(`  Cofactor C12 = (-1) * ${m[0][1]} * ${m12} = ${c12}`);
    console.log(`  Cofactor C13 = (+1) * ${m[0][2]} * ${m13} = ${c13}`);

    console.log(`\n  det(M) = ${c11} + (${c12}) + ${c13}`);
    console.log(line);
    console.log(`  ✓  DETERMINANT = ${det}`);
    console.log(line);
}

solveDeterminant(matrix);