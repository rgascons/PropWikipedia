package domini.controladors;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Grup 3: Wikipedia
 * Usuari: ricard.gascons
 * Data: 5/22/15
 */
public class CtrlSessio {
    // TODO: en la meva opinio, no te cap sentit
    static private CtrlSessio INSTANCE;

    private static String directoriSessio;
    private static String nomSessio;

    private CtrlSessio() {}

    public static CtrlSessio getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CtrlSessio();
        }
        return INSTANCE;
    }

    public static ArrayList<String> getNomsSessions() throws IOException{
        //return CtrlPersistencia.getFitxer("data/sessions.users");
        if(true)
            throw new RuntimeException("no entenc que vols fer amb aixo");
        return null;
    }

    public boolean crearNovaSessio(String usuari) throws IOException{
       /* ArrayList<String> nomsSessio = CtrlPersistencia.getFitxer("data/sessions.users");
        for (String nom : nomsSessio)
            if (nom.equals(usuari))
                return false;
        CtrlPersistencia.afegirDada("data/sessions.users", usuari);
        CtrlPersistencia.crearDirectoriData(usuari);
        */
        if(true)
            throw new RuntimeException("no entenc que vols fer amb aixo");
        return true;
    }

    public String getDirectoriSessio() {
        return directoriSessio;
    }

    public String getNomSessio() {
        return nomSessio;
    }

    public static void setSessioJaCreada(String nSessio) {
        nomSessio = nSessio;
        directoriSessio = "data/" + nSessio;
    }
}