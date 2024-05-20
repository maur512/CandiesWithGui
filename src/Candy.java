import java.io.Serializable;

public abstract class Candy implements GetSet, Comparable<Candy>, Serializable {
    public double weight;
    public int shugar;
    public String name;

    @Override
    public int compareTo(Candy o) {
        return (int) (o.getWeight() - this.getWeight());
    }
}
