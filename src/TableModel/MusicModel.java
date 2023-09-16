package TableModel;

import Music.Music;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;



public class MusicModel extends AbstractTableModel {
  private final String[] columnas = { "Nombre", "Autor", "Album" };
  

  private ArrayList<Music> lineas;
  


  public MusicModel()
  {
    lineas = new ArrayList();
  }
  
  public MusicModel(ArrayList<Music> lineas) {
    this.lineas = lineas;
  }
  

  public int getRowCount()
  {
    return lineas.size();
  }
  
  public int getColumnCount()
  {
    return columnas.length;
  }
  
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    Music m = (Music)lineas.get(rowIndex);
    switch (columnIndex) {
    case 0: 
      return m.getNombre();
    case 1: 
      return m.getAutor();
    case 2: 
      return m.getAlbum();
    }
    return null;
  }
  
  public void setValueAt(Object object, int rowIndex, int columnIndex)
  {
    Music m = (Music)lineas.get(rowIndex);
    String value = (String)object;
    switch (columnIndex) {
    case 0: 
      m.setNombre(value);
      break;
    case 1: 
      m.setAutor(value);
      break;
    case 2: 
      m.setAlbum(value);
      break;
    }
    fireTableRowsInserted(rowIndex, rowIndex);
  }

  public String getColumnName(int column)
  {
    return columnas[column];
  }
  

  public Class<?> getColumnClass(int columnIndex)
  {
    switch (columnIndex) {
    case 0: 
      return String.class;
    case 1: 
      return String.class;
    case 2: 
      return String.class;
    }
    
    return null;
  }
  
  public Music getMusica(int rowIndex)
  {
    return (Music)lineas.get(rowIndex);
  }
  
  public boolean cancionYaAgregada(Music musica){
      for (int i = 0; i < lineas.size(); i++) {
          if (lineas.get(i).getPath().equals(musica.getPath()))
              return true;                
      }
      return false;
  }
  
public void addMusica(Music musica) {
    String extension = "";
    int i = musica.getPath().lastIndexOf('.');
    if (i > 0) {
        extension = musica.getPath().substring(i+1);
    }

    if (extension.equals("mp3")) {
        boolean add = cancionYaAgregada(musica);
        if (!add)
            lineas.add(musica);
        else 
            JOptionPane.showMessageDialog(null, "Cancion ya agregada");
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    } else {
        JOptionPane.showMessageDialog(null, "El archivo no es mp3");
    }
}
  

  public void removeMusic(int indiceLinha) {
    lineas.remove(indiceLinha);
    fireTableRowsDeleted(indiceLinha, indiceLinha);
  }
  
  public ArrayList<Music> getAsArrayList() {
    return lineas;
  }
}
