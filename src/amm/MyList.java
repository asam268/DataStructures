package amm;

/**
 * @author Asa Marshall
 *
 * The amm.MyList object is a resizable list of Strings
 */
public class MyList {

    private String[] list;  // Internal String array

    MyList() {
        this.list = new String[0];
    }

    /**
     * Increases the size of amm.MyList and appends the given String to the end of the amm.MyList object
     *
     * @param value     to be appended to the end of the array
     */
void append(String value) {
        if (this.list.length > 0) {
            String[] temp = this.list;
            this.list = new String[temp.length + 1];
            System.arraycopy(temp, 0, this.list, 0, temp.length);
            this.list[this.list.length - 1] = value;
        }
        else {
            this.list = new String[1];
            this.list[0] = value;
        }
    }

    /**
     * Gets the String at the position of the given index
     *
     * @param idx   position index of the String
     * @return      String
     */
    String get(int idx) {
        return this.list[idx];
    }

    /**
     * Removes the String at the given index and decreases amm.MyList's size
     *
     * @param idx index of the String to remove
     */
    void remove(int idx) {
        String[] temp = this.list;
        this.list = new String[temp.length - 1];
        if (idx > 0) System.arraycopy(temp, 0, list, 0, idx);
        System.arraycopy(temp, idx + 1, list, idx, this.list.length - idx);
    }

    /**
     * Gets the size of amm.MyList
     *
     * @return int
     */
    int size() {
        return this.list.length;
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("{ ");
        for (String item : this.list) {
            toReturn.append(item).append(" ");
        }
        toReturn.append("}");
        return toReturn.toString();
    }
}
