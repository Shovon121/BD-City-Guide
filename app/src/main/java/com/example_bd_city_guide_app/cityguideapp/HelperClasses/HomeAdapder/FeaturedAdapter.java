package com.example_bd_city_guide_app.cityguideapp.HelperClasses.HomeAdapder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example_bd_city_guide_app.cityguideapp.Categories.CategoriesActivity;
import com.example_bd_city_guide_app.cityguideapp.Home.HomeActivity;
import com.example_bd_city_guide_app.cityguideapp.Place.MyMapsActivity;
import com.example_bd_city_guide_app.cityguideapp.R;
import com.example_bd_city_guide_app.cityguideapp.Traveling.TravelingActivity;
import com.example_bd_city_guide_app.cityguideapp.UserDeshBoard;
import com.example_bd_city_guide_app.cityguideapp.Weather.WeatherActivity;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    Context context;
    ArrayList<FeaturedHelperClass> featuredLocations;
    Intent  intent;

    public FeaturedAdapter(Context context, ArrayList<FeaturedHelperClass> featuredLocations) {
        this.context = context;
        this.featuredLocations = featuredLocations;
    }


    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_design, parent, false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);

        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.desc.setText(featuredHelperClass.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = featuredHelperClass.getTitle();
                if (title.equals("Airlines")) {
                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.biman-airlines.com/")));
                } else if (title.equals("Train'")) {
                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.esheba.cnsbd.com/#/")));
                } else if (title.equals("Maps'")) {
                    intent = new Intent(context, MyMapsActivity.class);
                    context.startActivity(intent);
                } else if (title.equals("Boat")) {
                    intent = new Intent(context, MyMapsActivity.class);
                    intent.putExtra("tourCategories", "boat");
                    context.startActivity(intent);
                } else if (title.equals("Restaurent")) {
                    intent = new Intent(context, HomeActivity.class);
                    intent.putExtra("msg","restaurent");
                    context.startActivity(intent);
                } else if (title.equals("Weather")) {
                    Intent weatherIntent = new Intent(context, WeatherActivity.class);
                    context.startActivity(weatherIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.featured_desc);

        }
    }
}
