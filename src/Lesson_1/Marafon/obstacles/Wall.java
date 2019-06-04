package Lesson_1.Marafon.obstacles;

import Lesson_1.Marafon.competitors.Competitor;
import Lesson_1.Marafon.obstacles.Obstacle;

public class Wall extends Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }

    @Override
    public int getObstacleSize() {
        return height;
    }
}