package graf;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Grup 3: Wikipedia
 * Usuari: aleix.paris
 * Data: 23/4/15
 */

public class GrafParser {
    public GrafParser(){}

    public GrafWikipedia parse(Path path){
        // TODO: quan estigui implementada Sessio.getGraf, no crear un nou graf
        GrafWikipedia g = new GrafWikipedia();
        try{
            List<String> l = Files.readAllLines(path, Charset.defaultCharset()); // canviar la implementacio, fitxers grans
            for(String s: l){
                parseLine(s);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return g;
    }

    private void parseLine(String s){
        String[] parts = s.split("\\t");
        System.out.println(parts[0]);
        System.out.println(parts[1]);
        System.out.println(parts[2]);
        System.out.println(parts[3]);
        System.out.println(parts[4]);
        System.out.println(parts[5]);
        /*
        Pattern p = Pattern.compile("");
        Matcher m = p.matcher(s);*/
    }
}
