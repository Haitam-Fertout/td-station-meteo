package fr.amu.iut.weatherstation.exo2;
import fr.amu.iut.weatherstation.exo1.HumiditySensor;
import fr.amu.iut.weatherstation.exo1.PressureSensor;
import fr.amu.iut.weatherstation.exo1.TemperatureSensor;

public class Exo2 {
    public static void main(String[] args) {
        // Initialize sensors
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        HumiditySensor humiditySensor = new HumiditySensor();
        PressureSensor pressureSensor = new PressureSensor();

        // Initialize our weather station by linking it to the sensors.
        WeatherStation weatherStation = new WeatherStation(temperatureSensor, humiditySensor, pressureSensor);

        ConsoleDisplay console = new ConsoleDisplay(weatherStation);
        KitchenDisplay kitchen = new KitchenDisplay(weatherStation);

        try {
            //noinspection InfiniteLoopStatement
            while (true){
                System.out.println();
                System.out.println("Weather station: polling sensors");
                // Take a measurement from the sensors
                weatherStation.pollSensors();

                for (Display display : weatherStation.displays) {
                    display.print();
                }

                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}