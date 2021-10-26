package com.securityguard.Adapter;

import android.content.Context;
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
    private Context context;

    public AdapterFriend(ArrayList<UserEntity> listViewFriends, Context context) {
        this.listViewFriends = listViewFriends;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_friends, parent, false);
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_friends, parent, false);
        return new AdapterFriend.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFriend.ViewHolder viewHolder, final int position) {
        viewHolder.txtNama.setText(listViewFriends.get(position).getNama());
        viewHolder.txtNoHp.setText(listViewFriends.get(position).getNoTelp());
    }

    @Override
    public int getItemCount() {
        return (listViewFriends != null) ? listViewFriends.size() : 0;
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
