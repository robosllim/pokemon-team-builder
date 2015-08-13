/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TBWindow.java
 *
 * Created on Oct 14, 2011, 4:09:36 PM
 */
package com.pixelchimera.teambuilder;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author dans
 */
public class TBWindow extends javax.swing.JFrame {

    /** Creates new form TBWindow */
    public TBWindow() {
        initComponents();
        
        this.setVisible(true);
        textTable.setEditable(false);
        rootPane = this.getRootPane();
        rootPane.setDefaultButton(calcButton);
        war = new WarningWindow();
        
        // Class for managing dex numbers and pokemon types
        consAccess = new ConsClass();
        // Combo boxes for choosing pokemon
        oneCombo.removeAllItems();
        oneCombo.addItem("Pokemon 1");
        for (String pkmnName : consAccess.pkmnNames) {
            oneCombo.addItem(pkmnName);
        }
        twoCombo.removeAllItems();
        twoCombo.addItem("Pokemon 2");
        for (String pkmnName : consAccess.pkmnNames) {
            twoCombo.addItem(pkmnName);
        }
        threeCombo.removeAllItems();
        threeCombo.addItem("Pokemon 3");
        for (String pkmnName : consAccess.pkmnNames) {
            threeCombo.addItem(pkmnName);
        }
        fourCombo.removeAllItems();
        fourCombo.addItem("Pokemon 4");
        for (String pkmnName : consAccess.pkmnNames) {
            fourCombo.addItem(pkmnName);
        }
        fiveCombo.removeAllItems();
        fiveCombo.addItem("Pokemon 5");
        for (String pkmnName : consAccess.pkmnNames) {
            fiveCombo.addItem(pkmnName);
        }
        sixCombo.removeAllItems();
        sixCombo.addItem("Pokemon 6");
        for (String pkmnName : consAccess.pkmnNames) {
            sixCombo.addItem(pkmnName);
        }
        
        // Create an array for the pokemon entry fields
        fieldArr = new JComboBox[6];
        fieldArr[0] = oneCombo;
        fieldArr[1] = twoCombo;
        fieldArr[2] = threeCombo;
        fieldArr[3] = fourCombo;
        fieldArr[4] = fiveCombo;
        fieldArr[5] = sixCombo;
        // Setup the multipliers
        offenseMult = new int[17];
        defenseMult = new int[17];
        defenseCount = new int[6][17];
        try {
            // Create the blank table
            ResetAll();
        } catch (BadLocationException ex) {
            Logger.getLogger(TBWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ResetAll() throws BadLocationException{
        typeLabel.setText("");
        String headerBreak = "------------------------------------------------"+
                "---------------------------------------------------------\n";
        // Iterate through the types, minus 1 (last one is ???, undefined)
        Document doc = textTable.getDocument();
        doc.remove(0, doc.getLength());
        MutableAttributeSet atts = new SimpleAttributeSet();
        
        doc.insertString(doc.getLength(), "ATTACKING AGAINST: +2 for SE, -1 for NVE\n | ", null);
        for (int i = 0; i < consAccess.basicTypes.length-1; i++){
            StyleConstants.setForeground(atts, consAccess.typeColors[i]);
            doc.insertString(doc.getLength(), consAccess.basicTypes[i], atts);
            StyleConstants.setForeground(atts, Color.black);
            if (i < 16){
                doc.insertString(doc.getLength(), " | ", atts);
            }
            else{
                doc.insertString(doc.getLength(), "\n", atts);
            }
        }
        doc.insertString(doc.getLength(), headerBreak+"\n\n\n\n", null);

        doc.insertString(doc.getLength(), "DEFENDING AGAINST: +2 for NVE, -1 for SE\n | ", null);
        for (int i = 0; i < consAccess.basicTypes.length-1; i++){
            StyleConstants.setForeground(atts, consAccess.typeColors[i]);
            doc.insertString(doc.getLength(), consAccess.basicTypes[i], atts);
            StyleConstants.setForeground(atts, Color.black);
            if (i < 16){
                doc.insertString(doc.getLength(), " | ", atts);
            }
            else{
                doc.insertString(doc.getLength(), "\n", atts);
            }
        }
        doc.insertString(doc.getLength(), headerBreak+"\n\n\n\n", null);
        
        doc.insertString(doc.getLength(), "DEFENSIVE STRENGTHS/WEAKNESSES BY COUNT\n    | ", null);
        for (int i = 0; i < consAccess.basicTypes.length-1; i++){
            StyleConstants.setForeground(atts, consAccess.typeColors[i]);
            doc.insertString(doc.getLength(), consAccess.basicTypes[i], atts);
            StyleConstants.setForeground(atts, Color.black);
            if (i < 16){
                doc.insertString(doc.getLength(), " | ", atts);
            }
            else{
                doc.insertString(doc.getLength(), "\n", atts);
            }
        }
        doc.insertString(doc.getLength(), "---"+headerBreak, null);

        String [] multStr = {"0.00", "0.25", "0.50", "1.00", "2.00", "4.00"};
        for (int i = 0; i < 6; i++){
            doc.insertString(doc.getLength(), multStr[i], null);
            if (i != 6){
                doc.insertString(doc.getLength(), "\n\n", null);
            }
        }
        
        // Reset multipliers to neutral, at a multiplier of 0
        for (int i = 0; i < 17; i++){
            offenseMult[i] = 0;
            defenseMult[i] = 0;
            for (int j = 0; j < 6; j++){
                defenseCount[j][i] = 0;
            }
        }
        
//        String text = "";
//        for (int i = 0; i < consAccess.dexTotal; i++){
//            text += i+" "+consAccess.pkmnNames[i]+"\n";
//        }
//        textTable.setText(text);
    }
    
    // This should only be called after the calcs have been done
    private void BuildChart() throws BadLocationException{
        String headerBreak = "------------------------------------------------"+
                "---------------------------------------------------------";
        String fullString = "";
        
        textTable.setText("");
        Document doc = textTable.getDocument();
        doc.remove(0, doc.getLength());
        MutableAttributeSet atts = new SimpleAttributeSet();
        
        // *****************************************************************************
        // ATTACK CHART ATTACK CHART ATTACK CHART ATTACK CHART ATTACK CHART ATTACK CHART 
        doc.insertString(doc.getLength(), "ATTACKING AGAINST: +2 for SE, -1 for NVE\n | ", null);
        for (int i = 0; i < consAccess.basicTypes.length-1; i++){
            StyleConstants.setForeground(atts, consAccess.typeColors[i]);
            doc.insertString(doc.getLength(), consAccess.basicTypes[i], atts);
            StyleConstants.setForeground(atts, Color.black);
            if (i < 16){
                doc.insertString(doc.getLength(), " | ", atts);
            }
            else{
                doc.insertString(doc.getLength(), "\n", atts);
            }
        }
        doc.insertString(doc.getLength(), headerBreak+"\n  ", null);
        
        for (int i = 0; i < 17; i++){
            fullString = String.format("%5s ", offenseMult[i]);
            StyleConstants.setForeground(atts, consAccess.GetScoreColor(offenseMult[i]));
            doc.insertString(doc.getLength(),fullString,atts);
        }
        doc.insertString(doc.getLength(), "\n\n\n\n", null);
        
        // ***********************************************************************************
        // DEFENSE CHART DEFENSE CHART DEFENSE CHART DEFENSE CHART DEFENSE CHART DEFENSE CHART 
        doc.insertString(doc.getLength(), "DEFENDING AGAINST: +2 for NVE, -1 for SE\n | ", null);
        for (int i = 0; i < consAccess.basicTypes.length-1; i++){
            StyleConstants.setForeground(atts, consAccess.typeColors[i]);
            doc.insertString(doc.getLength(), consAccess.basicTypes[i], atts);
            StyleConstants.setForeground(atts, Color.black);
            if (i < 16){
                doc.insertString(doc.getLength(), " | ", atts);
            }
            else{
                doc.insertString(doc.getLength(), "\n", atts);
            }
        }
        doc.insertString(doc.getLength(), headerBreak+"\n  ", null);
        
        for (int i = 0; i < 17; i++){
            fullString = String.format("%5s ", defenseMult[i]);
            StyleConstants.setForeground(atts, consAccess.GetScoreColor(defenseMult[i]));
            doc.insertString(doc.getLength(),fullString,atts);
        }
        doc.insertString(doc.getLength(), "\n\n\n\n", null);
        
        // *****************************************************************************
        // COUNTS CHART COUNTS CHART COUNTS CHART COUNTS CHART COUNTS CHART COUNTS CHART
        doc.insertString(doc.getLength(), "DEFENSIVE STRENGTHS/WEAKNESSES BY COUNT\n    | ", null);
        for (int i = 0; i < consAccess.basicTypes.length-1; i++){
            StyleConstants.setForeground(atts, consAccess.typeColors[i]);
            doc.insertString(doc.getLength(), consAccess.basicTypes[i], atts);
            StyleConstants.setForeground(atts, Color.black);
            if (i < 16){
                doc.insertString(doc.getLength(), " | ", atts);
            }
            else{
                doc.insertString(doc.getLength(), "\n", atts);
            }
        }
        doc.insertString(doc.getLength(), headerBreak+"---\n", null);

        String [] multStr = {"0.00", "0.25", "0.50", "1.00", "2.00", "4.00"};
        for (int i = 0; i < 6; i++){
            doc.insertString(doc.getLength(), multStr[i], null);
            for (int j = 0; j < 17; j++){
                StyleConstants.setForeground(atts, consAccess.GetCountColor(i,defenseCount[i][j]));
                fullString = String.format("%5s ", defenseCount[i][j]);
                doc.insertString(doc.getLength(), fullString, atts);
            }

            if (i != 6){
                doc.insertString(doc.getLength(), "\n\n", null);
            }
        }
        
        //textTable.setText(retString);
    }
    
    private void CalcOffenseMult(int[] dex){
        // Loop through each of our six pokemon
        int[] tempOff;
        for (int i = 0; i < 6; i++){
            if (dex[i] != -1){
                // For each valid dex number, get the two types (type 2 may be ???)
                int[] types = {17,17};
                types[0] = consAccess.GetIntTypeByDexNum(dex[i],0);
                types[1] = consAccess.GetIntTypeByDexNum(dex[i],1);
                
                // Now, we calculate the type table
                for (int j = 0; j < 2; j++){
                    // If either type is invalid, skip. The multipliers will stay in their
                    // initialized form.
                    if (types[j] == 17){
                        break;
                    }
                    tempOff = consAccess.CalcOff(types[j]);
                    for (int k = 0; k < 17; k++){
                        offenseMult[k] += tempOff[k];
                    }
                }
            }
            // If the pokemon is invalid (eg "spewgok"), set that field to blank
            else{
                fieldArr[i].setSelectedIndex(0);
            }
        }
    }
    
    private void CalcDefenseMult(int[] dex){
        // Loop through each of our six pokemon
        int[] tempDef;
        for (int i = 0; i < 6; i++){
            if (dex[i] != -1){
                // For each valid dex number, get the two types (type 2 may be ???)
                int[] types = {17,17,17,17};
                types[0] = consAccess.GetIntTypeByDexNum(dex[i],0);
                types[1] = consAccess.GetIntTypeByDexNum(dex[i],1);
                types[2] = consAccess.GetIntTypeByDexNum(dex[i],2);
                types[3] = consAccess.GetIntTypeByDexNum(dex[i],3);
                
                // Setup some counters
                // These will be treated as if they were defense mult, but they
                // will be compared to each other to figure out the real counts
                int[][] typeCtr = new int[4][17];
                
                for (int j = 0; j < 17; j++){
                    typeCtr[0][j] = 0;
                    typeCtr[1][j] = 0;
                    typeCtr[2][j] = 0;
                    typeCtr[3][j] = 0;
                }
                
                // Now, we calculate the type table, including abilities if the box is checked
                int goTo;
                if (abilityCheck.isSelected()){
                    goTo = 4;
                }
                else {
                    goTo = 2;
                }
                for (int j = 0; j < goTo; j++){
                    // If either type is invalid, skip. The multipliers will stay in their
                    // initialized form.
                    if (types[j] == 17){
                        continue;
                    }
                    System.out.println("Calculating for type: "+j);
                    tempDef = consAccess.CalcDef(types[j],j);
                    for (int k = 0; k < 17; k++){
                        typeCtr[j][k] += tempDef[k];
                    }
                }
                
                // Here, figure out the counts and apply them to the multiplier array
                for (int j = 0; j < 17; j++){
                    // Sum of the types: -1 is a 2x weak, 1 is a 1x, 2 is a 0.5x, 3 is a 0x

                    // Any immunity
                    if (typeCtr[0][j] == 3 || typeCtr[1][j] == 3 || typeCtr[2][j] == 3 || typeCtr[3][j] == 3){
                        if (typeCtr[0][j] == 3){
                            typeCtr[0][j] = 2;
                        }
                        if (typeCtr[1][j] == 3){
                            typeCtr[1][j] = 2;
                        }
                        if (typeCtr[2][j] == 3){
                            typeCtr[2][j] = 2;
                        }
                        if (typeCtr[3][j] == 3){
                            typeCtr[3][j] = 2;
                        }
                        defenseCount[0][j] ++;
                    }
                    // Double resistance
                    else if ((typeCtr[0][j] + typeCtr[1][j] + typeCtr[2][j] + typeCtr[3][j]) >= 4){
                        defenseCount[1][j] ++;
                    }
                    // Single resistance
                    else if ((typeCtr[0][j] + typeCtr[1][j] + typeCtr[2][j] + typeCtr[3][j]) >= 2){
                        defenseCount[2][j] ++;
                    }
                    // Neutral overall
                    else if ((typeCtr[0][j] + typeCtr[1][j] + typeCtr[2][j] + typeCtr[3][j]) >= 0){
                        defenseCount[3][j] ++;
                    }
                    // One weakness
                    else if ((typeCtr[0][j] + typeCtr[1][j] + typeCtr[2][j] + typeCtr[3][j]) >= -1){
                        defenseCount[4][j] ++;
                    }
                    // Two weaknesses
                    else if ((typeCtr[0][j] + typeCtr[1][j] + typeCtr[2][j] + typeCtr[3][j]) < -1){
                        defenseCount[5][j] ++;
                    }
                    
                    // Once we've calculated all that and adjusted the numbers,
                    // add the values to the multiplier array
                    defenseMult[j] += typeCtr[0][j];
                    defenseMult[j] += typeCtr[1][j];
                    defenseMult[j] += typeCtr[2][j];
                    defenseMult[j] += typeCtr[3][j];
                }
            }
            else{
                fieldArr[i].setSelectedIndex(0);
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calcButton = new javax.swing.JButton();
        optButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        textTable = new javax.swing.JTextPane();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        offRadio = new javax.swing.JRadioButton();
        defRadio = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        typeLabel = new javax.swing.JTextPane();
        abilityCheck = new javax.swing.JCheckBox();
        oneCombo = new javax.swing.JComboBox();
        twoCombo = new javax.swing.JComboBox();
        threeCombo = new javax.swing.JComboBox();
        fourCombo = new javax.swing.JComboBox();
        fiveCombo = new javax.swing.JComboBox();
        sixCombo = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        calcButton.setText("Calculate");
        calcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcButtonActionPerformed(evt);
            }
        });

        optButton.setText("Get Best Type");
        optButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        textTable.setBackground(new java.awt.Color(224, 224, 224));
        textTable.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(textTable);

        offRadio.setText("Offense");

        defRadio.setText("Defense");

        jLabel2.setText("Favor...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(defRadio)
                    .addComponent(offRadio)
                    .addComponent(jLabel2))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(offRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defRadio))
        );

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(typeLabel);

        abilityCheck.setText("Calculate with Abilities");

        oneCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        twoCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        threeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        fourCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        fiveCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        sixCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMenu1.setText("File");

        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(oneCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 174, Short.MAX_VALUE)
                    .addComponent(twoCombo, 0, 174, Short.MAX_VALUE)
                    .addComponent(threeCombo, 0, 174, Short.MAX_VALUE)
                    .addComponent(fourCombo, 0, 174, Short.MAX_VALUE)
                    .addComponent(fiveCombo, 0, 174, Short.MAX_VALUE)
                    .addComponent(sixCombo, 0, 174, Short.MAX_VALUE)
                    .addComponent(calcButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(clearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(abilityCheck)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(optButton, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(oneCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(twoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(threeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fiveCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sixCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calcButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(abilityCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(optButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void CalculateCharts(){
    try {
        // Reset everthing so we start clean
        ResetAll();
    } catch (BadLocationException ex) {
        Logger.getLogger(TBWindow.class.getName()).log(Level.SEVERE, null, ex);
    }
    String retText = "";
    // An array of dex numbers for each of the text fields. -1 is invalid or blank.
    int [] dexNums = {-1,-1,-1,-1,-1,-1};
    // Check each field and get the dex number for that name, if valid
    for (int i = 0; i < 6; i++){
        if (fieldArr[i].getSelectedIndex() != 0){
            dexNums[i] = consAccess.GetDexNum((String)fieldArr[i].getSelectedItem());
        }
    }
    // Calculate the multipliers. These funcs will find the types on their own
    CalcOffenseMult(dexNums);
    CalcDefenseMult(dexNums);
    try {
        // Build the charts with this info
        BuildChart();
    } catch (BadLocationException ex) {
        Logger.getLogger(TBWindow.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
private void calcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonActionPerformed
    CalculateCharts();
}//GEN-LAST:event_calcButtonActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed

        System.exit(0);     }//GEN-LAST:event_exitMenuActionPerformed

    private void optButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optButtonActionPerformed
        int flag = 0;
        CalculateCharts();
        for (int i = 0; i < 6; i++){
            if (fieldArr[i].getSelectedIndex() != 0){
                flag ++;
                if (flag > 1){
                    break;
                }
            }
        }
        if (flag < 2){
            war.setLocation((int)(this.getX() + this.getWidth()/2 - war.getWidth()/2), (int)(this.getY() + this.getHeight()/2 - war.getHeight()/2));
            war.setVisible(true);
            war.SetWarning("Must have at least two\nvalid Pokemon entered!");
        }
        else{
            int offDef = 0;
            if (offRadio.isSelected() && defRadio.isSelected()){
                offDef = 0;
            }
            else if (offRadio.isSelected()){
                offDef = 1;
            }
            else if (defRadio.isSelected()){
                offDef = -1;
            }
            // An array of dex numbers for each of the text fields. -1 is invalid or blank.
            int [] dexNums = {-1,-1,-1,-1,-1,-1};
            // Check each field and get the dex number for that name, if valid
            for (int i = 0; i < 6; i++){
                if (fieldArr[i].getSelectedIndex() != 0){
                    dexNums[i] = consAccess.GetDexNum((String)fieldArr[i].getSelectedItem());
                }
            }
            
            Optimizer optGuy = new Optimizer(offDef,2,dexNums,offenseMult,defenseMult);
            
            int[] bestTypes;
            bestTypes = optGuy.GetBestScores();
            
            String theType1 = consAccess.TypeToString(bestTypes[0]);
            String theType2 = consAccess.TypeToString(bestTypes[1]);
            typeLabel.setText("Best type: " + theType1 + "\nSecond best: " + theType2);
        }
    }//GEN-LAST:event_optButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        for (int i = 0; i < 6; i++){
            fieldArr[i].setSelectedIndex(0);
            try {
                ResetAll();
            } catch (BadLocationException ex) {
                Logger.getLogger(TBWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_clearButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TBWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            new TBWindow().setVisible(true);
        }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox abilityCheck;
    private javax.swing.JButton calcButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JRadioButton defRadio;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JComboBox fiveCombo;
    private javax.swing.JComboBox fourCombo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton offRadio;
    private javax.swing.JComboBox oneCombo;
    private javax.swing.JButton optButton;
    private javax.swing.JComboBox sixCombo;
    private javax.swing.JTextPane textTable;
    private javax.swing.JComboBox threeCombo;
    private javax.swing.JComboBox twoCombo;
    private javax.swing.JTextPane typeLabel;
    // End of variables declaration//GEN-END:variables
    public JComboBox[] fieldArr;
    private ConsClass consAccess;
    private int[] offenseMult;
    private int[] defenseMult;
    private int[][] defenseCount;
    private WarningWindow war;
}
