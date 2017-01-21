package language;

public final class Collage {
    private final String name;
    private final int intValue;
    private final long longValue;
    private final float floatValue;
    private final double doubleValue;

    private Collage(Builder builder) {
        this.name = builder.name;
        this.intValue = builder.intValue;
        this.longValue = builder.longValue;
        this.floatValue = builder.floatValue;
        this.doubleValue = builder.doubleValue;
    }

    @Override
    public String toString() {
        return "Collage{" +
                "name='" + name + '\'' +
                ", intValue=" + intValue +
                ", longValue=" + longValue +
                ", floatValue=" + floatValue +
                ", doubleValue=" + doubleValue +
                '}';
    }

    public static Collage.Builder builder(String name) {
        return new Collage.Builder(name);
    }

    public static class Builder {
        public final String name;
        private int intValue;
        private long longValue;
        private float floatValue;
        private double doubleValue;

        private Builder(String name) {
            this.name = name;
        }

        public Builder withInt(int intValue) {
            this.intValue = intValue;
            return this;
        }

        public Builder withLong(long longValue) {
            this.longValue = longValue;
            return this;
        }

        public Builder withFloat(float floatValue) {
            this.floatValue = floatValue;
            return this;
        }

        public Builder withDouble(double doubleValue) {
            this.doubleValue = doubleValue;
            return this;
        }

        public Collage build() {
            return new Collage(this);
        }
    }

    public static void main(String[] args) {
        Collage c2 = Collage.builder("My Collage").withInt(5).withFloat(1.0f).build();
        System.out.println(c2);
    }
}
