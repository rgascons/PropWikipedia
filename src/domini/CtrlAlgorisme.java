package domini;

import graf.GrafWikipedia;
import graf.NodeCategoria;
import graf.grafgenerator.Criteris.Criteri;
import graf.grafgenerator.GrafGenerator;
import org.grupwiki.graf.Algoritme;
import org.grupwiki.graf.ConjuntComunitats;
import org.grupwiki.graf.Graf;

import java.util.ArrayList;

/**
 * Grup 3: Wikipedia
 * Usuari: aleix.paris
 * Data: 02/05/2015
 */

public class CtrlAlgorisme{
    GrafWikipedia grafWikipedia;
    String tipusAlgorisme; // "Louvain", "Girvan", "Clique"
    int par1, par2;
    ArrayList<Criteri> criteris;

    public CtrlAlgorisme(GrafWikipedia grafWikipedia, String tipusAlgorisme, int par1, int par2, ArrayList<Criteri> criteris){
        this.grafWikipedia = grafWikipedia;
        this.tipusAlgorisme = tipusAlgorisme;
        this.par1 = par1;
        this.par2 = par2;
        this.criteris = criteris;
    }

    public ConjuntComunitats<NodeCategoria> cercarComunitats(){
        Algoritme<NodeCategoria> algorisme;

        if(tipusAlgorisme.equals("Louvain")) {
            algorisme = new AlgorismeLouvain<NodeCategoria>();
        }
        else if(tipusAlgorisme.equals("Girvan")){
            algorisme = new AlgorismeGirvan<NodeCategoria>();
        }
        else{ // Clique
            algorisme = new AlgorismeClique<NodeCategoria>();
        }

        GrafGenerator generator = new GrafGenerator();
        Graf<NodeCategoria> graf = generator.generate(grafWikipedia, criteris);
        ConjuntComunitats<NodeCategoria> comunitats = algorisme.cercarComunitats(graf, par1,par2);
        return comunitats;
    }

}