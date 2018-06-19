package com.example.asus.livestream_app;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Welcome on 6/19/2018.
 */

public class ChooseListAdapter extends RecyclerView.Adapter<ChooseListAdapter.ViewHolder> {

    static Context context;
    public ChooseListAdapter(Context context, ArrayList<?> lst){

    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.episode_item,parent,false);
        ChooseListAdapter.ViewHolder viewHolder=new ChooseListAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.bgOfItem.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    holder.bgOfItem.setBackground(context.getResources().getDrawable(R.drawable.oval_shape,null));
                    holder.txtItem.setTextColor(context.getResources().getColor(R.color.titleName,null));
                }
                else{
                    holder.bgOfItem.setBackground(context.getResources().getDrawable(R.drawable.oval_shape_not_focus,null));
                    holder.txtItem.setTextColor(context.getResources().getColor(R.color.colordescription,null));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button bgOfItem;
        TextView txtItem;

        public ViewHolder(View itemView) {
            super(itemView);
            bgOfItem=(Button)itemView.findViewById(R.id.bgOfItem);
            txtItem=(TextView) itemView.findViewById(R.id.tapFilm);
        }
    }
}
