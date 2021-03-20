package com.example_bd_city_guide_app.cityguideapp.HelperClasses.CategoriesAdapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example_bd_city_guide_app.cityguideapp.Education.CollageAndUnivarsityActivity;
import com.example_bd_city_guide_app.cityguideapp.Home.HomeActivity;
import com.example_bd_city_guide_app.cityguideapp.Hospital.HospitalActivity;
import com.example_bd_city_guide_app.cityguideapp.Place.MyMapsActivity;
import com.example_bd_city_guide_app.cityguideapp.R;
import com.example_bd_city_guide_app.cityguideapp.Shop.ShopsActivity;
import com.example_bd_city_guide_app.cityguideapp.Traveling.TravelingActivity;
import com.example_bd_city_guide_app.cityguideapp.Weather.WeatherActivity;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.AdapterAllCategoriesViewHolder> {

    ArrayList<CategoriesHelperClass> mostViewedLocations;
    Context context;
    Intent  intent;
    public CategoriesAdapter(ArrayList<CategoriesHelperClass> mostViewedLocations, Context context) {
        this.mostViewedLocations = mostViewedLocations;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterAllCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        AdapterAllCategoriesViewHolder lvh = new AdapterAllCategoriesViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAllCategoriesViewHolder holder, int position) {

        CategoriesHelperClass helperClass = mostViewedLocations.get(position);
        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.getTitle());
        holder.relativeLayout.setBackground(helperClass.getGradient());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String title = helperClass.getTitle();
                if (title.equals("Education")) {

                    intent = new Intent(context, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("msg","varsity");
                    context.startActivity(intent);
                } else if (title.equals("HOSPITAL")) {

                    intent = new Intent(context, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("msg","hospital");
                    context.startActivity(intent);
                } else if (title.equals("Shopping")) {

                    intent = new Intent(context, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("msg","shop");
                    context.startActivity(intent);
                } else if (title.equals("Transport")) {

                    intent = new Intent(context, TravelingActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                } else if (title.equals("Restaurant")) {
                    intent = new Intent(context, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("msg","restaurent");
                    context.startActivity(intent);
                } else if (title.equals("Weather")) {

                    Intent weatherIntent = new Intent(context, WeatherActivity.class);
                    weatherIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(weatherIntent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public static class AdapterAllCategoriesViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;

        public AdapterAllCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            relativeLayout = itemView.findViewById(R.id.background_gradient);
            imageView = itemView.findViewById(R.id.categories_image);
            textView = itemView.findViewById(R.id.categories_title);
        }
    }
}