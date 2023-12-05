public class MajorButler extends Motivator {

    String MOS;
    String retirementDate;

    public MajorButler(String name, String rank, double mustache_width, double hairLength, double weight, String MOS, String retirementDate) {
        super(name, rank, mustache_width, hairLength, weight);
        this.MOS = MOS;
        this.retirementDate = retirementDate;
    }


    @Override
    public String toString() {
        return "MajorButler{" +
                "retirementDate='" + retirementDate + '\'' +
                ", name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                ", mustache_width=" + mustache_width +
                ", hairLength=" + hairLength +
                ", weight=" + weight +
                "} " + super.toString();
    }
}
