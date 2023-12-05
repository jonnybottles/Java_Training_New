public class Motivator {

    String name;
    String rank;
    double mustache_width;
    double hairLength;
    double weight;

    public Motivator(String name, String rank, double mustache_width, double hairLength, double weight) {
        this.name = name;
        this.rank = rank;
        this.mustache_width = mustache_width;
        this.hairLength = hairLength;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public double getMustache_width() {
        return mustache_width;
    }

    public void setMustache_width(double mustache_width) {
        this.mustache_width = mustache_width;
    }

    public double getHairLength() {
        return hairLength;
    }

    public void setHairLength(double hairLength) {
        this.hairLength = hairLength;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Motivator{" +
                "name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                ", mustache_width=" + mustache_width +
                ", hairLength=" + hairLength +
                ", weight=" + weight +
                '}';
    }
}
