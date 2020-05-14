package pro.vteam.freemarket.repository;

import android.util.Log;


import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import pro.vteam.freemarket.interfaces.CategoriesService;

import pro.vteam.freemarket.models.CategoriesList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {


    public static void getCategoriesLists(MutableLiveData<ArrayList<CategoriesList>> liveData) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/m-khademloo/free-market-mocks/master/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoriesService categoriesService = retrofit.create(CategoriesService.class);

        Call<pro.vteam.freemarket.models.Response> call = categoriesService.getResponse();

        call.enqueue(new Callback<pro.vteam.freemarket.models.Response>() {
            @Override
            public void onResponse(Call<pro.vteam.freemarket.models.Response> call, Response<pro.vteam.freemarket.models.Response> response) {
                Log.wtf("LOG","on success");
                liveData.setValue(response.body().getResult().getCategoriesLists());


            }

            @Override
            public void onFailure(Call<pro.vteam.freemarket.models.Response> call, Throwable t) {
                Log.wtf("LOG","failure");
            }
        });


    }



}
