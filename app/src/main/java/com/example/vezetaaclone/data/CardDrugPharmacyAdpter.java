package com.example.vezetaaclone.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vezetaaclone.data.Drugs;
import com.example.vezetaaclone.R;
import com.example.vezetaaclone.pojo.CategoryModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDrugPharmacyAdpter  extends RecyclerView.Adapter
        <CardDrugPharmacyAdpter.DrugViewHolder> {
    private ArrayList<Drugs>drugsList;
    private Context context;
    private Random rand = new Random();
    public CardDrugPharmacyAdpter(ArrayList<Drugs> drugsList, Context context) {
        this.drugsList = drugsList;
        this.context = context;
    }

    @NonNull
    @Override
    public CardDrugPharmacyAdpter.DrugViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_drug_pharmacy
                ,parent,false);
        return new DrugViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardDrugPharmacyAdpter.DrugViewHolder holder, int position) {
        holder.onBind(drugsList.get(position));
    }

    @Override
    public int getItemCount() {
        return drugsList.size();
    }
    public void setlist(ArrayList<Drugs> drugsList){
        this.drugsList=drugsList;
        notifyDataSetChanged();
    }

    public class DrugViewHolder extends RecyclerView.ViewHolder
    {
        Animation  animation,anim;
        private TextView txtNameDrug,txtPriceDrug,txtRateValueDrug;
        private RatingBar ratingBarDrug;
        private ImageView imageViewDrug;
        private Animation togo,fromnothing,fromsmall;
        public DrugViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtNameDrug=itemView.findViewById(R.id.txt_name_drug_pharmacy_recycle);
            animation= AnimationUtils.loadAnimation(context,R.anim.scale);
            txtNameDrug.setAnimation(animation);

            txtPriceDrug=itemView.findViewById(R.id.txt_price_drug_pharmacy_recycle);
            txtRateValueDrug=itemView.findViewById(R.id.txt_rate_value_drug_pharmacy_recycle);
            ratingBarDrug=itemView.findViewById(R.id.rate_bare_drug_pharmacy_recycle);
            imageViewDrug=itemView.findViewById(R.id.image_drug_pharmacy_recycle);
            anim= AnimationUtils.loadAnimation(context,R.anim.rotation);
            imageViewDrug.setAnimation(anim);
        }

        public void onBind(Drugs drug)
        {
            txtNameDrug.setText(drug.getName());
            txtPriceDrug.setText(String.valueOf(drug.getPrice()));
            txtRateValueDrug.setText("("+String.valueOf(drug.getRate())+")");
            Picasso.get().load(drug.getImage()).into(imageViewDrug);
            ratingBarDrug.setRating(drug.getRate());
        }

    }

}
