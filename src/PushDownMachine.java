public class PushDownMachine {
    private int i;
    private final char[] s;

    public PushDownMachine(String input) {
        this.i = 0;
        this.s = input.toCharArray();
        S();
    }

    public boolean isValid() {
        return i == s.length;
    }

 
    private void S() {
         if (i < s.length && s[i] == 'a') {
            i++;
            A();
            if (i < s.length && s[i] == 'b') {
                i++;
                B();
            }
            else
                error();
        }
         else if (i < s.length && s[i] == 'c') {
            i++;
            if (i < s.length && s[i] == 'c') {
                i++;
                A();
            } else
                error();
        }
    }

    private void A()  {
        if (i < s.length && (  s[i] == 'a'|| s[i] == 'c'))
            i++;
        else
            error();
    }

    private void B() {
        if (i < s.length && (s[i] == 'b' || s[i] == 'a'))
            i++;
        else
            error();
    }

    private void error() {
        System.out.println("String is invalid");
    }
}
