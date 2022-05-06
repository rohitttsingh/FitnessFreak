package com.example.fitnessfreak;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.squareup.picasso.Picasso;

import java.util.List;

public class HorizontalImageAdapter extends RecyclerView.Adapter<HorizontalImageAdapter.HorizontalImageAdapterViewHolder> {

    private List<HorizontalImage> horizontalImages;

    public HorizontalImageAdapter(List<HorizontalImage> horizontalImages,ViewPager2 viewPager2) {
        this.horizontalImages = horizontalImages;
        this.viewPager2 = viewPager2;

    }
    public ViewPager2 viewPager2;



    @NonNull
        @Override
        public HorizontalImageAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new HorizontalImageAdapterViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_container_location,
                            parent,
                            false
                    )
            );
        }


@Override
public void onBindViewHolder(@NonNull HorizontalImageAdapterViewHolder holder, int position) {

        holder.setLocationData(horizontalImages.get(position));
        }

@Override
public int getItemCount() {
        return horizontalImages.size();
        }

static class HorizontalImageAdapterViewHolder extends RecyclerView.ViewHolder{
    private ImageView imageView;
    private TextView textTitle,textlocation;

    public HorizontalImageAdapterViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.kbvlocation);
        textTitle=itemView.findViewById(R.id.textTitle);
        textlocation=itemView.findViewById(R.id.textLocation);
    }
    void setLocationData(HorizontalImage horizontalImage){
        Picasso.get().load(horizontalImage.imageurl).into(imageView);
        textTitle.setText(horizontalImage.title);
        textlocation.setText(horizontalImage.description);
    }
}


}
