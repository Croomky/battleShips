/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ships;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Konrad
 */
public class Board extends JPanel {
    
    private Map playerMap;
    private Map computerMap;
    
    private Point currentShipLocation;
    private int currentShip;
    private ShipRotation currentShipRotation;
    private ShipsAggregate shipsAggregate;
    
    private List<AssignedShip> assignedShips;
    
    public Board() {
        //MapFactory mapFactory = new MapFactory();
        //this.map = mapFactory.createMap();
        this.currentShipLocation = new Point(0, 0);
        this.currentShipRotation = ShipRotation.DOWN;
        this.assignedShips = new ArrayList<AssignedShip>();
        this.shipsAggregate = new ShipsAggregate();
        this.currentShip = this.shipsAggregate.getCurrentShip();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        this.drawGrid((Graphics2D)g);
        this.drawShips((Graphics2D)g);
        if (this.currentShipRotation == ShipRotation.DOWN) {
            if (this.currentShipLocation.y > 10-this.currentShip) {
                this.currentShipLocation.y = 6;
            }
            ((Graphics2D)g).fillRect(
                this.currentShipLocation.x * 30,
                this.currentShipLocation.y * 30,
                30,
                this.currentShip * 30
            );
        } else if (this.currentShipRotation == ShipRotation.RIGHT) {
            if (this.currentShipLocation.x > 10-this.currentShip) {
                this.currentShipLocation.x = 6;
            }
            ((Graphics2D)g).fillRect(
                this.currentShipLocation.x * 30,
                this.currentShipLocation.y * 30,
                this.currentShip * 30,
                30
            );
        }
        
        if (this.currentShipLocation.y > 10-this.currentShip
                && this.currentShipRotation == ShipRotation.DOWN) {
            this.currentShipLocation.y = 6;
        }
    }
    
    private void drawGrid(Graphics2D g) {
        g.setColor(Color.GRAY);
        for (int x = 0; x <= 300; x += 30) {
            g.drawLine(x, 0, x, 300);
        }
        
        for (int y = 0; y <= 300; y += 30) {
            g.drawLine(0, y, 300, y);
        }
    }
    
    private void drawShips(Graphics2D g) {
        g.setColor(Color.BLUE);
        for (AssignedShip as : this.assignedShips) {
            if (as.getShipRotation() == ShipRotation.DOWN) {
                ((Graphics2D)g).fillRect(
                    as.getLocation().x * 30,
                    as.getLocation().y * 30,
                    30,
                    as.getMastsQty() * 30
                );
            } else if (as.getShipRotation() == ShipRotation.RIGHT) {
                ((Graphics2D)g).fillRect(
                    as.getLocation().x * 30,
                    as.getLocation().y * 30,
                    as.getMastsQty() * 30,
                    30
                );
            }
        }
        g.setColor(Color.GRAY);
    }
    
    public void setCurrentShipLocation(Point p) {
        this.currentShipLocation = p;
    }
    
    public void switchShipRotation() {
        if (this.currentShipRotation == ShipRotation.DOWN) {
            this.currentShipRotation = ShipRotation.RIGHT;
        } else if (this.currentShipRotation == ShipRotation.RIGHT) {
            this.currentShipRotation = ShipRotation.DOWN;
        }
    }
    
    public void assignShip() {
        this.assignedShips.add(
            new AssignedShip(
                    this.currentShip,
                    this.currentShipLocation,
                    this.currentShipRotation)
        );
        if (this.shipsAggregate.next()) {
            this.currentShip = this.shipsAggregate.getCurrentShip();
        }
    }
}
