package com.example_bd_city_guide_app.cityguideapp.Education;

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

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.ViewHolder> {

    Context context;
    ArrayList<Education> educationArrayList;

    public EducationAdapter(Context context, ArrayList<Education> educationArrayList) {
        this.context = context;
        this.educationArrayList = educationArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.education_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Education education = educationArrayList.get(position);
        holder.education_image.setImageResource(education.getImage());
        holder.education_text.setText("");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int image = education.getImage();
                Intent intent = new Intent(context, DescriptionActivity.class);

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
                else if (R.drawable.swmc == image) {
                    intent.putExtra("msg", "swmc");
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

                }  else if (R.drawable.bsc == image) {
                    intent.putExtra("msg", "bsc");
                    context.startActivity(intent);

                }else if (R.drawable.awc == image) {
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

    }

    @Override
    public int getItemCount() {
        return educationArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView education_image;
        TextView education_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            education_image = itemView.findViewById(R.id.educations_image);
            education_text = itemView.findViewById(R.id.educations_text);
        }
    }
}
