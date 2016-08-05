package com.github.abdalimran.desherabohawa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.github.abdalimran.desherabohawa.ConditionPojoModels.ConditionResponse;
import com.github.abdalimran.desherabohawa.Constants.Constants;
import com.github.abdalimran.desherabohawa.Forecast10dayPojoModels.Forecast10dayResponse;
import com.github.abdalimran.desherabohawa.Interfaces.API_Interface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout=(LinearLayout) findViewById(R.id.main_layout);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API_Interface weatherService = retrofit.create(API_Interface.class);
        Call<ConditionResponse> callWeatherConditions = weatherService.getWeatherConditions(Constants.API_KEY,"Dhaka");
        Call<Forecast10dayResponse> callWeatherForecast = weatherService.getWeatherForecast(Constants.API_KEY,"Dhaka");

        callWeatherConditions.enqueue(new Callback<ConditionResponse>() {
            @Override
            public void onResponse(Call<ConditionResponse> call, Response<ConditionResponse> response) {

                Log.d("result",response.body().toString());
            }

            @Override
            public void onFailure(Call<ConditionResponse> call, Throwable t) {

                Log.e("error",t.getMessage());
            }
        });

        callWeatherForecast.enqueue(new Callback<Forecast10dayResponse>() {
            @Override
            public void onResponse(Call<Forecast10dayResponse> call, Response<Forecast10dayResponse> response) {

            }

            @Override
            public void onFailure(Call<Forecast10dayResponse> call, Throwable t) {

            }
        });
    }
}
