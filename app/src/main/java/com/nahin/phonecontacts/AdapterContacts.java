package com.nahin.phonecontacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterContacts extends RecyclerView.Adapter<AdapterContacts.ContactListViewHolder>
{
    private List<PhoneContacts> phoneContactsList;
    private Context context;

    public AdapterContacts(List<PhoneContacts> phoneContactsList, Context context)
    {
        this.phoneContactsList = phoneContactsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contacts_item_row, parent, false);

        ContactListViewHolder vh = new ContactListViewHolder( v );

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactListViewHolder holder, int position) {

     holder.nameT.setText( phoneContactsList.get( position ).getName() );
     holder.contactsT.setText(phoneContactsList.get( position ).getNumber()  );

    }

    @Override
    public int getItemCount()
    {
        return phoneContactsList.size();
    }

    public static class ContactListViewHolder extends RecyclerView.ViewHolder
    {
        TextView nameT,contactsT;

        public ContactListViewHolder(@NonNull View itemView)
        {
            super( itemView );
            nameT=itemView.findViewById(R.id.nameV);
            contactsT=itemView.findViewById( R.id.numberV );

        }
    }

}
