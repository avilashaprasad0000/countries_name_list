package com.example.countries_name_list;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.scrounger.countrycurrencypicker.library.Buttons.CountryCurrencyButton;
import com.scrounger.countrycurrencypicker.library.Country;
import com.scrounger.countrycurrencypicker.library.CountryCurrencyPicker;
import com.scrounger.countrycurrencypicker.library.Currency;
import com.scrounger.countrycurrencypicker.library.Listener.CountryCurrencyPickerListener;
import com.scrounger.countrycurrencypicker.library.PickerType;

public class countrynameAdapter extends RecyclerView.Adapter<countrynameviewHolder> {

    //List listActivity;
    private List<countrynamemodalclass> eventModels;
    Context context;



        public countrynameAdapter(List<countrynamemodalclass> listActivity, Context context) {
        this.eventModels = listActivity;
        //this.eventModels = eventModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public countrynameviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardlayout, parent, false);

        countrynameviewHolder eviewHolder = new countrynameviewHolder(itemView);
        //This handles item clicks listener

        eviewHolder.setOnClickListener(new countrynameviewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int pos) {

                Intent avi = new Intent(context, NameDisplay.class);
                avi.putExtra("CountryName", eventModels.get(pos).getC_name());
                avi.putExtra("CountryCode", eventModels.get(pos).getC_code());
                avi.putExtra("CountryCapital", eventModels.get(pos).getC_capital());
                Toast.makeText(context, "Working Fine!!!", Toast.LENGTH_SHORT).show();
                context.startActivity(avi);

            }
        });

        return eviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final countrynameviewHolder holder, int position) {




        holder.mName.setText(eventModels.get(position).getC_name());
        holder.mCode.setText(eventModels.get(position).getC_code());
        holder.mCapital.setText(eventModels.get(position).getC_capital());


    }


    @Override
    public int getItemCount() {
        return eventModels.size();
    }
}
