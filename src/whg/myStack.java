package whg;/*LIFO Stack
 *Push
 *Pop
 *size
 *peek
 */

public class myStack {
    //fields
    private String[] array1;


    //constructor
    public myStack() {
        this.array1 = new String[0];
    }


    //public methods
    public void push(String newString) {
        increaseArrayLengthByOne();

        array1[array1.length - 1] = newString;
    }

    public String pop() {
        String topString = "";

        switch (array1.length) {
            case 0 -> topString = null;
            default -> topString = array1[array1.length - 1];
        }
        decreaseArrayLengthByOne();
        return topString;
    }

    public String peek() {
        String topString = array1[array1.length - 1];
        return topString;
    }

    public boolean isEmpty() {
        return array1.length == 0;
    }
    //private methods

    private void increaseArrayLengthByOne() {
        String[] newArray = new String[array1.length + 1];

        for (int i = 0; i <= array1.length - 1; i++)
            newArray[i] = array1[i];

        newArray[newArray.length - 1] = null;

        array1 = newArray;
    }

    private void decreaseArrayLengthByOne() {
        String[] newArray = new String[array1.length - 1];

        for (int i = 0; i <= newArray.length - 1; i++)
            newArray[i] = array1[i];
        array1 = newArray;
    }
}
