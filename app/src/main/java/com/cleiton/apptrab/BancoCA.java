package com.cleiton.apptrab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoCA extends SQLiteOpenHelper {

    private static final String NOME_BANCOCA = "AppTrab";
    private static final int VERSAO = 1;

    public BancoCA(Context context){

        super(context, NOME_BANCOCA, null, VERSAO);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS Pets( " +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL," +
                " nomePet TEXT NOT NULL," +
                " idadePet Float NOT NULL, " +
                " spAnimal TEXT NOT NULL )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
