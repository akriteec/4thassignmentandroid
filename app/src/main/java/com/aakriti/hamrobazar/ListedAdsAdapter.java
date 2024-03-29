package com.aakriti.hamrobazar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aakriti.hamrobazar.model.ListedAds;
import com.aakriti.hamrobazar.url.URL;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListedAdsAdapter extends RecyclerView.Adapter<ListedAdsAdapter.ListedAdsViewHolder> {

    CircleImageView imageAd;
    Context mContext;
    List<ListedAds> listedAdsList;
    public ListedAdsAdapter(Context mContext,List<ListedAds> listedAdsList){
        this.mContext=mContext;
        this.listedAdsList=listedAdsList;
    }
    @NonNull
    @Override
    public ListedAdsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_listed_ads_adapter,parent,false);
        return new ListedAdsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListedAdsViewHolder holder, int position) {

        ListedAds listedAds=listedAdsList.get(position);
        holder.tvProductType.setText(listedAds.getProducttype());
        holder.tvAdName.setText(listedAds.getAdName());
        holder.tvAdPrice.setText(listedAds.getAdprice());


        String image=listedAds.getImage();
        String imgPath = URL.imagePath + image;
        Picasso.get().load(imgPath).into(holder.imageAd);
    }

    @Override
    public int getItemCount() {
        return listedAdsList.size();
    }

    public class ListedAdsViewHolder extends RecyclerView.ViewHolder{
        ImageView imageAd;
        TextView tvAdName,tvAdPrice,tvProductType;

        public ListedAdsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageAd=itemView.findViewById(R.id.imageAd);
            tvAdName=itemView.findViewById(R.id.tvAdName);
            tvAdPrice=itemView.findViewById(R.id.tvAdPrice);
            tvProductType=itemView.findViewById(R.id.tvProductType);
        }
    }
}
