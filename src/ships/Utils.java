/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ships;

/**
 *
 * @author Konrad
 */
public class Utils {
    public static boolean isInRange(int x, int y) {
        if (x < 0
            || x > 9
            || y < 0
            || y > 9
        ) {
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean isLinear(int x1, int y1, int x2, int y2) {
        if (x1 == x2 || y1 == y2) {
            return true;
        } else {
            return false;
        }
    }
}
