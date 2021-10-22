package com.securityguard.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.securityguard.R;
import com.securityguard.entity.Friend;
import com.securityguard.entity.UserEntity;

import java.util.ArrayList;

public class AdapterFriend extends RecyclerView.Adapter<AdapterFriend.ViewHolder> {

    private ArrayList<UserEntity> listViewFriends;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_friends, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFriend.ViewHolder viewHolder, final int position) {
        viewHolder.txtNama.setText(listViewFriends.get(position).getNama());
        viewHolder.txtNoHp.setText(listViewFriends.get(position).getNoTelp());
    }

    @Override
    public int getItemCount() {
        return listViewFriends.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtNama, txtNoHp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.tx_Nama);
            txtNoHp = itemView.findViewById(R.id.tx_NoHp);
        }
    }
}
