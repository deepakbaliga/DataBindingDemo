package com.deepakbaliga.databindingdemo;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.deepakbaliga.databindingdemo.BR;
import com.deepakbaliga.databindingdemo.databinding.TemplateRowBinding;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;

/**
 * Created by deezdroid on 03/10/15.
 */
public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    private static LinkedList<Place> places;
    private static PlaceClickListener placeClickListener;

    public PlaceAdapter(LinkedList<Place> places, PlaceClickListener placeClickListener) {
        this.places = places;
        this.placeClickListener = placeClickListener;
    }



    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_row, parent, false);
        PlaceViewHolder placeViewHolder = new PlaceViewHolder(view);
        return placeViewHolder;
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {

        final Place place = places.get(position);

        holder.getRowBinding().setVariable(BR.place, place);
        holder.getRowBinding().executePendingBindings();

    }

    @BindingAdapter("bind:url")
    public static void setImage(ImageView imageView, String url){

        Picasso.with(imageView.getContext()).load(url).into(imageView);


    }

    @Override
    public int getItemCount() {
        return places.size();
    }



    public static class PlaceViewHolder extends RecyclerView.ViewHolder{

        private TemplateRowBinding rowBinding;

        public PlaceViewHolder(final View itemView) {
            super(itemView);

            rowBinding = DataBindingUtil.bind(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    placeClickListener.onTouch(itemView,getPosition());
                }
            });

        }

        public TemplateRowBinding getRowBinding() {
            return rowBinding;
        }

    }


}
