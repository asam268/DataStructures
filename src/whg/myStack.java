/*LIFO Stack
 *Push
 *Pop
 *size
 *peek
 */
package whg;

public class myStack {
    //fields
    private myList list1 = new myList();


    //constructor
    public myStack() {

    }


    //public methods
    public void push(String newString) {
        list1.append(newString);
    }

    public void pop() {
        String topString = list1.get(list1.size() - 1);
        list1.remove(list1.size() - 1);
    }

    public String peek() {
        String topString = list1.get(list1.size() - 1);
        return topString;
    }

    public int size() {
        return list1.size();
    }

    public boolean isEmpty() {
        return true;
    }
    //private methods
}
