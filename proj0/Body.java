public class Body {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

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


}
