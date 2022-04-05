package net.slidesoft;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Worker.State;
import javafx.embed.swing.JFXPanel;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;

/**
 *
 * @author Rachid El Alaoui , SlideSoft.net
 */
public class Main extends javax.swing.JFrame {

    public static final String EVENT_TYPE_CLICK = "click";
    public static final String EVENT_TYPE_MOUSEOVER = "mouseover";
    public static final String EVENT_TYPE_MOUSEOUT = "mouseclick";
    
    private WebView webView;
    WebHistory history =null;

    public Main() {
        super("JWebBrowser, SlideSoft.net");
        initComponents();
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        JFXPanel jfxPanel = new JFXPanel();
        this.add(jfxPanel);
        Platform.runLater(() -> {
            webView = new WebView();
            history = webView.getEngine().getHistory();
            initEngine(webView);
            jfxPanel.setScene(new Scene(webView));
            webView.getEngine().load("http://projects.slidesoft.net");
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPnl = new javax.swing.JPanel();
        edtUrl = new javax.swing.JTextField();
        comboBox = new javax.swing.JComboBox<>();
        btnClear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 51));

        topPnl.setBackground(new java.awt.Color(153, 153, 255));
        topPnl.setPreferredSize(new java.awt.Dimension(949, 100));

        edtUrl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        edtUrl.setText("slidesoft.net");
        edtUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtUrlActionPerformed(evt);
            }
        });

        comboBox.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setText("Timer");

        btnPrint.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPnlLayout = new javax.swing.GroupLayout(topPnl);
        topPnl.setLayout(topPnlLayout);
        topPnlLayout.setHorizontalGroup(
            topPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPnlLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(edtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear)
                .addGap(10, 10, 10)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrint)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        topPnlLayout.setVerticalGroup(
            topPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(topPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear)
                    .addComponent(jButton1)
                    .addComponent(btnPrint))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(topPnl, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void edtUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtUrlActionPerformed
        Platform.runLater( new Runnable() {
            @Override
            public void run() {
                String url = edtUrl.getText().trim() ;
                if (url.isEmpty()) {
                    return ;
                }
                if ( !url.toLowerCase().contains("http") ) {
                    url = "HTTP://"+url ;
                }
                webView.getEngine().load(url);
            }
        }  );
    }//GEN-LAST:event_edtUrlActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        Platform.runLater( new Runnable() {
            @Override
            public void run() {
                String url = comboBox.getSelectedItem().toString();
                edtUrl.setText(url);
                webView.getEngine().load(url);
            }
        }  );
    }//GEN-LAST:event_comboBoxActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        edtUrl.setText("");
        edtUrl.requestFocusInWindow();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            webView.getEngine().print(job);
            job.endJob();
        }
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnPrint;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JTextField edtUrl;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel topPnl;
    // End of variables declaration//GEN-END:variables
        
    

    private void initEngine(WebView web) {
        
        web.getEngine().getLoadWorker().stateProperty()
            .addListener((obs, oldValue, newValue) -> {
              if (newValue == State.SUCCEEDED) {
                    EventListener listener = new EventListener() {
                        @Override
                        public void handleEvent(Event evt) {
                            String domEventType = evt.getType();
                            if (domEventType.equals(EVENT_TYPE_CLICK)) {
                                String link = evt.getTarget().toString() ;
                                if (link.toLowerCase().endsWith("pdf")) {
                                    evt.preventDefault();
                                    evt.stopPropagation();
                                    // Read PDF 
                                }
                            } 
                        }
                        
                    };
                    Document doc = web.getEngine().getDocument();
                    Element el = doc.getElementById("a");
                    NodeList lista = doc.getElementsByTagName("a");
                    for (int i=0; i<lista.getLength(); i++)
                        ((EventTarget)lista.item(i)).addEventListener("click", listener, false);
              }
            });
        
        history.getEntries().addListener(
            (ListChangeListener.Change<? extends WebHistory.Entry> c) -> {
                c.next();
                c.getRemoved().stream().forEach((e) -> {
                    comboBox.removeAll();
            });
                c.getAddedSubList().stream().forEach((e) -> {
                    String url = e.getUrl();
                    if (url.endsWith("/")) {
                        url = url.substring(0, url.length()-1);
                    }
                    if (getHistory().contains(url)) {
                        return ;
                    }
                comboBox.addItem(url);
            });
        });
        
    }
    
    private List<String> getHistory(){
        List<String> list = new ArrayList<>();
        int size = comboBox.getItemCount();
        for (int i = 0; i < size; i++) {
          String item = comboBox.getItemAt(i);
          list.add(item);
        }
        return list;
    }
}
