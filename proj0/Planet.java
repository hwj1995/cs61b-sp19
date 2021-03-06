public class Planet{
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    static double G = 6.67 * Math.pow(10, -11);
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;  
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel; 
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    

    public double calcDistance(Planet p){
        double x_2 = Math.pow((xxPos - p.xxPos), 2);
        double y_2 = Math.pow((yyPos - p.yyPos), 2);
        return (Math.pow((x_2 + y_2),0.5));
    }
    
    public double calcForceExertedBy(Planet p){
        return (G * mass * p.mass / (calcDistance(p) * calcDistance(p)));
    }

    public double calcForceExertedByX(Planet p){
        return (p.xxPos-xxPos)/calcDistance(p)*calcForceExertedBy(p);
    }

    public double calcForceExertedByY(Planet p){
        return (p.yyPos-yyPos)/calcDistance(p)*calcForceExertedBy(p);
    }

    public double calcNetForceExertedByX(Planet p[]){
        double F_x = 0;
        for (Planet i : p){
            if(this.equals(i)){
                continue;
            }
            F_x += this.calcForceExertedByX(i);

        }
        return F_x;
    }
    public double calcNetForceExertedByY(Planet p[]){
        double F_y = 0;
        for (Planet i : p){
            if(this.equals(i)){
                continue;
            }
            F_y += this.calcForceExertedByY(i);

        }
        return F_y;
    }
    public Boolean equal(Planet p){
        return this == p ? true : false;
    }

    public void update(double dt, double fX, double fY){
        double a_x = fX / mass;
        double a_y = fY / mass;
        xxVel += dt * a_x;
        yyVel += dt * a_y;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }
    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
    public static void main(String[] args) {
        
    }
}