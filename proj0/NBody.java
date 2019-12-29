public class NBody {

    public static double readRadius(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }

    public static Body[] readBodies(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        double R = in.readDouble();
        Body[] bodies = new Body[N];

        for (int i = 0; i < N; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();

            Body b = new Body(xxPos, yyPos, xxVel, yyVel, mass, img);
            bodies[i] = b;
        }
        return bodies;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Body[] bodies = readBodies(filename);
        double radius = readRadius(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Body body : bodies) {
            body.draw();
        }

        StdDraw.enableDoubleBuffering();
        double time = 0;
        while (time < T) {
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];

            for (int i = 0; i < bodies.length; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }

            for (int j = 0; j < bodies.length; j++) {
                bodies[j].update(dt, xForces[j], yForces[j]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Body b : bodies) {
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        System.out.printf("%d\n", bodies.length);
        System.out.printf("%.2e\n", radius);

        for (int i = 0; i < bodies.length; i++) {
            System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }

    }

}