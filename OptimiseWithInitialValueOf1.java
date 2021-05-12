@Test
public void OptimiseWithInitialValueOf1() throws NoSquareException {
    double[][] x = new double[7][1];
    x[0][0] = 0.038;
    x[1][0] = 0.194;
    x[2][0] = 0.425;
    x[3][0] = 0.626;
    x[4][0] = 1.253;
    x[5][0] = 2.500;
    x[6][0] = 3.740;
    double[] y = new double[] { 0.050, 0.127, 0.094, 0.2122, 0.2729, 0.2665, 0.3317 };
    GaussNewton gaussNewton = new GaussNewton() {

        @Override
        public double findY(double x, double[] b) {
            // y = (x * a1) / (a2 + x)
            return (x * b[0]) / (b[1] + x);
        }
    };
    double[] b = gaussNewton.optimise(x, y, 2);
    Assert.assertArrayEquals(new double[]{0.36, 0.56}, b, 0.01);
};