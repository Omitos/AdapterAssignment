import java.util.HashMap;
import java.util.Map;

class WeatherData {
    private String location;
    private double temperature;
    private String condition;

    public WeatherData(String location, double temperature, String condition) {
        this.location = location;
        this.temperature = temperature;
        this.condition = condition;
    }

    public String getLocation() {
        return location;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}

class WeatherAPI {
    public Map<String, Object> fetchWeatherData() {
        Map<String, Object> data = new HashMap<>();
        data.put("location", "City A");
        data.put("temperature", 25.0);
        data.put("condition", "Sunny");
        return data;
    }
}

class WeatherDataAdapter {
    private WeatherAPI weatherAPI;

    public WeatherDataAdapter(WeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;
    }

    public WeatherData adaptWeatherData() {
        Map<String, Object> apiData = weatherAPI.fetchWeatherData();

        String location = (String) apiData.get("location");
        double temperature = (Double) apiData.get("temperature");
        String condition = (String) apiData.get("condition");

        return new WeatherData(location, temperature, condition);
    }
}

class MobileApp {
    public static void main(String[] args) {
        WeatherAPI weatherAPI = new WeatherAPI();
        WeatherDataAdapter adapter = new WeatherDataAdapter(weatherAPI);

        WeatherData weatherData = adapter.adaptWeatherData();
        System.out.println("Location: " + weatherData.getLocation());
        System.out.println("Temperature: " + weatherData.getTemperature() + "°C");
        System.out.println("Condition: " + weatherData.getCondition());
    }
}
