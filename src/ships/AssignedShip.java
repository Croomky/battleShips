/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ships;

import java.awt.Point;

/**
 *
 * @author Konrad
 */
public class AssignedShip {
    private Point location;
    private ShipRotation shipRotation;
    private int masts;
    
    public AssignedShip(int masts, Point location, ShipRotation shipRotation) {
        this.masts = masts;
        this.location = location;
        this.shipRotation = shipRotation;
    }
    
    public Point getLocation() {
        return this.location;
    }
    
    public ShipRotation getShipRotation() {
        return this.shipRotation;
    } 
    
    public int getMastsQty() {
        return this.masts;
    }
}
