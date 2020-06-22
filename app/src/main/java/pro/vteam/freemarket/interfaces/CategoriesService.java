package pro.vteam.freemarket.interfaces;

import pro.vteam.freemarket.oldModels.Response;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriesService {




    @GET("categories.json")
    Call<Response> getResponse();
}
