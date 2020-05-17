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
        String[] tabs=new String[2] ;
        tabs[0]="ویدیو";
        tabs[1]="برنامه و بازی";
        return tabs;

    }


}