package domini.controladors;

import domini.controladors.graf.grafgenerator.Criteris.Criteri;
import domini.controladors.graf.grafgenerator.GrafGenerator;
import domini.modeldades.ConjuntComunitatWiki;
import domini.modeldades.InformacioCjtComunitats;
import domini.modeldades.TipusAlgorisme;
import domini.modeldades.graf.GrafWikipedia;
import domini.modeldades.graf.NodeCategoria;
import prop.classescompartides.algorismes.AlgorismeLouvain;
import prop.classescompartides.algorismes.CtrlGirvanBron;
import prop.classescompartides.algorismes.grupclique.CtrlAlgoritmoClique;
import prop.classescompartides.graf.Algoritme;
import prop.classescompartides.graf.Graf;

import java.util.ArrayList;

/**
 * Grup 3: Wikipedia
 * Usuari: aleix.paris
 * Data: 02/05/2015
 */


/**
 * Controlador d'Algorisme
 */


public class CtrlAlgorisme{
    private GrafWikipedia grafWikipedia;
    private TipusAlgorisme tipusAlgorisme;
    private double par1;
    private ArrayList<Criteri> criteris;
    private ConjuntComunitatWiki conjunt;
    private Graf<NodeCategoria> grafGenerat;
    private InformacioCjtComunitats infoExecucio;

    /**
     * Constructora per defecte de la classe
     * @param grafWikipedia    .
     * @param tipusAlgorisme  .
     * @param par1           .
     * @param criteris      .
     */
    public CtrlAlgorisme(GrafWikipedia grafWikipedia, TipusAlgorisme tipusAlgorisme, double par1, ArrayList<Criteri> criteris){
        this.grafWikipedia = grafWikipedia;
        this.tipusAlgorisme = tipusAlgorisme;
        this.par1 = par1;
        this.criteris = criteris;
        this.conjunt = new ConjuntComunitatWiki();
        grafGenerat = new Graf<NodeCategoria>();
    }

    /**
     * Es genera un graf no dirigit segons els definits criteris i parametres que s'han determinat en la constructora
     */
    public void generarGraf() {
        //System.err.println("Algoritme triat: " + String.valueOf(tipusAlgorisme));
        //System.err.println("Aplicant criteris...");
        long startTime = System.currentTimeMillis();
        GrafGenerator generator = new GrafGenerator();
        grafGenerat = generator.generate(grafWikipedia, criteris);
        long generatorTime = System.currentTimeMillis() - startTime;
        //System.err.println("Temps en aplicar criteris: " + String.valueOf(generatorTime) + "ms");


        infoExecucio = new InformacioCjtComunitats(generatorTime, tipusAlgorisme, criteris.toString());
    }

    /**
     * Cerca comunitats en un graf no dirigit previament generat mitjan�ant un algorisme previament definit
     * @return un conjunt de comunitats trobades en el graf
     */
    public ConjuntComunitatWiki cercarComunitats() throws Exception {
        long startTime = System.currentTimeMillis();
        Algoritme<NodeCategoria> algorisme;
        if (tipusAlgorisme == TipusAlgorisme.LOUVAIN) {
            algorisme = new AlgorismeLouvain<>();
        } else if (tipusAlgorisme == TipusAlgorisme.GIRVAN) {
            algorisme = new CtrlGirvanBron<>();
        } else { // Clique
            algorisme = new CtrlAlgoritmoClique<>();
        }

        //System.err.println("Cercant comunitats...");
        conjunt.setCjtComunitats(algorisme.cercarComunitats(grafGenerat, par1));
        int nComunitats = conjunt.getCjtComunitats().getNumComunitats();
        //System.err.println("Nombre de comunitats generades: " + String.valueOf(nComunitats));
        infoExecucio.setNombreComunitats(nComunitats);
        infoExecucio.setMitjanaNodesPerComunitat(grafGenerat.ordre() / (double) conjunt.getCjtComunitats().getNumComunitats());
        long elapsedTime = System.currentTimeMillis() - startTime;
        //System.err.println("Temps en cercar: " + String.valueOf(elapsedTime) + "ms");

        infoExecucio.setTempsComunitats(elapsedTime);
        CtrlComunitat.getInstance().afegirComunitatsGenerades(conjunt);
        CtrlWikipedia.getInstance().afegirInfoExecucio(infoExecucio);

        return conjunt;
    }

}
