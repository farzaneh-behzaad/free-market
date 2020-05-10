package pro.vteam.freemarket.interfaces;

import java.util.ArrayList;
import java.util.List;

import pro.vteam.freemarket.models.CategoriesList;
import pro.vteam.freemarket.models.Response;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriesService {




    @GET("categories.json")
    Call<Response> getResponse();
}
