package pro.vteam.freemarket.repository;

import android.util.Log;


import java.util.ArrayList;

import pro.vteam.freemarket.interfaces.CategoriesService;


import pro.vteam.freemarket.models.CategoriesTabListModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    public interface OnAccessListener{
        void onAccess(ArrayList<CategoriesTabListModel> list);
        void onFailed();
    }



    public static void getCategoriesLists( OnAccessListener onAccessListener) {
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
                        onAccessListener.onAccess(response.body().getResult().getCategoriesLists());

                    } else {
                        onAccessListener.onFailed();
                    }

                }else {
                    onAccessListener.onFailed();
                }
            }


            @Override
            public void onFailure(Call<pro.vteam.freemarket.models.Response> call, Throwable t) {
                Log.wtf("LOG","failure");
                onAccessListener.onFailed();
            }
        });


    }


}
