public class SourCandy extends Candy {

    public SourCandy(String name, double weight, int shugar) {
        this.weight = weight;
        this.name = name;
        this.shugar = shugar;
    }

    public SourCandy() {

    }


    public double getWeight() {
        return weight;
    }

    public int getShugar() {
        return shugar;
    }

    public String getName() {
        return name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setShugar(int shugar) {
        this.shugar = shugar;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return (this.name + " " + this.weight + " " + this.shugar);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}