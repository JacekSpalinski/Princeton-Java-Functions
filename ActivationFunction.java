
public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        double f;
        if (Double.isNaN(x)) f = Double.NaN;
        else if (x < 0) f = 0;
        else if (x == 0) f = 0.5;
        else f = 1;
        return f;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        double f;
        if (Double.isNaN(x)) f = Double.NaN;
        else f = 1 / (1 + Math.exp(-x));
        return f;
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        double f;
        if (Double.isNaN(x)) f = Double.NaN;
        else if (x >= 20) f = 1;
        else if (x <= -20) f = -1;
        else f = (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
        return f;
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        double f;
        if (Double.isNaN(x)) f = Double.NaN;
        else if (x == Double.POSITIVE_INFINITY) f = 1;
        else if (x == Double.NEGATIVE_INFINITY) f = -1;
        else f = x / (1 + Math.abs(x));
        return f;
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        double f;
        if (Double.isNaN(x)) f = Double.NaN;
        else if (x <= -2) f = -1;
        else if (x > -2 && x < 0) f = x + (Math.pow(x, 2) / 4);
        else if (x >= 0 && x < 2) f = x - (Math.pow(x, 2) / 4);
        else f = 1;
        return f;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println("heaviside(" + x + ") = " + heaviside(x));
        StdOut.println("sigmoid(" + x + ") = " + sigmoid(x));
        StdOut.println("tanh(" + x + ") = " + tanh(x));
        StdOut.println("softsign(" + x + ") = " + softsign(x));
        StdOut.println("sqnl(" + x + ") = " + sqnl(x));
    }
}
