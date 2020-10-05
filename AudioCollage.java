
public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * alpha;
        }
        return c;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[a.length - i - 1];
        }
        return c;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[a.length + i] = b[i];
        }
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int len = Math.max(a.length, b.length);
        double[] c = new double[len];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[i] = c[i] + b[i];
        }
        return c;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int len = (int) (a.length / alpha);
        double[] c = new double[len];
        for (int i = 0; i < len; i++) {
            c[i] = a[(int) (i * alpha)];
        }
        return c;

    }

    public static void main(String[] args) {
        double[] piano = StdAudio.read("piano.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] exposure = StdAudio.read("exposure.wav");
        piano = amplify(piano, 2);
        beatbox = reverse(beatbox);
        double[] m1 = merge(piano, chimes);
        double[] m2 = merge(beatbox, cow);
        double[] mx = mix(m1, m2);
        mx = merge(exposure, mx);
        mx = changeSpeed(mx, 2);
        for (int i = 0; i < mx.length; i++) {
            if (Math.abs(mx[i]) <= 1) StdAudio.play(mx[i]);
        }
    }
}
