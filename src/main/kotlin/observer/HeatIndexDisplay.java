package observer;

public class HeatIndexDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    public WeatherData weatherData;

    public HeatIndexDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        float T = temperature;
        float RH = humidity;
        double heatIndex = 16.923 + 1.85212 * 10-1 * T + 5.37941 * RH - 1.00254 * 10-1 *
                T * RH + 9.41695 * 10-3 * (T * T) + 7.28898 * 10-3 * (RH * RH) + 3.45372 *
                10-4 * (T * T) * RH - 8.14971 * 10-4 * T * (RH * RH) + 1.02102 * 10-5 * (T * T) *
                (RH * RH) - 3.8646 * 10-5 * (T * T * T) + 2.91583 * 10-5 * (RH * RH * RH) + 1.42721 * 10-6
                * (T * T * T) * RH + 1.97483 * 10-7 * T * (RH * RH * RH) - 2.18429 * 10-8 * (T * T * T) * (RH * RH)
                + 8.43296 * 10-10 * (T * T) * (RH * RH * RH) - 4.81975 * 10-11 * (T * T * T) * (RH * RH * RH);

        System.out.println(
                "Heat index is " + heatIndex
        );
    }

    @Override
    public void update() {
        this.temperature = weatherData.temperature;
        this.humidity = weatherData.humidity;
        display();
    }
}
