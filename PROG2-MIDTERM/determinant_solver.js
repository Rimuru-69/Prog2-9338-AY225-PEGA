/**
 * =====================================================
 * Student Name    : [PEGA, LORD CLYDE W.]
 * Course          : BSCSIT 1203 Programming 2
 * Assignment      : Programming Assignment 1 — 3x3 Matrix Determinant Solver
 * School          : University of Perpetual Help System DALTA, Molino Campus
 * Date            : March 22, 2026
 * GitHub Repo     : https://github.com/[Rimuru-69]/uphsd-cs-PEGA]-[LORDCLYDE]
 * Runtime         : Node.js
 * =====================================================
 */

// ── SECTION 1: Matrix Declaration ───────────────────────────────────
// Hardcoded matrix values assigned for the assignment.
const matrix = [
    [6, 2, 3], 
    [4, 5, 1], 
    [3, 1, 4]  
];

// ── SECTION 2: Matrix Printer ────────────────────────────────────────
// Outputs the matrix to the console in a clean format using template strings.
function printMatrix(m) {
    console.log(`┌               ┐`);
    m.forEach(row => {
        const fmt = row.map(v => v.toString().padStart(3)).join("  ");
        console.log(`│ ${fmt}  │`);
    });
    console.log(`└               ┘`);
}

// ── SECTION 3: 2×2 Determinant Helper ───────────────────────────────
// Simple function to handle the 2x2 determinant calculation logic.
function computeMinor(a, b, c, d) {
    return (a * d) - (b * c);
}

// ── SECTION 4: Step-by-Step Determinant Solver ──────────────────────
// Main logic for solving the 3x3 determinant through expansion.
function solveDeterminant(m) {
    const line = "=".repeat(52);

    console.log(line);
    console.log("  3x3 MATRIX DETERMINANT SOLVER");
    console.log("  Student: [YOUR FULL NAME]");
    console.log("  Assigned Matrix:");
    console.log(line);
    printMatrix(m);
    console.log(line);
    console.log("\nExpanding along Row 1 (cofactor expansion):\n");

    // Processing the three 2x2 sub-matrices
    const minor11 = computeMinor(m[1][1], m[1][2], m[2][1], m[2][2]);
    console.log(`  Step 1 — Minor M₁₁: det([${m[1][1]},${m[1][2]}],[${m[2][1]},${m[2][2]}]) = (${m[1][1]}×${m[2][2]}) - (${m[1][2]}×${m[2][1]}) = ${minor11}`);

    const minor12 = computeMinor(m[1][0], m[1][2], m[2][0], m[2][2]);
    console.log(`  Step 2 — Minor M₁₂: det([${m[1][0]},${m[1][2]}],[${m[2][0]},${m[2][2]}]) = (${m[1][0]}×${m[2][2]}) - (${m[1][2]}×${m[2][0]}) = ${minor12}`);

    const minor13 = computeMinor(m[1][0], m[1][1], m[2][0], m[2][1]);
    console.log(`  Step 3 — Minor M₁₃: det([${m[1][0]},${m[1][1]}],[${m[2][0]},${m[2][1]}]) = (${m[1][0]}×${m[2][1]}) - (${m[1][1]}×${m[2][0]}) = ${minor13}`);

    // Calculating each signed cofactor term
    const c11 =  m[0][0] * minor11;
    const c12 = -m[0][1] * minor12;
    const c13 =  m[0][2] * minor13;

    console.log(`\n  Cofactor C₁₁ = (+1) × ${m[0][0]} × ${minor11} = ${c11}`);
    console.log(`  Cofactor C₁₂ = (-1) × ${m[0][1]} × ${minor12} = ${c12}`);
    console.log(`  Cofactor C₁₃ = (+1) × ${m[0][2]} × ${minor13} = ${c13}`);

    // Final result summation
    const det = c11 + c12 + c13;
    console.log(`\n  det(M) = ${c11} + (${c12}) + ${c13}`);
    console.log(line);
    console.log(`  ✓  DETERMINANT = ${det}`);

    // Check for singularity
    if (det === 0) {
        console.log("  ⚠ The matrix is SINGULAR — it has no inverse.");
    }
    console.log(line);
}

// Start program
solveDeterminant(matrix);