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
public abstract class MapBuilder {
    private MapSymbol[][] map;
    
    public MapBuilder() {
        this.map = new MapSymbol[10][10];
        this.initializeMapSymbol(MapSymbol.Empty);
    }
    
    private void initializeMapSymbol(MapSymbol mp) {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                this.map[x][y] = mp;
            }
        }
    }
    
    protected Map getMap() {
        return new Map(this.map);
    }
    
    protected abstract void buildShips();
}
