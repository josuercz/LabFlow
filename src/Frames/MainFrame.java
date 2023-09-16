package Frames;

import Music.Music;
import TableModel.MusicModel;
import TimeLogic.Time;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javazoom.jl.player.Player;

public class MainFrame extends javax.swing.JFrame {
    private JButton btnNextSong;
    private JButton btnRemoveSong;
    private JButton btnPlay;
    private JButton btnStop;
    private JPanel PanelOpciones;
    private JPanel PanelPlayer;
    private JPanel PanelListaCanciones;
    private JPanel PanelSlider;
    private javax.swing.JScrollPane jScrollPane1;
    private JLabel lblAutor;
    private JLabel lblTituloCancion;
    private JLabel lblPlaying;
    private JLabel lblTiempoRecorrido;
    private JLabel lblTituloAutor;
    private JSlider slider1;
    private JTable tbPlayList;
    private JButton btnPausa;
    
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        tbPlayList.setModel(modeloMusica);
        setLayoutTabla();
        lblTituloCancion.setText("Cancion:");
        lblPlaying.setText("");
        lblAutor.setText("");
        slider1.setValue(0);
        btnStop.setEnabled(false);
        fileChooser.setMultiSelectionEnabled(true);
    }
  
    public void StopMusica() {}

    private void initComponents() {
        PanelOpciones = new JPanel();
        btAddMusic = new JButton();
        btnRemoveSong = new JButton();
        PanelPlayer = new JPanel();
        btnPlay = new JButton();
        btnStop = new JButton();
        PanelSlider = new JPanel();
        lblTituloCancion = new JLabel();
        lblPlaying = new JLabel();
        slider1 = new JSlider();
        lblTiempoRecorrido = new JLabel();
        lblTituloAutor = new JLabel();
        lblAutor = new JLabel();
        btnPreviousSong = new JButton();
        btnNextSong = new JButton();
        PanelListaCanciones = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPlayList = new JTable();
        btnPausa = new JButton();

        setDefaultCloseOperation(3);
        setTitle("Flow");
        setPreferredSize(new Dimension(1000,700));

        PanelOpciones.setBorder(BorderFactory.createTitledBorder(null, "Opciones", 0, 0, new Font("Arial", 1, 14)));
        PanelOpciones.setToolTipText("Opciones");
        PanelOpciones.setLayout(new java.awt.GridLayout(1, 0));

        btAddMusic.setFont(new Font("Arial", 1, 14));
        btAddMusic.setIcon(new ImageIcon(getClass().getResource("/Icons/AddSong.png")));
        btAddMusic.setText("Add");
        btAddMusic.setBackground(Color.white);
        btAddMusic.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainFrame.this.btAddMusicActionPerformed(evt);
          }
        });
        PanelOpciones.add(btAddMusic);

        btnRemoveSong.setFont(new Font("Arial", 1, 14));
        btnRemoveSong.setIcon(new ImageIcon(getClass().getResource("/Icons/DeleteSong.png")));
        btnRemoveSong.setText("Delete");
        btnRemoveSong.setBackground(Color.white);
        btnRemoveSong.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainFrame.this.btnRemoveSongActionPerformed(evt);
          }
        });
        PanelOpciones.add(btnRemoveSong);

        PanelPlayer.setBorder(BorderFactory.createTitledBorder(null, "Player", 0, 0, new Font("Arial", 1, 14)));
        PanelPlayer.setToolTipText("Reproduciendo");

        btnPlay.setFont(new Font("Arial", 1, 14));
        btnPlay.setIcon(new ImageIcon(getClass().getResource("/Icons/play.png")));
        btnPlay.setText("Play");
        btnPlay.setBackground(Color.white);
        btnPlay.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainFrame.this.btnPlayActionPerformed(evt);
          }

        });
        btnStop.setFont(new Font("Arial", 1, 14));
        btnStop.setIcon(new ImageIcon(getClass().getResource("/Icons/stop.png")));
        btnStop.setText("Stop");
        btnStop.setBackground(Color.white);
        btnStop.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainFrame.this.btnStopActionPerformed(evt);
          }

        });

        btnPausa.setFont(new Font("Arial",1,14));
        btnPausa.setIcon(new ImageIcon(getClass().getResource("/Icons/pausa.png")));
        btnPausa.setText("Pause");
        btnPausa.setBackground(Color.white);
        btnPausa.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainFrame.this.btpausaActionPerformed(evt);
          }

        });

        PanelSlider.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        PanelSlider.setBorder(BorderFactory.createEtchedBorder());

        lblTituloCancion.setFont(new Font("Arial", 1, 14));
        lblTituloCancion.setText("Playing:");

        lblPlaying.setFont(new Font("Arial", 1, 14));
        lblPlaying.setText("jLabel2");

        slider1.setBackground(new java.awt.Color(255, 255, 255));

        lblTiempoRecorrido.setText("00:00:00");

        lblTituloAutor.setFont(new Font("Arial", 1, 14));
        lblTituloAutor.setText("Autor:");

        lblAutor.setFont(new Font("Arial", 1, 14));
        lblAutor.setText("jLabel2");

        GroupLayout PanelSliderLayout = new GroupLayout(PanelSlider);
        PanelSlider.setLayout(PanelSliderLayout);
        PanelSliderLayout.setHorizontalGroup(PanelSliderLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(PanelSliderLayout.createSequentialGroup().addContainerGap().addGroup(PanelSliderLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(PanelSliderLayout.createSequentialGroup().addComponent(slider1, -2, 0, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lblTiempoRecorrido, -2, 54, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)).addGroup(PanelSliderLayout.createSequentialGroup().addGroup(PanelSliderLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, PanelSliderLayout.createSequentialGroup().addComponent(lblTituloAutor).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(lblAutor, -1, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, PanelSliderLayout.createSequentialGroup().addComponent(lblTituloCancion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(lblPlaying, -2, 350, -2))).addContainerGap(-1, 32767)))));

        PanelSliderLayout.setVerticalGroup(PanelSliderLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, PanelSliderLayout.createSequentialGroup().addContainerGap().addGroup(PanelSliderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblPlaying).addComponent(lblTituloCancion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(PanelSliderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblAutor).addComponent(lblTituloAutor)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, 32767).addGroup(PanelSliderLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(slider1, GroupLayout.Alignment.TRAILING, -2, 34, -2).addComponent(lblTiempoRecorrido, GroupLayout.Alignment.TRAILING, -2, 34, -2))));

        btnPreviousSong.setIcon(new ImageIcon(getClass().getResource("/Icons/anterior.png")));
        btnPreviousSong.setBackground(Color.white);
        btnPreviousSong.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainFrame.this.btnPreviousSongActionPerformed(evt);
          }

        });
        btnNextSong.setIcon(new ImageIcon(getClass().getResource("/Icons/siguiente.png")));
        btnNextSong.setBackground(Color.white);
        btnNextSong.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            MainFrame.this.btnNextSongActionPerformed(evt);
          }

        });

        GroupLayout PanelPlayerLayout = new GroupLayout(PanelPlayer);
        PanelPlayer.setLayout(PanelPlayerLayout);
        PanelPlayerLayout.setHorizontalGroup(PanelPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(PanelPlayerLayout.createSequentialGroup()
                    .addGroup(PanelPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(GroupLayout.Alignment.TRAILING, 
                                      PanelPlayerLayout.createSequentialGroup()
                                              .addComponent(btnPreviousSong, -2, 0, 32767)
                                              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                              .addComponent(btnNextSong, -2, 43, -2))
                            .addComponent(btnPlay, -1, 100, 32767)
                            .addComponent(btnStop, -1, -1, 32767)
                            .addComponent(btnPausa, -1, -1, 32767))                        
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)                
                    .addComponent(PanelSlider, -1, -1, 32767)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)));

        PanelPlayerLayout.setVerticalGroup(PanelPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(PanelPlayerLayout.createSequentialGroup()
                        .addGroup(PanelPlayerLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(PanelPlayerLayout.createSequentialGroup()
                                        .addComponent(btnPlay, -2, 36, -2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnStop, -2, 34, -2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPausa)
                                        .addGroup(
                                                PanelPlayerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnPreviousSong, -2, 24, 32767)
                                                        .addComponent(btnNextSong, -2, 0, 32767))))
                        .addGap(0, 0, 32767))
                .addGroup(PanelPlayerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelSlider, -2, -1, -2)
                        .addContainerGap(-1, 32767)));

        PanelListaCanciones.setBorder(BorderFactory.createTitledBorder(null, "Canciones", 0, 0, new Font("Arial", 1, 14)));

        tbPlayList.setAutoCreateRowSorter(true);
        tbPlayList.setBorder(BorderFactory.createEtchedBorder());
        tbPlayList.setFont(new Font("Arial", 1, 14));
        tbPlayList.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
        tbPlayList.setAutoResizeMode(4);
        tbPlayList.setSelectionMode(0);
        tbPlayList.addMouseListener(new java.awt.event.MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            MainFrame.this.tbPlayListMouseClicked(evt);
          }

          public void mouseEntered(MouseEvent evt) { MainFrame.this.tbPlayListMouseEntered(evt);
          }
        });
        jScrollPane1.setViewportView(tbPlayList);

        GroupLayout PanelListaCancionesLayout = new GroupLayout(PanelListaCanciones);
        PanelListaCanciones.setLayout(PanelListaCancionesLayout);
        PanelListaCancionesLayout.setHorizontalGroup(PanelListaCancionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, -2, 0, 32767));

        PanelListaCancionesLayout.setVerticalGroup(PanelListaCancionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(PanelListaCancionesLayout.createSequentialGroup().addComponent(jScrollPane1, -1, 172, 32767).addGap(18, 18, 18)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(PanelOpciones, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(PanelListaCanciones, -1, -1, 32767).addComponent(PanelPlayer, -1, -1, 32767)).addContainerGap()));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(PanelPlayer, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(PanelOpciones, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(PanelListaCanciones, -1, -1, 32767).addGap(16, 16, 16)));

        pack();
    }

    public void setLayoutTabla()  {
        tbPlayList.getColumnModel().getColumn(0).setPreferredWidth(350);
        tbPlayList.getColumnModel().getColumn(1).setPreferredWidth(250);
        tbPlayList.getColumnModel().getColumn(2).setPreferredWidth(250);
        tbPlayList.setRowSorter(null);
    }
  

    private void btAddMusicActionPerformed(ActionEvent evt) {
        if (fileChooser.showOpenDialog(PanelOpciones) == 0) {
            try {
                File[] files = fileChooser.getSelectedFiles();

                for (int i = 0; i < files.length; i++) {
                    javax.sound.sampled.AudioFileFormat baseFileFormat = javax.sound.sampled.AudioSystem.getAudioFileFormat(files[i]);

                    if ((baseFileFormat instanceof org.tritonus.share.sampled.file.TAudioFileFormat)) {
                        Music musica = new Music();

                        Map properties = ((org.tritonus.share.sampled.file.TAudioFileFormat)baseFileFormat).properties();
                        String key = "title";
                        String val = (String)properties.get(key);

                        musica.setNombre(val);

                        key = "author";
                        val = (String)properties.get(key);
                        musica.setAutor(val);

                        key = "album";
                        val = (String)properties.get(key);
                        musica.setAlbum(val);

                        key = "duration";
                        Long valLong = (Long)properties.get(key);
                        musica.setTiempo(Long.valueOf(valLong.longValue() / 1000000L));

                        musica.setPath(files[i].getAbsolutePath());

                        modeloMusica.addMusica(musica);
                    }
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
  
    private void btnRemoveSongActionPerformed(ActionEvent evt) {
        Integer linea = Integer.valueOf(tbPlayList.getSelectedRow());
        if (linea.intValue() > -1) {
            if ((lblPlaying.getText().equals(modeloMusica.getMusica(linea.intValue()).getNombre().toString())) && (lblTituloCancion.getText().equals("Playing:"))) {
                stop = Boolean.valueOf(true);
                tiempo.setStopFlag(Boolean.valueOf(true));
                btnStop.setEnabled(false);
                player.close();
                btnPlay.setEnabled(true);

                lblTituloCancion.setText("Cancion:");
                lblAutor.setText("Autor");
                lblPlaying.setText("");
            }
          modeloMusica.removeMusic(linea.intValue());
        }
        else {
            JOptionPane.showMessageDialog(null, "Seleccionar una cancion primero");
        }
    }

    private void tbPlayListMouseEntered(MouseEvent evt) {}
  
    private void tbPlayListMouseClicked(MouseEvent evt) {
        Integer linea = Integer.valueOf(tbPlayList.getSelectedRow());
        if (linea.intValue() > -1) {
            if (tiempo.getStopFlag().booleanValue() == true)  {
                lblPlaying.setText(modeloMusica.getMusica(linea.intValue()).getNombre());
                lblAutor.setText(modeloMusica.getMusica(linea.intValue()).getAutor());
            }
        }
        if (evt.getClickCount() == 2) {
            if (!lblTituloCancion.getText().equals("Playing:")) {
                btnPlayActionPerformed(null);
            }
            else {
                stop = Boolean.valueOf(true);
                tiempo.setStopFlag(stop);
                player.close();
                btnPlayActionPerformed(null);
            }
        }
    }
  
    private void btnNextSongActionPerformed(ActionEvent evt) {
        if (tbPlayList.getRowCount() > 0)  {
            if (lblTituloCancion.getText().equals("Playing:")) {
                if (line.intValue() < tbPlayList.getRowCount() - 1)
                    player.close();
                btnPlay.setEnabled(false);
                btnStop.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Reproducir la cancion primero");
            }                   
        }
    }
  
    private void btnPreviousSongActionPerformed(ActionEvent evt) {
        if (tbPlayList.getRowCount() > 0) {
            if (lblTituloCancion.getText().equals("Playing:")) {
                if (line.intValue() > 0) {
                    Integer localInteger1 = line;Integer localInteger2 = this.line = Integer.valueOf(line.intValue() - 1);
                    devolver = Boolean.valueOf(true);
                    player.close();
                    btnPlay.setEnabled(false);
                    btnStop.setEnabled(true);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Reproducir la cancion primero");
            }
        }
    }

    private void btnStopActionPerformed(ActionEvent evt) {
        if (tbPlayList.getSelectedRow() == -1) {
            lblPlaying.setText("");
            lblAutor.setText("Autor");
        } else {
            lblAutor.setText(modeloMusica.getValueAt(tbPlayList.getSelectedRow(), 1).toString());
            lblPlaying.setText(modeloMusica.getValueAt(tbPlayList.getSelectedRow(), 0).toString());
        }
        stop = Boolean.valueOf(true);
        tiempo.setStopFlag(stop);
        player.close();
        btnPlay.setEnabled(true);
        btnStop.setEnabled(false);
        lblTituloCancion.setText("Cancion:");
    }
  
  private void btnPlayActionPerformed(ActionEvent evt)
  {
    final Integer linea = Integer.valueOf(tbPlayList.getSelectedRow());
    if (linea.intValue() > -1)
    {

      new Thread()
      {
        public void run()
        {
          line = linea;
          stop = Boolean.valueOf(false);
          while ((!stop.booleanValue()) && (line.intValue() < modeloMusica.getRowCount())) {
            try
            {
              player = new Player(new java.io.FileInputStream(new File(modeloMusica.getMusica(line.intValue()).getPath())));
              
              lblTiempoRecorrido.setText(String.valueOf(player.getPosition()));
              tiempo = new Time(lblTiempoRecorrido, player, modeloMusica.getMusica(line.intValue()).getTiempo(), slider1);
              
              tiempo.start();
              tbPlayList.setRowSelectionInterval(line.intValue(), line.intValue());
              lblTituloCancion.setText("Playing:");
              lblAutor.setText(modeloMusica.getMusica(line.intValue()).getAutor());
              lblPlaying.setText(modeloMusica.getMusica(line.intValue()).getNombre());
              
              player.play();
              player.close();
              tiempo.setStopFlag(Boolean.valueOf(true));
              Integer localInteger1;
              if (devolver.booleanValue()) {
                devolver = Boolean.valueOf(false);
              } else {
                localInteger1 = line;Integer localInteger2 = MainFrame.this.line = Integer.valueOf(line.intValue() + 1);
              }
              if (line.intValue() == modeloMusica.getRowCount())
              {
                Integer lineaSelecionada = Integer.valueOf(tbPlayList.getSelectedRow());
                if (lineaSelecionada.intValue() > -1)
                {
                  lblTituloCancion.setText("Cancion:");
                  lblAutor.setText(modeloMusica.getMusica(tbPlayList.getSelectedRow()).getAutor());
                  lblPlaying.setText(modeloMusica.getMusica(tbPlayList.getSelectedRow()).getNombre());
                }
                else
                {
                  lblTituloCancion.setText("Cancion:");
                  lblAutor.setText("");
                  lblPlaying.setText("");
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
      btnPlay.setEnabled(false);
      btnStop.setEnabled(true);
      btnPausa.setEnabled(true);
    }
  }

  
  private void btpausaActionPerformed(ActionEvent evt){
      btnPlay.setEnabled(true);
      btnPausa.setEnabled(false);
  }
  
  MusicModel modeloMusica = new MusicModel();
  JFileChooser fileChooser = new JFileChooser();
  Player player;
  Boolean devolver = Boolean.valueOf(false);
  Boolean stop = Boolean.valueOf(false);
  Time tiempo = new Time();
  Integer line;
  private JButton btAddMusic;
  private JButton btnPreviousSong;
  

}
