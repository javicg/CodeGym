package language;

public class ElvisCollection {

    public static class Elvis1 {
        private static final Elvis1 INSTANCE = new Elvis1();

        private Elvis1() {}

        public static Elvis1 getInstance() {
            return INSTANCE;
        }
    }

    public static class Elvis2 {
        private Elvis2() {}

        public static Elvis2 getInstance() {
            return Elvis2Holder.INSTANCE;
        }

        private static class Elvis2Holder {
            private static final Elvis2 INSTANCE = new Elvis2();
        }
    }
}
