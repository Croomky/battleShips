/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ships;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Konrad
 */
public class ShipsAggregate {
    private ArrayList ships;
    private int currentIndex;
    
    public ShipsAggregate() {
        this.ships = new ArrayList();
        for (int masts = 4; masts >= 1; masts--) {
            for (int i = 0; i < 5-masts; i++) {
                this.ships.add(masts);
            }
        }
        
        this.currentIndex = 0;
    }
    
    public boolean next() {
        this.currentIndex++;
        if (this.currentIndex == this.ships.size()) {
            return false;
        } else {
            return true;
        }
    }
    
    public int getCurrentShip() {
        return (int)this.ships.get(currentIndex);
    }
    
    
}
