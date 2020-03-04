/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Soundbank;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javazoom.jl.player.Player;

/**
 *
 * @author pavilion
 */
public class NewApplication extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form NewApplication
     */
    String names[];
    boolean start=false,first=false,second=false,third=false,fourth=false;
    JButton[] firstPlayerButton;
    JButton[] secondPlayerButton;
    JButton[] thirdPlayerButton;
    JButton[] fourthPlayerButton;
    JButton[] scoreButton;
    ArrayList<Integer> list;
    int player;
    Icon icon,icon2;
    int points[];
    int call[];
    Random random=new Random();
    public NewApplication() {
        initComponents();
        this.getContentPane().setBackground(Color.BLACK);
        menuBar.setBackground(Color.RED);
        fileMenu.setForeground(Color.WHITE);
        editMenu.setForeground(Color.WHITE);
        helpMenu.setForeground(Color.WHITE);
        icon=new ImageIcon(getClass().getResource("xyz.jpg"));
        icon2=new ImageIcon(getClass().getResource("Groups-Meeting-Light-icon.png"));
        firstPlayerButton=new JButton[8];
        secondPlayerButton=new JButton[8];
        thirdPlayerButton=new JButton[8];
        fourthPlayerButton=new JButton[8];
        scoreButton=new JButton[4];
        list=new ArrayList<>();
        this.initializeButton();
        //initCard();
    }
    public void initializeButton()
    {
        /**
         * first player card button
         */
        firstPlayerButton[0]=jButton11;
        firstPlayerButton[1]=jButton12;
        firstPlayerButton[2]=jButton13;
        firstPlayerButton[3]=jButton14;
        firstPlayerButton[4]=jButton18;
        firstPlayerButton[5]=jButton17;
        firstPlayerButton[6]=jButton16;
        firstPlayerButton[7]=jButton15;
        
        /**
         * second player card button
         */
        secondPlayerButton[0]=jButton2;
        secondPlayerButton[1]=jButton3;
        secondPlayerButton[2]=jButton4;
        secondPlayerButton[3]=jButton5;
        secondPlayerButton[4]=jButton9;
        secondPlayerButton[5]=jButton8;
        secondPlayerButton[6]=jButton7;
        secondPlayerButton[7]=jButton6;
        
        /**
         * third player card button
         */
        thirdPlayerButton[0]=jButton20;
        thirdPlayerButton[1]=jButton21;
        thirdPlayerButton[2]=jButton22;
        thirdPlayerButton[3]=jButton23;
        thirdPlayerButton[4]=jButton27;
        thirdPlayerButton[5]=jButton26;
        thirdPlayerButton[6]=jButton25;
        thirdPlayerButton[7]=jButton24;
        
        /**
         * fourth player card button
         */
        fourthPlayerButton[0]=jButton29;
        fourthPlayerButton[1]=jButton30;
        fourthPlayerButton[2]=jButton31;
        fourthPlayerButton[3]=jButton32;
        fourthPlayerButton[4]=jButton36;
        fourthPlayerButton[5]=jButton35;
        fourthPlayerButton[6]=jButton34;
        fourthPlayerButton[7]=jButton33;
        /**
         * score button
         */
        scoreButton[0]=jButtonF;
        scoreButton[1]=jButtonS;
        scoreButton[2]=jButtonT;
        scoreButton[3]=jButtonFo;
        
    }
    public void initCard()       
    {
        for(int i=2;i<=64;i+=2)
        {
            list.add(i);
        }
        Collections.shuffle(list);
        for(int i=0;i<4;i++)
        {
            shuffleCard(i);
            points[i]=0;
        }   
    }
    public void shuffleCard(int x)
    {
        if(x==0)
        {
            for(int i=0;i<8;i++)
            {
                firstPlayerButton[i].setBackground(Color.BLACK);
                firstPlayerButton[i].setForeground(Color.BLACK);
                firstPlayerButton[i].setText(list.get(i).toString());
                //firstPlayerButton[i].doClick();
                if(player>=1)
                {
                    firstPlayerButton[i].addActionListener(this);
                    first=true;
                        /*new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            for(int k=0;k<8;k++)
                            {
                                if(firstPlayerButton[k]==e.getSource())
                                {
                                   jButtonF.setText(firstPlayerButton[k].getText());
                                   secondPlayerButton[2].doClick();
                                }
                            }
                        }
                    });*/
                }
            }
        }
        if(x==1)
        {
            for(int i=0;i<8;i++)
            {
                secondPlayerButton[i].setBackground(Color.BLACK);
                secondPlayerButton[i].setForeground(Color.BLACK);
                secondPlayerButton[i].setText(list.get(8+i).toString());
                if(player>=2)
                {
                    secondPlayerButton[i].addActionListener(this);
                       /* new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            for(int k=0;k<8;k++)
                            {
                                if(secondPlayerButton[k]==e.getSource())
                                {
                                   jButtonS.setText(secondPlayerButton[k].getText());
                                }
                            }
                        }
                    });*/
                }
            }
        }
        if(x==2)
        {
            for(int i=0;i<8;i++)
            {
                thirdPlayerButton[i].setBackground(Color.BLACK);
                thirdPlayerButton[i].setForeground(Color.BLACK);
                thirdPlayerButton[i].setText(list.get(16+i).toString());
                if(player>=3)
                {
                    thirdPlayerButton[i].addActionListener(this);
                        /*new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            for(int k=0;k<8;k++)
                            {
                                if(thirdPlayerButton[k]==e.getSource())
                                {
                                   jButtonT.setText(thirdPlayerButton[k].getText());
                                }
                            }
                        }
                    });*/
                }
            }
        }
        if(x==3)
        {
            for(int i=0;i<8;i++)
            {
                fourthPlayerButton[i].setBackground(Color.BLACK);
                fourthPlayerButton[i].setForeground(Color.BLACK);
                fourthPlayerButton[i].setText(list.get(23+i).toString());
                if(player>=4)
                {
                    fourthPlayerButton[i].addActionListener(this);
                       /* new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            for(int k=0;k<8;k++)
                            {
                                if(fourthPlayerButton[k]==e.getSource())
                                {
                                   jButtonFo.setText(fourthPlayerButton[k].getText());
                                }
                            }
                        }
                    });*/
                }
            }
        }
    }
    public void clearText()
    {
        jLabel2.setText("********************");
        jLabel3.setText("**************************");
        jButtonF.setText("*");
        jButtonS.setText("*");
        jButtonT.setText("*");
        jButtonFo.setText("*");
    }
    public void startPlay(int a)
    {
       /* AudioPlayer mgp=AudioPlayer.player;
        AudioStream bgm;
        AudioData md;
        ContinuousAudioDataStream loop=null;
        try
        {
            //
            bgm=new AudioStream(new FileInputStream("Alan.mp3"));
            md=bgm.getData();
            loop=new ContinuousAudioDataStream(md);
        }
        catch(Exception e)
        {
            
        }
        mgp.start();*/
        String snd[]={"C:\\Users\\pavilion\\Documents\\NetBeansProjects\\CardGame\\src\\cardgame\\Play1 running.mp3"
                ,"C:\\Users\\pavilion\\Documents\\NetBeansProjects\\CardGame\\src\\cardgame\\Play2 running.mp3",
                "C:\\Users\\pavilion\\Documents\\NetBeansProjects\\CardGame\\src\\cardgame\\Pacman_Introduction_Music-KP-826387403.mp3"};
        if(a!=0)
            a=random.nextInt(2);
        else
            a=2;
        try
        {
            File file=new File(snd[a]);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis=new BufferedInputStream(fis);
            Player player=new Player(bis);
            player.play();
        }
        catch(Exception ex)
        {
            
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(first)
        {
            for(int i=0;i<8;i++)
            {
                if(firstPlayerButton[i]==e.getSource() && firstPlayerButton[i].getBackground()==Color.BLACK)
                {
                   clearText();
                   firstPlayerButton[i].setBackground(Color.red);
                   startPlay(1);
                   jButtonF.setText(firstPlayerButton[i].getText());
                   first=false;
                   second=true;
                   if(player==1)
                   {
                       computerPlaying(1);
                   }
                }
            }
        }
        else if(second)
        {
            for(int k=0;k<8;k++)
            {
                if(secondPlayerButton[k]==e.getSource() && secondPlayerButton[k].getBackground()==Color.BLACK)
                {
                   jButtonS.setText(secondPlayerButton[k].getText());
                   secondPlayerButton[k].setBackground(Color.red);
                   startPlay(1);
                   second=false;
                   third=true;
                   if(player==2)
                   {
                       computerPlaying(2);
                   }
                }
            }
        }
        else if(third)
        {
            for(int k=0;k<8;k++)
            {
                if(thirdPlayerButton[k]==e.getSource() && thirdPlayerButton[k].getBackground()==Color.BLACK)
                {
                   jButtonT.setText(thirdPlayerButton[k].getText());
                   startPlay(1);
                   thirdPlayerButton[k].setBackground(Color.red);
                   third=false;
                   fourth=true;
                   if(player==3)
                   {
                       computerPlaying(3);
                   }
                }
            }
        }
        else if(fourth)
        {
            for(int k=0;k<8;k++)
            {
                if(fourthPlayerButton[k]==e.getSource() && fourthPlayerButton[k].getBackground()==Color.BLACK)
                {
                   System.out.println(k);
                   jButtonFo.setText(fourthPlayerButton[k].getText());
                   startPlay(1);
                   fourthPlayerButton[k].setBackground(Color.red);
                   fourth=false;
                   first=true;
                   //clearText();
                   checkMaximumCard();
                }
            }
        }
    }
    public void computerPlaying(int x)
    {
        for(int i=x;i<4;i++)
        {
            int w;
            while(true)
            {
                w=random.nextInt(8);
                if(i==1 && secondPlayerButton[w].getBackground()==Color.BLACK)
                    break;
                else if(i==2 && thirdPlayerButton[w].getBackground()==Color.BLACK)
                    break;
                else if(i==3 && fourthPlayerButton[w].getBackground()==Color.BLACK)
                    break;
            }
            clickOnCard(i,w);
            startPlay(1);
            scoreButton[i].setText(list.get(8*i+w)+"");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(NewApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        first=true;
        checkMaximumCard();
    }
    public void clickOnCard(int m,int n)
    {
        if(m==1)
        {
            secondPlayerButton[n].doClick(250);
            secondPlayerButton[n].setBackground(Color.red);
        }
        else if(m==2)
        {
            thirdPlayerButton[n].doClick(250);
            thirdPlayerButton[n].setBackground(Color.red);
        }
        else if(m==3)
        {
            fourthPlayerButton[n].doClick(250);
            fourthPlayerButton[n].setBackground(Color.red);
        }
    }
    public void checkMaximumCard()
    {
        int max=-1;
        int save=-1,sum=0;
        for(int i=0;i<4;i++)
        {
            if(Integer.parseInt(scoreButton[i].getText())>max)
            {
                max=Integer.parseInt(scoreButton[i].getText());
                save=i;
            }
            sum+=Integer.parseInt(scoreButton[i].getText());
        }
        points[save]+=sum;
        if(save==0)
        {
            jLabel1.setText("Point : "+points[save]);
        }
        else if(save==1)
        {
            jLabel8.setText("Point : "+points[save]);
        }
        else if(save==2)
        {
            jLabel6.setText("Point : "+points[save]);
        }
        else if(save==3)
        {
            jLabel10.setText("Point : "+points[save]);
        }
        jLabel2.setText("Highest Crad found from "+names[save]);
        jLabel3.setText("So he get all card..!");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelName1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabelName2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabelName3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabelName4 = new javax.swing.JLabel();
        jButtonS = new javax.swing.JButton();
        jButtonF = new javax.swing.JButton();
        jButtonFo = new javax.swing.JButton();
        jButtonT = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newGameJMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        resultMenuItem = new javax.swing.JMenuItem();
        storyAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        developerMenuItem = new javax.swing.JMenuItem();
        designerMenuItem = new javax.swing.JMenuItem();
        programmerMenuItem = new javax.swing.JMenuItem();
        storyWritterMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        controlMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Developed By SUFIAN");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Second Player : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/msDefaultPicture@2x.png"))); // NOI18N

        jButton11.setFont(new java.awt.Font("Algerian", 0, 1)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 153, 153));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setMultiClickThreshhold(2L);
        jButton11.setPreferredSize(null);
        jButton11.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton11.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton12.setFont(new java.awt.Font("Algerian", 0, 1)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 153, 153));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setMultiClickThreshhold(2L);
        jButton12.setPreferredSize(null);
        jButton12.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton12.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton13.setFont(new java.awt.Font("Algerian", 0, 1)); // NOI18N
        jButton13.setForeground(new java.awt.Color(0, 153, 153));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setMultiClickThreshhold(2L);
        jButton13.setPreferredSize(null);
        jButton13.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton13.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton14.setFont(new java.awt.Font("Algerian", 0, 1)); // NOI18N
        jButton14.setForeground(new java.awt.Color(0, 153, 153));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setMultiClickThreshhold(2L);
        jButton14.setPreferredSize(null);
        jButton14.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton14.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton15.setFont(new java.awt.Font("Algerian", 0, 1)); // NOI18N
        jButton15.setForeground(new java.awt.Color(0, 153, 153));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setMultiClickThreshhold(2L);
        jButton15.setPreferredSize(null);
        jButton15.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton15.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton15.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton16.setFont(new java.awt.Font("Algerian", 0, 1)); // NOI18N
        jButton16.setForeground(new java.awt.Color(0, 153, 153));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton16.setFocusable(false);
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setMultiClickThreshhold(2L);
        jButton16.setPreferredSize(null);
        jButton16.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton16.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton16.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton17.setFont(new java.awt.Font("Algerian", 0, 1)); // NOI18N
        jButton17.setForeground(new java.awt.Color(0, 153, 153));
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton17.setFocusable(false);
        jButton17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton17.setMultiClickThreshhold(2L);
        jButton17.setPreferredSize(null);
        jButton17.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton17.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton17.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton18.setFont(new java.awt.Font("Algerian", 0, 1)); // NOI18N
        jButton18.setForeground(new java.awt.Color(0, 153, 153));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton18.setFocusable(false);
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton18.setMultiClickThreshhold(2L);
        jButton18.setPreferredSize(null);
        jButton18.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton18.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton18.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Point : ");

        jLabelName1.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        jLabelName1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelName1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelName1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Second Player : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPreferredSize(null);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton2.setRequestFocusEnabled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton3.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setPreferredSize(null);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton3.setRequestFocusEnabled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton3.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton4.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setPreferredSize(null);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton4.setRequestFocusEnabled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton4.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton5.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setPreferredSize(null);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton5.setRequestFocusEnabled(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton5.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton6.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setPreferredSize(null);
        jButton6.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton6.setRequestFocusEnabled(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton6.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton7.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setPreferredSize(null);
        jButton7.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton7.setRequestFocusEnabled(false);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton7.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton8.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setPreferredSize(null);
        jButton8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton8.setRequestFocusEnabled(false);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton8.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton9.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setPreferredSize(null);
        jButton9.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton9.setRequestFocusEnabled(false);
        jButton9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton9.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/msDefaultPicture@2x.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Point : ");

        jLabelName2.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        jLabelName2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabelName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelName2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Second Player : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jButton20.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton20.setFocusable(false);
        jButton20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton20.setPreferredSize(null);
        jButton20.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton20.setRequestFocusEnabled(false);
        jButton20.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton20.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton21.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton21.setFocusable(false);
        jButton21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton21.setPreferredSize(null);
        jButton21.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton21.setRequestFocusEnabled(false);
        jButton21.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton21.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton22.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton22.setFocusable(false);
        jButton22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton22.setPreferredSize(null);
        jButton22.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton22.setRequestFocusEnabled(false);
        jButton22.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton22.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton23.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton23.setFocusable(false);
        jButton23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton23.setPreferredSize(null);
        jButton23.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton23.setRequestFocusEnabled(false);
        jButton23.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton23.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton24.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton24.setFocusable(false);
        jButton24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton24.setPreferredSize(null);
        jButton24.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton24.setRequestFocusEnabled(false);
        jButton24.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton24.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton25.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton25.setFocusable(false);
        jButton25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton25.setPreferredSize(null);
        jButton25.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton25.setRequestFocusEnabled(false);
        jButton25.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton25.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton26.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton26.setFocusable(false);
        jButton26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton26.setPreferredSize(null);
        jButton26.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton26.setRequestFocusEnabled(false);
        jButton26.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton26.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton27.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton27.setFocusable(false);
        jButton27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton27.setPreferredSize(null);
        jButton27.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton27.setRequestFocusEnabled(false);
        jButton27.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton27.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/msDefaultPicture@2x.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Point : ");

        jLabelName3.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        jLabelName3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jLabelName3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelName3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Second Player : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jButton29.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton29.setFocusable(false);
        jButton29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton29.setPreferredSize(null);
        jButton29.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton29.setRequestFocusEnabled(false);
        jButton29.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton29.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton30.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton30.setFocusable(false);
        jButton30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton30.setPreferredSize(null);
        jButton30.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton30.setRequestFocusEnabled(false);
        jButton30.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton30.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton31.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton31.setFocusable(false);
        jButton31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton31.setPreferredSize(null);
        jButton31.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton31.setRequestFocusEnabled(false);
        jButton31.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton31.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton32.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton32.setFocusable(false);
        jButton32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton32.setPreferredSize(null);
        jButton32.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton32.setRequestFocusEnabled(false);
        jButton32.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton32.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton33.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton33.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton33.setFocusable(false);
        jButton33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton33.setPreferredSize(null);
        jButton33.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton33.setRequestFocusEnabled(false);
        jButton33.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton33.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton34.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton34.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton34.setFocusable(false);
        jButton34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton34.setPreferredSize(null);
        jButton34.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton34.setRequestFocusEnabled(false);
        jButton34.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton34.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton35.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton35.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton35.setFocusable(false);
        jButton35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton35.setPreferredSize(null);
        jButton35.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton35.setRequestFocusEnabled(false);
        jButton35.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton35.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton36.setFont(new java.awt.Font("Agency FB", 0, 1)); // NOI18N
        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jButton36.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton36.setFocusable(false);
        jButton36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton36.setPreferredSize(null);
        jButton36.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        jButton36.setRequestFocusEnabled(false);
        jButton36.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        jButton36.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N

        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/msDefaultPicture@2x.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Point : ");

        jLabelName4.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        jLabelName4.setForeground(new java.awt.Color(0, 0, 0));
        jLabelName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabelName4, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelName4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButtonS.setBackground(new java.awt.Color(4, 69, 8));
        jButtonS.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButtonS.setForeground(new java.awt.Color(255, 255, 255));
        jButtonS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Stock.png"))); // NOI18N
        jButtonS.setToolTipText("");
        jButtonS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonS.setIconTextGap(3);
        jButtonS.setMultiClickThreshhold(2L);
        jButtonS.setRequestFocusEnabled(false);
        jButtonS.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Search-icon.png"))); // NOI18N
        jButtonS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButtonF.setBackground(new java.awt.Color(102, 0, 102));
        jButtonF.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButtonF.setForeground(new java.awt.Color(255, 255, 255));
        jButtonF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Stock.png"))); // NOI18N
        jButtonF.setToolTipText("");
        jButtonF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonF.setIconTextGap(3);
        jButtonF.setMultiClickThreshhold(2L);
        jButtonF.setRequestFocusEnabled(false);
        jButtonF.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Search-icon.png"))); // NOI18N
        jButtonF.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButtonFo.setBackground(new java.awt.Color(255, 102, 0));
        jButtonFo.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButtonFo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Stock.png"))); // NOI18N
        jButtonFo.setToolTipText("");
        jButtonFo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFo.setIconTextGap(3);
        jButtonFo.setMultiClickThreshhold(2L);
        jButtonFo.setRequestFocusEnabled(false);
        jButtonFo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Search-icon.png"))); // NOI18N
        jButtonFo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButtonT.setBackground(new java.awt.Color(0, 0, 102));
        jButtonT.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButtonT.setForeground(new java.awt.Color(255, 255, 255));
        jButtonT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Stock.png"))); // NOI18N
        jButtonT.setToolTipText("");
        jButtonT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonT.setIconTextGap(3);
        jButtonT.setMultiClickThreshhold(2L);
        jButtonT.setRequestFocusEnabled(false);
        jButtonT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Search-icon.png"))); // NOI18N
        jButtonT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel44.setFont(new java.awt.Font("Castellar", 1, 50)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 0, 0));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("CARD GAMES");
        jLabel44.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel44.setDoubleBuffered(true);
        jLabel44.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel44.setIconTextGap(5);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("**************************");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("********************");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Groups-Meeting-Light-icon.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/user-group-icon.png"))); // NOI18N

        menuBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));

        fileMenu.setBackground(new java.awt.Color(153, 0, 0));
        fileMenu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Stock.png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("File");
        fileMenu.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N

        newGameJMenu.setBackground(new java.awt.Color(255, 102, 0));
        newGameJMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Spacer32.png"))); // NOI18N
        newGameJMenu.setText("New Game");
        newGameJMenu.setFocusable(false);
        newGameJMenu.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jMenuItem1.setText("Player Number 1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        newGameJMenu.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jMenuItem2.setText("Player Number 2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        newGameJMenu.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jMenuItem3.setText("Player Number 3");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        newGameJMenu.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1176.png"))); // NOI18N
        jMenuItem4.setText("Player Number 4");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        newGameJMenu.add(jMenuItem4);

        fileMenu.add(newGameJMenu);

        resultMenuItem.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        resultMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Search.png"))); // NOI18N
        resultMenuItem.setMnemonic('s');
        resultMenuItem.setText("Result");
        resultMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(resultMenuItem);

        storyAsMenuItem.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        storyAsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Edite.png"))); // NOI18N
        storyAsMenuItem.setMnemonic('a');
        storyAsMenuItem.setText("Story");
        storyAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storyAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(storyAsMenuItem);

        exitMenuItem.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/close.png"))); // NOI18N
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setBackground(new java.awt.Color(153, 0, 0));
        editMenu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        editMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/Purchasing Details.png"))); // NOI18N
        editMenu.setMnemonic('e');
        editMenu.setText("About");
        editMenu.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N

        developerMenuItem.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        developerMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1178.png"))); // NOI18N
        developerMenuItem.setMnemonic('t');
        developerMenuItem.setText("Developer");
        developerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                developerMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(developerMenuItem);

        designerMenuItem.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        designerMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1178.png"))); // NOI18N
        designerMenuItem.setMnemonic('y');
        designerMenuItem.setText("Designer");
        designerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                designerMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(designerMenuItem);

        programmerMenuItem.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        programmerMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1178.png"))); // NOI18N
        programmerMenuItem.setMnemonic('p');
        programmerMenuItem.setText("Programmer");
        programmerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programmerMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(programmerMenuItem);

        storyWritterMenuItem.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        storyWritterMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/1178.png"))); // NOI18N
        storyWritterMenuItem.setMnemonic('d');
        storyWritterMenuItem.setText("Story Writer");
        storyWritterMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storyWritterMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(storyWritterMenuItem);

        menuBar.add(editMenu);

        helpMenu.setBackground(new java.awt.Color(153, 0, 0));
        helpMenu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");
        helpMenu.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N

        controlMenuItem.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        controlMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cardgame/logo.png"))); // NOI18N
        controlMenuItem.setMnemonic('c');
        controlMenuItem.setText("Control");
        controlMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(controlMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonS, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jButtonFo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jButtonS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(jButtonT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonFo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        //resultMenuItem.;
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        list.clear();
        numberOfPlayer(1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        list.clear();
        numberOfPlayer(2);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        list.clear();
        numberOfPlayer(3);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        list.clear();
        numberOfPlayer(4);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void developerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_developerMenuItemActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "ABU SUFIAN\nCSE,PREMIER UNIVERSITY", "DEVELOPER", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_developerMenuItemActionPerformed

    private void designerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_designerMenuItemActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "ABU SUFIAN\nCSE,PREMIER UNIVERSITY", "DESIGNER", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_designerMenuItemActionPerformed

    private void programmerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programmerMenuItemActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "ABU SUFIAN\nCSE,PREMIER UNIVERSITY", "PROGRAMMER", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_programmerMenuItemActionPerformed

    private void storyWritterMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storyWritterMenuItemActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "ABU SUFIAN\nCSE,PREMIER UNIVERSITY", "STORY WRITTER", JOptionPane.INFORMATION_MESSAGE, icon);

    }//GEN-LAST:event_storyWritterMenuItemActionPerformed

    private void storyAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storyAsMenuItemActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "ABU SUFIAN\nCSE,PREMIER UNIVERSITY", "STORY", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_storyAsMenuItemActionPerformed

    private void resultMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultMenuItemActionPerformed
        // TODO add your handling code here:
        try
        {
            String str="";
            int max=0,save=-1;
            for(int i=0;i<4;i++)
            {
                if(points[i]>=call[i])
                {
                    str+=names[i]+" is succeed..Your current point = "+points[i]+" & Target points = "+call[i]+"\n";
                    if(max<call[i])
                    {
                        max=call[i];
                        save=i;
                    }
                }
                else if(points[i]<call[i])
                    str+=names[i]+" is failed..Your current point = "+points[i]+" & Target points = "+call[i]+"\n";
            }
            str+="\nCongratulation..!! "+names[save];
            JOptionPane.showMessageDialog(null, str,"RESULT",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Result is not ready....!!!!","Result",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_resultMenuItemActionPerformed

    private void controlMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlMenuItemActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "The black square box indecate the cards\n"
                + "All cards have distict points\n"
                + "You have to select by clicking card\n"
                + "\nTTHANK YOU", "Game Controling", JOptionPane.INFORMATION_MESSAGE, icon2);
    }//GEN-LAST:event_controlMenuItemActionPerformed
    public void numberOfPlayer(int n)
    {
        start=true;
        player=n;
        names=new String[4];
        points=new int[4];
        call=new int[4];
        try 
          {     
            for(int i=0;i<n;i++)
            {
                names[i]=JOptionPane.showInputDialog((i+1)+" . Enter Player Name : ");
                if(names[i].length()>8)
                    names[i]=names[i].substring(0, 8);
                try
                {
                    call[i]=Integer.parseInt(JOptionPane.showInputDialog((i+1)+" . Enter your target point = "));
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Target point must be integer...\nplease re-enter your name & target point", "wrong input!!!", JOptionPane.ERROR_MESSAGE);
                    --i;
                }
            }
            for(int i=n;i<4;i++)
            {
                names[i]="Computer "+(i+1);
                call[i]=80+random.nextInt(30 );
                //System.out.println(names[i]);
            }
            jLabelName1.setText(names[0]);
            jLabelName1.setForeground(Color.WHITE);
            jLabelName2.setText(names[1]);
            jLabelName2.setForeground(Color.WHITE);
            jLabelName3.setText(names[2]);
            jLabelName3.setForeground(Color.WHITE);
            jLabelName4.setText(names[3]);
            jLabelName4.setForeground(Color.WHITE);
            if(player>=1)
                first=true;
              startPlay(0);
            initCard();
        }             
        catch(Exception ex)     
        {
            //numberOfPlayer(n);
            System.out.println("bsvvnvndsv");
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(NewApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem controlMenuItem;
    private javax.swing.JMenuItem designerMenuItem;
    private javax.swing.JMenuItem developerMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonF;
    private javax.swing.JButton jButtonFo;
    private javax.swing.JButton jButtonS;
    private javax.swing.JButton jButtonT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JLabel jLabelName2;
    private javax.swing.JLabel jLabelName3;
    private javax.swing.JLabel jLabelName4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu newGameJMenu;
    private javax.swing.JMenuItem programmerMenuItem;
    private javax.swing.JMenuItem resultMenuItem;
    private javax.swing.JMenuItem storyAsMenuItem;
    private javax.swing.JMenuItem storyWritterMenuItem;
    // End of variables declaration//GEN-END:variables

    

}
