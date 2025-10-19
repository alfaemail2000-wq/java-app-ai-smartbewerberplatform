package serverundclienttest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

//Das ist ein Server um Daten an dritservice aus Backend per API in json absenden z.B. Alle bewerber


public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket lauscherAufPort=new ServerSocket(6767);

        while(true){
            Socket verbindung=lauscherAufPort.accept();
            System.out.println("client verbunden: "+verbindung.getPort()+verbindung.getInetAddress());
            InputStream inputStream=verbindung.getInputStream();
            OutputStream outputStream=verbindung.getOutputStream();

            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
            BufferedWriter schreib = new BufferedWriter(outputStreamWriter);

            schreib.write("Hier bin ich Server "+ LocalTime.now()+"Uhr");
            schreib.newLine();
            schreib.flush();
            System.out.println("Der client hat die wichtige infors bekommen");

            BufferedReader leser=new BufferedReader((new InputStreamReader(verbindung.getInputStream())));
            String inforVormClienet= leser.readLine();
            System.out.println("Der Client schreibt: "+inforVormClienet);


        }



    }
}
