package aluno;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AlunoTableModel extends AbstractTableModel {

    private List<Aluno> alunos = new ArrayList<>();
    private String[] colunas = {"Id", "Nome", "Cidade"};

    public AlunoTableModel(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = alunos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return aluno.getId();
            case 1:
                return aluno.getNome();
            case 2:
                return aluno.getCidade();

        }
        return null;
    }

    public String getColumnName(int index) {
        switch (index) {
            case 0:
                return colunas[0];
            case 1:
                return colunas[1];
            case 2:
                return colunas[2];

        }
        return null;
    }

}
