package pro.vteam.freemarket.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import pro.vteam.freemarket.models.AppModel;
import pro.vteam.freemarket.models.ApplicationTypesModel;

public class ItemsViewModel extends ViewModel {

    MutableLiveData<ArrayList<ApplicationTypesModel>> appTypes;


    private ItemsViewModel(){

        appTypes=new MutableLiveData<>();
        appTypes.setValue(modifyAppTypes());
    }

    public MutableLiveData<ArrayList<ApplicationTypesModel>> getAppTypes() {
        return appTypes;
    }

    private ArrayList<ApplicationTypesModel> modifyAppTypes(){



        ArrayList<AppModel> appList=new ArrayList<>();
            for (int i=0;i<=10;i++){
                AppModel app = new AppModel();
                app.setAppName("اپلیکیشن "+ i);
                app.setAppCost("رایگان");
                app.setAppIconUrl("R.drawable.ic_android_black_24dp");
                appList.add(app);
            }


          ArrayList<ApplicationTypesModel> appsTypeList=new ArrayList<>();
            for (int i=0;i<=10;i++){
                ApplicationTypesModel appType = new ApplicationTypesModel();
                appType.setAppsType("نوع " + i);
                appType.setAppsList(appList);
                appsTypeList.add(appType);

        }

            return appsTypeList;
    }
}
