import java.util.Arrays;

class Solution {

    // Modulo value because the answer can become very large
    int M = (int)1e9 + 7;

    /*
        Memoization table

        t[onesLeft][zerosLeft][lastDigit]

        onesLeft  -> how many 1s we still need to place
        zerosLeft -> how many 0s we still need to place
        lastDigit -> what was the last placed digit
                     0 -> last digit was 0
                     1 -> last digit was 1

        This stores already computed results so we don't recompute them.
    */
    int t[][][] = new int[201][201][2];


    /*
        Recursive function that counts number of valid arrays
    */
    public int solve(int onesLeft, int zerosLeft, boolean lastWasOne, int limit) {

        /*
            BASE CASE

            If no ones and no zeros are left,
            it means we successfully created a valid array.
        */
        if (onesLeft == 0 && zerosLeft == 0) {
            return 1;
        }

        // Convert boolean to array index (true -> 1, false -> 0)
        int last = lastWasOne ? 1 : 0;

        /*
            If we already solved this state before,
            return the stored answer (DP memoization)
        */
        if (t[onesLeft][zerosLeft][last] != -1) {
            return t[onesLeft][zerosLeft][last];
        }

        int result = 0;

        /*
            If the last placed number was 1,
            then we must place zeros next
        */
        if (lastWasOne) {

            /*
                We can place between 1 and "limit" zeros,
                but we cannot exceed remaining zeros
            */
            for (int len = 1; len <= Math.min(zerosLeft, limit); len++) {

                // Place "len" zeros and recurse
                result = (result + solve(onesLeft, zerosLeft - len, false, limit)) % M;
            }
        }

        /*
            If the last placed number was 0,
            then we must place ones next
        */
        else {

            /*
                We can place between 1 and "limit" ones
            */
            for (int len = 1; len <= Math.min(onesLeft, limit); len++) {

                // Place "len" ones and recurse
                result = (result + solve(onesLeft - len, zerosLeft, true, limit)) % M;
            }
        }

        // Store the result in DP table before returning
        return t[onesLeft][zerosLeft][last] = result;
    }


    /*
        Main function required by the problem
    */
    public int numberOfStableArrays(int zero, int one, int limit) {

        /*
            Initialize DP table with -1
            meaning "not computed yet"
        */
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }

        /*
            Case 1 → array starts with 1
            (so last digit before recursion is considered 0)
        */
        int startWithOne = solve(one, zero, false, limit);

        /*
            Case 2 → array starts with 0
            (so last digit before recursion is considered 1)
        */
        int startWithZero = solve(one, zero, true, limit);

        // Total ways
        return (startWithZero + startWithOne) % M;
    }
}