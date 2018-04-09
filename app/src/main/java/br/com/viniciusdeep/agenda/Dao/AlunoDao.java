package br.com.viniciusdeep.agenda.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.viniciusdeep.agenda.modelo.Aluno;

public class AlunoDao extends SQLiteOpenHelper{


    public AlunoDao(Context context) {
        super(context, "Agenda", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Alunos (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT, telefone TEXT, site TEXT, nota REAL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Alunos";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", aluno.getNome());
        dados.put("site",aluno.getSite());
        dados.put("telefone", aluno.getTelefone());
        dados.put("endereco", aluno.getEndereco());
        dados.put("nota", aluno.getNota());
        db.insert("Alunos", null, dados);


    }

}
