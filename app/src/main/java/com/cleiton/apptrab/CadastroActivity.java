package com.cleiton.apptrab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etNomepet;
    private EditText etidadepet;
    private Spinner Animal;
    private Button btnBotao;
    private String acao;
    private Pets pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome = findViewById(R.id.etNome);
        etNomepet = findViewById(R.id.etNomePet);
        etidadepet = findViewById(R.id.etIdadePet);
        Animal = findViewById(R.id.spAnimal);
        btnBotao = findViewById(R.id.btnBotao);

        acao = getIntent().getStringExtra("acao");
        if(acao.equals("editar")){
            carregarCadastro();

        }

        btnBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

    }

    private void carregarCadastro(){

        int id = getIntent().getIntExtra("idPets", 0);
        pets = PetsDAO.getPetsById(this, id );
        etNome.setText(pets.getNome() );
        etNomepet.setText(pets.getNomepet() );
        etidadepet.setText(pets.getIdadepet() );

        String[] animais = getResources().getStringArray(R.array.Animal);
        for(int i = 0; i < animais.length; i++){
            if (pets.getSpAnimal().equals(animais[i]) ){
                Animal.setSelection(i);
                break;

            }

        }

    }

    public void salvar(){

        String nome = etNome.getText().toString();
        String nomepet = etNomepet.getText().toString();
        String idadepet = etidadepet.getText().toString();

        if(nome.isEmpty() || Animal.getSelectedItemPosition() == 0 ){

            Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG ).show();

        }else{

            if(acao.equals("inserir")) {

                pets = new Pets();

            }
            pets.setNome(nome);
            pets.setNomepet(nomepet);
            pets.setIdadepet(idadepet);
            pets.setSpAnimal(Animal.getSelectedItem().toString());

            if(acao.equals("inserir")) {
                PetsDAO.inserir(this, pets);

                etNome.setText("");
                etNomepet.setText("");
                etidadepet.setText("");
                Animal.setSelection(0, true);
            }else{
                PetsDAO.editar(this, pets);
                finish();

            }

        }

    }

}