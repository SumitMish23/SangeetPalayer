package com.example.myweather;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData
{
    private String temp, Micon, city, weathertype;
    private int condition;

    public static weatherData fromJson(JSONObject jsonObject)
    {
        try
        {
            weatherData wd = new weatherData();
            wd.city = jsonObject.getString("name");
            wd.condition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            wd.weathertype = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            wd.Micon = updateWeatherIcon(wd.condition);
            double tempResult =jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue = (int)Math.rint(tempResult);
            wd.temp=Integer.toString(roundedValue);
          return wd;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            return null;

        }
    }


    private static String updateWeatherIcon(int condition)
    {

        if (condition >= 0 && condition <= 300)
        {
            return "lightrain";
        }
        else if (condition >= 300 && condition <= 500)
        {
            return "overcas";
        }
        else if (condition >= 500 && condition <= 700)
        {
            return "download";
        }
        else if (condition >= 700 && condition <= 771)
        {
            return "snow";
        }
        else if (condition == 800)
        {
            return "sunny";
        }
        else if (condition >= 800 && condition <= 900)
        {
            return "snow";
        }
           return "dunno";
    }

    public String getTemp() {
        return temp+"°C";
    }

    public String getIcon() {
        return Micon;
    }

    public String getCity() {
        return city;
    }

    public String getWeathertype() {
        return weathertype;
    }
}
