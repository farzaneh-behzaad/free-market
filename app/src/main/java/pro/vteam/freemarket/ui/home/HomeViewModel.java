package pro.vteam.freemarket.ui.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import pro.vteam.freemarket.models.Component;
import pro.vteam.freemarket.repository.Repository;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Component>> componentList;

    public HomeViewModel() {
        componentList = new MutableLiveData<>();
        modifyHomeDataList();

    }




    public MutableLiveData<ArrayList<Component>> getComponentList(){
        return componentList;
    }



    public void modifyHomeDataList(){


        Repository.getHomeData(new Repository.homeDataListener() {
            @Override
            public void onAccess(ArrayList<Component> components) {
                componentList.setValue(components);


            }

            @Override
            public void onFailed() {
                Log.i("LOG","on repository failed");

            }
        });
    }


}