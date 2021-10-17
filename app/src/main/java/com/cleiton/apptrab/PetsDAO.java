package com.cleiton.apptrab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PetsDAO {

    public static void inserir(Context context, Pets pets){

        ContentValues values = new ContentValues();
        values.put("nome", pets.getNome());
        values.put("nomepet", pets.getNomepet());
        values.put("idadepet", pets.getIdadepet());
        values.put("spAnimal", pets.getSpAnimal());

        BancoCA conexao = new BancoCA(context);
        SQLiteDatabase db = conexao.getWritableDatabase();

        db.insert(" Pets ", null, values);

    }

    public static void editar(Context context, Pets pets){

        ContentValues values = new ContentValues();
        values.put("nome", pets.getNome());
        values.put("nomepet", pets.getNomepet());
        values.put("idadepet", pets.getIdadepet());
        values.put("spAnimal", pets.getSpAnimal());

        BancoCA conexao = new BancoCA(context);
        SQLiteDatabase db = conexao.getWritableDatabase();

        db.update("Pets", values, "id = " + pets.getId(), null);

    }

    public static void excluir(Context context, int idPets){

        BancoCA conexao = new BancoCA(context);
        SQLiteDatabase db = conexao.getWritableDatabase();

        db.delete("Pets", " id = " + idPets, null);

    }

    public static List<Pets> getPets(Context context){

        List<Pets> lista = new ArrayList<>();

        BancoCA conexao = new BancoCA(context);
        SQLiteDatabase db = conexao.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM pets ORDER BY nome", null);

        if(cursor.getCount() > 0){

            cursor.moveToFirst();

            do{

                Pets pets = new Pets();
                pets.setId(cursor.getInt(0));
                pets.setNome(cursor.getString(1));
                pets.setNomepet(cursor.getString(2));
                pets.setIdadepet(cursor.getString(3));
                pets.setSpAnimal(cursor.getString(4));

                lista.add(pets);

            }while(cursor.moveToNext() );

        }

        return lista;
    }

    public static Pets getPetsById(Context context, int idProduto) {

        BancoCA conexao = new BancoCA(context);
        SQLiteDatabase db = conexao.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM pets WHERE id = " + idProduto, null);

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();

                Pets pets = new Pets();
                pets.setId(cursor.getInt(0));
                pets.setNome(cursor.getString(1));
                pets.setNomepet(cursor.getString(2));
                pets.setIdadepet(cursor.getString(3));
                pets.setSpAnimal(cursor.getString(4));

                return pets;

            }else{

                return null;

            }

        }

    }
