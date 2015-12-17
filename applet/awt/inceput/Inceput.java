import java.awt.*;
import java.applet.*;

public class Inceput extends Applet{
  public void init(){}

  public void paint(Graphics g){
    String name=getParameter("nume");
    g.drawString("Hello "+name+" !!", 50, 60 );
  }
}