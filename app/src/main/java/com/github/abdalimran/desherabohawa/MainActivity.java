package com.github.abdalimran.desherabohawa;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.abdalimran.desherabohawa.ConditionPojoModels.ConditionResponse;
import com.github.abdalimran.desherabohawa.Constants.Constants;
import com.github.abdalimran.desherabohawa.Forecast10dayPojoModels.Forecast10dayResponse;
import com.github.abdalimran.desherabohawa.GeolookupPojoModels.GeolookupResponse;
import com.github.abdalimran.desherabohawa.Interfaces.API_Interface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
* Please register on: https://www.wunderground.com/weather/api/
* Generate your own free API key and replace the key into API_KEY field of the Constant class.*/


public class MainActivity extends AppCompatActivity {
    private TextView currentLocation;
    private TextView currentDate;
    private TextView currentTime;
    private ImageView weatherIcon;
    private TextView weatherStatus;
    private TextView currentTemp;
    private TextView feelsLike;
    private TextView currentHigh;
    private TextView currentLow;
    private TextView currentPressure;
    private TextView currentHumidity;
    private TextView chancesRain;
    private TextView forDayName1;
    private ImageView forWeaStatIconD1;
    private TextView forHiLwD1;
    private TextView forPoRD1;
    private TextView forDayName2;
    private ImageView forWeaStatIconD2;
    private TextView forHiLwD2;
    private TextView forPoRD2;
    private TextView forDayName3;
    private ImageView forWeaStatIconD3;
    private TextView forHiLwD3;
    private TextView forPoRD3;

    private GPSTracker gps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        gps=new GPSTracker(getApplicationContext());

