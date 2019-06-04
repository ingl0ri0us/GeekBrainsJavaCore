package Lesson_1.Marafon.obstacles;

import Lesson_1.Marafon.competitors.Competitor;
import Lesson_1.Marafon.competitors.Team;

public class Course {
    private Obstacle [] course;

    public Course() {
        course = new Obstacle[3];

        course[0] = new Cross(5000);
        course[1] = new Wall(30);
        course[2] = new Water(200);
    }

    public void runThroughCourse(Team team) {
        for (Competitor competitor : team.getTeamMembers()) {
            competitor.run(course[0].getObstacleSize());
            competitor.jump(course[1].getObstacleSize());
            competitor.swim(course[2].getObstacleSize());
        }
    }
}
