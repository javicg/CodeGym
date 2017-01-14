package language;

public class DiamondProblem {
    private interface A {
        default int m() {
            return 10;
        }
    }

    private interface B extends A {
        @Override
        default int m() {
            return 20;
        }
    }

    private interface C extends A {
        @Override
        default int m() {
            return 30;
        }
    }

    private static class D implements B, C {
        @Override
        public int m() {
            return B.super.m();
        }
    }

    public static void main(String[] args) {
        D d = new D();
        System.out.println(d.m());
    }
}
