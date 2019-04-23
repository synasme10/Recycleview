package com.recyclebin;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactsViewHolder> {
    Context mContext;
    List<Contacts> contactsList;
    //Constructor, to receive data from the activity
    public ContactAdapter (Context mContext,
                          List<Contacts> contactsList){
        this.mContext = mContext;
        this.contactsList= contactsList;
    }

    @NonNull
    @Override
    //object create garne
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contact,viewGroup,false);
        return new ContactsViewHolder(view);

    }
    @Override
    //data learune.
    public void onBindViewHolder
            (@NonNull ContactsViewHolder contactsViewHolder, int i){
        final Contacts contacts = contactsList.get(i);
        contactsViewHolder.imgProfile.setImageResource(contacts.getImageId());
        contactsViewHolder.tvName.setText(contacts.getName());
        contactsViewHolder.tvPhone.setText(contacts.getPhoneNo());



        contactsViewHolder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetailsActivity.class);
                intent.putExtra("image",contacts.getImageId());
                intent.putExtra("name",contacts.getName());
                intent.putExtra("phone",contacts.getPhoneNo());
                intent.putExtra("address",contacts.getAddress());
                intent.putExtra("email",contacts.getEmail());

                mContext.startActivity(intent);

            }
        });



    }
    @Override
    public int getItemCount(){
        return contactsList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imgProfile;
        TextView tvName,tvPhone;
        public ContactsViewHolder(@NonNull View itemView){
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);

        }



    }
    public void filterList(ArrayList<Contacts> filterList){
        contactsList = filterList;
        notifyDataSetChanged();
    }
}
