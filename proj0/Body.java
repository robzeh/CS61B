public class Body {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double gravity = 6.67e-11;

    public Body(double xP, double yp, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yp;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        // return double = distance between b and body.calcDistance
        double dx = this.xxPos - b.xxPos;
        double dy = this.yyPos - b.yyPos;

        double radius = Math.pow(dx, 2) + Math.pow(dy, 2);

        return Math.sqrt(radius);
    }

    public double calcForceExertedBy(Body b) {
        double m1 = this.mass;
        double m2 = b.mass;
        double radius = Math.pow(this.calcDistance(b), 2);

        return ((gravity * m1 * m2) / radius);
    }

    public double calcForceExertedByX(Body b) {
        double dx;

        if (this.xxPos > b.xxPos) {
            dx = this.xxPos - b.xxPos;
        } else {
            dx = -(this.xxPos - b.xxPos);
        }

        double force = this.calcForceExertedBy(b);
        double radius = this.calcDistance(b);

        return (force * dx) / radius;
    }

    public double calcForceExertedByY(Body b) {
        double dy;

        if (this.yyPos > b.yyPos) {
            dy = this.yyPos - b.yyPos;
        } else {
            dy = -(this.yyPos - b.yyPos);
        }

        double force = this.calcForceExertedBy(b);
        double radius = this.calcDistance(b);

        return (force * dy) / radius;
    }

    public double calcNetForceExertedByX(Body[] arr) {
        double netForce = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!(this.equals(arr[i]))) {
                netForce += this.calcForceExertedByX(arr[i]);
            }
        }

        return netForce;
    }

    public double calcNetForceExertedByY(Body[] arr) {
        double netForce = 0;

        for (int i = 0; i <arr.length; i++) {
            if (!(this.equals(arr[i]))) {
                netForce += this.calcForceExertedByY(arr[i]);
            }
        }

        return netForce;
    }

    public void update(double t, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;

        double vx = this.xxVel + (t * ax);
        double yx = this.yyVel + (t * ay);

        this.xxVel = vx;
        this.yyVel = yx;

        this.xxPos = this.xxPos + (t * vx);
        this.yyPos = this.yyPos + (t * yx);

    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }

}
