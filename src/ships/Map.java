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
public class Map {
    
    private MapSymbol[][] map;
    
    public Map(MapSymbol[][] map) {
        this.map = map;
    }
    
    public boolean shot(int x, int y) {
        if (this.map[x][y] == MapSymbol.Mast) {
        this.map[x][y] = MapSymbol.DestroyedMast;
        return true;
        } else {
            return false;
        }
    }
}
