import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Feladat1 {
    ArrayList<Jarmu> jarmuLista = new ArrayList<>();
    ArrayList<Jarmu> opelLista = new ArrayList<>();
    public void readFile(){
        try {
            tryReadFile();
        } catch (FileNotFoundException e) {
            System.err.println("A fájl nem található: "+ e);
        }
    }

    public void tryReadFile()throws FileNotFoundException{
        File file = new File("jarmuvek_opel.csv");
        Scanner sc = new Scanner(file);
        String firstLine=sc.nextLine();
        while (sc.hasNextLine()) {
            String line=sc.nextLine();
            String[] splitLine=line.split(":");
            Jarmu jarmu = new Jarmu();
            jarmu.id=Integer.parseInt(splitLine[0]);
            jarmu.rendszam=splitLine[1];
            jarmu.marka=splitLine[2];
            jarmu.urtartalom=Integer.parseInt(splitLine[3]);
            jarmu.ar=Double.parseDouble(splitLine[4]);
            jarmuLista.add(jarmu);
        }
        sc.close();
    }
    public void kivonat(){
        for(Jarmu jarmu: jarmuLista){
            if (jarmu.marka.equals("Opel")) {
                opelLista.add(jarmu);
            }
        }
    }
    public void write(){
        try {
            tryWrite();
        } catch (IOException e) {
            System.err.println("A fájl nem található: "+ e);
        }
    }
    public void tryWrite()throws IOException{
        FileWriter fw = new FileWriter("onlyopel.csv");
        for(Jarmu jarmu : opelLista){
            fw.write(jarmu.id.toString());
            fw.write(":");
            fw.write(jarmu.rendszam);
            fw.write(":");
            fw.write(jarmu.marka);
            fw.write(":");
            fw.write(jarmu.urtartalom.toString());
            fw.write(":");
            fw.write(jarmu.ar.toString());
            fw.write("\n");
        }
        fw.close();
    }
}
