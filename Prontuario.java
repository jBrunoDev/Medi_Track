package ui;

import constants.UIvariables;

import javax.swing.*;
import java.awt.*;

public class Prontuario extends JFrame {

    private JPanel panelContent, panelDadosPessoais, panelEstadoClinico;
    private JLabel labelTitulo, labelIcon, labelIcon2;
    private ImageIcon icon, icon2;

    public Prontuario() {
        setTitle("Prontuário");
        setSize(1500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null); // usaremos layout absoluto para controle total

        // Fundo azul claro
        getContentPane().setBackground(new Color(173, 216, 230)); // Azul claro (light blue)

        // Painel branco (conteúdo)
        panelContent = new JPanel();
        panelContent.setBackground(new Color(240, 248, 255)); // branco com tom azulado
        panelContent.setBounds(100, 100, 1300, 550);
        panelContent.setLayout(null);
        add(panelContent);

        //imagem
        icon = new ImageIcon(getClass().getResource("../img/assets/icon-prontuario.png"));
        labelIcon = new JLabel(icon);
        labelIcon.setBounds(20, 5, 80, 80);
        panelContent.add(labelIcon);


        // Título
        labelTitulo = new JLabel("Prontuário");
        labelTitulo.setFont(UIvariables.FONT_TITLE);
        labelTitulo.setBounds(80, 33, 300, 40);
        panelContent.add(labelTitulo);

        // Linha divisória horizontal
        JSeparator separator = new JSeparator();
        separator.setBounds(20, 70, 1260, 1);
        panelContent.add(separator);

        // Painel Dados Pessoais
        panelDadosPessoais = new JPanel();
        panelDadosPessoais.setLayout(new GridLayout(6, 1, 10, 10));
        panelDadosPessoais.setBounds(250, 130, 300, 300);
        panelDadosPessoais.setBackground(null);
        panelContent.add(panelDadosPessoais);

        JLabel labelDados = new JLabel("Dados Pessoais");
        labelDados.setFont(UIvariables.FONT_BUTTON);
        labelDados.setForeground(UIvariables.BLACK_COLOR);
        panelDadosPessoais.add(labelDados);

        panelDadosPessoais.add(createInfoLabel("CPF:", "47100065652"));
        panelDadosPessoais.add(createInfoLabel("Temperatura:", "37,5"));
        panelDadosPessoais.add(createInfoLabel("Peso:", "80 kg"));
        panelDadosPessoais.add(createInfoLabel("Altura:", "1.80"));
        panelDadosPessoais.add(createInfoLabel("Idade:", "25"));

        // Painel Estado Clínico
        panelEstadoClinico = new JPanel();
        panelEstadoClinico.setLayout(new GridLayout(4, 1, 10, 10));
        panelEstadoClinico.setBounds(700, 120, 300, 300);
        panelEstadoClinico.setBackground(null);
        panelContent.add(panelEstadoClinico);

        JLabel estadoClinico = new JLabel("Estado Clínico");
        estadoClinico.setFont(UIvariables.FONT_BUTTON);
        estadoClinico.setForeground(UIvariables.BLACK_COLOR);
        panelEstadoClinico.add(estadoClinico);

        panelEstadoClinico.add(createInfoLabel("Sintomas:", "O paciente está azul"));
        panelEstadoClinico.add(createInfoLabel("Alergias:", "O paciente possui alergia a Dipirona"));
        panelEstadoClinico.add(createInfoLabel("Obs:", "<html>Ao examinar o paciente aparenta que ele teve uma reação alérgica ao medicamento</html>"));

        icon2 = new ImageIcon(getClass().getResource("../img/assets/icon-line-vertical.png"));
        labelIcon2 = new JLabel(icon2);

        labelIcon2.setBounds(500, 100, 100, 400);
        panelContent.add(labelIcon2);

        setVisible(true);
    }

    private JPanel createInfoLabel(String titulo, String valor) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(null);

        JLabel labelTitulo = new JLabel(titulo);
        labelTitulo.setFont(UIvariables.FONT_INPUT );
        labelTitulo.setForeground(UIvariables.BLACK_COLOR);

        JLabel labelValor = new JLabel(valor);
        labelValor.setFont(UIvariables.FONT_TITLE2);

        panel.add(labelTitulo);
        panel.add(labelValor);

        return panel;
    }

    public static void main(String[] args) {
        new Prontuario();
    }
}
