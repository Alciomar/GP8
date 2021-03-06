/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import aluno.Aluno;
import aluno.AlunoDAO;
import aluno.AlunoTableModel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ALCIOMAR
 */
public class CadastrarAluno extends javax.swing.JDialog {
    
    Aluno aluno = new Aluno();
    AlunoDAO alunoDAO = new AlunoDAO();
    
    String caminho;
    List<Aluno> listaAlunos = new ArrayList<>();
    
    List<String> lista = new ArrayList<>();
    
    public void limparCampos() {
        util.Util.limparCamposJDialog(this);
        aluno = new Aluno();
        Excluir.setEnabled(false);
    }
    
    public void lerXLS() {
        FileInputStream fisPlanilha = null;
        
        try {
            fisPlanilha = new FileInputStream(caminho);
            //cria um workbook = planilha toda com todas as abas
            XSSFWorkbook workbook = new XSSFWorkbook(fisPlanilha);

            //recuperamos apenas a primeira aba ou primeira planilha
            XSSFSheet sheet = workbook.getSheetAt(0);

            //retorna todas as linhas da planilha 0 (aba 1)
            Iterator<Row> rowIterator = sheet.iterator();

            //varre todas as linhas da planilha 0
            while (rowIterator.hasNext()) {

                //recebe cada linha da planilha
                Row row = rowIterator.next();

                //pegamos todas as celulas desta linha
                Iterator<Cell> cellIterator = row.iterator();

                //varremos todas as celulas da linha atual
                int contador = 0;
                Aluno aluno = new Aluno();
                while (cellIterator.hasNext()) {

                    //criamos uma celula
                    Cell cell = cellIterator.next();
                    if (contador == 0) {
                        aluno.setNome(cell.getStringCellValue());
                        contador++;
                    } else if (contador == 1) {
                        aluno.setEmail(cell.getStringCellValue());
                        contador++;
                    } else if (contador == 2) {
                        aluno.setTelefone(cell.getStringCellValue());
                        contador++;
                    } else if (contador == 3) {
                        aluno.setCidade(cell.getStringCellValue());
                        contador++;
                    } else if (contador == 4) {
                        aluno.setPrimeiraOpcaoDeCurso(cell.getStringCellValue());
                        contador++;
                    } else if (contador == 5) {
                        aluno.setSegundaOpcaoDeCurso(cell.getStringCellValue());
                        contador++;
                    } else if (contador == 6) {
                        
                        contador = 0;
                        
                        aluno.setCpf(cell.getStringCellValue());
                        listaAlunos.add(aluno);
                        aluno = new Aluno();
                    }
                    
                }
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fisPlanilha.close();
            } catch (IOException ex) {
                Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    /**
     * Creates new form CadastrarAluno
     */
    public CadastrarAluno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Excluir.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CarregarArquivo = new javax.swing.JButton();
        SalvarArquivo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Nome = new javax.swing.JTextField();
        SalvarAluno = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Arquivo = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        fechar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Telefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Cidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Pesquisar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        SegundaOpcaoDeCurso = new javax.swing.JComboBox<>();
        PrimeiraOpcaoDeCurso = new javax.swing.JComboBox<>();
        Cpf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(622, 353));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(622, 353));
        getContentPane().setLayout(null);

        CarregarArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/CARREGARARQUIVO.png"))); // NOI18N
        CarregarArquivo.setBorderPainted(false);
        CarregarArquivo.setContentAreaFilled(false);
        CarregarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarregarArquivoActionPerformed(evt);
            }
        });
        getContentPane().add(CarregarArquivo);
        CarregarArquivo.setBounds(470, 260, 110, 40);

        SalvarArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/salvar arquivo_1.png"))); // NOI18N
        SalvarArquivo.setBorderPainted(false);
        SalvarArquivo.setContentAreaFilled(false);
        SalvarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarArquivoActionPerformed(evt);
            }
        });
        getContentPane().add(SalvarArquivo);
        SalvarArquivo.setBounds(470, 300, 110, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("PRIMEIRA OPÇÃO DE CURSO");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 160, 156, 22);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("NOME.:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 40, 45, 22);
        getContentPane().add(Nome);
        Nome.setBounds(80, 30, 219, 32);

        SalvarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/salvar aluno.png"))); // NOI18N
        SalvarAluno.setBorderPainted(false);
        SalvarAluno.setContentAreaFilled(false);
        SalvarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarAlunoActionPerformed(evt);
            }
        });
        getContentPane().add(SalvarAluno);
        SalvarAluno.setBounds(360, 220, 120, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("E-MAIL.:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 80, 46, 22);
        getContentPane().add(Arquivo);
        Arquivo.setBounds(220, 270, 247, 23);
        getContentPane().add(Email);
        Email.setBounds(80, 80, 219, 32);

        fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/x.png"))); // NOI18N
        fechar.setBorderPainted(false);
        fechar.setContentAreaFilled(false);
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });
        getContentPane().add(fechar);
        fechar.setBounds(560, 0, 80, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("TEL.:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(340, 40, 62, 20);
        getContentPane().add(Telefone);
        Telefone.setBounds(370, 30, 219, 32);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("CIDADE.:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(320, 90, 62, 20);
        getContentPane().add(Cidade);
        Cidade.setBounds(370, 80, 219, 32);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("SEGUNDA OPÇÃO DE CURSO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(370, 160, 151, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("CPF.:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 130, 50, 20);

        Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/PESQUISAR_1.png"))); // NOI18N
        Pesquisar.setBorderPainted(false);
        Pesquisar.setContentAreaFilled(false);
        Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(Pesquisar);
        Pesquisar.setBounds(130, 220, 120, 40);

        Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/EXCLUIR_1.png"))); // NOI18N
        Excluir.setBorderPainted(false);
        Excluir.setContentAreaFilled(false);
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(Excluir);
        Excluir.setBounds(250, 220, 110, 40);

        SegundaOpcaoDeCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administração", "Analise de Sistemas ", "Ciências Contabeis ", "Direito", "Enfermagem", "Educação Física", "Fisioterapia", "Psicologia ", "Seviço Social" }));
        getContentPane().add(SegundaOpcaoDeCurso);
        SegundaOpcaoDeCurso.setBounds(380, 180, 122, 34);

        PrimeiraOpcaoDeCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administração", "Analise de Sistemas ", "Ciências Contabeis ", "Direito", "Enfermagem", "Educação Física", "Fisioterapia", "Psicologia ", "Seviço Social" }));
        getContentPane().add(PrimeiraOpcaoDeCurso);
        PrimeiraOpcaoDeCurso.setBounds(130, 180, 122, 34);
        getContentPane().add(Cpf);
        Cpf.setBounds(70, 120, 170, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/transparente 3.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 20, 600, 330);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/tela cadastrar aluno.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, -10, 630, 370);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CarregarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarregarArquivoActionPerformed
        JFileChooser arquivo = new JFileChooser();
        FileNameExtensionFilter filtroPDF = new FileNameExtensionFilter("Arquivos xlsx", "xlsx");
        arquivo.addChoosableFileFilter(filtroPDF);
        arquivo.setAcceptAllFileFilterUsed(false);
        if (arquivo.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            caminho = arquivo.getSelectedFile().getAbsolutePath();
            Arquivo.setText(caminho);
            lerXLS();
            
        }
    }//GEN-LAST:event_CarregarArquivoActionPerformed

    private void SalvarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarArquivoActionPerformed
        if (listaAlunos != null) {
            for (Aluno alunoIteracao : listaAlunos) {
                alunoDAO.salvarAluno(alunoIteracao);
            }
            JOptionPane.showMessageDialog(null, "Dandos Inseridos com sucesso!");
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Dados nao Inseridos!");
            
        }
    }//GEN-LAST:event_SalvarArquivoActionPerformed

    private void SalvarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarAlunoActionPerformed
        if (alunoDAO.validarAluno(Cpf.getText()) == null) {
            if (!Nome.getText().equals("") && !Email.getText().equals("") && !Telefone.getText().equals("")
                    && !Cidade.getText().equals("")
                    && !PrimeiraOpcaoDeCurso.getSelectedItem().equals("")
                    && !SegundaOpcaoDeCurso.getSelectedItem().equals("")) {
                
                aluno.setNome(Nome.getText());
                aluno.setEmail(Email.getText());
                aluno.setCidade(Cidade.getText());
                aluno.setTelefone(Telefone.getText());
                aluno.setPrimeiraOpcaoDeCurso(String.valueOf(PrimeiraOpcaoDeCurso.getSelectedItem()));
                aluno.setSegundaOpcaoDeCurso(String.valueOf(SegundaOpcaoDeCurso.getSelectedItem()));
                aluno.setCpf(String.valueOf(Cpf.getText()));
                
                if (aluno.getId() == 0) {
                    
                    alunoDAO.salvarAluno(aluno);
                    JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
                    
                } else {
                    alunoDAO.editarAluno(aluno);
                    JOptionPane.showMessageDialog(null, "Aluno editado com sucesso!");
                }
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Existem campos obrigatórios que não foram preenchidos!");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "CPF já cadastrado");
        }
    }//GEN-LAST:event_SalvarAlunoActionPerformed

    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed
        
       System.exit(0);
    }//GEN-LAST:event_fecharActionPerformed

    private void PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarActionPerformed
        List<Aluno> lista;
        lista = (alunoDAO.listarAluno());
        AlunoTableModel itm = new AlunoTableModel(lista);
        Object objetoRetorno = PesquisaGenerica.exibeTela(itm, "Aluno");
        if (objetoRetorno != null) {
            aluno = alunoDAO.pesquisarAlunoId((Integer) objetoRetorno);
            Nome.setText(aluno.getNome());
            Email.setText(aluno.getEmail());
            Telefone.setText(aluno.getTelefone());
            Cidade.setText(aluno.getCidade());
            PrimeiraOpcaoDeCurso.setSelectedItem(aluno.getPrimeiraOpcaoDeCurso());
            SegundaOpcaoDeCurso.setSelectedItem(aluno.getSegundaOpcaoDeCurso());
            Cpf.setText(aluno.getCpf());
            
            Excluir.setEnabled(true);
            
        }

    }//GEN-LAST:event_PesquisarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        alunoDAO.excluirAluno(aluno);
        JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
        limparCampos();
    }//GEN-LAST:event_ExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastrarAluno dialog = new CadastrarAluno(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField Arquivo;
    private javax.swing.JButton CarregarArquivo;
    private javax.swing.JTextField Cidade;
    private javax.swing.JTextField Cpf;
    private javax.swing.JTextField Email;
    private javax.swing.JButton Excluir;
    private javax.swing.JTextField Nome;
    private javax.swing.JButton Pesquisar;
    private javax.swing.JComboBox<String> PrimeiraOpcaoDeCurso;
    private javax.swing.JButton SalvarAluno;
    private javax.swing.JButton SalvarArquivo;
    private javax.swing.JComboBox<String> SegundaOpcaoDeCurso;
    private javax.swing.JTextField Telefone;
    private javax.swing.JButton fechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
