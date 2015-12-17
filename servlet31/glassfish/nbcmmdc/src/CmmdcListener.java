import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.PrintWriter;

public class CmmdcListener implements ReadListener {

  private ServletInputStream input = null;
  private AsyncContext context = null;
  private PrintWriter out = null;
  
  public CmmdcListener(ServletInputStream in, AsyncContext ac, PrintWriter output) {
    input = in;
    context = ac;
    out = output;
  }

  @Override
  public void onDataAvailable() {
    try {
      int len = -1;
      byte b[] = new byte[1024];
      while (input.isReady() && (len = input.read(b)) != -1) {
        String data = new String(b, 0, len);
        out.write(data);
        out.write("<p>");
        String rez=solver(data);
        out.write(rez);
      }
    } 
    catch (IOException e) {
      System.out.println("onAvailableException : "+e.getMessage());
    }
  }

  @Override
  public void onAllDataRead() {
    System.out.println("onAllDataRead");
    context.complete();
  }

  @Override
  public void onError(Throwable t) {
    t.printStackTrace();
    context.complete();
  }
  
  private String solver(String data){
    String[] s=data.split("&");
    String[] s0=s[0].split("=");
    long m=Long.parseLong(s0[1]);
    String[] s1=s[1].split("=");
    long n=Long.parseLong(s1[1]);
    String r=(new Long(cmmdc(m,n))).toString();
    return "Cmmdc : "+r;
  }
  
  private long cmmdc(long m, long n){
     long r,c;
     do{
        c=n;
        r=m%n;
        m=n;
        n=r;
     }while(r!=0);
     return c;
  }   
}
