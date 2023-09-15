package Forms;

import Music.Music;
import TableModel.MusicModel;
import Utils.Time;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javazoom.jl.player.Player;

public class MainFrame extends javax.swing.JFrame {
  public MainFrame() {
    initComponents();
    setLocationRelativeTo(null);
    tbPlayListAtual.setModel(modeloMusicas);
    setLayoutTabela();
    lbTituloTocando.setText("Cancion:");
    lbTocandoAgora.setText("");
    lbAutor.setText("");
    slider1.setValue(0);
    btstop.setEnabled(false);
    fc.setMultiSelectionEnabled(true);
    jcSalvaLista.setMultiSelectionEnabled(false);
    jcSalvaLista.setApproveButtonText("Salvar");
  }
  






  public void StopMusica() {}
  






  private void initComponents()
  {
    jPanel1 = new JPanel();
    btAddmusica = new JButton();
    btRemoveMusica = new JButton();
    jPanel2 = new JPanel();
    btplay = new JButton();
    btstop = new JButton();
    jPanel5 = new JPanel();
    lbTituloTocando = new JLabel();
    lbTocandoAgora = new JLabel();
    slider1 = new JSlider();
    lbtempoDecorrido = new JLabel();
    lbtituloAutor = new JLabel();
    lbAutor = new JLabel();
    btAnteriorMusica = new JButton();
    btProximaMusica = new JButton();
    jPanel4 = new JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tbPlayListAtual = new JTable();
    btPausa = new JButton();
    
    setDefaultCloseOperation(3);
    setTitle("Flow");
    setPreferredSize(new Dimension(1000,700));
    
    jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Opciones", 0, 0, new Font("Arial", 1, 14)));
    jPanel1.setToolTipText("Opciones");
    jPanel1.setLayout(new java.awt.GridLayout(1, 0));
    
    btAddmusica.setFont(new Font("Arial", 1, 14));
    btAddmusica.setIcon(new ImageIcon(getClass().getResource("/Icons/AddMusica.png")));
    btAddmusica.setText("Add");
    btAddmusica.setBackground(Color.white);
    btAddmusica.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainFrame.this.btAddmusicaActionPerformed(evt);
      }
    });
    jPanel1.add(btAddmusica);
    
    btRemoveMusica.setFont(new Font("Arial", 1, 14));
    btRemoveMusica.setIcon(new ImageIcon(getClass().getResource("/Icons/removeMusica.png")));
    btRemoveMusica.setText("Delete");
    btRemoveMusica.setBackground(Color.white);
    btRemoveMusica.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainFrame.this.btRemoveMusicaActionPerformed(evt);
      }
    });
    jPanel1.add(btRemoveMusica);
    
    jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Player", 0, 0, new Font("Arial", 1, 14)));
    jPanel2.setToolTipText("Reproduciendo");
    
    btplay.setFont(new Font("Arial", 1, 14));
    btplay.setIcon(new ImageIcon(getClass().getResource("/Icons/play.png")));
    btplay.setText("Play");
    btplay.setBackground(Color.white);
    btplay.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainFrame.this.btplayActionPerformed(evt);
      }
      
    });
    btstop.setFont(new Font("Arial", 1, 14));
    btstop.setIcon(new ImageIcon(getClass().getResource("/Icons/stop.png")));
    btstop.setText("Stop");
    btstop.setBackground(Color.white);
    btstop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainFrame.this.btstopActionPerformed(evt);
      }
      
    });
    
    btPausa.setFont(new Font("Arial",1,14));
    btPausa.setIcon(new ImageIcon(getClass().getResource("/Icons/pausa.png")));
    btPausa.setText("Pause");
    btPausa.setBackground(Color.white);
    btPausa.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainFrame.this.btpausaActionPerformed(evt);
      }
      
    });
    
    jPanel5.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
    jPanel5.setBorder(BorderFactory.createEtchedBorder());
    
    lbTituloTocando.setFont(new Font("Arial", 1, 14));
    lbTituloTocando.setText("Playing:");
    
    lbTocandoAgora.setFont(new Font("Arial", 1, 14));
    lbTocandoAgora.setText("jLabel2");
    
    slider1.setBackground(new java.awt.Color(255, 255, 255));
    
    lbtempoDecorrido.setText("00:00:00");
    
    lbtituloAutor.setFont(new Font("Arial", 1, 14));
    lbtituloAutor.setText("Autor:");
    
    lbAutor.setFont(new Font("Arial", 1, 14));
    lbAutor.setText("jLabel2");
    
    GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(slider1, -2, 0, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lbtempoDecorrido, -2, 54, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup().addComponent(lbtituloAutor).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(lbAutor, -1, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup().addComponent(lbTituloTocando).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(lbTocandoAgora, -2, 350, -2))).addContainerGap(-1, 32767)))));

    
    
    
    
    
    
    
    
    
    
    jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lbTocandoAgora).addComponent(lbTituloTocando)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lbAutor).addComponent(lbtituloAutor)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(slider1, GroupLayout.Alignment.TRAILING, -2, 34, -2).addComponent(lbtempoDecorrido, GroupLayout.Alignment.TRAILING, -2, 34, -2))));
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    btAnteriorMusica.setIcon(new ImageIcon(getClass().getResource("/Icons/anterior.png")));
    btAnteriorMusica.setBackground(Color.white);
    btAnteriorMusica.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainFrame.this.btAnteriorMusicaActionPerformed(evt);
      }
      
    });
    btProximaMusica.setIcon(new ImageIcon(getClass().getResource("/Icons/proxima.png")));
    btProximaMusica.setBackground(Color.white);
    btProximaMusica.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainFrame.this.btProximaMusicaActionPerformed(evt);
      }
      
    });
    
    GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(GroupLayout.Alignment.TRAILING, 
                                  jPanel2Layout.createSequentialGroup()
                                          .addComponent(btAnteriorMusica, -2, 0, 32767)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addComponent(btProximaMusica, -2, 43, -2))
                        .addComponent(btplay, -1, 100, 32767)
                        .addComponent(btstop, -1, -1, 32767)
                        .addComponent(btPausa, -1, -1, 32767))                        
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)                
                .addComponent(jPanel5, -1, -1, 32767)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)));
    
    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btplay, -2, 36, -2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btstop, -2, 34, -2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btPausa)
                                    .addGroup(
                                            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(btAnteriorMusica, -2, 24, 32767)
                                                    .addComponent(btProximaMusica, -2, 0, 32767))))
                    .addGap(0, 0, 32767))
            .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, -2, -1, -2)
                    .addContainerGap(-1, 32767)));
    


















    jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Canciones", 0, 0, new Font("Arial", 1, 14)));
    
    tbPlayListAtual.setAutoCreateRowSorter(true);
    tbPlayListAtual.setBorder(BorderFactory.createEtchedBorder());
    tbPlayListAtual.setFont(new Font("Arial", 1, 14));
    tbPlayListAtual.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
    









    tbPlayListAtual.setAutoResizeMode(4);
    tbPlayListAtual.setSelectionMode(0);
    tbPlayListAtual.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        MainFrame.this.tbPlayListAtualMouseClicked(evt);
      }
      
      public void mouseEntered(MouseEvent evt) { MainFrame.this.tbPlayListAtualMouseEntered(evt);
      }
    });
    jScrollPane1.setViewportView(tbPlayListAtual);
    
    
    
    
    GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, -2, 0, 32767));
    



    jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(jScrollPane1, -1, 172, 32767).addGap(18, 18, 18)));
    







    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(jPanel4, -1, -1, 32767).addComponent(jPanel2, -1, -1, 32767)).addContainerGap()));
    








    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel4, -1, -1, 32767).addGap(16, 16, 16)));
    









    pack();
  }
  

  public void setLayoutTabela()
  {
    tbPlayListAtual.getColumnModel().getColumn(0).setPreferredWidth(350);
    tbPlayListAtual.getColumnModel().getColumn(1).setPreferredWidth(250);
    tbPlayListAtual.getColumnModel().getColumn(2).setPreferredWidth(250);
    tbPlayListAtual.setRowSorter(null);
  }
  

  private void btAddmusicaActionPerformed(ActionEvent evt)
  {
    if (fc.showOpenDialog(jPanel1) == 0) {
      try
      {
        File[] files = fc.getSelectedFiles();
        
        for (int i = 0; i < files.length; i++)
        {

          javax.sound.sampled.AudioFileFormat baseFileFormat = javax.sound.sampled.AudioSystem.getAudioFileFormat(files[i]);
          

          if ((baseFileFormat instanceof org.tritonus.share.sampled.file.TAudioFileFormat))
          {
            Music musica = new Music();
            
            Map properties = ((org.tritonus.share.sampled.file.TAudioFileFormat)baseFileFormat).properties();
            String key = "title";
            String val = (String)properties.get(key);
            
            musica.setNome(val);
            
            key = "author";
            val = (String)properties.get(key);
            musica.setAutor(val);
            
            key = "album";
            val = (String)properties.get(key);
            musica.setAlbum(val);
            
            key = "duration";
            Long valLong = (Long)properties.get(key);
            musica.setTempo(Long.valueOf(valLong.longValue() / 1000000L));
            
            musica.setPath(files[i].getAbsolutePath());
            
            modeloMusicas.addMusica(musica);
          }
          
        }
        

      }
      catch (Exception ex)
      {
        System.out.println(ex.getMessage());
      }
    }
  }
  
  private void btRemoveMusicaActionPerformed(ActionEvent evt) {
    Integer linha = Integer.valueOf(tbPlayListAtual.getSelectedRow());
    if (linha.intValue() > -1)
    {

      if ((lbTocandoAgora.getText().equals(modeloMusicas.getMusica(linha.intValue()).getNome().toString())) && (lbTituloTocando.getText().equals("Playing:")))
      {


        stop = Boolean.valueOf(true);
        tempo.setStopFlag(Boolean.valueOf(true));
        btstop.setEnabled(false);
        player.close();
        btplay.setEnabled(true);
        
        lbTituloTocando.setText("Cancion:");
        lbAutor.setText("Autor");
        lbTocandoAgora.setText("");
      }
      


      modeloMusicas.removeMusica(linha.intValue());
    }
  }
  

  private void tbPlayListAtualMouseEntered(MouseEvent evt) {}
  

  private void tbPlayListAtualMouseClicked(MouseEvent evt)
  {
    Integer linha = Integer.valueOf(tbPlayListAtual.getSelectedRow());
    if (linha.intValue() > -1)
    {
      if (tempo.getStopFlag().booleanValue() == true)
      {
        lbTocandoAgora.setText(modeloMusicas.getMusica(linha.intValue()).getNome());
        lbAutor.setText(modeloMusicas.getMusica(linha.intValue()).getAutor());
      }
    }
    if (evt.getClickCount() == 2)
    {
      if (!lbTituloTocando.getText().equals("Playing:")) {
        btplayActionPerformed(null);
      }
      else {
        stop = Boolean.valueOf(true);
        tempo.setStopFlag(stop);
        player.close();
        btplayActionPerformed(null);
      }
    }
  }
  
  

  

  private void btProximaMusicaActionPerformed(ActionEvent evt)
  {
    if (tbPlayListAtual.getRowCount() > 0)
    {
      if (lbTituloTocando.getText().equals("Playing:"))
      {
        if (line.intValue() < tbPlayListAtual.getRowCount() - 1)
          player.close();
        btplay.setEnabled(false);
        btstop.setEnabled(true);
      }
    }
  }
  
  private void btAnteriorMusicaActionPerformed(ActionEvent evt) {
    if (tbPlayListAtual.getRowCount() > 0)
    {
      if (lbTituloTocando.getText().equals("Playing:"))
      {
        if (line.intValue() > 0)
        {
          Integer localInteger1 = line;Integer localInteger2 = this.line = Integer.valueOf(line.intValue() - 1);
          volta = Boolean.valueOf(true);
          player.close();
          btplay.setEnabled(false);
          btstop.setEnabled(true);
        }
      }
    }
  }

  private void btstopActionPerformed(ActionEvent evt) {
    if (tbPlayListAtual.getSelectedRow() == -1)
    {
      lbTocandoAgora.setText("");
      lbAutor.setText("Autor");
    }
    else
    {
      lbAutor.setText(modeloMusicas.getValueAt(tbPlayListAtual.getSelectedRow(), 1).toString());
      lbTocandoAgora.setText(modeloMusicas.getValueAt(tbPlayListAtual.getSelectedRow(), 0).toString());
    }
    stop = Boolean.valueOf(true);
    tempo.setStopFlag(stop);
    player.close();
    btplay.setEnabled(true);
    btstop.setEnabled(false);
    lbTituloTocando.setText("Cancion:");
  }
  
  private void btplayActionPerformed(ActionEvent evt)
  {
    final Integer linha = Integer.valueOf(tbPlayListAtual.getSelectedRow());
    if (linha.intValue() > -1) {
        new Thread() {
            public void run() {
                line = linha;
                stop = Boolean.valueOf(false);
                while ((!stop.booleanValue()) && (line.intValue() < modeloMusicas.getRowCount())) {
                    try {

                        
                        
                        
                        
                        
                        
                          player = new Player(new java.io.FileInputStream(new File(modeloMusicas.getMusica(line.intValue()).getPath())));

                          lbtempoDecorrido.setText(String.valueOf(player.getPosition()));
                          tempo = new Time(lbtempoDecorrido, player, modeloMusicas.getMusica(line.intValue()).getTempo(), slider1);

                          tempo.start();
                          tbPlayListAtual.setRowSelectionInterval(line.intValue(), line.intValue());
                          lbTituloTocando.setText("Playing:");
                          lbAutor.setText(modeloMusicas.getMusica(line.intValue()).getAutor());
                          lbTocandoAgora.setText(modeloMusicas.getMusica(line.intValue()).getNome());

                          player.play();
                          player.close();
                          tempo.setStopFlag(Boolean.valueOf(true));
                          Integer localInteger1;
                          if (volta.booleanValue()) {
                            volta = Boolean.valueOf(false);
                          } else {
                            localInteger1 = line;Integer localInteger2 = MainFrame.this.line = Integer.valueOf(line.intValue() + 1);
                          }
                          if (line.intValue() == modeloMusicas.getRowCount())
                          {
                            Integer linhaSelecionada = Integer.valueOf(tbPlayListAtual.getSelectedRow());
                            if (linhaSelecionada.intValue() > -1)
                            {
                              lbTituloTocando.setText("Cancion:");
                              lbAutor.setText(modeloMusicas.getMusica(tbPlayListAtual.getSelectedRow()).getAutor());
                              lbTocandoAgora.setText(modeloMusicas.getMusica(tbPlayListAtual.getSelectedRow()).getNome());
                            }
                            else
                            {
                              lbTituloTocando.setText("Cancion:");
                              lbAutor.setText("");
                              lbTocandoAgora.setText("");
                            }

                          }
            }
            catch (Exception ex)
            {
              System.out.println(ex.getMessage());
            }
          }
        }
      }.start();
      btplay.setEnabled(false);
      btstop.setEnabled(true);
    }
  }
  
  private void btpausaActionPerformed(ActionEvent evt){
    btplay.setEnabled(true);
    btstop.setEnabled(true);
    btPausa.setEnabled(false);
  }
  
  MusicModel modeloMusicas = new MusicModel();
  JFileChooser fc = new JFileChooser();
  JFileChooser jcSalvaLista = new JFileChooser();
  JFileChooser jcImportaLista = new JFileChooser();
  Player player;
  Boolean volta = Boolean.valueOf(false);
  Boolean stop = Boolean.valueOf(false);
  Time tempo = new Time();
  
  Integer line;
  
  javax.sound.sampled.FloatControl volCtrl;
  private JButton btAddmusica;
  private JButton btAnteriorMusica;
  
  public static void main(String[] args)
  {
 
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MainFrame().setVisible(true);
      }
    });
  }
  
  private JButton btProximaMusica;
  private JButton btRemoveMusica;
  private JButton btplay;
  private JButton btstop;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JPanel jPanel4;
  private JPanel jPanel5;
  private javax.swing.JScrollPane jScrollPane1;
  private JLabel lbAutor;
  private JLabel lbTituloTocando;
  private JLabel lbTocandoAgora;
  private JLabel lbtempoDecorrido;
  private JLabel lbtituloAutor;
  private JSlider slider1;
  private JTable tbPlayListAtual;
  private JButton btPausa;
}
