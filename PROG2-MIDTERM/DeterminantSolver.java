/**
 * =====================================================
 * Student Name    : [PEGA, LORD CLYDE W.]
 * Course          : BSCSIT 1203 Programming 2
 * Assignment      : Programming Assignment 1 — 3x3 Matrix Determinant Solver
 * School          : University of Perpetual Help System DALTA, Molino Campus
 * Date            : March 22, 2026
 * GitHub Repo     : https://github.com/[Rimuru-69]/uphsd-cs-PEGA]-[LORDCLYDE]
 *
 * Description:
 * This program calculates the determinant of a specific 3x3 matrix 
 * using the cofactor expansion method along the first row. It breaks 
 * down the 3x3 matrix into three 2x2 minors and sums them to find 
 * the final determinant value.
 * =====================================================
 */
public class DeterminantSolver {

    // ── SECTION 1: Matrix Declaration ───────────────────────────────────
    // This is the specific 3x3 matrix assigned to me.
    static int[][] matrix = {
        { 6, 2, 3 },   // Row 1
        { 4, 5, 1 },   // Row 2
        { 3, 1, 4 }    // Row 3
    };

    // ── SECTION 2: 2×2 Determinant Helper ───────────────────────────────
    // Helper function to solve the cross-multiplication (ad - bc) for a 2x2 grid.
    static int computeMinor(int a, int b, int c, int d) {
        return (a * d) - (b * c);
    }

    // ── SECTION 3: Matrix Printer ────────────────────────────────────────
    // Visualizes the 3x3 matrix in the console with decorative borders.
    static void printMatrix(int[][] m) {
        System.out.println("┌               ┐");
        for (int[] row : m) {
            System.out.printf("│  %2d  %2d  %2d  │%n", row[0], row[1], row[2]);
        }
        System.out.println("└               ┘");
    }

    // ── SECTION 4: Step-by-Step Determinant Solver ──────────────────────
    // Performs the actual math using row 1 expansion and prints every step.
    static void solveDeterminant(int[][] m) {
        // Replacing .repeat() with a fixed String for Java 8 compatibility
        String line = "====================================================";

        System.out.println(line);
        System.out.println("  3x3 MATRIX DETERMINANT SOLVER");
        System.out.println("  Student: [YOUR FULL NAME]");
        System.out.println("  Assigned Matrix:");
        System.out.println(line);
        printMatrix(m);
        System.out.println(line);

        // Step 1: Minor M11 (Exclude row 0, col 0) -> Sub-matrix: [[5,1],[1,4]]
        int minor11 = computeMinor(m[1][1], m[1][2], m[2][1], m[2][2]);
        System.out.printf("  Step 1 — Minor M₁₁: det([%d,%d],[%d,%d]) = (%d×%d)-(%d×%d) = %d%n",
            m[1][1], m[1][2], m[2][1], m[2][2], m[1][1], m[2][2], m[1][2], m[2][1], minor11);

        // Step 2: Minor M12 (Exclude row 0, col 1) -> Sub-matrix: [[4,1],[3,4]]
        int minor12 = computeMinor(m[1][0], m[1][2], m[2][0], m[2][2]);
        System.out.printf("  Step 2 — Minor M₁₂: det([%d,%d],[%d,%d]) = (%d×%d)-(%d×%d) = %d%n",
            m[1][0], m[1][2], m[2][0], m[2][2], m[1][0], m[2][2], m[1][2], m[2][0], minor12);

        // Step 3: Minor M13 (Exclude row 0, col 2) -> Sub-matrix: [[4,5],[3,1]]
        int minor13 = computeMinor(m[1][0], m[1][1], m[2][0], m[2][1]);
        System.out.printf("  Step 3 — Minor M₁₃: det([%d,%d],[%d,%d]) = (%d×%d)-(%d×%d) = %d%n",
            m[1][0], m[1][1], m[2][0], m[2][1], m[1][0], m[2][1], m[1][1], m[2][0], minor13);

        // Calculate signed terms based on the +/-/+ pattern of the first row
        int c11 =  m[0][0] * minor11;
        int c12 = -m[0][1] * minor12;
        int c13 =  m[0][2] * minor13;

        System.out.println();
        System.out.printf("  Cofactor C₁₁ = (+1) × %d × %d = %d%n", m[0][0], minor11, c11);
        System.out.printf("  Cofactor C₁₂ = (-1) × %d × %d = %d%n", m[0][1], minor12, c12);
        System.out.printf("  Cofactor C₁₃ = (+1) × %d × %d = %d%n", m[0][2], minor13, c13);

        // Final result: Combine all terms
        int det = c11 + c12 + c13;
        System.out.printf("%n  det(M) = %d + (%d) + %d%n", c11, c12, c13);
        System.out.println(line);
        System.out.printf("  ✓  DETERMINANT = %d%n", det);

        // Check if the matrix is singular
        if (det == 0) {
            System.out.println("  ⚠ The matrix is SINGULAR — it has no inverse.");
        }
        System.out.println(line);
    }

    public static void main(String[] args) {
        solveDeterminant(matrix);
    }
}