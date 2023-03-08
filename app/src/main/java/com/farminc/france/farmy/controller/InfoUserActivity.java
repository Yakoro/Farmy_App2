package com.farminc.france.farmy.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.farminc.france.farmy.R;

import org.json.JSONException;
import org.json.JSONObject;

public class InfoUserActivity extends AppCompatActivity {

    private EditText mEditTextName;
    private Button mButtonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_user);

        mEditTextName = findViewById(R.id.info_edittext_name);
        mButtonName = findViewById(R.id.info_button_name);

        mButtonName.setEnabled(false);

        //On regarde quand du texte est tapé

        mEditTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            //Méthode appelée quand du texte est tapé
            public void afterTextChanged(Editable editable) {
                mButtonName.setEnabled(true);

            }
        });

        //Si le bouton est appuyé

        mButtonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Récupération du nom tapé dans le EditText
                String nom_user = mEditTextName.getText().toString();

                JSONObject infoUser = new JSONObject();
                try {
                    infoUser.put("Name", nom_user);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Envoi dans l'activité SynchroActivity
                Intent synchroActivityIntent = new Intent(InfoUserActivity.this, SynchroActivity.class);
                startActivity(synchroActivityIntent);
            }
        });

    } //Commentaire pour commit
}