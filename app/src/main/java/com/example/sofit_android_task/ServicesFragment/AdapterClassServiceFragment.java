package com.example.sofit_android_task.ServicesFragment;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sofit_android_task.HomeFragment.ModelClassImage;
import com.example.sofit_android_task.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AdapterClassServiceFragment extends RecyclerView.Adapter<AdapterClassServiceFragment.ViewHoldeer>{
    ArrayList<ModelClassService> word;
    Context context;

    public AdapterClassServiceFragment(Context mContext, ArrayList<ModelClassService> words){
       this.context=mContext;
        word = words;

    }

    @NonNull
    @Override
    public ViewHoldeer onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.fragment_services_lst_items,viewGroup,false);
        return new ViewHoldeer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoldeer viewHoldeer, int i) {
                     ModelClassService currentItems = word.get(i);
//             viewHoldeer.textView.setText(currentItems.getTextimg());
//             viewHoldeer.imageView.setImageResource(currentItems.getImgae());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(viewHoldeer.imageView);
                    Picasso.get().load(currentItems.getImageone()).into(viewHoldeer.imageViewone);
                    Picasso.get().load(currentItems.getImagetwo()).into(viewHoldeer.imageViewtwo);
                    Picasso.get().load(currentItems.getImagethree()).into(viewHoldeer.imageViewthree);
                    Picasso.get().load(currentItems.getImagefour()).into(viewHoldeer.imageViewfour);
        }
    }

    @Override
    public int getItemCount() {


        return word.size();
    }


    public  class ViewHoldeer extends RecyclerView.ViewHolder{
       TextView textView;
       ImageView imageViewone,imageViewtwo,imageViewthree,imageViewfour;
        public ViewHoldeer(@NonNull View itemView) {
            super(itemView);
//            textView = (TextView) itemView.findViewById(R.id.frg_home_list_txv);
            imageViewone = (ImageView) itemView.findViewById(R.id.laybttab_chb_home);
            imageViewtwo = (ImageView) itemView.findViewById(R.id.laybttab_chb_history);
            imageViewthree = (ImageView) itemView.findViewById(R.id.laybttab_chb_profile);
            imageViewfour = (ImageView) itemView.findViewById(R.id.laybttab_chb_settings);

        }
    }
}
