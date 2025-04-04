public class L2Q5Circle implements Comparable<L2Q5Circle>{
    double radius;

    public L2Q5Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int compareTo(L2Q5Circle other){
        return Double.compare(this.radius, other.radius);
    }

    public String toString(){
        return ("radius = " + radius);
    }
}