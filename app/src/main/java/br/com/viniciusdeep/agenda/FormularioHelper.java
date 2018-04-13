package br.com.viniciusdeep.agenda;

import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

import br.com.viniciusdeep.agenda.modelo.Aluno;

public class FormularioHelper {


    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoTelefone;
    private final EditText campoSite;
    private final RatingBar campoNota;
    private Aluno aluno;
    public FormularioHelper(FormularioActivity activity) {
               campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
//                String nome = campoNome.getText().toString();

                campoEndereco = (EditText) activity.findViewById(R.id.formulario_endereco);
//                String endereco =  campoEndereco.getText().toString();

                campoTelefone = (EditText) activity.findViewById(R.id.formulario_telefone);
//                String telefone = campoTelefone.getText().toString();


                campoSite = (EditText) activity.findViewById(R.id.formulario_site);
//                String site = campoSite.getText().toString();

                campoNota= (RatingBar) activity.findViewById(R.id.formulario_stars);

                aluno = new Aluno();
    }


    public Aluno pegaAluno() {


        Aluno aluno = new Aluno();


        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setTelefone(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));

        return aluno;
    }


    public void preencheFormulario(Aluno aluno) {
            campoNome.setText(aluno.getNome());
            campoEndereco.setText(aluno.getEndereco());
            campoSite.setText(aluno.getSite());
            campoTelefone.setText(aluno.getTelefone());
            campoNota.setProgress(aluno.getNota().intValue());
            this.aluno = aluno;
    }
}
