package com.example.buttomnavigation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class AdminFragment extends Fragment {
    private MaterialButton imvDepot;
    CatergoryAdapterSpn adapterSpn;
    private Spinner spnCategory;
    private Dialog dialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imvDepot = view.findViewById(R.id.imvDepot);
        adapterSpn = new CatergoryAdapterSpn(getContext(),R.layout.item_selected,getAllListCatergory());

        imvDepot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ){
                DialogSelected();
            }
        });

    }

    public void DialogSelected(){

        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_add1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add1,null);
//        builder.setView(view);
//        Dialog dialog = builder.create();

        spnCategory = (Spinner) dialog.findViewById(R.id.spn_category);
        spnCategory.setAdapter(adapterSpn);
        spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(),adapterSpn.getItem(i).getName() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dialog.show();
    }
    private List<Category> getAllListCatergory(){
        List<Category> list = new ArrayList<>();
        list.add(new Category("kho hang 1"));
        list.add(new Category("kho hang 2"));
        list.add(new Category("kho hang 3"));

        return list;
    }

}