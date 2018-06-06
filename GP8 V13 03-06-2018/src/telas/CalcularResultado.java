/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import Gabarito.Gabarito;
import Gabarito.GabaritoDAO;
import Gabarito.GabaritoTableModel;
import aluno.Aluno;
import aluno.AlunoDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import corrigirGabarito.CorrigirDAO;
import corrigirGabarito.CorrigirGabarito;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Adriano
 */
public class CalcularResultado extends javax.swing.JDialog {

    List<CorrigirGabarito> corrigir = new ArrayList<>();
    CorrigirDAO corrigirDAO = new CorrigirDAO();
    Gabarito gabarito = new Gabarito();
    GabaritoDAO dao = new GabaritoDAO();
    Aluno aluno = new Aluno();
    AlunoDAO alunoDAO = new AlunoDAO();

    /**
     * Creates new form CalcularResultado
     */
    public CalcularResultado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void calcularPontuacao() {

        for (CorrigirGabarito respostasAlunos : corrigir) {
            respostasAlunos.setQtdAcertosBiologia(0);
            respostasAlunos.setQtdAcertosMatematica(0);
            respostasAlunos.setQtdAcertosPortugues(0);
            respostasAlunos.setQtdAcertosFisica(0);
            respostasAlunos.setQtdAcertosQuimica(0);
            respostasAlunos.setQtdAcertosHistoria(0);
            respostasAlunos.setQtdAcertosGeografia(0);
            respostasAlunos.setQtdAcertosLinguas(0);
            respostasAlunos.setNotaFinal(0);

            respostasAlunos.setRespostaJSON(respostasAlunos.getRespostaJSON().replace("\"", "").replace("[", "").replace("]", ""));
            respostasAlunos.setResposta(respostasAlunos.getRespostaJSON().split(","));
            respostasAlunos.getGabarito().setRespostaJSON(respostasAlunos.getGabarito().getRespostaJSON().replace("\"", "").replace("[", "").replace("]", ""));
            respostasAlunos.getGabarito().setResposta(respostasAlunos.getGabarito().getRespostaJSON().split(","));
            for (int i = 0; i < respostasAlunos.getResposta().length; i++) {
                if (i >= 0 && i <= 9) {
                    if (respostasAlunos.getResposta()[i].equalsIgnoreCase(respostasAlunos.getGabarito().getResposta()[i])) {
                        respostasAlunos.setQtdAcertosPortugues(respostasAlunos.getQtdAcertosPortugues() + 1);
                    }
                } else if (i >= 10 && i <= 17) {
                    if (respostasAlunos.getResposta()[i].equalsIgnoreCase(respostasAlunos.getGabarito().getResposta()[i])) {
                        respostasAlunos.setQtdAcertosMatematica(respostasAlunos.getQtdAcertosMatematica() + 1);
                    }
                } else if (i >= 18 && i <= 25) {
                    if (respostasAlunos.getResposta()[i].equalsIgnoreCase(respostasAlunos.getGabarito().getResposta()[i])) {
                        respostasAlunos.setQtdAcertosBiologia(respostasAlunos.getQtdAcertosBiologia() + 1);
                    }
                } else if (i >= 26 && i <= 29) {
                    if (respostasAlunos.getResposta()[i].equalsIgnoreCase(respostasAlunos.getGabarito().getResposta()[i])) {
                        respostasAlunos.setQtdAcertosQuimica(respostasAlunos.getQtdAcertosQuimica() + 1);
                    }
                } else if (i >= 30 && i <= 33) {
                    if (respostasAlunos.getResposta()[i].equalsIgnoreCase(respostasAlunos.getGabarito().getResposta()[i])) {
                        respostasAlunos.setQtdAcertosFisica(respostasAlunos.getQtdAcertosFisica() + 1);
                    }
                } else if (i >= 34 && i <= 37) {
                    if (respostasAlunos.getResposta()[i].equalsIgnoreCase(respostasAlunos.getGabarito().getResposta()[i])) {
                        respostasAlunos.setQtdAcertosHistoria(respostasAlunos.getQtdAcertosHistoria() + 1);
                    }
                } else if (i >= 38 && i <= 41) {
                    if (respostasAlunos.getResposta()[i].equalsIgnoreCase(respostasAlunos.getGabarito().getResposta()[i])) {
                        respostasAlunos.setQtdAcertosGeografia(respostasAlunos.getQtdAcertosGeografia() + 1);
                    }
                } else if (i >= 42 && i <= 44) {
                    if (respostasAlunos.getResposta()[i].equalsIgnoreCase(respostasAlunos.getGabarito().getResposta()[i])) {
                        respostasAlunos.setQtdAcertosLinguas(respostasAlunos.getQtdAcertosLinguas() + 1);
                    }
                }
            }
            String primeiraOpcao = respostasAlunos.getAluno().getPrimeiraOpcaoDeCurso();
            if (primeiraOpcao.contains("Administração")
                    || primeiraOpcao.contains("Analise de Sistemas")
                    || primeiraOpcao.contains("Ciências Contábeis")
                    || primeiraOpcao.contains("Psicologia")
                    || primeiraOpcao.contains("Serviço Social")
                    || primeiraOpcao.contains("Direito")) {
                calcularPesosExatas(respostasAlunos);
            } else {
                calcularPesosSaude(respostasAlunos);
            }
            respostasAlunos.setNotaFinal(respostasAlunos.getNotaFinal() + respostasAlunos.getQtdAcertosRedacao());
            corrigirDAO.editarCorrigirGabarito(respostasAlunos);
        }
    }

