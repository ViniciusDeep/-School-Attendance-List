package br.com.viniciusdeep.agenda;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.List;

import br.com.viniciusdeep.agenda.Dao.AlunoDao;
import br.com.viniciusdeep.agenda.modelo.Aluno;

public class FormularioActivity extends AppCompatActivity {


    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        Aluno aluno = (Aluno) intent.getSerializableExtra("aluno"); //Recuperar dados do aluno, e colocar na variável aluno na vaserialazable
        helper = new FormularioHelper(this);
        if(aluno != null) {
            helper.preencheFormulario(aluno);
        }

        Button button_image = (Button) findViewById(R.id.formulario_button_image);
        button_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                String awayPhoto = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";
                File archiveImage = new File(awayPhoto);
                intentImage.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(archiveImage));
                startActivity(intentImage);

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_ok:
                Aluno aluno = helper.pegaAluno();
                AlunoDao dao = new AlunoDao(this);

                if(aluno.getId() != null){
                    dao.altera(aluno);
                }else{
                    dao.insert(aluno);
                }


                dao.close();
                Toast.makeText(FormularioActivity.this, "Aluno " + aluno.getNome() + " salvo!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }





}
