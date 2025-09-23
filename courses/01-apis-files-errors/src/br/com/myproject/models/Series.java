package br.com.myproject.models;

public class Series extends AudiovisualContent{
    private int numberOfSeasons;
    private int totalNumberOfEpisodes;
    private boolean active;
    private int minutesPerEpisode;

    public Series(String name, int yearOfRelease) {
        super(name, yearOfRelease);
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public int getTotalNumberOfEpisodes() {
        return totalNumberOfEpisodes;
    }

    public void setTotalNumberOfEpisodes(int totalNumberOfEpisodes) {
        this.totalNumberOfEpisodes = totalNumberOfEpisodes;
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int getTotalDurationMinutes() {
        return totalNumberOfEpisodes * minutesPerEpisode;
    }

    @Override
    public String toString() {
        return "Serie: " + this.getName() + " (" + this.getYearOfRelease() + ")";
    }
}