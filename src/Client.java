package src;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.net.*;

public class Client {
   public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 4545);
            while(true){
                
            //Mandar msg de volta
            Scanner scan = new Scanner(System.in);
            scan.reset();
            System.out.println("Digite: num1,num2,(operacao) ou exit para sair\n Favor, escrever sem acentuação");
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            String strr = scan.nextLine();
            out.writeObject(new String(strr));
            out.flush();

            
            
            //ler mensagem
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            String str = (String)in.readObject();
            System.out.println(str);
            
        
        }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        
    }
}