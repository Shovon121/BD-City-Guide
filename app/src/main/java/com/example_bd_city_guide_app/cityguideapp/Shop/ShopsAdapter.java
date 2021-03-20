package com.example_bd_city_guide_app.cityguideapp.Shop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example_bd_city_guide_app.cityguideapp.Description.DescriptionActivity;
import com.example_bd_city_guide_app.cityguideapp.R;

import java.util.ArrayList;

public class ShopsAdapter extends RecyclerView.Adapter<ShopsAdapter.ViewHolder> {
    public ShopsAdapter(Context context, ArrayList<Shops> shops) {
        this.context = context;
        this.shops = shops;
    }

    Context context;
    ArrayList<Shops> shops;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.shop_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Shops shop =  shops.get(position);
        holder.shops_image.setImageResource(shop.getImage());
        holder.shops_text.setText(shop.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DescriptionActivity.class);

                String shopName = shop.getName();

                if (shopName.equals("Bashundhara City Shopping Complex")) {
                    intent.putExtra("msg", "bashundara");
                    context.startActivity(intent);
                } else if (shopName.equals("Jamuna Future Park")) {
                    intent.putExtra("msg", "jamuna");
                    context.startActivity(intent);
                } else if (shopName.equals("New Market")) {
                    intent.putExtra("msg", "newmarket");
                    context.startActivity(intent);
                } else if (shopName.equals("Police Plaza Concord")) {
                    intent.putExtra("msg", "policeplazza");
                    context.startActivity(intent);
                } else if (shopName.equals("Metro Shopping Mall")) {
                    intent.putExtra("msg", "metro");
                    context.startActivity(intent);
                } else if (shopName.equals("Rapa Plaza")) {
                    intent.putExtra("msg", "rapaplaza");
                    context.startActivity(intent);
                } else if (shopName.equals("Eastern Plaza")) {
                    intent.putExtra("msg", "easternplaza");
                    context.startActivity(intent);
                } else if (shopName.equals("Shimanto Square")) {
                    intent.putExtra("msg", "simanto");
                    context.startActivity(intent);
                } else if (shopName.equals("Pink City")) {
                    intent.putExtra("msg", "pinkcity");
                    context.startActivity(intent);
                } else if (shopName.equals("Mascot Plaza")) {
                    intent.putExtra("msg", "mascot");
                    context.startActivity(intent);

                } else if (shopName.equals("Sylhet City Centre")) {
                    intent.putExtra("msg", "Sylhet City Centre");
                    context.startActivity(intent);

                } else if (shopName.equals("Uposhohar Plaza")) {
                    intent.putExtra("msg", "Uposhohar Plaza");
                    context.startActivity(intent);

                }  else if (shopName.equals("Firoz Centre")) {
                    intent.putExtra("msg", "Firoz Centre");
                    context.startActivity(intent);

                } else if (shopName.equals("Shukria Market")) {
                    intent.putExtra("msg", "Shukria Market");
                    context.startActivity(intent);

                } else if (shopName.equals("Elegant Shopping Mall")) {
                    intent.putExtra("msg", "Elegant Shopping Mall");
                    context.startActivity(intent);

                } else if (shopName.equals("Myth, Sylhet")) {
                    intent.putExtra("msg", "Myth, Sylhet");
                    context.startActivity(intent);

                } else if (shopName.equals("Arcadia")) {
                    intent.putExtra("msg", "Arcadia");
                    context.startActivity(intent);

                } else if (shopName.equals("Kazi Mansion")) {
                    intent.putExtra("msg", "Kazi Mansion");
                    context.startActivity(intent);

                } else if (shopName.equals("RAMC COMPLEX RANGPUR")) {
                    intent.putExtra("msg", "RAMC COMPLEX RANGPUR");
                    context.startActivity(intent);

                } else if (shopName.equals("RAMC Shopping Complex")) {
                    intent.putExtra("msg", "RAMC Shopping Complex");
                    context.startActivity(intent);

                } else if (shopName.equals("Zilla Parishad Super Market")) {
                    intent.putExtra("msg", "Zilla Parishad Super Market");
                    context.startActivity(intent);

                } else if (shopName.equals("Golden Tower Shopping Complex")) {
                    intent.putExtra("msg", "Golden Tower Shopping Complex");
                    context.startActivity(intent);

                } else if (shopName.equals("Rangpur Zila Muktijoddha Complex Bhavan")) {
                    intent.putExtra("msg", "Rangpur Zila Muktijoddha Complex Bhavan");
                    context.startActivity(intent);

                } else if (shopName.equals("Saat Matha Jamee Mosque Complex")) {
                    intent.putExtra("msg", "Saat Matha Jamee Mosque Complex");
                    context.startActivity(intent);

                } else if (shopName.equals("Royalty Mega Mall")) {
                    intent.putExtra("msg", "Royalty Mega Mall");
                    context.startActivity(intent);

                } else if (shopName.equals("Lalbag Plaza")) {
                    intent.putExtra("msg", "Lalbag Plaza");
                    context.startActivity(intent);

                } else if (shopName.equals("Chittagong Shopping Complex")) {
                    intent.putExtra("msg", "Chittagong Shopping Complex");
                    context.startActivity(intent);

                } else if (shopName.equals("Afmi Plaza")) {
                    intent.putExtra("msg", "Afmi Plaza");
                    context.startActivity(intent);

                } else if (shopName.equals("Sanmar Ocean City")) {
                    intent.putExtra("msg", "Sanmar Ocean City");
                    context.startActivity(intent);

                } else if (shopName.equals("Mimi Super Market")) {
                    intent.putExtra("msg", "Mimi Super Market");
                    context.startActivity(intent);

                } else if (shopName.equals("Yunusco City Centre")) {
                    intent.putExtra("msg", "Yunusco City Centre");
                    context.startActivity(intent);

                } else if (shopName.equals("Ameen Center")) {
                    intent.putExtra("msg", "Ameen Center");
                    context.startActivity(intent);

                } else if (shopName.equals("Akhtaruzzaman Center")) {
                    intent.putExtra("msg", "Akhtaruzzaman Center");
                    context.startActivity(intent);

                } else if (shopName.equals("CONCORD KHULSHI TOWN CENTER")) {
                    intent.putExtra("msg", "CONCORD KHULSHI TOWN CENTER");
                    context.startActivity(intent);

                } else if (shopName.equals("এ্যারাবিয়ান (Khulna Shopping Complex)")) {
                    intent.putExtra("msg", "এ্যারাবিয়ান (Khulna Shopping Complex)");
                    context.startActivity(intent);

                } else if (shopName.equals("Blue Star Shopping Mall Khulna")) {
                    intent.putExtra("msg", "Blue Star Shopping Mall Khulna");
                    context.startActivity(intent);

                } else if (shopName.equals("Jalil Tower Shopping Complex")) {
                    intent.putExtra("msg", "Jalil Tower Shopping Complex");
                    context.startActivity(intent);

                } else if (shopName.equals("6 Plus Shopping Center")) {
                    intent.putExtra("msg", "6 Plus Shopping Center");
                    context.startActivity(intent);

                } else if (shopName.equals("Khulna jori house")) {
                    intent.putExtra("msg", "Khulna jori house");
                    context.startActivity(intent);

                } else if (shopName.equals("Khulna Shopping Center")) {
                    intent.putExtra("msg", "Khulna Shopping Center");
                    context.startActivity(intent);

                } else if (shopName.equals("Khulna Trimmer House")) {
                    intent.putExtra("msg", "Khulna Trimmer House");
                    context.startActivity(intent);

                } else if (shopName.equals("Khulna Multi Shopping Mall")) {
                    intent.putExtra("msg", "Khulna Multi Shopping Mall");
                    context.startActivity(intent);

                } else if (shopName.equals("Chowdhury Market")) {
                    intent.putExtra("msg", "Chowdhury Market");
                    context.startActivity(intent);

                } else if (shopName.equals("Fatema Center")) {
                    intent.putExtra("msg", "Fatema Center");
                    context.startActivity(intent);

                } else if (shopName.equals("Walton Plaza")) {
                    intent.putExtra("msg", "Walton Plaza");
                    context.startActivity(intent);

                } else if (shopName.equals("LOTTO Showroom")) {
                    intent.putExtra("msg", "LOTTO Showroom");
                    context.startActivity(intent);

                } else if (shopName.equals("Janani Store")) {
                    intent.putExtra("msg", "Janani Store");
                    context.startActivity(intent);

                } else if (shopName.equals("Easy Fashion Ltd")) {
                    intent.putExtra("msg", "Easy Fashion Ltd");
                    context.startActivity(intent);

                } else if (shopName.equals("Jonaki Shopping Complex")) {
                    intent.putExtra("msg", "Jonaki Shopping Complex");
                    context.startActivity(intent);

                } else if (shopName.equals("Nusrat Shopping Complex")) {
                    intent.putExtra("msg", "Nusrat Shopping Complex");
                    context.startActivity(intent);

                } else if (shopName.equals("Theme Omor Plaza")) {
                    intent.putExtra("msg", "Theme Omor Plaza");
                    context.startActivity(intent);

                } else if (shopName.equals("Rajshahi Engineering Complex রাজশাহী ইঞ্জিনিয়ারিং কমপ্লেক্স")) {
                    intent.putExtra("msg", "Rajshahi Engineering Complex রাজশাহী ইঞ্জিনিয়ারিং কমপ্লেক্স");
                    context.startActivity(intent);

                } else if (shopName.equals("Best Online Shopping Store in Rajshahi")) {
                    intent.putExtra("msg", "Best Online Shopping Store in Rajshahi");
                    context.startActivity(intent);

                } else if (shopName.equals("Rajshahi City Center")) {
                    intent.putExtra("msg", "Rajshahi City Center");
                    context.startActivity(intent);

                } else if (shopName.equals("Horogram New Market")) {
                    intent.putExtra("msg", "Horogram New Market");
                    context.startActivity(intent);

                } else if (shopName.equals("Momtaz Shopping Center")) {
                    intent.putExtra("msg", "Momtaz Shopping Center");
                    context.startActivity(intent);

                } else if (shopName.equals("Realme authorized Brand Shop (Main),Rajshahi")) {
                    intent.putExtra("msg", "Realme authorized Brand Shop (Main),Rajshahi");
                    context.startActivity(intent);

                } else if (shopName.equals("Bata showroom")) {
                    intent.putExtra("msg", "Bata showroom");
                    context.startActivity(intent);

                } else if (shopName.equals("পালিকা শপিং সেণ্টার")) {
                    intent.putExtra("msg", "পালিকা শপিং সেণ্টার");
                    context.startActivity(intent);

                } else if (shopName.equals("Noorjahan Complex")) {
                    intent.putExtra("msg", "Noorjahan Complex");
                    context.startActivity(intent);

                } else if (shopName.equals("Doel Shopping Complex Ltd")) {
                    intent.putExtra("msg", "Doel Shopping Complex Ltd");
                    context.startActivity(intent);

                } else if (shopName.equals("Bari Plaza")) {
                    intent.putExtra("msg", "Bari Plaza");
                    context.startActivity(intent);

                } else if (shopName.equals("Shuchona Shopping Complex")) {
                    intent.putExtra("msg", "Shuchona Shopping Complex");
                    context.startActivity(intent);

                } else if (shopName.equals("Imperial Super Market")) {
                    intent.putExtra("msg", "Imperial Super Market");
                    context.startActivity(intent);

                }


            }
        });




    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView shops_image;
        TextView shops_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            shops_image = itemView.findViewById(R.id.shops_image);
            shops_text = itemView.findViewById(R.id.shops_text);


        }
    }
}
