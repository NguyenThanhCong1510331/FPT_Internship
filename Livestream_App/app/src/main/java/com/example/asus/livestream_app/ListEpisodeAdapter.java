package com.example.asus.livestream_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Welcome on 6/19/2018.
 */

public class ListEpisodeAdapter extends RecyclerView.Adapter<ListEpisodeAdapter.ViewHolder> {

    Context context;
    ArrayList<ArrayList<String>> lst;
    public ListEpisodeAdapter(Context context,   ArrayList<ArrayList<String>> lstFilm){
            this.context=context;
            this.lst=new ArrayList<>(lstFilm);
    }
    @Override
    public ListEpisodeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_recyle_view,parent,false);
        ListEpisodeAdapter.ViewHolder viewHolder=new ListEpisodeAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ListEpisodeAdapter.ViewHolder holder, final int position) {

        ArrayList<String> lstItem=lst.get(position);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,6);
        holder.recyclerView.setLayoutManager(gridLayoutManager);
        ChooseListAdapter chooseListAdapter=new ChooseListAdapter(context,lstItem);
        holder.recyclerView.setAdapter(chooseListAdapter);
      /*  holder.leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position>=2){
                    holder.itemView
                }
            }
        });
        holder.rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(position<lst.size()-1){
                   GridLayoutManager gridLayoutManager=new GridLayoutManager(context,5);
                   holder.recyclerView.setLayoutManager(gridLayoutManager);
               }

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView leftArrow,rightArrow;
         RecyclerView recyclerView;
        public ViewHolder(View itemView) {
            super(itemView);

            leftArrow=(ImageView)itemView.findViewById(R.id.arrow1);
            rightArrow=(ImageView)itemView.findViewById(R.id.arrow2);
            recyclerView=(RecyclerView)itemView.findViewById(R.id.itemRecycleView);
        }
    }
}
