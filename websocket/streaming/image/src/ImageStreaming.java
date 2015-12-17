import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;  
import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.EncodeException;
import java.io.IOException;
import java.io.OutputStream;
//import java.io.File;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
//import java.awt.image.BufferedImage;
//import javax.imageio.ImageIO;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

@ServerEndpoint(value="/image")
public class ImageStreaming{
  private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
  
  @OnMessage
  public void myTask(String msg,Session session) 
      throws IOException,EncodeException{
    String fs=System.getProperty("file.separator");
    // apache-tomcat
    /*
    String pathTomcat = new java.io.File(".").getCanonicalPath();
    String path=Paths.get(pathTomcat).toString()+
      fs+"webapps"+fs+"ImageStreaming"+
      fs+"WEB-INF"+fs+"images"+fs;
    */
    // glassfish
    /*
    String pathGlassfish0 = new java.io.File(".").getCanonicalPath();
    int x=pathGlassfish0.lastIndexOf(fs);
    String pathGlassfish=pathGlassfish0.substring(0,x);
    String path=Paths.get(pathGlassfish).toString()+
      fs+"applications"+fs+"ImageStreaming"+
      fs+"WEB-INF"+fs+"images"+fs;
    */
    String pathServer=new java.io.File(".").getCanonicalPath();
    int x=pathServer.indexOf("glassfish");
    String path="";
    String path0=fs+"ImageStreaming"+
        fs+"WEB-INF"+fs+"images"+fs;
    if(x==-1){
      // apache-tomcat
      path=Paths.get(pathServer).toString()+
      fs+"webapps"+path0;
    }  
    else{
      // glassfish
      x=pathServer.lastIndexOf(fs);
      String pathGlassfish=pathServer.substring(0,x);
      path=Paths.get(pathGlassfish).toString()+
        fs+"applications"+path0;
    }    
    int noFile=Integer.parseInt(msg);
    String fileName="";
    switch(noFile){
    case 1:
      fileName="brasov.jpg";
      break;
    case 2:  
      fileName="xml-pic.jpg"; 
      break;
    }  
    System.out.println(path+fileName);
    /*
    File file=new File(path+fileName);  
    BufferedImage bi=ImageIO.read(file);
    */
    Path cale=Paths.get(path+fileName);
    for (Session peer : sessions) {
      if(peer.equals(session)){
        OutputStream out=peer.getBasicRemote().getSendStream();
        //ImageIO.write(bi,"jpg",out);
        //out.flush();
        Files.copy(cale,out);
        out.close();
      }
    }              
  }
  
  @OnOpen
  public void onOpen(Session session){
    sessions.add(session);
  }
     
  @OnClose
  public void onClose(Session session){
    sessions.remove(session);
  }
}
