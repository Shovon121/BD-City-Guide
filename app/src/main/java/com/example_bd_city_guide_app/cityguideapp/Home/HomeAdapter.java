package com.example_bd_city_guide_app.cityguideapp.Home;

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
import com.example_bd_city_guide_app.cityguideapp.Education.Education;
import com.example_bd_city_guide_app.cityguideapp.Hospital.Hospital;
import com.example_bd_city_guide_app.cityguideapp.R;
import com.example_bd_city_guide_app.cityguideapp.Restaurent.Restaurent;
import com.example_bd_city_guide_app.cityguideapp.Shop.Shops;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Object> objectArrayList;
    private String msg;
    private final int HOSPITAL_TYPE = 1;
    private final int EDUCATIONS_TYPE = 2;
    private final int RESTAURENT_TYPE = 3;
    private final int SHOP_TYPE = 4;

    Intent intent;

    public HomeAdapter(Context context, ArrayList<Object> objectArrayList, String msg) {
        this.context = context;
        this.objectArrayList = objectArrayList;
        this.msg = msg;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        intent = new Intent(context, DescriptionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        switch (holder.getItemViewType()) {
            case HOSPITAL_TYPE:

                Hospital hospital = (Hospital) objectArrayList.get(position);
                holder.home_image.setImageResource(hospital.getImage());
                holder.home_text.setText(hospital.getName());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String hospitalName = hospital.getName();
                        intent = new Intent(context, DescriptionActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        if (hospitalName == null) {
                            Toast.makeText(context, "No Hospital name found!", Toast.LENGTH_SHORT).show();
                        } else if (hospitalName.equals("Apollo Hospitals Dhaka")) {
                            intent.putExtra("msg", "ah");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Square Hospitals Ltd")) {
                            intent.putExtra("msg", "sh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("LABAID Specialized Hospital")) {
                            intent.putExtra("msg", "lh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("ইবনে সিনা স্পেশালাইজড হাসপাতাল")) {
                            intent.putExtra("msg", "ish");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Popular hospital")) {
                            intent.putExtra("msg", "ph");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("BIRDEM General Hospital")) {
                            intent.putExtra("msg", "bh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Bangabandhu Sheikh Mujib Medical University Hospital")) {
                            intent.putExtra("msg", "bsmmuh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Bangladesh Eye Hospital")) {
                            intent.putExtra("msg", "beh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Dhaka Medical College")) {
                            intent.putExtra("msg", "dmc");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Mymensingh Medical College")) {
                            intent.putExtra("msg", "mmc");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Mymensingh  Government  Hospital & Medical College")) {
                            intent.putExtra("msg", "mghmc");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Popular Diagnostic Centre Ltd. Mymensingh")) {
                            intent.putExtra("msg", "pdcm");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Mymensingh BNSB Eye Hospital")) {
                            intent.putExtra("msg", "mbeh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Police Government  Hospital")) {
                            intent.putExtra("msg", "mpgh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Rajshahi Model Hospital")) {
                            intent.putExtra("msg", "rdh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Rajshahi Medical College")) {
                            intent.putExtra("msg", "rmc");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Rajshahi Royal Hospital")) {
                            intent.putExtra("msg", "rrh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Islami bank hospital")) {
                            intent.putExtra("msg", "ibh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Rajshahi Metropolitan Hospital Ltd.")) {
                            intent.putExtra("msg", "rmh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Ambia Memorial Hospital")) {
                            intent.putExtra("msg", "amh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Sher-E-Bangla Medical College Hospital")) {
                            intent.putExtra("msg", "smch");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Grameen GC Eye Hospital")) {
                            intent.putExtra("msg", "ggeh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("South Bangla Appolo Hospital Main Building")) {
                            intent.putExtra("msg", "sbah");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Khulna Sadar Hospital")) {
                            intent.putExtra("msg", "ksh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Khulna Medical College")) {
                            intent.putExtra("msg", "kmc");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Khulna BNSB Eye Hospital")) {
                            intent.putExtra("msg", "kbeh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Khulna General Hospital")) {
                            intent.putExtra("msg", "kgh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Holly Health Hospital Pvt. Ltd")) {
                            intent.putExtra("msg", "hhh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Royal Hospital (Pvt.) Limited")) {
                            intent.putExtra("msg", "rh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Chattogram Maa-O-Shishu Hospital")) {
                            intent.putExtra("msg", "cmh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Red Crescent Maternity Hospital")) {
                            intent.putExtra("msg", "rcmh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Rangpur Medical College")) {
                            intent.putExtra("msg", "rrmc");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Bangladesh Hospital Rangpur")) {
                            intent.putExtra("msg", "bhr");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Rangpur General Hospital")) {
                            intent.putExtra("msg", "rgh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Rangpur central Hospital")) {
                            intent.putExtra("msg", "rch");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Ibn Sina Hospital Sylhet Ltd")) {
                            intent.putExtra("msg", "ishs");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Al Haramain Hospital Private Limited")) {
                            intent.putExtra("msg", "ahh");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Emergency Department, Sylhet M A G Osmani Medical")) {
                            intent.putExtra("msg", "eds");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Sylhet MAG Osmani Medical College")) {
                            intent.putExtra("msg", "smo");
                            context.startActivity(intent);
                        } else if (hospitalName.equals("Oasis Hospital")) {
                            intent.putExtra("msg", "oh");
                            context.startActivity(intent);
                        }
                    }
                });

                break;
            case RESTAURENT_TYPE:
                Restaurent restaurent = (Restaurent) objectArrayList.get(position);
                holder.home_image.setImageResource(restaurent.getImage());
                holder.home_text.setText(restaurent.getName());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String restaurentName = restaurent.getName();
                        int image = restaurent.getImage();
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

                        }else if (restaurentName.equals("Sarinda Restaurant")) {

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
                break;
            case EDUCATIONS_TYPE:
                Education education = (Education) objectArrayList.get(position);
                holder.home_image.setImageResource(education.getImage());
                holder.home_text.setText(education.getName());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int image = education.getImage();


                        if (R.drawable.buet == image) {
                            intent.putExtra("msg", "buet");
                            context.startActivity(intent);
                        } else if (R.drawable.dhakauniversity == image) {
                            intent.putExtra("msg", "du");
                            context.startActivity(intent);
                        } else if (R.drawable.jahangirnagar == image) {
                            intent.putExtra("msg", "ju");
                            context.startActivity(intent);
                        } else if (R.drawable.northsout == image) {
                            intent.putExtra("msg", "nsu");
                            context.startActivity(intent);
                        } else if (R.drawable.bau == image) {
                            intent.putExtra("msg", "bau");
                            context.startActivity(intent);
                        } else if (R.drawable.ru == image) {
                            intent.putExtra("msg", "ru");
                            context.startActivity(intent);
                        } else if (R.drawable.kuet == image) {
                            intent.putExtra("msg", "kuet");
                            context.startActivity(intent);
                        } else if (R.drawable.iu == image) {
                            intent.putExtra("msg", "iu");
                            context.startActivity(intent);
                        } else if (R.drawable.cuet == image) {
                            intent.putExtra("msg", "cuet");
                            context.startActivity(intent);
                        } else if (R.drawable.brac == image) {
                            intent.putExtra("msg", "brac");
                            context.startActivity(intent);

                        }

                        else if (R.drawable.sust == image) {
                            intent.putExtra("msg", "sust");
                            context.startActivity(intent);

                        }


                        else if (R.drawable.sau == image) {
                            intent.putExtra("msg", "sau");
                            context.startActivity(intent);

                        } else if (R.drawable.smomc == image) {
                            intent.putExtra("msg", "smomc");
                            context.startActivity(intent);

                        } else if (R.drawable.mc == image) {
                            intent.putExtra("msg", "mc");
                            context.startActivity(intent);

                        } else if (R.drawable.rmc == image) {
                            intent.putExtra("msg", "rmc");
                            context.startActivity(intent);

                        } else if (R.drawable.cc == image) {
                            intent.putExtra("msg", "cc");
                            context.startActivity(intent);

                        } else if (R.drawable.rgc == image) {
                            intent.putExtra("msg", "rgc");
                            context.startActivity(intent);

                        } else if (R.drawable.bru == image) {
                            intent.putExtra("msg", "bru");
                            context.startActivity(intent);

                        } else if (R.drawable.gcc == image) {
                            intent.putExtra("msg", "gcc");
                            context.startActivity(intent);

                        } else if (R.drawable.cu == image) {
                            intent.putExtra("msg", "cu");
                            context.startActivity(intent);

                        } else if (R.drawable.cmc == image) {
                            intent.putExtra("msg", "cmc");
                            context.startActivity(intent);

                        } else if (R.drawable.awc == image) {
                            intent.putExtra("msg", "awc");
                            context.startActivity(intent);

                        } else if (R.drawable.ku == image) {
                            intent.putExtra("msg", "ku");
                            context.startActivity(intent);

                        } else if (R.drawable.kmc == image) {
                            intent.putExtra("msg", "kmc");
                            context.startActivity(intent);

                        } else if (R.drawable.kpi == image) {
                            intent.putExtra("msg", "kpi");
                            context.startActivity(intent);

                        } else if (R.drawable.kwc == image) {
                            intent.putExtra("msg", "kwc");
                            context.startActivity(intent);

                        } else if (R.drawable.bm == image) {
                            intent.putExtra("msg", "bm");
                            context.startActivity(intent);

                        } else if (R.drawable.gc == image) {
                            intent.putExtra("msg", "gc");
                            context.startActivity(intent);

                        } else if (R.drawable.smc == image) {
                            intent.putExtra("msg", "smc");
                            context.startActivity(intent);

                        } else if (R.drawable.bpi == image) {
                            intent.putExtra("msg", "bpi");
                            context.startActivity(intent);

                        } else if (R.drawable.bwc == image) {
                            intent.putExtra("msg", "bwc");
                            context.startActivity(intent);

                        } else if (R.drawable.rmc == image) {
                            intent.putExtra("msg", "rmc");
                            context.startActivity(intent);

                        } else if (R.drawable.ruet == image) {
                            intent.putExtra("msg", "ruet");
                            context.startActivity(intent);

                        } else if (R.drawable.rwc == image) {
                            intent.putExtra("msg", "rwc");
                            context.startActivity(intent);

                        } else if (R.drawable.rpi == image) {
                            intent.putExtra("msg", "rpi");
                            context.startActivity(intent);

                        } else if (R.drawable.amc == image) {
                            intent.putExtra("msg", "amc");
                            context.startActivity(intent);

                        } else if (R.drawable.mmc == image) {
                            intent.putExtra("msg", "mmc");
                            context.startActivity(intent);

                        } else if (R.drawable.mwc == image) {
                            intent.putExtra("msg", "mwc");
                            context.startActivity(intent);

                        } else if (R.drawable.knu == image) {
                            intent.putExtra("msg", "knu");
                            context.startActivity(intent);

                        }

                    }
                });


                break;
            case SHOP_TYPE:
                Shops shop = (Shops) objectArrayList.get(position);
                holder.home_image.setImageResource(shop.getImage());
                holder.home_text.setText(shop.getName());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
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

                        } else if (shopName.equals("Firoz Centre")) {
                            intent.putExtra("msg", "");
                            context.startActivity(intent);

                        } else if (shopName.equals("Firoz Centre")) {
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


                break;
        }


    }

    @Override
    public int getItemCount() {
        return objectArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView home_image;
        TextView home_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            home_image = itemView.findViewById(R.id.home_image);
            home_text = itemView.findViewById(R.id.home_text);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (objectArrayList.get(position) instanceof Restaurent) {
            return RESTAURENT_TYPE;
        } else if (objectArrayList.get(position) instanceof Education) {
            return EDUCATIONS_TYPE;
        } else if (objectArrayList.get(position) instanceof Hospital) {
            return HOSPITAL_TYPE;
        } else if (objectArrayList.get(position) instanceof Shops) {
            return SHOP_TYPE;
        }


        return -1;
    }
}
