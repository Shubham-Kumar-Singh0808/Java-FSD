package exceptionHandling;

class MyException extends Exception {
    public MyException(String s) {
        super(s);
    }
}

public class ExceptionDemo {
    public static void main(String[] args) {

    
        int a = 45, b = 0, rs;

        try {
            if (b == 0)
                throw new ArithmeticException("Can't divide by zero.");
            else {
                rs = a / b;
                System.out.print("\n\tThe result is : " + rs);
            }
        } catch (ArithmeticException Ex) {
            System.out.print("\n\tError : " + Ex.getMessage());
        }

        try {
            ThrowsDemo T = new ThrowsDemo();
            T.Division();
        } catch (ArithmeticException Ex) {
            System.out.print("\n\tError : " + Ex.getMessage());
        }
        System.out.print("\n\tEnd of program.");

        int aFinally = 45, bFinally = 0, rsFinally = 0;
        try {
            rsFinally = aFinally / bFinally;
        } catch (ArithmeticException Ex) {
            System.out.print("\n\tError : " + Ex.getMessage());
        } finally {
            System.out.print("\n\tThe result is : " + rsFinally);
        }

        try {
            throw new MyException("temp");
        } catch (MyException ex) {
            System.out.println("\nCaught");
            System.out.println(ex.getMessage());
        }
    }
}

class ThrowsDemo {
    void Division() throws ArithmeticException {
        int a = 45, b = 0, rs;
        rs = a / b;
        System.out.print("\n\tThe result is : " + rs);
    }
}

