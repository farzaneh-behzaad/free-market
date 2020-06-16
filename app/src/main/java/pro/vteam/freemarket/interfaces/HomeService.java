package pro.vteam.freemarket.interfaces;

import pro.vteam.freemarket.models.HomeResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HomeService {




    @GET("all-page-components.json")
    Call<HomeResponse> getHomeData();
}
