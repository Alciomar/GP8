package corrigirGabarito;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CorrigirGabaritoTableModel extends AbstractTableModel {

    private List<CorrigirGabarito> corrigir = new ArrayList<>();
    private String[] colunas = {"Id", "Aluno", "nota"};

    public CorrigirGabaritoTableModel(List<CorrigirGabarito> corrigir) {
        this.corrigir = corrigir;
    }

    @Override
    public int getRowCount() {
        return corrigir.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CorrigirGabarito corrigir1 = corrigir.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return corrigir1.getId();
            case 1:
                return corrigir1.getAluno().getNome();

        }
        return null;
    }

    public String getColumnName(int index) {
        switch (index) {
            case 0:
                return colunas[0];
            case 1:
                return colunas[1];

        }
        return null;
    }

}
