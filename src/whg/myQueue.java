/*
 *publish
 *pull
 *size
 */
package whg;

public class myQueue {
    //fields
    private myList list1 = new myList();


    //constructor
    public myQueue() {
    }

    //public methods
    public void publish(String newString) {
        list1.appendToBack(newString);
    }

    public void pull() {
        list1.remove(list1.size() - 1);
    }

    public int size() {
        return list1.size();
    }

    public String peekFront() {
        return list1.get(list1.size() - 1);
    }

    public String peekBack() {
        return list1.get(0);
    }

    //private methods


}
