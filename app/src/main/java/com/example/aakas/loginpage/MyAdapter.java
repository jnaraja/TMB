package com.example.aakas.loginpage;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<RecyclerItem> listItem;
    private Context mContext;

    public MyAdapter(List<RecyclerItem> listItem, Context mContext) {
        this.listItem = listItem;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final RecyclerItem itemList = listItem.get(position);
        holder.trail_name.setText(itemList.getTitle());
        holder.trail_location.setText(itemList.getDescription());
        //holder.trail_photo.setImage(itemList.getImage());
        holder.txtOptionDigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(mContext, holder.txtOptionDigit);
                popupMenu.inflate(R.menu.option_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_item_edit:
                                Toast.makeText(mContext, "Edited",Toast.LENGTH_LONG).show();
                                break;
                            case R.id.menu_item_delete:
                                listItem.remove(position);
                                notifyDataSetChanged();
                                Toast.makeText(mContext, "Deleted", Toast.LENGTH_LONG).show();
                                break;
                            default:
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Trail_info.class);
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView trail_name;
        public TextView trail_location;
        public TextView txtOptionDigit;
        public ImageView trail_photo;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            trail_name = (TextView) itemView.findViewById(R.id.trail_name);
            trail_location = (TextView) itemView.findViewById(R.id.trail_location);
            txtOptionDigit = (TextView) itemView.findViewById(R.id.txtOptionDigit);
            trail_photo = (ImageView) itemView.findViewById(R.id.trail_photo);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }


}
