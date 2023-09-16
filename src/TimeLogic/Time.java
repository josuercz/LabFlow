package TimeLogic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javazoom.jl.player.Player;

public class Time extends Thread {
  JLabel lblTiempo;
  Player player;
  Long duration;
  JSlider slider;
  Boolean stopFlag;
  
  public Boolean getStopFlag()
  {
    return stopFlag;
  }
  
  public void setStopFlag(Boolean stopFlag) {
    this.stopFlag = stopFlag;
  }
  
  public Time(Boolean stopFlag) {
    this.stopFlag = stopFlag;
  }
  
  public Time()
  {
    stopFlag = Boolean.valueOf(true);
  }
  
  public Time(JLabel tiempo, Player player, Long duration, JSlider slider)
  {
    lblTiempo = tiempo;
    this.player = player;
    this.duration = duration;
    this.slider = slider;
    stopFlag = Boolean.valueOf(false);
  }

  public void run()
  {
    SimpleDateFormat dt = new SimpleDateFormat("HH:mm:ss");
    Calendar cad = Calendar.getInstance();
    cad.clear();
    Date data = new Date(cad.getTime().getTime());

    slider.setMaximum(duration.intValue());
    while (!stopFlag.booleanValue())
    {
      System.out.println(stopFlag);
      cad.clear();
      Integer value = Integer.valueOf(player.getPosition() / 1000);
      cad.add(13, value.intValue());
      slider.setValue(value.intValue());
      data.setTime(cad.getTime().getTime());
      lblTiempo.setText(dt.format(data));
      
      try
      {
        Thread.sleep(200L);
      } catch (Exception ex) {} }
    System.out.println(stopFlag);
    slider.setValue(0);
    lblTiempo.setText("00:00:00");
  }
}
