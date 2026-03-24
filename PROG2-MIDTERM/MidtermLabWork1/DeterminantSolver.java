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

    // Assigned Matrix: 6 2 3 / 4 5 1 / 3 1 4
    static int[][] matrix = {
        { 6, 2, 3 },
        { 4, 5, 1 },
        { 3, 1, 4 }
    };

    static int computeMinor(int a, int b, int c, int d) {
        return (a * d) - (b * c);
    }

    static void printMatrix(int[][] m) {
        System.out.println("┌               ┐");
        for (int i = 0; i < 3; i++) {
            System.out.printf("│  %2d  %2d  %2d  │%n", m[i][0], m[i][1], m[i][2]);
        }
        System.out.println("└               ┘");
    }

    static void solveDeterminant(int[][] m) {
        String line = "====================================================";
        System.out.println(line);
        System.out.println("  3x3 MATRIX DETERMINANT SOLVER");
        System.out.println("  Course: Programming 2");
        System.out.println("  Student: Lordclyde Pega");
        System.out.println(line);
        printMatrix(m);
        System.out.println(line);

        // Cofactor Expansion Steps
        int m11 = computeMinor(m[1][1], m[1][2], m[2][1], m[2][2]);
        int m12 = computeMinor(m[1][0], m[1][2], m[2][0], m[2][2]);
        int m13 = computeMinor(m[1][0], m[1][1], m[2][0], m[2][1]);

        System.out.printf("  Step 1 — Minor M₁₁: %d%n", m11);
        System.out.printf("  Step 2 — Minor M₁₂: %d%n", m12);
        System.out.printf("  Step 3 — Minor M₁₃: %d%n", m13);

        int c11 = m[0][0] * m11;
        int c12 = -m[0][1] * m12;
        int c13 = m[0][2] * m13;
        int det = c11 + c12 + c13;

        System.out.println(line);
        System.out.printf("  ✓  DETERMINANT = %d%n", det);

        if (det == 0) {
            System.out.println("  ⚠ The matrix is SINGULAR — it has no inverse.");
        }
        System.out.println(line);
    }

    public static void main(String[] args) {
        solveDeterminant(matrix);
    }
}