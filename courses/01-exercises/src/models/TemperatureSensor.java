package models;

public class TemperatureSensor {
    String local;
    private double temperature;

    public TemperatureSensor(String local,double temperature) {
        this.local = local;
        this.temperature = temperature;
    }

    public void showInformation(){
        System.out.printf("Local: %s.\nTemperature: %.1fºC.\n",local,temperature);
        if(isAboveMaximumTemperature(temperature)) System.out.println("Alert: Temperature above limit.");
    }

    public boolean isAboveMaximumTemperature(double temperature){
        return temperature > 37.5;
    }
}
