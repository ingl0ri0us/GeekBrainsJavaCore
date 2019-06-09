package Lesson_2.enums;

enum  DayOfWeek {
    MONDAY(0,8),
    TUESDAY(1,8),
    WEDNESDAY(2,8),
    THURSDAY(3,8),
    FRIDAY(4,8),
    SATURDAY(5,0),
    SUNDAY(6,0);

    private int dayNumber;
    private int workingHours;

    DayOfWeek(int dayNumber, int workingHours) {
        this.dayNumber = dayNumber;
        this.workingHours = workingHours;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public int getWorkingHours() {
        return workingHours;
    }
}
