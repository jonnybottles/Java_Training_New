package dev.lpa;

interface Player{
    String name();
}

record BaseballPlayer(String name, String position) implements Player {}

record FootballPlayer(String name, String position) implements Player {}

record VolleyballPlayer(String name, String position) implements Player {}

public class Main {
    public static void main(String[] args) {

        var philly = new Affiliation("city", "Philadelphia PA", "US" );

        BaseballTeam phillies1 = new BaseballTeam("Phillies");
        BaseballTeam astros1 = new BaseballTeam("Astros");
        scoreResult(phillies1, 3, astros1, 5);

        SportsTeam phillies = new SportsTeam("Phillies");
        SportsTeam astros = new SportsTeam("Astros");
        scoreResult(phillies, 3, astros, 5);

        Team<BaseballPlayer, Affiliation> phillies2 = new Team<>("Phillies", philly);
        Team<BaseballPlayer, Affiliation> astros2 = new Team<>("Astros");
        scoreResult(phillies2, 3, astros2, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");

        phillies.listTeamMembers();

        SportsTeam afc = new SportsTeam("Crows");
        Team<FootballPlayer, String> afc1 = new Team<>("Crows", "City of Adelaide, South Austrailia, in AU");

        var tex = new FootballPlayer("Tex Walker", "Centre half forward");
        afc.addTeamMember(tex);
        var rory = new FootballPlayer("Rory Laird", "Midfield");
        afc.addTeamMember(rory);
        afc.listTeamMembers();

        Team<VolleyballPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember(new VolleyballPlayer("N Roberts", "Setter"));
        adelaide.listTeamMembers();

        var canberra = new Team<VolleyballPlayer, Affiliation>("Canberra Heat");
        canberra.addTeamMember(new VolleyballPlayer("B Black", "Opposite"));
        canberra.listTeamMembers();
        scoreResult(canberra, 0, adelaide, 1);

//        Team<Integer> melbourneVB =new Team<>("Melbourne Vipers");

    }

    public static void scoreResult(BaseballTeam team1, int t1_score, BaseballTeam team2, int t2_score) {
        String message = team1.setSCore(t1_score, t2_score);
        team2.setSCore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);

    }

    public static void scoreResult(SportsTeam team1, int t1_score, SportsTeam team2, int t2_score) {
        String message = team1.setSCore(t1_score, t2_score);
        team2.setSCore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);

    }

    public static void scoreResult(Team team1, int t1_score, Team team2, int t2_score) {
        String message = team1.setSCore(t1_score, t2_score);
        team2.setSCore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);

    }
}