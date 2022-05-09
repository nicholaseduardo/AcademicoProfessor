/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.academicoprofessor.manter_professor;

import br.edu.ifms.academicoprofessor.pattern.IDao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author professor
 */
public class DocenteTableModel extends AbstractTableModel {
    
    private IDao<Docente> dao;
    private List<Docente> lista;
    private String[] colunas = {"Id", "Nome"};
    
    public DocenteTableModel(IDao<Docente> dao) {
        this.dao = dao;
        lista = dao.listar();
    }
    
    public void refresh() {
        lista.clear();
        lista.addAll(dao.listar());
        fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Docente obj = lista.get(row);
        switch (col) {
            case 0: return obj.getId();
            case 1: return obj.getNome();
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Long.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    
    
}
