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
public class ComputerMapBuilder extends MapBuilder {
    
    public ComputerMapBuilder() {
        super();
    }
    
    @Override
    protected void buildShips() {
        for (int masts = 1; masts <= 4; masts++) {
            for (int i = 0; i < 5-masts; i++) {
                //finish
            }
        }
    }
}
