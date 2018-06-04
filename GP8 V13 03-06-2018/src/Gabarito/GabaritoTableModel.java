package Gabarito;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class GabaritoTableModel extends AbstractTableModel {

    private List<Gabarito> gabaritos = new ArrayList<>();
    private String[] colunas = {"Id", "Processo Seletivo"};

    public GabaritoTableModel(List<Gabarito> gabaritos) {
        this.gabaritos = gabaritos;
    }

    @Override
    public int getRowCount() {
        return gabaritos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Gabarito gabarito = gabaritos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return gabarito.getId();
            case 1:
                return gabarito.getNomeGabarito();
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