        FindViewByID();
        if(!gps.canGetLocation() && !isOnline()) {
            Toast.makeText(getApplicationContext(),"Please enable Location & Internet service.",Toast.LENGTH_LONG).show();
        }
        else if (!gps.canGetLocation()){
            Toast.makeText(getApplicationContext(),"Please enable Location service.",Toast.LENGTH_LONG).show();
        }
        else if(!isOnline()){
            Toast.makeText(getApplicationContext(),"Please enable Internet service.",Toast.LENGTH_LONG).show();
        }
        else {
            getWeatherData();
        }
        currentDate.setText(TimeDate.getWeekDay() + "\n" + TimeDate.getDate());
        currentTime.setText(TimeDate.getTime());
    }

    private void FindViewByID()
    {
        currentLocation= (TextView) findViewById(R.id.currentLocation);
        currentDate= (TextView) findViewById(R.id.currentDate);
        currentTime= (TextView) findViewById(R.id.currentTime);
        weatherIcon= (ImageView) findViewById(R.id.weatherIcon);
        weatherStatus= (TextView) findViewById(R.id.weatherStatus);
        currentTemp= (TextView) findViewById(R.id.currentTemp);
        feelsLike= (TextView) findViewById(R.id.feelsLike);
        currentHigh= (TextView) findViewById(R.id.currentHigh);
        currentLow= (TextView) findViewById(R.id.currentLow);
        currentPressure= (TextView) findViewById(R.id.currentPressure);
        currentHumidity= (TextView) findViewById(R.id.currentHumidity);
        chancesRain= (TextView) findViewById(R.id.chancesRain);
        forDayName1= (TextView) findViewById(R.id.forDayName1);
        forWeaStatIconD1= (ImageView) findViewById(R.id.forWeaStatIconD1);
        forHiLwD1= (TextView) findViewById(R.id.forHiLwD1);
        forPoRD1= (TextView) findViewById(R.id.forPoRD1);
        forDayName2= (TextView) findViewById(R.id.forDayName2);
        forWeaStatIconD2= (ImageView) findViewById(R.id.forWeaStatIconD2);
        forHiLwD2= (TextView) findViewById(R.id.forHiLwD2);
        forPoRD2= (TextView) findViewById(R.id.forPoRD2);
        forDayName3= (TextView) findViewById(R.id.forDayName3);
        forWeaStatIconD3= (ImageView) findViewById(R.id.forWeaStatIconD3);
        forHiLwD3= (TextView) findViewById(R.id.forHiLwD3);
        forPoRD3= (TextView) findViewById(R.id.forPoRD3);
    }

    private void getWeatherConditions(String currentCity)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API_Interface weatherService = retrofit.create(API_Interface.class);
        Call<ConditionResponse> callWeatherConditions = weatherService.getWeatherConditions(Constants.API_KEY,currentCity);
        callWeatherConditions.enqueue(new Callback<ConditionResponse>() {
            @Override
            public void onResponse(Call<ConditionResponse> call, Response<ConditionResponse> response) {
                weatherIcon.setImageResource(getIconID(response.body().getCurrentObservation().getIcon()));
                weatherStatus.setText(response.body().getCurrentObservation().getWeather());
                Log.e("getWeather", response.body().getCurrentObservation().getWeather());
                currentTemp.setText(String.valueOf(response.body().getCurrentObservation().getTempC())+"°C");
                feelsLike.setText("Feels like: "+response.body().getCurrentObservation().getFeelslikeC()+"°C");
                currentPressure.setText("Pressure: "+String.valueOf(response.body().getCurrentObservation()
                        .getPressureMb()+" hPa"));
                currentHumidity.setText("Humidity: "+String.valueOf(response.body().getCurrentObservation()
                        .getRelativeHumidity()));
            }
            @Override
            public void onFailure(Call<ConditionResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "We are sorry! Something went wrong with the API!", Toast.LENGTH_LONG).show();
                Log.e("error",t.getMessage());
            }
        });

    }

    private void getForecast10day(String currentCity)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API_Interface weatherService = retrofit.create(API_Interface.class);
        Call<Forecast10dayResponse> callWeatherForecast = weatherService.getWeatherForecast(Constants.API_KEY,currentCity);
        callWeatherForecast.enqueue(new Callback<Forecast10dayResponse>() {
            @Override
            public void onResponse(Call<Forecast10dayResponse> call, Response<Forecast10dayResponse> response) {

                currentHigh.setText("High: "+String.valueOf(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(0).getHigh().getCelsius())+"°C");
                currentLow.setText("Low: "+String.valueOf(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(0).getLow().getCelsius())+"°C");
                chancesRain.setText("Poss. of Rain: "+String.valueOf(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(0).getPop())+"%");

                forDayName1.setText(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(1).getDate().getWeekday());
                forWeaStatIconD1.setImageResource(getIconID(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(1).getIcon()));
                forHiLwD1.setText(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(1).getHigh().getCelsius()+"°C / "+
                        response.body().getForecast()
                                .getSimpleforecast().getForecastday().get(1).getLow().getCelsius()+"°C");
                forPoRD1.setText("PoR: "+String.valueOf(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(1).getPop())+"%");

                forDayName2.setText(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(2).getDate().getWeekday());
                forWeaStatIconD2.setImageResource(getIconID(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(2).getIcon()));
                forHiLwD2.setText(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(2).getHigh().getCelsius()+"°C / "+
                        response.body().getForecast()
                                .getSimpleforecast().getForecastday().get(2).getLow().getCelsius()+"°C");
                forPoRD2.setText("PoR: "+String.valueOf(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(2).getPop())+"%");

                forDayName3.setText(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(3).getDate().getWeekday());
                forWeaStatIconD3.setImageResource(getIconID(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(3).getIcon()));
                forHiLwD3.setText(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(3).getHigh().getCelsius()+"°C / "+
                        response.body().getForecast()
                                .getSimpleforecast().getForecastday().get(3).getLow().getCelsius()+"°C");
                forPoRD3.setText("PoR: "+String.valueOf(response.body().getForecast()
                        .getSimpleforecast().getForecastday().get(3).getPop())+"%");
            }

            @Override
            public void onFailure(Call<Forecast10dayResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "We are sorry! Something went wrong with the API!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void getWeatherData()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API_Interface weatherService = retrofit.create(API_Interface.class);
        Call<GeolookupResponse> callGeolookup = weatherService.getGeolookup(Constants.API_KEY,gps.getLatitude(),gps.getLongitude());

        callGeolookup.enqueue(new Callback<GeolookupResponse>(){
            @Override
            public void onResponse(Call<GeolookupResponse> call, Response<GeolookupResponse> response) {
                if (response.body().getLocation() != null) {
                    currentLocation.setText(response.body().getLocation().getCity() + ", Bangladesh");
                    String currentCity = response.body().getLocation().getCity();
                    getWeatherConditions(currentCity);
                    getForecast10day(currentCity);
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry! API key is not valid due to exceeding rate plan.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GeolookupResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "We are sorry! Something went wrong with the API!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private int getIconID(String s)
    {
        Resources res = getResources();
        int resID = res.getIdentifier(s,"drawable", getPackageName());
        return resID;
    }

    public void updateWeather(View view) {

        if(!gps.canGetLocation() && !isOnline()) {
            Toast.makeText(getApplicationContext(),"Please enable Location & Internet service.",Toast.LENGTH_LONG).show();
        }
        else if (!gps.canGetLocation()){
            Toast.makeText(getApplicationContext(),"Please enable Location service.",Toast.LENGTH_LONG).show();
        }
        else if(!isOnline()){
            Toast.makeText(getApplicationContext(),"Please enable Internet service.",Toast.LENGTH_LONG).show();
        }
        else {
            currentDate.setText(TimeDate.getWeekDay() + "\n" + TimeDate.getDate());
            currentTime.setText(TimeDate.getTime());
            getWeatherData();
            Toast.makeText(getApplicationContext(),"Weather information has been updated!",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
