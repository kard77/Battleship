package battleship;

/**
 *
 * @author ak
 */
public abstract class Player {

    /**
     *
     */
    protected Game game;    
    /**
     *
     */
    protected String name;
    /**
     *
     */
    protected int score;
    /**
     *
     */
    protected Field field;
        /**
     *
     */
    protected Field otherField;
    /**
     *
     */
    protected AircraftCarrier a1 = new AircraftCarrier(5, 5, "A", field);
    /**
     *
     */
    protected AircraftCarrier a2 = new AircraftCarrier(5, 5, "A", field);
    /**
     *
     */
    protected Destroyer d1 = new Destroyer(3, 2, "D", field);
    /**
     *
     */
    protected Destroyer d2 = new Destroyer(3, 2, "D", field);
    /**
     *
     */
    protected Destroyer d3 = new Destroyer(3, 2, "D", field);
    /**
     *
     */
    protected Submarine s1 = new Submarine(1, 3, "S", field);
    /**
     *
     */
    protected Submarine s2 = new Submarine(1, 3, "S", field);
    /**
     *
     */
    protected Ship fleet[] = {a1, a2, d1, d2, d3, s1, s2};


    /**
     *
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }    
    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     *
     * @return
     */
    public Game getGame() {
        return this.game;
    }    
    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return
     */
    public int getScore() {
        return this.score;
    }

    /**
     *
     */
    public void printField() {
        this.otherField.printGrid();
    }

    /**
     *
     * @param r
     * @param c
     */
    public abstract void initField(int r, int c);

    /**
     *
     * @return
     */
    public boolean hasWon() {
        return true;
    }

    /**
     *
     * @return
     */
    public abstract Location selectMove() throws InvalidLocationException;

    /**
     *
     * @param otherField
     */
    public abstract void placeShips(Field otherField);
}
