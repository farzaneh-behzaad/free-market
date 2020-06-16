package pro.vteam.freemarket.repository;

import android.util.Log;


import androidx.core.view.KeyEventDispatcher;

import java.util.ArrayList;

import pro.vteam.freemarket.interfaces.CategoriesService;


import pro.vteam.freemarket.interfaces.HomeService;
import pro.vteam.freemarket.models.CategoriesTabListModel;
import pro.vteam.freemarket.models.HomeComponent;
import pro.vteam.freemarket.models.HomeResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    public interface categoriesDataListener {
        void onAccess(ArrayList<CategoriesTabListModel> list);
        void onFailed();
    }

    public interface homeDataListener{
        void onAccess(ArrayList<HomeComponent> components);
        void onFailed();

    }



    public static void getCategoriesLists( categoriesDataListener categoriesDataListener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/m-khademloo/free-market-mocks/master/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoriesService categoriesService = retrofit.create(CategoriesService.class);
        Call<pro.vteam.freemarket.models.Response> call = categoriesService.getResponse();

        call.enqueue(new Callback<pro.vteam.freemarket.models.Response>() {
            @Override
            public void onResponse(Call<pro.vteam.freemarket.models.Response> call, Response<pro.vteam.freemarket.models.Response> response) {
                if (response.body() != null) {
                    if (response.body().getStatusCode() == 200) {
                        categoriesDataListener.onAccess(response.body().getResult().getCategoriesLists());

                    } else {
                        categoriesDataListener.onFailed();
                    }

                }else {
                    categoriesDataListener.onFailed();
                }
            }


            @Override
            public void onFailure(Call<pro.vteam.freemarket.models.Response> call, Throwable t) {
                Log.wtf("LOG","failure");
                categoriesDataListener.onFailed();
            }
        });


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
                   ArrayList<HomeComponent> components=response.body().getHomeResult().getHomePage().getComponents();
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
