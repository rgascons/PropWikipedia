package domini;

/**
 * Grup 3: Wikipedia
 * Usuari: ricard.gascons
 * Data: 15/4/15
 */

import graf.GrafWikipedia;
import graf.NodeWiki;

import java.text.*;
import java.util.*;

public class Cerca {

    private Cerca() {

    }

    public static InfoCerca cercarWikipediaP (GrafWikipedia g, String query) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return new InfoCerca(cercarPagina(g, query), dateFormat.format(date));
    }

    public static InfoCerca cercarWikipediaC (GrafWikipedia g, String query) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return new InfoCerca(cercaCategoria(g, query), dateFormat.format(date));
    }

    private static NodeWiki cercaCategoria (GrafWikipedia g, String query) throws Exception {
        int size = query.length();
        Set<NodeWiki> s = g.getNodes();
        for (NodeWiki n : s) {
            if (n.esCategoria()) {
                if (LevenshteinDistance.calculate(query, n.getNom()) == 0) return n;
            }
        }
        throw new Exception("No s'ha trobat cap resultat");
    }

    private static NodeWiki cercarPagina (GrafWikipedia g, String query) throws Exception {
        int size = query.length();
        Set<NodeWiki> s = g.getNodes();
        for (NodeWiki n : s) {
            if (!n.esCategoria()) {
                if (LevenshteinDistance.calculate(query, n.getNom()) == 0) return n;
            }
        }
        throw new Exception("No s'ha trobat cap resultat");
    }
}