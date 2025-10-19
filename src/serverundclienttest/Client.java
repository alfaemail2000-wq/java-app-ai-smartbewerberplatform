package serverundclienttest;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


//Das ist ein Client um die Bewerber Daten von API von backend server bekommen zu können und nutzen im frontend.


public class Client {
    public static void main(String[] args)throws IOException {
        Socket verbindung=new Socket("localhost", 6767);
        BufferedReader leser=new BufferedReader(new InputStreamReader(verbindung.getInputStream()));

        System.out.println("Was sagst du zu diese Urhzeit?");
        System.out.println("Server sagt: " + leser.readLine());

        Scanner tastaturLeser=new Scanner(System.in);
        String meinunDesUsers=tastaturLeser.nextLine();

        BufferedWriter schreiber=new BufferedWriter(new OutputStreamWriter((verbindung.getOutputStream())));
        schreiber.write(meinunDesUsers);
        schreiber.newLine();;
        schreiber.flush();
    }
}
