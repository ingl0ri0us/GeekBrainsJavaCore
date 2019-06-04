package Lesson_1.Marafon.obstacles;

import Lesson_1.Marafon.competitors.Competitor;
import Lesson_1.Marafon.obstacles.Obstacle;

public class Water extends Obstacle {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }

    @Override
    public int getObstacleSize() {
        return length;
    }
}