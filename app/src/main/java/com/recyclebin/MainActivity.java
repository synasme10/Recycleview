package com.recyclebin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.etsearch);


        //Create a list of Contact
        final List<Contacts> contactsList = new ArrayList<>();
        contactsList.add(new Contacts("saugat Malla", "9860345213", "nakkhu", "ahsajdha@gmail.com", R.drawable.saugat));
        contactsList.add(new Contacts("Bhuwan", "9860345217", "Bhaisipati", "ahsajdha@gmail.com", R.drawable.bhuwan));
        contactsList.add(new Contacts("Rajesh", "9860345567", "Sunakothi", "ahsajdha@gmail.com", R.drawable.rajesh));
        contactsList.add(new Contacts("Dahayang", "98012342123", "bakhu", "ahsajdha@gmail.com", R.drawable.dahayang));
        contactsList.add(new Contacts("Johnny", "9860321987", "Bhalku", "ahsajdha@gmail.com", R.drawable.johnny));
        contactsList.add(new Contacts("Grant", "9868761987", "Boudha", "ahsajdha@gmail.com", R.drawable.grant));
        contactsList.add(new Contacts("Robert", "9841433451", "bakhu", "ahsajdha@gmail.com", R.drawable.robert));
        contactsList.add(new Contacts("stephen", "9860344871", "bakhu", "ahsajdha@gmail.com", R.drawable.stephen));
        contactsList.add(new Contacts("Anmol KC", "9845123456", "bakhu", "ahsajdha@gmail.com", R.drawable.anmol));
        contactsList.add(new Contacts("Dwayne", "98012342112", "bakhu", "ahsajdha@gmail.com", R.drawable.dwayne));
        contactsList.add(new Contacts("Jacky", "9841561234", "bakhu", "ahsajdha@gmail.com", R.drawable.jacky));
        //pass this list to adapter

        final ContactAdapter contactAdapter = new ContactAdapter(this, contactsList);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }


            public void filter(String text) {
                ArrayList<Contacts> filteredList = new ArrayList<>();
                for (Contacts contacts : contactsList) {
                    if (contacts.getName().toLowerCase().contains((text.toLowerCase()))) {
                        filteredList.add(contacts);
                    }

                }
                contactAdapter.filterList(filteredList);
            }
        });

    }
}

