package pro.vteam.freemarket.repository;

import android.util.Log;


import java.util.ArrayList;


import pro.vteam.freemarket.interfaces.HomeService;

import pro.vteam.freemarket.models.Component;
import pro.vteam.freemarket.models.HomeResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {


    public interface homeDataListener{
        void onAccess(ArrayList<Component> components);
        void onFailed();

    }



    public static void getHomeData(homeDataListener homeDataListener){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/m-khademloo/free-market-mocks/master/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HomeService homeService= retrofit.create(HomeService.class);
        Call<HomeResponse> call = homeService.getHomeData();

        call.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {


                if (response.body() != null && response.body().getStatusCode()==200){
                   Log.i("LOG","response received");
                   ArrayList<Component> components=response.body().getHomeResult().getPage().getComponents();
                   homeDataListener.onAccess(components);

                   }else homeDataListener.onFailed();
            }

            @Override
            public void onFailure(Call<HomeResponse> call, Throwable t) {
                homeDataListener.onFailed();

            }
        });


    }





}
