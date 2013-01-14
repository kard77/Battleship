/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author ak
 */
public class Location {

    private int row, col;
    private Ship ship = null;
    private boolean marked;
    private String content;
    private boolean isHit;

    /**
     *
     */
    public void mark() {
        this.marked = true;
    }
    
    /**
     *
     * @return
     */
    public boolean isMarked() {
        if (this.marked == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        if (this.content.equals(".")) {
            return true;
        } else {
            return false;
        }
    }

    
    
    
    
    public void hit() {
        this.isHit = true;
    }    
    
    
    
    /**
     *
     * @return
     */
    public boolean isHit() {
        if (this.isHit()) {
            return true;
        } else {
            return false;
        }
    }

    
    /**
     *
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     *
     * @param col
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     * @param ship
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }


    /**
     *
     * @return
     */
    public Ship getShip() {
        return this.ship;
    }
    
    /**
     *
     * @return
     */
    public String getContent() {
        return this.content;
    }
    
    /**
     *
     * @return
     */
    public int getRow() {
        return this.row;
    }

    /**
     *
     * @return
     */
    public int getCol() {
        return this.col;
    }    
    
    
    
}
