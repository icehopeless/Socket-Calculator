package src;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;


public class Server{
    
    private int num1,num2;
    private static String operation;
    public static void main(String[] args) {
        try {
            
            System.out.println("Server On\nListening in port 4545");
            ServerSocket server = new ServerSocket(4545);
            Server sv = new Server();

            while(true){
                
                Socket client = server.accept();
                //receber mensagem
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());
                String str = (String)in.readObject();
                sv.StringReceived(str);
                System.out.println(str);
        
            
                
                if(str.equals("exit")){
                    in.close();
                    client.close();
                    server.close();
                }


                //mandar msg...
                ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                out.writeObject(new String(sv.StringReceived(str)));
                out.flush();  
                     
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }

    public String StringReceived(String str){
        String[] strr = str.split(",");
        
        num1 =  Integer.parseInt(strr[0]);
        num2 =  Integer.parseInt(strr[1]);
        operation = strr[2];
        
        
        if(operation.equals("soma")){
            return soma();
        }
        if(operation.equals("subtracao")){
            return subtr();
        }
        if(operation.equals("divisao")){
            return divis();
        }
        if(operation.equals("produto")){
            return produt();
        }
        return "";
    }
    public String soma(){
        int result =  num1+num2;
        return result + "";
    }
    public String subtr(){
        int result =  num1-num2;
        return result + "";
    }
    public String divis(){
        int result =  num1/num2;
        return result + "";
    }
    public String produt(){
        int result =  num1*num2;
        return result + "";
    }       
}