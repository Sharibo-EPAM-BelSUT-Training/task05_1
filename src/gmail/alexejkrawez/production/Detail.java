package gmail.alexejkrawez.production;

public class Detail {

    /**
     * Number of detail in productions cycle.
     */
    private int id;

    /**
     * Time of production detail in first conveyor.
     */
    private int t1;

    /**
     * Time of production detail in second conveyor.
     */
    private int t2;

    /**
     * Constructor of the detail.
     *
     * @param id number of detail in productions cycle.
     * @param t1 time of production detail in first conveyor.
     * @param t2 time of production detail in second conveyor.
     */
    public Detail(int id, int t1, int t2) {
        this.id = id;
        this.t1 = t1;
        this.t2 = t2;
    }

    /**
     * Get number of detail in productions cycle.
     *
     * @return number of detail in productions cycle.
     */
    public int getId() {
        return id;
    }

    /**
     * Get time of production detail in first conveyor.
     *
     * @return time of production detail in first conveyor.
     */
    public int getT1() {
        return t1;
    }

    /**
     * Get time of production detail in second conveyor.
     *
     * @return time of production detail in second conveyor.
     */
    public int getT2() {
        return t2;
    }

    /**
     * Overrides toString() method.
     *
     * @return number, time of production detail in first conveyor
     * and time of production detail in second conveyor.
     */
    @Override
    public String toString() {
        return "\n" + id + "| t1: " + t1 +
                           ", t2: " + t2;
    }
}
