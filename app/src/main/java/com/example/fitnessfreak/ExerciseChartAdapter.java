package com.example.fitnessfreak;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ExerciseChartAdapter extends RecyclerView.Adapter<ExerciseChartAdapter.ExerciseSliderViewHolder> {

    public ExerciseChartAdapter(List<ExerciseChartitems> exerciseChartitems, ViewPager2 viewPager2) {
        this.exerciseChartitems = exerciseChartitems;
        this.viewPager2 = viewPager2;
    }
    private List<ExerciseChartitems> exerciseChartitems;
    public ViewPager2 viewPager2;

    @NonNull
    @Override
    public ExerciseChartAdapter.ExerciseSliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExerciseChartAdapter.ExerciseSliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.slide_exercise_chart,
                parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseSliderViewHolder holder, int position) {
        holder.setImageView(exerciseChartitems.get(position));
    }

    @Override
    public int getItemCount() {
        return exerciseChartitems.size();
    }

    class ExerciseSliderViewHolder extends RecyclerView.ViewHolder{

        private RoundedImageView imageView;

        public ExerciseSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageSlide);
        }
        void setImageView(ExerciseChartitems exerciseChartitems){
            Picasso.get().load(exerciseChartitems.imageurl).into(imageView);

        }
    }

}
