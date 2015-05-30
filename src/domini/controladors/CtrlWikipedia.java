package domini.controladors;

import domini.modeldades.graf.GrafWikipedia;
import domini.modeldades.graf.NodeCategoria;
import domini.modeldades.graf.NodePagina;
import persistencia.GrafParser;
import prop.classescompartides.graf.ConjuntComunitats;
import prop.classescompartides.graf.Graf;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Grup 3: Wikipedia
 * Usuari: ricard.gascons
 * Data: 22/3/15
 */

/**
 * CtrlWikipedia de la Wikipedia // TODO: superdefinicion
 */

public class CtrlWikipedia implements Serializable{
    // TODO: jo li diria ctrlSessio a aquesta classe ja que te tots els canvis que es realitzen.
    private static CtrlWikipedia INSTANCE;

    private String dataCreacio;
    private GrafWikipedia grafWiki;
    private Graf<NodeCategoria> grafAlgoritme;
    private ConjuntComunitats<NodeCategoria> conjuntsGenerats;

    private CtrlWikipedia() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataCreacio = new Date();
        this.dataCreacio = dateFormat.format(dataCreacio);
        grafWiki = new GrafWikipedia();
        grafAlgoritme = new Graf<>();

    }

    /**
     * /**
     * Retorna una instancia de CtrlWikipedia
     * @return una instancia de CtrlWikipedia
     */
    public static CtrlWikipedia getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CtrlWikipedia();
        }
        return INSTANCE;
    }

    public static void setInstance(CtrlWikipedia instance) {
        CtrlWikipedia.INSTANCE = instance;
    }

    /**
     * Retorna la data de creació de la sessió
     * @return la data de creació de la sessió
     */
    public String getDataCreacio() {
        return dataCreacio;
    }


    /**
     * Retorna el Graf de la Wikipedia
     * @return el graf de la Wikipedia
     */
    public GrafWikipedia getGrafWiki() {
        return grafWiki;
    }

    public void setGrafWiki(GrafWikipedia grafWiki) {
        this.grafWiki = grafWiki;
    }

    /**
     * Retorna el graf de categories pels algorismes
     * @return el graf de categories pels algorismes
     */
    //TODO: probablement ja no fa falta aqui, crec que te mes sentit a CtrlAlgorisme
    public Graf<NodeCategoria> getGrafAlgoritme() {
        return grafAlgoritme;
    }

    public void setGrafAlgoritme(Graf<NodeCategoria> grafAlgoritme) {
        this.grafAlgoritme = grafAlgoritme;
    }

    /**
     * Cas d'us Importar Fitxer
     */
    public void getGrafWikiFromFile(String path) throws IOException {


        GrafParser.parse(path, grafWiki);

        System.out.println(grafWiki);
        //TODO: faltaria guardar el nou graf (o subgraf) importat en el nostre format. No se si s'hauria de fer aqui o a CtrlSessio
    }

    /**
     * Cas d'us Afegir Categoria
     */
    public void afegirCat(String nom){
        NodeCategoria nodeC = new NodeCategoria(nom);
        grafWiki.afegirCategoria(nodeC);
    }

    /**
     * Cas d'us Afegir Pagina
     */
    public void afegirPag(String nom){
        NodePagina nodeC = new NodePagina(nom);
        grafWiki.afegirPagina(nodeC);
    }

    /**
     * Cas d'us Eliminar Categoria
     */
    public void elimCat(String nom){
        grafWiki.eliminarCategoria(grafWiki.getNodeCat(nom));
    }

    /**
     * Cas d'us Eliminar Pagina
     */
    public void elimPag(String nom){
        grafWiki.eliminarPagina(grafWiki.getNodePag(nom));
    }


    public ConjuntComunitats<NodeCategoria> getConjuntsGenerats() {
        return conjuntsGenerats;
    }

    public void setConjuntsGenerats(ConjuntComunitats<NodeCategoria> conjuntsGenerats) {
        this.conjuntsGenerats = conjuntsGenerats;
    }

    @Override
    public String toString() {
        return "CtrlWikipedia{" +'\n' +
                "dataCreacio='" + dataCreacio + '\n' +
                ", grafWiki=" + grafWiki +'\n' +
                ", grafAlgoritme=" + grafAlgoritme +'\n' +
                ", conjuntsGenerats=" + conjuntsGenerats +'\n' +
                '}';
    }
}