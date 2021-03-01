package whg;

import org.w3c.dom.Node;

public class Main {
    public static void main(String[] args) {
        DLL a = new DLL();
        a.append(a, "Caleb");
        a.append(a, "Caleb");
        a.append(a, "Jack");
        a.printList(a);
        System.out.println();

        a.deleteByKey(a, "Jack");
        a.printList(a);

    }
}
