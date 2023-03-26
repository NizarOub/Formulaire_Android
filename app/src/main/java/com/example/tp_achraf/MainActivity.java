package com.example.tp_achraf;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nomEditText;
    private EditText prenomEditText;
    private EditText ageEditText;
    private EditText domaineEditText;
    private EditText numeroEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomEditText = findViewById(R.id.nom_edit_text);
        prenomEditText = findViewById(R.id.prenom_edit_text);
        ageEditText = findViewById(R.id.age_edit_text);
        domaineEditText = findViewById(R.id.domaine_edit_text);
        numeroEditText = findViewById(R.id.numero_edit_text);

    }
    public void valid(View view) {
        String nom = nomEditText.getText().toString();
        String prenom = prenomEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String domaine = domaineEditText.getText().toString();
        String numero = numeroEditText.getText().toString();

        if (nom.isEmpty()){
            nomEditText.setError("Veuillez saisir votre nom");
        }
        if (prenom.isEmpty()){
            prenomEditText.setError("Veuillez saisir votre prenom");
        }
        if (age.isEmpty()){
            ageEditText.setError("Veuillez saisir votre age");
        }
        if (domaine.isEmpty()){
            domaineEditText.setError("Veuillez saisir votre domaine");
        }
        if (numero.isEmpty()){
            numeroEditText.setError("Veuillez saisir votre numero");
        }
        if (!nom.isEmpty() && !prenom.isEmpty() && !age.isEmpty() && !domaine.isEmpty() && !numero.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Confirmation");
            builder.setMessage("Êtes-vous sûr de vouloir valider ces informations ?");
            builder.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this,
                            "Nom: " + nom + "\n"
                            + "Prénom: " + prenom + "\n"
                            + "Age: " + age + "\n"
                            + "Domaine de compétences: " + domaine + "\n"
                            + "Numéro de téléphone: " + numero, Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Annuler", null);
            builder.show();
        }
    }
}
