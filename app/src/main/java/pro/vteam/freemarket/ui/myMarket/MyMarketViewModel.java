package pro.vteam.freemarket.ui.myMarket;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyMarketViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyMarketViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is MyMarket fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}