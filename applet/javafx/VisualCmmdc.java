import java.awt.Container;
import javax.swing.JApplet;
import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.paint.Color; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class VisualCmmdc extends JApplet{
  static private TextField tm,tn,rez;
 
  public void init() {
    Container content = getContentPane();
    final JFXPanel fxPanel = new JFXPanel();
    content.add(fxPanel);
    content.setVisible(true);
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        initFX(fxPanel);
      }
    });
  }  
  
  private static void initFX(JFXPanel fxPanel) {          
    Group root = new Group(); 
    Scene scene = new Scene(root, 600, 250, Color.LIGHTGREEN); 
    fxPanel.setScene(scene);
    GridPane gridPane = new GridPane();
		
    Label mLabel = new Label("Primul numar");
    gridPane.add(mLabel, 1, 1); // column=1 row=1
    tm=new TextField();
    gridPane.add(tm,2,1);
    
    Label nLabel = new Label("Al doilea numar");
    gridPane.add(nLabel, 1, 2); // column=1 row=1
    tn=new TextField();
    gridPane.add(tn,2,2);
    
    Button button = new Button("Calculeaza");
    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
        public void handle(ActionEvent e) {
        String sm = tm.getText();
        String sn = tn.getText();
        long m=Long.parseLong(sm);
        long n=Long.parseLong(sn);
        long r=cmmdc(m,n);
        rez.setText((new Long(r)).toString());
      }
    });
    gridPane.add(button, 1, 3);
		
    rez = new TextField();
    gridPane.add(rez, 2, 3);
    root.getChildren().add(gridPane);
    fxPanel.setScene(scene);
  }

  static long cmmdc(long m, long n){
    long c,r;
    do{
      c=n;
      r=m % n;
      m=n;
      n=r;
    }
    while (r!=0);
    return c;
  }
}
