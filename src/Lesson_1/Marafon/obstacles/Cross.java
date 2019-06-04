package Lesson_1.Marafon.obstacles;

import Lesson_1.Marafon.competitors.Competitor;

public class Cross extends Obstacle {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }

    @Override
    public int getObstacleSize() {
        return length;
    }


}