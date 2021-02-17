package whg;

public class Main {
    public static void main(String[] args) {
        DLL a = new DLL();
        a.append(a, "Hunter");
        a.append(a, "Asa");
        a.append(a, "Caleb");

        a.printList(a);
    }
}
