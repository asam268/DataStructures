package whg;/*
 *publish
 *pull
 *size
 */

public class myQueue {
    //fields
    private String[] array1;


    //constructor
    public myQueue() {
        this.array1 = new String[0];
    }

    //public methods
    public void publish(String newString) {
        String[] newArray = new String[array1.length + 1];

        for (int i = 0; i <= array1.length - 1; i++)
            newArray[i + 1] = array1[i];
        newArray[0] = newString;
        array1 = newArray;
    }

    public String pull() {
        String topString = array1[array1.length - 1];

        String[] newArray = new String[array1.length - 1];

        for (int i = 0; i <= newArray.length - 1; i++)
            newArray[i] = array1[i];
        array1 = newArray;
        return topString;
    }

    public int size() {
        return array1.length;
    }
}
