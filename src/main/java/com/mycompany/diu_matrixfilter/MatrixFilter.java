package com.mycompany.diu_matrixfilter;

import static java.lang.Math.abs;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixFilter extends javax.swing.JFrame {
    
    /** 
     * tamNumMax es un atributo que nos sirve para ajustar los espacios entre 
     * números en la visualización de la matrix   
    */
    private int tamNumMax;
    private int[][] matrix;
    
    private int min;
    private int max;
    
    public MatrixFilter() {
        
        min = 1;
        max = 20;
        
        matrix = new int[10][10];
        tamNumMax = 2;
        
        setMatriz(min, max);
        
        initComponents();
        
        showMatrix();
        
        showMatrix.setEditable(false);
        barra.setMaximum(max);
        barra.setMinimum(min - 1);
        
        barra.setPaintTicks(false);
        int espacio = (int) ((abs(max) + abs(min)) /4);
        barra.setMajorTickSpacing(espacio);

        barra.setPaintTicks(true);
        
    }
    
    private void setMatriz(int min, int max) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (int)(Math.random() * ((max - min) + 1))+min;
            }
        }
    }
    
    private void showMatrix() {
        int tamNum;
        showMatrix.setText("");
        
        if(numCifras(max) > numCifras(min)){
            tamNum = numCifras(max);
        } else {
            tamNum = numCifras(min);
        }

        for(int i = 0; i < matrix.length; i++) {
            showMatrix.setText(showMatrix.getText() + "| ");
            for(int j = 0; j < matrix.length; j++) {
                if((int) barra.getValue() < matrix[i][j]) {
                    showMatrix.setText(showMatrix.getText() +
                            matrix[i][j]);
                    
                    for (int x = numCifras(matrix[i][j]); x < tamNum; x++){
                        showMatrix.setText(showMatrix.getText() + " ");                       
                    }
                    
                } else {
                    showMatrix.setText(showMatrix.getText() + "--");
                    
                    for (int x = 2; x < tamNum; x++){
                        showMatrix.setText(showMatrix.getText() + " ");                       
                    }
                }
                showMatrix.setText(showMatrix.getText() + " | ");
            }
            showMatrix.setText(showMatrix.getText() + "\n");
        }
    }
    
    /**
     * Método auxiliar para calcular cuanto espacio ocupa cada número
     * @param numero
     * @return numero de cifras que tiene el @param
     */
    private int numCifras(int numero) {
        if(numero == 0) return 1;
        int res = 0;
        if(numero < 0) res++;
        while(numero != 0) {
            numero /= 10;
            res++;
        }
        return res;
    }
    
    private boolean intCheck(String input) {
        Pattern pattern = Pattern.compile("[-+]?[0-9]+");
        Matcher matcher  = pattern.matcher(input);
        return matcher.matches();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMatriz = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showMatrix = new javax.swing.JTextArea();
        barra = new javax.swing.JSlider();
        numActual = new javax.swing.JLabel();
        valoresMatriz = new javax.swing.JPanel();
        textMaximo = new javax.swing.JTextField();
        textMinimo = new javax.swing.JTextField();
        minimo = new javax.swing.JLabel();
        maximo = new javax.swing.JLabel();
        avisos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MatrixFilter");
        setResizable(false);

        panelMatriz.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Visualiza la Matriz", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        showMatrix.setColumns(20);
        showMatrix.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        showMatrix.setRows(10);
        showMatrix.setToolTipText("Valores mayores que el número de la barra deslizante");
        jScrollPane1.setViewportView(showMatrix);

        barra.setToolTipText("Desliza para mostrar mas o menos valores");
        barra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                barraStateChanged(evt);
            }
        });

        numActual.setText("Valor actual: ");

        javax.swing.GroupLayout panelMatrizLayout = new javax.swing.GroupLayout(panelMatriz);
        panelMatriz.setLayout(panelMatrizLayout);
        panelMatrizLayout.setHorizontalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMatrizLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(barra, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMatrizLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numActual, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        panelMatrizLayout.setVerticalGroup(
            panelMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMatrizLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numActual, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        valoresMatriz.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Introduce el Rango de la Matriz", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        textMaximo.setText("20");
        textMaximo.setToolTipText("Introduzca el valor máximo");
        textMaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textMaximoKeyReleased(evt);
            }
        });

        textMinimo.setText("1");
        textMinimo.setToolTipText("Introduzca el valor mínimo");
        textMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textMinimoKeyReleased(evt);
            }
        });

        minimo.setText("MÍNIMO");

        maximo.setText("MÁXIMO");

        javax.swing.GroupLayout valoresMatrizLayout = new javax.swing.GroupLayout(valoresMatriz);
        valoresMatriz.setLayout(valoresMatrizLayout);
        valoresMatrizLayout.setHorizontalGroup(
            valoresMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(valoresMatrizLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(valoresMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(valoresMatrizLayout.createSequentialGroup()
                        .addComponent(maximo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(valoresMatrizLayout.createSequentialGroup()
                        .addComponent(minimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        valoresMatrizLayout.setVerticalGroup(
            valoresMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, valoresMatrizLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(valoresMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minimo)
                    .addComponent(textMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(valoresMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maximo)
                    .addComponent(textMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        avisos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        avisos.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(valoresMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(avisos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(valoresMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(avisos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_barraStateChanged
        numActual.setText("Valor actual: "+barra.getValue());
        showMatrix();
    }//GEN-LAST:event_barraStateChanged

    private void textMinimoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMinimoKeyReleased
        avisos.setText("");
        if(intCheck(textMinimo.getText())) {
            
            if(Integer.parseInt(textMinimo.getText()) <= max){
                min = Integer.parseInt(textMinimo.getText());
                setMatriz(min,max);
                barra.setMinimum(min - 1);
                
                barra.setPaintTicks(false);
                int espacio = (int) ((abs(max) + abs(min)) /4);
                barra.setMajorTickSpacing(espacio);

                barra.setPaintTicks(true);
            } else {
                avisos.setText("El valor de MÁXIMO debe ser mayor que el valor de MÍNIMO");
            }  
        } else {
            avisos.setText("Introduzca un número entero en la casilla MÍNIMO");
        }
    }//GEN-LAST:event_textMinimoKeyReleased

    private void textMaximoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMaximoKeyReleased
        avisos.setText("");
        if(intCheck(textMaximo.getText())) {
            
            if(Integer.parseInt(textMaximo.getText()) >= min){
                max = Integer.parseInt(textMaximo.getText());
                setMatriz(min,max);
                barra.setMaximum(max);
                
                barra.setPaintTicks(false);
                int espacio = (int) ((abs(max) + abs(min)) /4);
                barra.setMajorTickSpacing(espacio);

                barra.setPaintTicks(true);
            } else {
                avisos.setText("El valor de MÁXIMO debe ser menor que el valor de MÍNIMO");
            }    
        } else {
            avisos.setText("Introduzca un número entero en la casilla MÁXIMO");
        }
    }//GEN-LAST:event_textMaximoKeyReleased

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MatrixFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatrixFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatrixFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatrixFilter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MatrixFilter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avisos;
    private javax.swing.JSlider barra;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel maximo;
    private javax.swing.JLabel minimo;
    private javax.swing.JLabel numActual;
    private javax.swing.JPanel panelMatriz;
    private javax.swing.JTextArea showMatrix;
    private javax.swing.JTextField textMaximo;
    private javax.swing.JTextField textMinimo;
    private javax.swing.JPanel valoresMatriz;
    // End of variables declaration//GEN-END:variables

}
