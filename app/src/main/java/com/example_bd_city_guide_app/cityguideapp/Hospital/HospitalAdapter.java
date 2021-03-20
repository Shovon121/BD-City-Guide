package com.example_bd_city_guide_app.cityguideapp.Hospital;

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

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.ViewHolder> {
    Context context;
    ArrayList<Hospital> hospitals;

    public HospitalAdapter(Context context, ArrayList<Hospital> hospitals) {
        this.context = context;
        this.hospitals = hospitals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.hospital_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Hospital hospital = hospitals.get(position);
        holder.hospital_image.setImageResource(hospital.getImage());
        holder.hospital_text.setText(hospital.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DescriptionActivity.class);
                String hospitalName = hospital.getName();
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





                else if (hospitalName.equals("Islami Bank Hospital(Barishal)")) {
                    intent.putExtra("msg", "ibhb");
                    context.startActivity(intent);
                } else if (hospitalName.equals("Grameen GC Eye Hospital, Barishal")) {
                    intent.putExtra("msg", "ggehb");
                    context.startActivity(intent);
                } else if (hospitalName.equals("Khulna Shishu Hospital")) {
                    intent.putExtra("msg", "ksh");
                    context.startActivity(intent);
                } else if (hospitalName.equals("Khulna General Hospital")) {
                    intent.putExtra("msg", "kgh");
                    context.startActivity(intent);
                } else if (hospitalName.equals("Chittagong General Hospital")) {
                    intent.putExtra("msg", "cgh");
                    context.startActivity(intent);
                } else if (hospitalName.equals("Rangpur Popular Hospital")) {
                    intent.putExtra("msg", "rgh");
                    context.startActivity(intent);
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return hospitals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hospital_image;
        TextView hospital_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hospital_image = itemView.findViewById(R.id.hospital_image);
            hospital_text = itemView.findViewById(R.id.hospital_text);

        }
    }
}
