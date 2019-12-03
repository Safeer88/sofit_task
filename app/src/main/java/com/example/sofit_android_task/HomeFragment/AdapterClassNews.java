package com.example.sofit_android_task.HomeFragment;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sofit_android_task.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AdapterClassNews extends RecyclerView.Adapter<AdapterClassNews.ViewHoldeer>{
    ArrayList<ModelClassImage> word;
    Context context;

    public AdapterClassNews(Context mContext, ArrayList<ModelClassImage> words){
       this.context=mContext;
        word = words;

    }

    @NonNull
    @Override
    public ViewHoldeer onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.frg_home_lst_items,viewGroup,false);
        return new ViewHoldeer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoldeer viewHoldeer, int i) {
                     ModelClassImage currentItems = word.get(i);
             viewHoldeer.textView.setText(currentItems.getTextimg());
//             viewHoldeer.imageView.setImageResource(currentItems.getImgae());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(viewHoldeer.imageView);
                    Picasso.get().load(currentItems.getImgae()).into(viewHoldeer.imageView);
        }
    }

    @Override
    public int getItemCount() {


        return word.size();
    }


    public  class ViewHoldeer extends RecyclerView.ViewHolder{
       TextView textView;
       ImageView imageView;
        public ViewHoldeer(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.frg_home_list_txv);
            imageView = (ImageView) itemView.findViewById(R.id.frg_home_list_img);
        }
    }
}
