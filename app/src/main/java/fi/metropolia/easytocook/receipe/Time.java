package fi.metropolia.easytocook.receipe;

public class Time {
    private int hour;
    private int minutes;

    public Time(int initialHour, int initialMinutes){
        this.hour = initialHour;
        this.minutes = initialMinutes;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }
}
