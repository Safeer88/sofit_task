package com.example.sofit_android_task.HomeFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;

import com.example.sofit_android_task.IBadgeUpdateListener;
import com.example.sofit_android_task.R;
import com.example.sofit_android_task.ServicesFragment.ServicesFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment  implements View.OnClickListener{
    ListView listView;
    LinearLayout ll_govermentservices;
    private FragmentTransaction mFragTransctn;
    private FragmentManager mFragMgr;
//    public HomefrgAdapterClass adapter;
    ArrayList<ModelClassImage> modelClassImages,modelClasspayments;
    IBadgeUpdateListener iBadgeUpdateListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View frg = inflater.inflate(R.layout.fragment_home, container, false);
        iBadgeUpdateListener = (IBadgeUpdateListener) getActivity();
        iBadgeUpdateListener.setHeaderTitle("Home Fragment");
        mFragMgr =getActivity().getSupportFragmentManager();
        modelClassImages = new ArrayList<>();
        modelClasspayments =new ArrayList<>();
        populatelistNews();
        populatelistPayments();

        bindView(frg);
        return frg;
    }
    public void populatelistNews(){
        String dummytxv="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
        modelClassImages.add(new ModelClassImage(dummytxv,"https://cdn.pixabay.com/photo/2019/11/14/07/05/plateau-4625455_960_720.jpg"));
        modelClassImages.add(new ModelClassImage(dummytxv,"https://image.shutterstock.com/image-photo/lake-scanno-laquila-italy-when-600w-1108510025.jpg"));
        modelClassImages.add(new ModelClassImage(dummytxv,"https://image.shutterstock.com/image-photo/lama-lake-on-putorana-plateau-600w-1499302607.jpg"));
        modelClassImages.add(new ModelClassImage(dummytxv,"https://image.shutterstock.com/image-photo/mueritz-national-park-holiday-destination-600w-1418697659.jpg"));
        modelClassImages.add(new ModelClassImage(dummytxv,"https://cdn.pixabay.com/photo/2016/11/21/17/29/agriculture-1846649_960_720.jpg"));
        modelClassImages.add(new ModelClassImage(dummytxv,"https://cdn.pixabay.com/photo/2016/07/30/09/56/wheat-1556698_960_720.jpg"));

    }

    public void populatelistPayments(){
        String dummytxv="Payment History";
        modelClasspayments.add(new ModelClassImage(dummytxv,"https://cdn.pixabay.com/photo/2019/11/14/07/05/plateau-4625455_960_720.jpg"));
        modelClasspayments.add(new ModelClassImage(dummytxv,"https://image.shutterstock.com/image-photo/lake-scanno-laquila-italy-when-600w-1108510025.jpg"));
        modelClasspayments.add(new ModelClassImage(dummytxv,"https://image.shutterstock.com/image-photo/lama-lake-on-putorana-plateau-600w-1499302607.jpg"));
        modelClasspayments.add(new ModelClassImage(dummytxv,"https://image.shutterstock.com/image-photo/mueritz-national-park-holiday-destination-600w-1418697659.jpg"));
        modelClasspayments.add(new ModelClassImage(dummytxv,"https://cdn.pixabay.com/photo/2016/11/21/17/29/agriculture-1846649_960_720.jpg"));
        modelClasspayments.add(new ModelClassImage(dummytxv,"https://cdn.pixabay.com/photo/2016/07/30/09/56/wheat-1556698_960_720.jpg"));

    }



    public void bindView(View frg){
        ll_govermentservices = frg.findViewById(R.id.ll_goverment_services);
        ll_govermentservices.setOnClickListener(this);

        RecyclerView recyclerView = (RecyclerView) frg.findViewById(R.id.recycleview);
        RecyclerView recyclerViewCard =(RecyclerView) frg.findViewById(R.id.recycleview_card);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

  recyclerViewCard.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerViewCard.setHasFixedSize(true);
        recyclerViewCard.setAdapter(new AdapterClassPayment(getActivity(),modelClasspayments));
        recyclerView.setAdapter(new AdapterClassNews(getActivity(),modelClassImages));

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
    {
        case R.id.ll_goverment_services:
            navtoServiceFragment();

            break;
        }
    }

    private void navtoServiceFragment() {
        Fragment frg = new ServicesFragment();
        mFragTransctn = mFragMgr.beginTransaction();
        mFragTransctn.add(R.id.act_main_content_fragment, frg, "Service Fragment");
        mFragTransctn.addToBackStack(null);
        mFragTransctn.hide(this);
        mFragTransctn.commit();
    }
    @Override
    public void onHiddenChanged(boolean hidden) {

        iBadgeUpdateListener.setHeaderTitle("Home Fragment");
    }
}
