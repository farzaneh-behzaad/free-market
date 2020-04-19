package pro.vteam.freemarket.ui.myMarket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import pro.vteam.freemarket.R;

public class MyMarketFragment extends Fragment {

    private MyMarketViewModel myMarketViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myMarketViewModel =
                ViewModelProviders.of(this).get(MyMarketViewModel.class);
        View root = inflater.inflate(R.layout.fragment_my_market, container, false);
        final TextView textView = root.findViewById(R.id.text_myMarket);
        myMarketViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