    public void calcularPesosSaude(CorrigirGabarito respostaAluno) {
        // CALCULANDO A PONTUAÇÃO DE PORTUGUÊS
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosPortugues() * 20));

        //CALCULANDO A PONTUAÇÃO DE MATEMÁTICA
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosMatematica() * 20));

        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosBiologia() * 20));
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosFisica() * 20));
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosGeografia() * 20));
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosHistoria() * 20));
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosLinguas() * 20));
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosQuimica() * 20));

    }

    public void calcularPesosExatas(CorrigirGabarito respostaAluno) {
        // CALCULANDO A PONTUAÇÃO DE PORTUGUÊS
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosPortugues() * 40));

        //CALCULANDO A PONTUAÇÃO DE MATEMÁTICA
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosMatematica() * 40));

        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosBiologia() * 40));
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosFisica() * 40));
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosGeografia() * 40));
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosHistoria() * 40));
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosLinguas() * 40));
        respostaAluno.setNotaFinal(respostaAluno.getNotaFinal() + (respostaAluno.getQtdAcertosQuimica() * 40));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pesquisar1 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        tfNomeAluno1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        GerarRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Pesquisar1.setText("PESQUISAR");
        Pesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pesquisar1ActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jLabel47.setText("PROCESSO SELETIVO");

        tfNomeAluno1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfNomeAluno1.setEnabled(false);
        tfNomeAluno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeAluno1ActionPerformed(evt);
            }
        });
        tfNomeAluno1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNomeAluno1KeyTyped(evt);
            }
        });

        jButton1.setText("CALCULAR PONTUAÇÃO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GerarRelatorio.setText("GERAR RELATORIO");
        GerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfNomeAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Pesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(GerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomeAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pesquisar1))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Pesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pesquisar1ActionPerformed
        List<Gabarito> lista;
        lista = (dao.listarGabarito());
        GabaritoTableModel itm = new GabaritoTableModel(lista);
        Object objetoRetorno = PesquisaGenerica.exibeTela(itm, "Gabarito");
        if (objetoRetorno != null) {
            gabarito = dao.pesquisarGabarito((Integer) objetoRetorno);
            tfNomeAluno1.setText(gabarito.getNomeGabarito());
            corrigir = corrigirDAO.listarTodosOsGabaritosDigitados(gabarito.getId());
        }

    }//GEN-LAST:event_Pesquisar1ActionPerformed

    private void tfNomeAluno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeAluno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeAluno1ActionPerformed

    private void tfNomeAluno1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeAluno1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeAluno1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (gabarito.getId() != 0) {
            calcularPontuacao();
            JOptionPane.showMessageDialog(this, "CÁLCULO EFETUADO COM SUCESSO!");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione o processo seletivo!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void GerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerarRelatorioActionPerformed
        Document document = new Document();
        List<Aluno> aluno1 = alunoDAO.listarAluno();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("Documento.pdf"));

            document.open();

            Paragraph paragrafo = new Paragraph();
            paragrafo.setAlignment(1);
            document.add(paragrafo);
            paragrafo = new Paragraph("");
            document.add(paragrafo);

            PdfPTable tabela = new PdfPTable(2);

            PdfPCell cel1 = new PdfPCell(new Paragraph("ID"));
            PdfPCell cel2 = new PdfPCell(new Paragraph("NOME"));

            tabela.addCell(cel1);
            tabela.addCell(cel2);

            for (Aluno aluno : aluno1) {
                cel1 = new PdfPCell(new Paragraph(aluno.getId() + ""));
                cel2 = new PdfPCell(new Paragraph(aluno.getNome()));

                tabela.addCell(cel1);
                tabela.addCell(cel2);

            }
            document.add(tabela);

        } catch (FileNotFoundException | DocumentException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            document.close();
        }

        try {
            Desktop.getDesktop().open(new File("Documento.pdf"));
        } catch (IOException ex) {
            System.out.println("Erro: " + ex);
        }


    }//GEN-LAST:event_GerarRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(CalcularResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalcularResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalcularResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalcularResultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalcularResultado dialog = new CalcularResultado(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GerarRelatorio;
    private javax.swing.JButton Pesquisar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JTextField tfNomeAluno1;
    // End of variables declaration//GEN-END:variables
}
