package Lesson_1.Marafon;

import Lesson_1.Marafon.competitors.*;
import Lesson_1.Marafon.obstacles.Course;
import Lesson_1.Marafon.obstacles.Cross;
import Lesson_1.Marafon.obstacles.Obstacle;
import Lesson_1.Marafon.obstacles.Wall;

public class Main {
    public static void main(String[] args) {
        Course course = new Course();
        Team team = new Team("Hotdogs");
        course.runThroughCourse(team);
        team.showResults();
    }
}