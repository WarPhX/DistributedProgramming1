import java.net.*;
import java.io.*;

public class  ReadHTTPAuth{
  public static void main(String[] args){
    try{
      String adr="http://localhost:8080/url/Hello.html";
      final String username = "digest";
      final String password = "digest";
      URL url=new URL(adr);
      Authenticator.setDefault(new Authenticator(){
        @Override
        protected PasswordAuthentication getPasswordAuthentication(){
          return new PasswordAuthentication(username,password.toCharArray());
        }
      }); 
      InputStream in=url.openStream();
      InputStreamReader isr=new InputStreamReader(in);
      BufferedReader br=new BufferedReader(isr);
      String s;
      do{
        s=br.readLine();
        if(s!=null)
          System.out.println(s);
      }
      while(s!=null);
      br.close();
      isr.close();
      in.close();
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}
