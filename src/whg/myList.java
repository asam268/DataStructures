package whg;

public class myList {
    /* Append: add entry to end of list
     * Get: get entry at passed index
     * Size: returns size of list
     * Removes: removes element at passed index
     */
    private String[] array1;

    //constructor
    public myList() {
        this.array1 = new String[1];
    }


    //public methods
    public void append(String newString) {
        array1[array1.length - 1] = newString;
        increaseArrayLimit();
    }

    public String get(int index) {
        return array1[index];
    }

    public int size() {
        int sizeOfList = array1.length - 1;
        return sizeOfList;
    }

    public void remove(int index) {
        String[] newArray = new String[array1.length - 1];

        array1[index] = null;

        for (int i = 0; i < index; i++)
            newArray[i] = array1[i];

        for (int i = array1.length - 1; i > index; i--)
            newArray[i - 1] = array1[i];

        array1 = newArray;
    }

    public void appendToBack(String newString) {
        String[] newArray = new String[array1.length + 1];
        newArray[0] = null;
        for (int i = 0; i <= array1.length - 1; i++)
            newArray[i + 1] = array1[i];
        newArray[0] = newString;
        array1 = newArray;
    }

    //private methods
    private void increaseArrayLimit() {
        String[] newArray = new String[array1.length + 1];

        for (int i = 0; i <= array1.length - 1; i++)
            newArray[i] = array1[i];
        newArray[newArray.length - 1] = null;

        array1 = newArray;
    }
}
