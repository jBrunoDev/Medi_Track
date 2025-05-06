package ui;

import constants.UIvariables;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginFrame extends JFrame {
    // criação das variaveis de componentes

    JPanel leftPanel, rightPanel;
    JLabel logoLabel, idLabel, passwordLabel, imgLabelPanelLeft, imgLabelContentPanelLeft, imgLabelLogoPanelIcon2;
    JTextField idField;
    JPasswordField passwordField;
    JButton btnLogin,  btnEye;
    ImageIcon logoIcon, logoPanelIcon, logoPanelIcon2, contentRightImage, eyeClose, eyeOpen ;

    public LoginFrame() {
        setTitle("Login");
        setSize(1500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        //definir o icon do logo
        URL iconUrl = getClass().getResource("../img/img-logo.png");
        if (iconUrl != null) {
            logoIcon = new ImageIcon(iconUrl);
            setIconImage(logoIcon.getImage());
        } else {
            System.err.println("Icone do logo não encontrado!");
        }


        //criação do painel esquerdo
        leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 750, 800);
        leftPanel.setBackground(UIvariables.BACKGROUND_PANEL_BLUE);
        leftPanel.setLayout(null);

        //criação do logo para o painel esquerdo
        URL logoPanelUrl = getClass().getResource("../img/img-logo.png");
        if (logoPanelUrl != null) {
            logoPanelIcon = new ImageIcon(logoPanelUrl);
            Image scaledLogo = logoPanelIcon.getImage().getScaledInstance(52, 52, Image.SCALE_SMOOTH);
            imgLabelPanelLeft = new JLabel(new ImageIcon(scaledLogo));
            imgLabelPanelLeft.setBounds(60, 45, 52, 52);
            leftPanel.add(imgLabelPanelLeft);
        } else {
            System.err.println("Logo para o painel esquerdo não encontrado!");
            imgLabelPanelLeft = new JLabel("Logo não encontrado");
            imgLabelPanelLeft.setBounds(60, 45, 150, 30); // Define um tamanho para o label de erro
            leftPanel.add(imgLabelPanelLeft);
        }


        logoLabel = new JLabel("MediTrack");
        logoLabel.setBounds(120, 50, 150, 40);
        logoLabel.setForeground(UIvariables.WHITE_COLOR);
        logoLabel.setFont(UIvariables.FONT_LOGO);

        //criação da imagem do painel
        contentRightImage = new ImageIcon(getClass().getResource("../img/img_Panel_Right.png"));
        Image scaledcontentRightImage = contentRightImage.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        imgLabelContentPanelLeft = new JLabel(contentRightImage);
        imgLabelContentPanelLeft.setBounds(125, 190, 500, 500);

        //criação do painel da direita
        rightPanel = new JPanel();
        rightPanel.setBounds(750, 0, 750, 800);
        rightPanel.setBackground(UIvariables.WHITE_COLOR);
        rightPanel.setLayout(null);

        //criacao dos componentes do painel da direita
        logoPanelIcon2 = new ImageIcon(getClass().getResource("../img/img-logo.png"));
        Image scaledlogoPanelIcon2 = contentRightImage.getImage().getScaledInstance(92, 92, Image.SCALE_SMOOTH);
        imgLabelLogoPanelIcon2 = new JLabel(logoPanelIcon2);
        imgLabelLogoPanelIcon2.setBounds(329, 94, 92, 92);

        //cricao dos inputs
        idLabel = new JLabel("ID");
        idLabel.setBounds(135, 250, 40, 40);
        idLabel.setFont(UIvariables.FONT_INPUT);
        idLabel.setForeground(UIvariables.BLACK_COLOR);


        idField = new JTextField();
        idField.setBounds(125, 290, 500, 60);
        idField.setFont(UIvariables.FONT_INPUT);

        passwordLabel = new JLabel("Senha");
        passwordLabel.setBounds(135, 370, 100, 40);
        passwordLabel.setFont(UIvariables.FONT_INPUT);
        passwordLabel.setForeground(UIvariables.BLACK_COLOR);


        passwordField = new JPasswordField();
        passwordField.setBounds(125, 410, 500, 60);
        passwordField.setFont(UIvariables.FONT_INPUT);



        /*Criação do botao do olho --> Criacao de um array. Olho fechado e olho aberto
          na posição [0] o olho esta fechado na posição [1] o olho está aberto

         */
         eyeClose = new ImageIcon(getClass().getResource("../img/img-eye-close.png"));
         eyeOpen = new ImageIcon(getClass().getResource("../img/img-eye-open.png"));

        btnEye = new JButton(eyeClose);
        btnEye.setContentAreaFilled(false);
        btnEye.setBorderPainted(false);
        btnEye.setFocusPainted(false);
        btnEye.setBounds(630, 420, 36, 36);

        //array [0] falso / [1] verdadeiro
        final boolean[] isEyeOpen = {false}; // Começa com o olho fechado

        // Configuração do botão
        btnEye.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnEye.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (isEyeOpen[0]) {
                    btnEye.setIcon(eyeClose); // Altera para o ícone de olho fechado
                    passwordField.setEchoChar('•');

                } else {
                    btnEye.setIcon(eyeOpen); // Altera para o ícone de olho aberto
                    passwordField.setEchoChar((char) 0); // Mostra o texto
                }
                isEyeOpen[0] = !isEyeOpen[0]; // Alterna o estado
            }
        });


        //criação do botão
        btnLogin = new JButton("Login");
        btnLogin.setBounds(110, 550, 530, 80);
        btnLogin.setBackground(UIvariables.BTN_COLOR);
        btnLogin.setForeground(UIvariables.WHITE_COLOR);
        btnLogin.setFont(UIvariables.FONT_BUTTON);

        //config botao login
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });


        add(leftPanel);
        leftPanel.add(logoLabel);
        leftPanel.add(imgLabelContentPanelLeft);
        add(rightPanel);
        rightPanel.add(imgLabelLogoPanelIcon2);
        rightPanel.add(idField);
        rightPanel.add(idLabel);
        rightPanel.add(passwordField);
        rightPanel.add(btnEye);
        rightPanel.add(passwordLabel);
        rightPanel.add(btnLogin);
        setVisible(true);
    }


    public static void main(String[] args) {
        new LoginFrame();
    }


}
