package com.example_bd_city_guide_app.cityguideapp.Restaurent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example_bd_city_guide_app.cityguideapp.Description.DescriptionActivity;
import com.example_bd_city_guide_app.cityguideapp.R;

import java.util.ArrayList;

public class RestaurentAdapter extends RecyclerView.Adapter<RestaurentAdapter.ViewHolder> {

    Context context;
    ArrayList<Restaurent> restaurents;

    public RestaurentAdapter(Context context, ArrayList<Restaurent> restaurents) {
        this.context = context;
        this.restaurents = restaurents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.restaurent_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Restaurent restaurent = restaurents.get(position);
        holder.restaurent_image.setImageResource(restaurent.getImage());
        holder.restaurent_text.setText(restaurent.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int image = restaurent.getImage();
                Intent intent = new Intent(context, DescriptionActivity.class);

                String restaurentName = restaurent.getName();

                if (restaurentName == null) {
                    Toast.makeText(context, "No Restaurent name found!", Toast.LENGTH_SHORT).show();
                } else if (restaurentName.equals("Baton Rouge")) {
                    intent.putExtra("msg", "baton");
                    context.startActivity(intent);
                } else if (restaurentName.equals("The Atrium Restauran")) {
                    intent.putExtra("msg", "atrium");
                    context.startActivity(intent);
                } else if (restaurentName.equals("Mainland China")) {
                    intent.putExtra("msg", "mainland");
                    context.startActivity(intent);
                } else if (restaurentName.equals("Spice And Rice")) {
                    intent.putExtra("msg", "spice");
                    context.startActivity(intent);
                } else if (restaurentName.equals("Bar-B-Q Tonight")) {
                    intent.putExtra("msg", "bar_B_Q");
                    context.startActivity(intent);
                } else if (restaurentName.equals("Picasso Restaurant")) {
                    intent.putExtra("msg", "picasso restaurent");
                    context.startActivity(intent);
                } else if (restaurentName.equals("Lake Terrace")) {
                    intent.putExtra("msg", "lake restaurent");
                    context.startActivity(intent);
                } else if (restaurentName.equals("Pan Tao")) {
                    intent.putExtra("msg", "pantau restaurent");
                    context.startActivity(intent);
                } else if (restaurentName.equals("Panshi Restaurant")) {

                    intent.putExtra("msg", "pr");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Woondaal King Kebab")) {

                    intent.putExtra("msg", "wkk");
                    context.startActivity(intent);

                } else if (restaurentName.equals("The Mad Grill")) {

                    intent.putExtra("msg", "tmg");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Eatopia")) {

                    intent.putExtra("msg", "eatopia");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Platinum Lounge")) {

                    intent.putExtra("msg", "pl");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Pach Bhai Restaurant")) {

                    intent.putExtra("msg", "pbr");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Curry Royal")) {

                    intent.putExtra("msg", "cr");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Hideout Cafe")) {

                    intent.putExtra("msg", "hc");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Cicily Thai Chinese Restaurant")) {

                    intent.putExtra("msg", "ctcr");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Twist & Taste")) {

                    intent.putExtra("msg", "tt");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Mouban Resturentt")) {

                    intent.putExtra("msg", "mr");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Colino")) {

                    intent.putExtra("msg", "colino");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Master Chef Bangla Restaurant")) {

                    intent.putExtra("msg", "mcbr");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Wow Food's")) {

                    intent.putExtra("msg", "wf");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Hotel Star International")) {

                    intent.putExtra("msg", "hti");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Caspia The Home")) {

                    intent.putExtra("msg", "cth");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Ambrosia")) {

                    intent.putExtra("msg", "ambrosia");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Handi Restaurant")) {

                    intent.putExtra("msg", "hr");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Pizza Hut")) {

                    intent.putExtra("msg", "pizza hut");
                    context.startActivity(intent);

                } else if (restaurentName.equals("The Arrosto")) {

                    intent.putExtra("msg", "arrosto");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Mezetto")) {

                    intent.putExtra("msg", "mezetto");
                    context.startActivity(intent);

                } else if (restaurentName.equals("The River View Restaurant")) {

                    intent.putExtra("msg", "river view restaurant");
                    context.startActivity(intent);

                } else if (restaurentName.equals("The Pavilion")) {

                    intent.putExtra("msg", "pavilion");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Citylight Cafe & Restaurant")) {

                    intent.putExtra("msg", "citylight cafe Rrstaurant");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Castle Salam")) {

                    intent.putExtra("msg", "castle calam");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Deshi Kitchen")) {

                    intent.putExtra("msg", "keshi kitchen");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Shawarma House")) {

                    intent.putExtra("msg", "shawarma house");
                    context.startActivity(intent);

                } else if (restaurentName.equals("New Azmiri Grill & Bar-B-Q")) {

                    intent.putExtra("msg", "new azmiri");
                    context.startActivity(intent);

                } else if (restaurentName.equals("We Hungry")) {

                    intent.putExtra("msg", "we hungry");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Safe'n'Save")) {

                    intent.putExtra("msg", "safe");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Aloka Restaurant")) {

                    intent.putExtra("msg", "aloka restaurant");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Zafran restaurant Barishal")) {

                    intent.putExtra("msg", "zafran");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Tawa")) {

                    intent.putExtra("msg", "tawa");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Handi Karai")) {

                    intent.putExtra("msg", "kandi karai");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Singara Point")) {

                    intent.putExtra("msg", "Singara Point");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Garden Inn Restaurant")) {

                    intent.putExtra("msg", "Garden Inn Restaurant");
                    context.startActivity(intent);

                } else if (restaurentName.equals("The river cafe")) {

                    intent.putExtra("msg", "The river cafe");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Western Food Restaurant")) {

                    intent.putExtra("msg", "Western Food Restaurant");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Amigos Restaurant & Juice Bar")) {

                    intent.putExtra("msg", "Amigos Restaurant & Juice Bar");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Espresso")) {

                    intent.putExtra("msg", "Espresso");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Twist & Taste")) {

                    intent.putExtra("msg", "Twist & Taste");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Chili's Fast Food")) {

                    intent.putExtra("msg", "Chili's Fast Food");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Colino's")) {

                    intent.putExtra("msg", "Colino's");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Master Chef Bangla Restaurant")) {

                    intent.putExtra("msg", "Master Chef Bangla Restaurant");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Aristocrat Coffee Shop and Restaurant")) {

                    intent.putExtra("msg", "Aristocrat Coffee Shop and Restaurant");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Hotel Star International")) {

                    intent.putExtra("msg", "Hotel Star International");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Flavours")) {

                    intent.putExtra("msg", "Flavours");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Chillox Mymensingh")) {

                    intent.putExtra("msg", "Chillox Mymensingh");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Sarinda Restaurant")) {

                    intent.putExtra("msg", "Sarinda Restaurant");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Avanti Restaurant")) {

                    intent.putExtra("msg", "Avanti Restaurant");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Chef Time Restaurant")) {

                    intent.putExtra("msg", "Chef Time Restaurant");
                    context.startActivity(intent);

                } else if (restaurentName.equals("নাওয়াবীয়ানা-The Legacy Remains")) {

                    intent.putExtra("msg", "নাওয়াবীয়ানা-The Legacy Remains");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Saffron Restaurant")) {

                    intent.putExtra("msg", "Saffron Restaurant");
                    context.startActivity(intent);

                } else if (restaurentName.equals("Hunger's Garage")) {

                    intent.putExtra("msg", "Hunger's Garage");
                    context.startActivity(intent);

                } else if (restaurentName.equals("The Food Company")) {

                    intent.putExtra("msg", "The Food Company");
                    context.startActivity(intent);

                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return restaurents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView restaurent_image;
        TextView restaurent_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            restaurent_image = itemView.findViewById(R.id.restaurent_image);
            restaurent_text = itemView.findViewById(R.id.restaurent_text);
        }
    }
}
