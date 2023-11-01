


public class MainChallenge {
    public static void main(String[] args) {

        calculateScore();

    }

    public static void calculateScore() {
        boolean gameOver = true;
        int score = 10000;
        int levelCompleted = 8;
        int bonus = 200;

        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore);

        }
    }
}