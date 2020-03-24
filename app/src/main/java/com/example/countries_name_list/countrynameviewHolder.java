package com.example.countries_name_list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class countrynameviewHolder extends RecyclerView.ViewHolder {
    TextView mName,mCapital,mCode;
    View mView;

    public countrynameviewHolder(@NonNull final View itemView) {
        super(itemView);
        mView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when user click on the item....I'll work on it later :). By the way this is just for try. Avilasha Prasad...stop that
                /*Intent avi = new Intent(itemView.getContext(),EditInventoryFragment.class);
                avi.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(avi);*/
                mClickListener.onItemClick(v, getAdapterPosition());

            }
        });

        //initializes views with cardviewsearch_xml layout...hmmm
        mName = itemView.findViewById(R.id.textview_countryname);

    }

    private countrynameviewHolder.ClickListener mClickListener;

    public void setOnClickListener(countrynameviewHolder.ClickListener clickListener) {

        mClickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(View view, int pos);
    }
}