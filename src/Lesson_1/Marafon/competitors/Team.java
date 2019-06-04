package Lesson_1.Marafon.competitors;

import java.util.Random;

public class Team {
    private String teamName;
    private Competitor [] teamMembers;

    public Team(String teamName) {
        this.teamName = teamName;
        this.teamMembers = new Competitor[4];

        teamMembers[0] = new Cat("Barsik");
        teamMembers[1] = new Dog ("Bobik");
        teamMembers[2] = new Human ("Ivan");
        teamMembers[3] = new Human ("Maria");
    }

    public void showResults () {
        for(Competitor competitor : teamMembers) {
            competitor.info();
        }
    }

    public void showFinished () {
        for(Competitor competitor : teamMembers) {
            if(competitor.isOnDistance()) {
                System.out.println(competitor.getName() + " finished!");
            }
        }
    }

    public String getTeamName() {
        return teamName;
    }

    public Competitor[] getTeamMembers() {
        return teamMembers;
    }
}
