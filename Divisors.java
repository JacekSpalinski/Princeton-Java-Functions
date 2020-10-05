
public class Divisors {
    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0) return 0;
        else if (a == 0) return b;
        else if (b == 0) return a;
        else {
            while (a % b != 0) {
                int c = a % b;
                a = b;
                b = c;
            }
            return b;
        }
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        int f;
        if (a == 0 || b == 0) return 0;
        else {
            f = Math.abs(a) / gcd(a, b) * Math.abs(b);
            return f;
        }
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        boolean areRPrime;
        if (gcd(a, b) == 1) areRPrime = true;
        else areRPrime = false;
        return areRPrime;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int f = 0;
        for (int i = 1; i < n + 1; i++) {
            if (areRelativelyPrime(n, i)) f++;
        }
        return f;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        StdOut.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        StdOut.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        StdOut.println("totient(" + a + ") = " + totient(a));
        StdOut.println("totient(" + b + ") = " + totient(b));
    }
}
