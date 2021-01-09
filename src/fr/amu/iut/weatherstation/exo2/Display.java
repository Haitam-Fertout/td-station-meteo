package fr.amu.iut.weatherstation.exo2;

public abstract class Display {

    private float temperature;
    private float humidity;
    private float pressure;

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public void print() {
        System.out.println("Print from :" + getClass());
        System.out.println("Temperature: " + temperature);
        System.out.println("Humidity: " + humidity);
        System.out.println("Pressure: " + pressure);
    }

    public Display(WeatherStation station) {
        station.addDisplay(this);
    }
}