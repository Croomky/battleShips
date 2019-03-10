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
public class MapFactory {
    
    private MapSymbol[][] map;
    private int currentShipMasts = 4;
    private int currentShips = 0;
    private boolean isAssigned = false;
    
    public MapFactory() {
        this.map = new MapSymbol[10][10];
    }
    
    public int getNextShip() throws Exception {
        switch (this.currentShipMasts) {
            case 4:
                if (this.currentShips == 1) {
                    this.currentShipMasts = 3;
                    this.currentShips = 0;
                }
                break;
            case 3:
                if (this.currentShips == 2) {
                    this.currentShipMasts = 2;
                    this.currentShips = 0;
                }
                break;
            case 2:
                if (this.currentShips == 3) {
                    this.currentShipMasts = 1;
                    this.currentShips = 0;
                }
                break;
            case 1:
                if (this.currentShips == 4) {
                    this.currentShipMasts = 0;
                }
                break;
            default:
                throw new Exception("Number of masts have to be between 1 and 4");
        }
        this.currentShips++;
        this.isAssigned = false;
        
        return this.currentShipMasts;
    }
    
    public boolean assignShip(int x1, int y1, int x2, int y2) throws Exception {
        if (this.isAssigned) {
            throw new Exception("Ship was already assigned");
        }
        
        if (!Utils.isLinear(x1, y1, x2, y2)) {
            return false;
//            throw new Exception("Ship has invalid coordinates, should be in one line.");
        }
        
        if (!Utils.isInRange(x2, y2) || Utils.isInRange(x1, y1)) {
            return false;
        }
        
        if (x1 == x2) {
            if (y1 > y2) {
               for (int y = y2; y <= y1; y++) {
                   this.map[x1][y] = MapSymbol.Mast;
               }
            } else {
                for (int y = y1; y <= y2; y++) {
                   this.map[x1][y] = MapSymbol.Mast;
               }
            }
        } else {
            if (x1 > x2) {
                for (int x = x2; x <= x1; x++) {
                    this.map[x][y1] = MapSymbol.Mast;
                }
            } else {
                for (int x = x1; x <= x2; x++) {
                   this.map[x][y1] = MapSymbol.Mast;
               }
            }
        }
        
        this.isAssigned = true;
        return true;
    }
    
    public Map createMap() {
        return new Map(this.map);
    }
}
