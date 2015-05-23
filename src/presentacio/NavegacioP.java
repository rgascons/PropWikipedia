package presentacio;

/**
 * Grup 3: Wikipedia
 * Usuari: aleix.paris
 * Data: 23/05/15
 */

public class NavegacioP extends javax.swing.JPanel {

    /**
     * Creates new form NavegacioP
     */
    public NavegacioP() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        labelTitol = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListCats = new javax.swing.JList();
        labelCats = new javax.swing.JLabel();
        jButtonCats = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(400, 300));

        labelTitol.setText("T�tol de la p�gina");

        jListCats.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListCats);

        labelCats.setText("Categories a les quals pertany");

        jButtonCats.setText("Accedir a la categoria");
        jButtonCats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCatsActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Editar la p�gina");
        jButtonEdit.setToolTipText("");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonCats)
                                        .addComponent(labelCats)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(labelTitol)
                                .addGap(0, 159, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonEdit)
                                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(labelTitol)
                                .addGap(18, 18, 18)
                                .addComponent(labelCats)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCats)
                                .addGap(14, 14, 14)
                                .addComponent(jButtonEdit)
                                .addContainerGap())
        );
    }// </editor-fold>

    private void jButtonCatsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButtonCats;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JList jListCats;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCats;
    private javax.swing.JLabel labelTitol;
    // End of variables declaration
}
