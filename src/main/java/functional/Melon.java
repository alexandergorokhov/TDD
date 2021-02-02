package functional;

public class Melon {
    private int size;

    /**
     * Gets size.
     *
     * @return Value of size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets new size.
     *
     * @param size New value of size.
     */
    public void setSize(int size) {
        this.size = size;
    }

    public Melon(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Melon{" +
                "size=" + size +
                '}';
    }
}
