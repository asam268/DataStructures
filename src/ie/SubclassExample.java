package ie;

public class SubclassExample {

    int a;
    Sub x;

    SubclassExample(int a) {
        this.a = a;
        x = new Sub(this.a);
    }

    static class Sub {
        int b;

        Sub(int b) {
            this.b = b;
        }
    }
}
