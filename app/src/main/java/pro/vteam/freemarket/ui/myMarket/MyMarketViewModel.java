package pro.vteam.freemarket.ui.myMarket;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyMarketViewModel extends ViewModel {

    private MutableLiveData<String[]> tabs;

    public MyMarketViewModel() {
        tabs=new MutableLiveData<>();
        tabs.setValue(modifyTabs());

    }


    public MutableLiveData<String[]> getTabs(){
        return tabs;
    }


    private String[] modifyTabs(){
        String[] tabs = {"برنامه و بازی","ویدیو"};
        return tabs;

    }


}