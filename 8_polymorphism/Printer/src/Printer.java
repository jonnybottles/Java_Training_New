public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = tonerLevel;
        this.duplex = duplex;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplex() {
        return duplex;
    }

    public int addToner(int tonerAmount) {
        if ((tonerAmount + tonerLevel) < 0 || (tonerAmount + tonerLevel > 100)) {
            return -1;
        }
        this.tonerLevel += tonerAmount;
        return tonerLevel;
    }

    public int printPages(int numPages) {
        if (duplex) {
            System.out.println("This is a duplex printer.");
            numPages /=  2;
            pagesPrinted += numPages;
        } else {
            System.out.println("This is not a duplex printer.");
            pagesPrinted += numPages;
        }

        return numPages;
    }

}
