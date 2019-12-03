package com.example.sofit_android_task.ServicesFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.sofit_android_task.HomeFragment.AdapterClassPayment;
import com.example.sofit_android_task.HomeFragment.ModelClassImage;
import com.example.sofit_android_task.IBadgeUpdateListener;
import com.example.sofit_android_task.R;

import java.util.ArrayList;

public class ServicesFragment extends Fragment {
    ArrayList<ModelClassService> modelClassServices;
    IBadgeUpdateListener iBadgeUpdateListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View frg = inflater.inflate(R.layout.fragment_services, container, false);
        iBadgeUpdateListener = (IBadgeUpdateListener) getActivity();
        iBadgeUpdateListener.setHeaderTitle("Service Fragment");
        modelClassServices = new ArrayList<>();
        populatelistService();
        bindView(frg);
        return frg;
    }
    public void bindView(View frg){
        RecyclerView recyclerView = (RecyclerView) frg.findViewById(R.id.recycleview_services);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new AdapterClassServiceFragment(getActivity(),modelClassServices));

    }
    public void populatelistService(){
        String dummytxv="Payment History";
        modelClassServices.add(new ModelClassService("https://cdn.pixabay.com/photo/2016/11/21/17/29/agriculture-1846649_960_720.jpg",
                "https://cdn.pixabay.com/photo/2019/11/14/07/05/plateau-4625455_960_720.jpg",
                "https://cdn.pixabay.com/photo/2019/11/14/07/05/plateau-4625455_960_720.jpg",
                "https://image.shutterstock.com/image-photo/lake-scanno-laquila-italy-when-600w-1108510025.jpg"

                ));
        modelClassServices.add(new ModelClassService("https://cdn.pixabay.com/photo/2016/11/21/17/29/agriculture-1846649_960_720.jpg",
                "https://cdn.pixabay.com/photo/2019/11/14/07/05/plateau-4625455_960_720.jpg",
                "https://cdn.pixabay.com/photo/2019/11/14/07/05/plateau-4625455_960_720.jpg",
                "https://image.shutterstock.com/image-photo/lake-scanno-laquila-italy-when-600w-1108510025.jpg"

        ));
        modelClassServices.add(new ModelClassService("https://cdn.pixabay.com/photo/2016/11/21/17/29/agriculture-1846649_960_720.jpg",
                "https://cdn.pixabay.com/photo/2019/11/14/07/05/plateau-4625455_960_720.jpg",
                "https://cdn.pixabay.com/photo/2019/11/14/07/05/plateau-4625455_960_720.jpg",
                "https://image.shutterstock.com/image-photo/lake-scanno-laquila-italy-when-600w-1108510025.jpg"

        ));

        modelClassServices.add(new ModelClassService("https://cdn.pixabay.com/photo/2016/11/21/17/29/agriculture-1846649_960_720.jpg",
                "https://cdn.pixabay.com/photo/2019/11/14/07/05/plateau-4625455_960_720.jpg",
                "https://cdn.pixabay.com/photo/2019/11/14/07/05/plateau-4625455_960_720.jpg",
                "https://image.shutterstock.com/image-photo/lake-scanno-laquila-italy-when-600w-1108510025.jpg"

        ));

        modelClassServices.add(new ModelClassService("https://cdn.pixabay.com/photo/2016/11/21/17/29/agriculture-1846649_960_720.jpg",
                "https://cdn.pixabay.com/photo/2019/11/14/07/05/plateau-4625455_960_720.jpg",
                "https://cdn.pixabay.com/photo/2019/11/14/07/05/plateau-4625455_960_720.jpg",
                "https://image.shutterstock.com/image-photo/lake-scanno-laquila-italy-when-600w-1108510025.jpg"

        ));



    }

    @Override
    public void onHiddenChanged(boolean hidden) {

        iBadgeUpdateListener.setHeaderTitle("Service Fragment");
    }
}
