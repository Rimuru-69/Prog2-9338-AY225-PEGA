/**
 * =====================================================
 * Student Name    : Lordclyde Pega
 * Course          : BSCSIT 1203 Programming 2
 * Assignment      : Midterm Lab Work 1
 * GitHub Repo     : https://github.com/pega-lordclyde/uphsd-cs-pega-lordclyde
 * =====================================================
 */

const matrix = [
    [6, 2, 3],
    [4, 5, 1],
    [3, 1, 4]
];

function computeMinor(a, b, c, d) {
    return (a * d) - (b * c);
}

function solveDeterminant(m) {
    const m11 = computeMinor(m[1][1], m[1][2], m[2][1], m[2][2]);
    const m12 = computeMinor(m[1][0], m[1][2], m[2][0], m[2][2]);
    const m13 = computeMinor(m[1][0], m[1][1], m[2][0], m[2][1]);

    const det = (m[0][0] * m11) - (m[0][1] * m12) + (m[0][2] * m13);

    const line = "====================================================";
    console.log(line);
    console.log("  3x3 MATRIX DETERMINANT SOLVER (JS)");
    console.log("  Student: Lordclyde Pega");
    console.log(line);
    console.log(`  ✓  DETERMINANT = ${det}`);
    if (det === 0) console.log("  ⚠ The matrix is SINGULAR.");
    console.log(line);
}

solveDeterminant(matrix);