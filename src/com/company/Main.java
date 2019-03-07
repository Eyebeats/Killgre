
package com.company;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Main extends javax.swing.JFrame {



    public String version = "0.5.2(A)";

    public Color background = new Color(255,255,0);

    public Color text = new Color(0,0,0);

    public Integer textsize = 40;

    public boolean piss = false;
    public boolean shoot = false;
    public boolean wee = false;
    public boolean staff = false;
    public ArrayList<String> cmds = new ArrayList<>();
    public Integer tp = 0;
    public Main() {
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        int conheight = height * 2 / 3 + 20;

        int cmdwidth = width * 2 / 2 - 30;



        jScrollPane1 = new javax.swing.JScrollPane();
        Console = new javax.swing.JTextArea();
        cmdline = new javax.swing.JTextField();

        Console.append("Hello! To proceed type your command in the box that reads 'Enter Command'\n\n");




        Console.setBackground(background);
        Console.setFont(new Font("serif", Font.BOLD, textsize));
        cmdline.setFont(new Font("serif", Font.BOLD, textsize));
        cmdline.setText("Enter Command");
        Console.setForeground(text);
        cmdline.setBackground(background);
        cmdline.setForeground(text);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Console.setColumns(20);
        Console.setRows(5);
        jScrollPane1.setViewportView(Console);

        this.setTitle("K1lLGR3 | " + version);
        cmdline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdlineMouseClicked(evt);
            }
        });
        cmdline.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmdlineKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addComponent(cmdline, javax.swing.GroupLayout.DEFAULT_SIZE, cmdwidth, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, conheight, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(cmdline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );

        pack();
    }

    public void updateTitle(String title){
        this.setTitle(title);
    }

    public void updateTSize(Integer value){

        if (value == 40){
            Console.append("Your text-size has been reset to the default size");
        }
        else {
            CommandManager cmd = new CommandManager();
            Console.setText("");
            Console.setFont(new Font("serif", Font.BOLD, value));
            cmdline.setFont(new Font("serif", Font.BOLD, value));

            Console.setText("");
            Console.append("Your text-size has been updated to: " + value + "\n\n To change to default use size reset");
        }


    }

    public void updateColor(Integer settings){

        CommandManager cm = new CommandManager();
        SecureRandom ro = new SecureRandom();


        if (settings == 0){
            background = new Color(255,255,0);
            text = new Color(0,0,0);
        }
        else if (settings == 1){
            background = new Color(0,0,0);
            text = new Color(255,255,0);
        }
        else if (settings == 2){
            background = new Color(0,0,0);
            text = new Color(50,255,40);
        }
        else if (settings == 3){
            background = new Color(0,0,0);
            text = new Color(255,255,0);
        }
        else if (settings == 123456789){
            background = new Color(ro.nextInt(255),ro.nextInt(255),ro.nextInt(255));
            text = new Color(ro.nextInt(255),ro.nextInt(255),ro.nextInt(255));
        }
        else if (settings == 4){
            background = new Color(0,255,255);
            text = new Color(0,0,255);
        }
        else if (settings == 5){
            background = new Color(150,255,0);
            text = new Color(0,150,0);
        }
        else if (settings == 6){
            background = new Color(255,170,186);
            text = new Color(255,0,0);
        }


        Console.setForeground(text);
        cmdline.setForeground(text);

        Console.setBackground(background);
        cmdline.setBackground(background);


        Console.append("Your color settings have been updated.\n If you wish to undo this please use 'settings reset'\n\n");

    }

    private void cmdlineKeyReleased(java.awt.event.KeyEvent evt) {

        CommandManager cmd = new CommandManager();

        if (cmdline.hasFocus()){
            if (evt.getKeyCode() == KeyEvent.VK_ENTER){

                String[] args = cmdline.getText().split(" ");

                String camd = cmdline.getText().replaceFirst("/", "");


                    if (!cmd.isCommand(camd, args)){
                        Console.setText("");
                        Console.append("Error. Unknown command.. Type '/Help' for a list of commands\n\n");
                        if (!cmdline.getText().equalsIgnoreCase("")){
                            cmds.add(cmdline.getText());
                            if (staff){
                                tp = cmds.size();
                                staff = false;
                            }
                            else {
                                tp++;
                            }

                        }
                        else {

                        }
                    }
                    else {
                        Console.setText("");
                        cmds.add(cmdline.getText());
                        if (staff){
                            tp = cmds.size();
                            staff = false;
                        }
                        else {
                            tp++;
                        }
                        if (cmdline.getText().contains("settings")){



                            if (cmd.resp == "one"){
                                updateColor(1);
                            }
                            else if (cmd.resp == "two"){
                                updateColor(2);
                            }
                            else if (cmd.resp == "three"){
                                updateColor(3);
                            }
                            else if (cmd.resp == "zero"){
                                updateColor(0);
                            }
                            else if (cmd.resp == "random"){
                                updateColor(123456789);
                            }
                            else if (cmd.resp == "bluetheme"){
                                updateColor(4);
                            }
                            else if (cmd.resp == "greentheme"){
                                updateColor(5);
                            }
                            else if (cmd.resp == "redtheme"){
                                updateColor(6);
                            }
                            else if (cmd.resp == "listcolors"){
                                Console.setText("");
                                Console.append("Current colors are:\n\nBlue\n\nRed\n\nGreen\n\n0\n\n1\n\n2\n\n3\n\nrandom");
                            }



                        }
                        if (cmdline.getText().contains("size")){
                            if (cmd.resp == "reset-0024"){
                                updateTSize(40);
                            }
                            else {
                                Integer tsize = Integer.valueOf(cmd.resp);
                                updateTSize(tsize);
                            }

                        }
                        else {
                            Console.append(cmd.resp + "\n\n");
                        }
                        cmdline.setText("");





                    }


            }
            if (evt.getKeyCode() == KeyEvent.VK_UP){

                shoot = true;
                staff = true;



                if (wee){
                    tp--;
                    wee = false;
                }
                Integer ltp = tp - 1;

                if (ltp == 0){
                    cmdline.setText(cmds.get(0));
                }
                else if (ltp > cmds.size()){
                    cmdline.setText(cmds.get(cmds.size()));

                }
                else if (cmds.size() > ltp){

                    tp--;
                    cmdline.setText(cmds.get(ltp));


                }

            }

            if (evt.getKeyCode() == KeyEvent.VK_DOWN){
                piss = true;
                wee = true;




                Integer ltp = tp;

                if (ltp == 0){
                    cmdline.setText(cmds.get(0));
                }
                else if (ltp > cmds.size()){
                    cmdline.setText(cmds.get(cmds.size()));
                }
                else if (cmds.size() > ltp){
                    cmdline.setText(cmds.get(ltp));
                    tp++;



                }
            }

        }
    }

    private void cmdlineMouseClicked(java.awt.event.MouseEvent evt) {






    }


    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }


    private javax.swing.JTextArea Console;
    private javax.swing.JTextField cmdline;
    private javax.swing.JScrollPane jScrollPane1;





}
