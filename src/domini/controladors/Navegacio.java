package domini.controladors;

import domini.modeldades.graf.GrafWikipedia;
import domini.modeldades.graf.NodeCategoria;
import domini.modeldades.graf.NodePagina;
import prop.classescompartides.graf.Arc;
import prop.classescompartides.graf.Graf;

import java.util.ArrayList;

/**
 * Grup 3: Wikipedia
 * Usuari: aleix.paris
 * Data: 01/05/2015
 */

/**
 * NavegacioVista per la Wikipedia, amb tots els detalls explicat a l'enunciat
 */

public class Navegacio {

    private GrafWikipedia grafWikipedia;

    /**
     * Constructora per defecte
     * @param graf
     */
    public Navegacio(GrafWikipedia graf){
        grafWikipedia = graf;
    }

    /**
     * Retorna les superpacetories d'un node determinat
     * @param nodeCategoria
     * @return les superpacetories d'un node determinat
     */
    public ArrayList<NodeCategoria> getSupercategories(NodeCategoria nodeCategoria){
        ArrayList<Arc<NodeCategoria>> arcs = new ArrayList<>(grafWikipedia.getNodesAdjacents(nodeCategoria));
        ArrayList<NodeCategoria> supercategories = new ArrayList<>();
        for(Arc<NodeCategoria> arc : arcs){
            if(arc.getPes() > 0) supercategories.add(Graf.getNodeOposat(nodeCategoria, arc));
        }
        return supercategories;
    }

    /**
     * Retorna les subcategories d'un node determinat
     * @param nodeCategoria
     * @return les subcategories d'un node determinat
     */
    public ArrayList<NodeCategoria> getSubcategories(NodeCategoria nodeCategoria){
        ArrayList<Arc<NodeCategoria>> arcs = new ArrayList<>(grafWikipedia.getNodesAdjacents(nodeCategoria));
        ArrayList<NodeCategoria> subcategories = new ArrayList<>();
        for(Arc<NodeCategoria> arc : arcs){
            if(arc.getPes() < 0) subcategories.add((NodeCategoria)Graf.getNodeOposat(nodeCategoria, arc));
        }
        return subcategories;
    }

    /**
     * Retorna les pagines associades a una categoria
     * @param nodeCategoria
     * @return les pagines associades a una categoria
     */
    public ArrayList<NodePagina> getPagines(NodeCategoria nodeCategoria){
        return nodeCategoria.getPagines();
    }

    /**
     * Retorna les categories associades a una pagina
     * @param nodePagina
     * @return les categories associades a una pagina
     */
    public ArrayList<NodeCategoria> getCategories(NodePagina nodePagina){
        return new ArrayList<>(nodePagina.getCategories());
    }

    public ArrayList<NodeCategoria> getCatsTema(NodeCategoria nodeCategoria){
        // TODO: cal obtenir en la constructora el Conjunt de comunitats
        return null;
    }
}