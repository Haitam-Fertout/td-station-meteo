package fr.amu.iut.weatherstation.exo2;

import fr.amu.iut.weatherstation.exo1.HumiditySensor;
import fr.amu.iut.weatherstation.exo1.PressureSensor;
import fr.amu.iut.weatherstation.exo1.TemperatureSensor;

import java.util.ArrayList;

public class WeatherStation {
    private TemperatureSensor temperatureSensor;
    private HumiditySensor humiditySensor;
    private PressureSensor pressureSensor;
    private float temperature;
    private float humidity;
    private float pressure;


    public WeatherStation(TemperatureSensor temperatureSensor, HumiditySensor humiditySensor, PressureSensor pressureSensor){
        this.temperatureSensor = temperatureSensor;
        this.humiditySensor = humiditySensor;
        this.pressureSensor = pressureSensor;
    }

    public float getTemperature(){
        return this.temperature;
    }
    public float getHumidity(){
        return this.humidity;
    }
    public float getPressure(){
        return this.pressure;
    }


    public ArrayList<Display> displays = new ArrayList<Display>();
    public void pollSensors(){

        // Ask each sensor for its value and store it
        if (temperature != temperatureSensor.takeMeasurement() ||
                humidity != humiditySensor.takeMeasurement() ||
                pressure != pressureSensor.takeMeasurement()) {

            temperature = temperatureSensor.takeMeasurement();
            humidity = humiditySensor.takeMeasurement();
            pressure = pressureSensor.takeMeasurement();

            for (Display display : displays) {
                display.update(temperature, humidity, pressure);
            }
        }
    }

    public void addDisplay(Display ecran){
        displays.add(ecran);
    }

    }
