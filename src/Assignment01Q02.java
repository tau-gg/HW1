public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;

        int iterations = Integer.parseInt(args[0]);
        for (int i = 0; i < iterations; i++) {
            int denominator = (2*i + 1) * (i % 2 == 0 ? 1 : -1);
            approxPi += 1.0 / (double)denominator;
        }
        approxPi *= 4;
        
        System.out.println(approxPi + " " + actualPi);
    }
}
