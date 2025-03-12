package edu.miracosta.cs113.change;

import java.util.ArrayList;
import java.util.List;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculatorRecursive extends ChangeCalculator {

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static List<String> calculateRecursive(int cents) {
        // TODO:
        // Implement a recursive solution following the given documentation.
        List<String> combinations = new ArrayList<>();
        checkChangeCombinations(combinations, cents, 0, 0, 0, 0);
        return combinations;
    }

    public static void checkChangeCombinations(List<String> list, int cents, int pennies, int nickels, int dimes, int quarters)
    {
       String currentChange = "";
       /*
        int penniesNum = pennies;
        int nickelsNum = nickels;
        int dimesNum = dimes;
        int quartersNum = quarters;
        int change = cents;

        */
        if(cents >= 25)
        {
            checkChangeCombinations(list, cents - 25, pennies, nickels, dimes, quarters + 1);
        }
        if(cents >= 10)
        {
            checkChangeCombinations(list, cents - 10, pennies, nickels, dimes + 1, quarters);
        }
        if(cents >= 5)
        {
            checkChangeCombinations(list, cents - 5, pennies, nickels + 1, dimes, quarters);
        }
        if(cents >= 1) {
            checkChangeCombinations(list, cents - 1, pennies + 1, nickels, dimes, quarters);
        }
        if(cents == 0) {
            currentChange = quarters + "q " + dimes + "d " + nickels + "n " + pennies + "p";
            if(list.contains(currentChange))
            {
                return;
            }
            else {
                list.add(currentChange);
            }
        }
    }

}