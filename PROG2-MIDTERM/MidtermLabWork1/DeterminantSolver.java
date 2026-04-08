/**
 * =====================================================
 * Student Name    : Lordclyde Pega
 * Course          : BSCSIT 1203 Programming 2
 * Assignment      : Midterm Lab Work 1 — 3x3 Matrix Determinant Solver
 * School          : University of Perpetual Help System DALTA, Molino Campus
 * Date            : March 25, 2026
 * GitHub Repo     : https://github.com/pega-lordclyde/uphsd-cs-pega-lordclyde
 *
 * Description:
 * This program calculates the determinant of a 3x3 matrix using 
 * cofactor expansion along the first row. 
 * =====================================================
 */

public class DeterminantSolver {

    // ── SECTION 1: Matrix Declaration ───────────────────────────────────
    static int[][] matrix = {
        { 3, 2, 1 },   
        { 5, 8, 2 },   
        { 4, 6, 9 }    
    };

    // ── SECTION 2: 2×2 Determinant Helper ───────────────────────────────
    static int computeMinor(int a, int b, int c, int d) {
        return (a * d) - (b * c);
    }

    // ── SECTION 3: Matrix Printer (Strict Alignment) ────────────────────
    static void printMatrix(int[][] m) {
        // Top: 6 spaces + 1 char + 16 dashes + 1 char
        System.out.println("      ┌                ┐"); 
        for (int[] row : m) {
            // Each row uses exactly 16 spaces between the vertical bars
            // %3d (3) + space (1) + %3d (3) + space (1) + %3d (3) + padding = 16
            System.out.printf("      │  %2d   %2d   %2d  │%n", row[0], row[1], row[2]);
        }
        // Bottom: 6 spaces + 1 char + 16 dashes + 1 char
        System.out.println("      └                ┘");
    }

    // ── SECTION 4: Step-by-Step Determinant Solver ──────────────────────
    static void solveDeterminant(int[][] m) {
        String line = "=".repeat(52);

        System.out.println(line);
        System.out.println("  3x3 MATRIX DETERMINANT SOLVER");
        System.out.println("  Student: Lord Clyde W. Pega");
        System.out.println("  Assigned Matrix:");
        System.out.println(line);
        printMatrix(m);
        System.out.println(line);

        // Determinant Math
        int m11 = computeMinor(m[1][1], m[1][2], m[2][1], m[2][2]);
        int m12 = computeMinor(m[1][0], m[1][2], m[2][0], m[2][2]);
        int m13 = computeMinor(m[1][0], m[1][1], m[2][0], m[2][1]);

        int c11 =  m[0][0] * m11;
        int c12 = -m[0][1] * m12;
        int c13 =  m[0][2] * m13;
        int det = c11 + c12 + c13;

        System.out.printf("  Step 1 - Minor M11: %d%n", m11);
        System.out.printf("  Step 2 - Minor M12: %d%n", m12);
        System.out.printf("  Step 3 - Minor M13: %d%n", m13);
        System.out.printf("%n  ✓  DETERMINANT = %d%n", det);
        System.out.println(line);
    }

    public static void main(String[] args) {
        solveDeterminant(matrix);
    }
}