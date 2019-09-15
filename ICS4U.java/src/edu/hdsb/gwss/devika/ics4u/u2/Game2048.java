/*
 * ICS4U.2019
 * 2048
 */
package edu.hdsb.gwss.devika.ics4u.u2;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

/**
 * @author Wm.Muir
 * @version 2019.S2
 */
public class Game2048 extends javax.swing.JFrame {

    // COLOURS
    private static final Color[] COLOUR_BG = {
        new Color(205, 193, 180), // 0
        new Color(238, 228, 218), // 2
        new Color(237, 224, 200), // 4
        new Color(242, 177, 121), // 8
        new Color(236, 141, 83), // 16
        new Color(245, 124, 95), // 32
        new Color(233, 89, 55), // 64
        new Color(243, 217, 107), // 128
        new Color(241, 208, 75), // 256
        new Color(228, 192, 42), // 512
        new Color(226, 185, 19), // 1024
        new Color(236, 196, 2), // 2048
        
    };

    private static final Color[] COLOUR_FONT = {
        new Color(205, 193, 180), // 0
        new Color(119, 110, 101), // 2
        new Color(119, 110, 101), // 4
        new Color(249, 246, 242), // 8
        new Color(249, 246, 242), // 16
        new Color(249, 246, 242), // 32
        new Color(249, 246, 242), // 64
        new Color(249, 246, 242), // 128
        new Color(249, 246, 242), // 256
        new Color(249, 246, 242), // 512
        new Color(249, 246, 242), // 1024
        new Color(249, 246, 242), // 2048
        
    };

    private JLabel[][] jLabels;
    private int[][] data;
    private int score;
    private boolean gameOver;
    private boolean gameOverShown;
    private boolean won;
    private boolean wonShown;

    /**
     * Creates new form Game2048
     */
    public Game2048() {
        initComponents();

        // SQUARE VALUES
        this.data = new int[4][4];

        // SQUARE LABELS
        this.jLabels = new JLabel[4][4];

        // ROW 0
        jLabels[0][0] = jLabel00;
        jLabels[0][1] = jLabel01;
        jLabels[0][2] = jLabel02;
        jLabels[0][3] = jLabel03;

        // ROW 1
        jLabels[1][0] = jLabel10;
        jLabels[1][1] = jLabel11;
        jLabels[1][2] = jLabel12;
        jLabels[1][3] = jLabel13;

        // ROW 2
        jLabels[2][0] = jLabel20;
        jLabels[2][1] = jLabel21;
        jLabels[2][2] = jLabel22;
        jLabels[2][3] = jLabel23;

        // ROW 3
        jLabels[3][0] = jLabel30;
        jLabels[3][1] = jLabel31;
        jLabels[3][2] = jLabel32;
        jLabels[3][3] = jLabel33;

        // PLACE, two, 2's
        this.placeRandomTwoOrFour();
        this.placeRandomTwoOrFour();
        /* TEST DATA
        this.data[0][0] = 2;
        this.data[1][0] = 4;
        this.data[2][0] = 8;
        this.data[3][0] = 16;
        
        this.data[0][1] = 2;
        this.data[1][1] = 4;
        this.data[2][1] = 8;
        this.data[3][1] = 16;
        
        this.data[0][0] = 2;
        this.data[1][0] = 0;
        this.data[2][0] = 2;
        this.data[3][0] = 2;

        this.data[0][1] = 0;
        this.data[1][1] = 2;
        this.data[2][1] = 2;
        this.data[3][1] = 2;

        this.data[0][2] = 2;
        this.data[1][2] = 0;
        this.data[2][2] = 0;
        this.data[3][2] = 2;

        this.data[0][3] = 0;
        this.data[1][3] = 2;
        this.data[2][3] = 2;
        this.data[3][3] = 0;
        */
        this.updateGameBoard();
        this.gameOver = false;
        this.gameOverShown = false;
        this.won = false;
        this.wonShown = false;

    }

    public void placeRandomTwoOrFour() {
        
        boolean placed = false;
        int row, col;
        
        while (!placed) {
            row = (int) (Math.random() * data.length);
            col = (int) (Math.random() * data[row].length);
            
            if (data[row][col] == 0) {
                int value = 2;
                
                if (Math.random() > .8) {
                    value = 4;
                }
                
                data[row][col] = value;
                placed = true;
            }
        } 

    }

    public boolean shiftLeft() {

        boolean moved = false;
        for (int row = 0; row < this.data.length; row++) {
            
            for (int pass = 0; pass < this.data[row].length - 1; pass++) {
                
                for (int col = 1; col < this.data[0].length; col++) {
            
                    if (this.data[row][col - 1] == 0 && this.data[row][col] != 0) {
                        this.data[row][col - 1] = this.data[row][col];
                        this.data[row][col] = 0;
                        moved = true;
                        
                    }
                }

            }
        }
        return moved;
    }

    public boolean mergeLeft() {

        boolean moved = false;
        for (int row = 0; row < this.data.length; row++) {

            for (int col = 1; col < this.data[row].length; col++) {

                if (this.data[row][col - 1] == this.data[row][col]) {
                    this.data[row][col - 1] *= 2;
                    this.data[row][col] = 0;
                    moved = true;
                    score += (this.data[row][col-1] * 2);
                }
            }
        }
        return moved;
    }

    public boolean shiftUp() {
        boolean moved = false;
        
        for (int col = 0; col < this.data[0].length; col++) {
            
            for (int pass = 0; pass < this.data[0].length - 1; pass++) {
                
                for (int row = 1; row < this.data.length; row++) {

                    if (this.data[row - 1][col] == 0 && this.data[row][col] != 0) {
                        this.data[row - 1][col] = this.data[row][col];
                        this.data[row][col] = 0;
                        moved = true;
                        
                    }
                }

            }
        }
        return moved;
    }

    public boolean mergeUp() {
        boolean moved = false;

        for (int col = 0; col < this.data[0].length; col++) {

            for (int row = 1; row < this.data.length; row++) {

                if (this.data[row][col] != 0 && this.data[row - 1][col] == this.data[row][col]) {
                    this.data[row - 1][col] *= 2;
                    this.data[row][col] = 0;
                    moved = true;
                    score += (this.data[row-1][col] * 2);
                }
            }
        }
        return moved;
    }

    public boolean shiftRight() {

        boolean moved = false;
        
        for (int row = 0; row < this.data.length; row++) {
            
            for (int pass = 0; pass < this.data[row].length - 1; pass++) {
    
                for (int col = this.data[row].length - 2; col >= 0; col--) {

                    if (this.data[row][col + 1] == 0 && this.data[row][col] != 0 ) {
                        this.data[row][col + 1] = this.data[row][col];
                        this.data[row][col] = 0;
                        moved = true;
                        
                    }
                }

            }
        }
        return moved;
    }

    public boolean mergeRight() {

        boolean moved = false;
        for (int row = 0; row < this.data.length; row++) {

            for (int col = this.data[row].length - 2; col >= 0; col--) {

                if (this.data[row][col + 1] == this.data[row][col] && this.data[row][col] != 0 ) {
                    this.data[row][col + 1] *= 2;
                    this.data[row][col] = 0;
                    moved = true;
                    score += (this.data[row][col+1] * 2);
                }
            }
        }
        return moved;
    }

    public boolean shiftDown() {
        
        boolean moved = false;

        for (int col = 0; col < this.data.length; col++) {
            
            for (int pass = 0; pass < this.data[0].length - 1; pass++) {
    
                for (int row = this.data.length - 2; row >= 0; row--) {

                    if (this.data[row + 1][col] == 0 && this.data[row][col] != 0 ) {
                        this.data[row + 1][col] = this.data[row][col];
                        this.data[row][col] = 0;
                        moved = true;
                        
                    }
                }

            }
        }
        return moved;
    }

    public boolean mergeDown() {

        boolean moved = false;
        for (int row = this.data.length - 2; row >= 0; row--) {

            for (int col = 0; col < this.data.length; col++) {

                if (this.data[row + 1][col] == this.data[row][col]) {
                    this.data[row + 1][col] *= 2;
                    this.data[row][col] = 0;
                    moved = true;
                    score += (this.data[row+1][col] * 2);
                }
            }
        }
        return moved;
    }
    
    public boolean gameOver() {
        
        for (int row = 0; row < this.data.length; row++) {
            
            for (int col = 0; col < this.data[row].length; col++) {
                
                if (this.data[row][col] == 0) {
                    
                    return false;
                }
            }
        }
        
        // horizontal
        for (int row = 0; row < this.data.length; row++) {
            
            for (int col = 0; col < this.data[row].length-1; col++) {
                 
                if (this.data[row][col] != 0 && this.data[row][col] == this.data[row][col+1]  ) {
                   
                    return false;
                }
            }
        }
        //vertical
        for (int col = 0; col < data[0].length; col++) {
            
            for (int row = 0; row < data.length-1; row++) {
                
                if (this.data[row][col] != 0 && this.data[row][col] == this.data[row+1][col]  ) {
                    
                    return false;
                }
                
            }
        }
        return true;
    }
    
    public boolean showGameOver() {
        
        //Row 0
        this.jLabels[0][0].setText("G");
        this.jLabels[0][1].setText("A");
        this.jLabels[0][2].setText("M");
        this.jLabels[0][3].setText("E");

        // ROW 1
        this.jLabels[1][0].setText("O");
        this.jLabels[1][1].setText("V");
        this.jLabels[1][2].setText("E");
        this.jLabels[1][3].setText("R");
        
        for (int row = 2; row < this.jLabels.length; row++) {
            
            for (int col = 0; col < this.jLabels[row].length; col++) {
                
                this.jLabels[row][col].setText("");
                
            }
        }
        this.jLabels[3][3].setText("←"); //if clicked on, the end game board will be shown
        
        return true;
    }
    
    public boolean won() {
        
        for (int row = 0; row < this.data.length; row++) {
            
            for (int col = 0; col < this.data[row].length; col++) {
                
                if (this.data[row][col] == 2048) {
                    
                    return true;
                }
            }
        }
        return false;
    }

    public boolean showWon() {
        
        for (int row = 0; row < 2; row++) {
            
            for (int col = 0; col < this.jLabels[row].length; col++) {
                
                this.jLabels[row][col].setBackground(COLOUR_BG[2]);
                this.jLabels[row][col].setForeground(COLOUR_FONT[2]);
                this.jLabels[row][col].setText("");
            }
        }
        for (int row = 2; row < this.jLabels.length; row++) {
            
            for (int col = 0; col < this.jLabels[row].length; col++) {
                
                this.jLabels[row][col].setBackground(COLOUR_BG[0]);
                this.jLabels[row][col].setForeground(COLOUR_FONT[0]);
                this.jLabels[row][col].setText("");
            }
        }
        
        //Row 0
        this.jLabels[0][0].setText("Y");
        this.jLabels[0][1].setText("O");
        this.jLabels[0][2].setText("U");
        this.jLabels[0][3].setText("");

        // ROW 1
        this.jLabels[1][0].setText("W");
        this.jLabels[1][1].setText("O");
        this.jLabels[1][2].setText("N");
        this.jLabels[1][3].setText("!");
        
        this.jLabels[3][3].setBackground(COLOUR_BG[2]);
        this.jLabels[3][3].setForeground(COLOUR_FONT[2]);
        this.jLabels[3][3].setText("←"); //if clicked on, the end game board will be shown
        
        return true;
    }
    
    public void updateGameBoard() {

        int colourIndex;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {

                // COLOUR BASED ON VALUE
                if (data[row][col] == 0) {
                    colourIndex = 0;
                } else {
                    colourIndex = (int) (Math.log(data[row][col]) / Math.log(2));
                }
                this.jLabels[row][col].setBackground(COLOUR_BG[colourIndex]);
                this.jLabels[row][col].setForeground(COLOUR_FONT[colourIndex]);
                this.jLabels[row][col].setText("" + this.data[row][col]);

            }
        }
        this.jLabelScore.setText("" + score);
        
        gameOver = gameOver();
        won = won();
        if (gameOver && !gameOverShown) {
            System.out.println("game over");
            gameOverShown = showGameOver();
        }
        if (won && !wonShown) {
            System.out.println("won");
            wonShown = showWon();
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBottom = new javax.swing.JPanel();
        jLabel00 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel01 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel02 = new javax.swing.JLabel();
        jLabel03 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanelTop = new javax.swing.JPanel();
        jLabel2048Title = new javax.swing.JLabel();
        jLabelScore = new javax.swing.JLabel();
        jLabelScoreTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("2048");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanelBottom.setBackground(new java.awt.Color(187, 173, 160));

        jLabel00.setBackground(new java.awt.Color(205, 193, 180));
        jLabel00.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel00.setText("00");
        jLabel00.setOpaque(true);

        jLabel10.setBackground(new java.awt.Color(205, 193, 180));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("00");
        jLabel10.setOpaque(true);

        jLabel20.setBackground(new java.awt.Color(205, 193, 180));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("00");
        jLabel20.setOpaque(true);

        jLabel30.setBackground(new java.awt.Color(205, 193, 180));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("00");
        jLabel30.setOpaque(true);

        jLabel01.setBackground(new java.awt.Color(205, 193, 180));
        jLabel01.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel01.setText("00");
        jLabel01.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(205, 193, 180));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("00");
        jLabel11.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(205, 193, 180));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("00");
        jLabel21.setOpaque(true);

        jLabel31.setBackground(new java.awt.Color(205, 193, 180));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("00");
        jLabel31.setOpaque(true);

        jLabel02.setBackground(new java.awt.Color(205, 193, 180));
        jLabel02.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel02.setText("00");
        jLabel02.setOpaque(true);

        jLabel03.setBackground(new java.awt.Color(205, 193, 180));
        jLabel03.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel03.setText("00");
        jLabel03.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(205, 193, 180));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("00");
        jLabel12.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(205, 193, 180));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("00");
        jLabel13.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(205, 193, 180));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("00");
        jLabel22.setOpaque(true);

        jLabel23.setBackground(new java.awt.Color(205, 193, 180));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("00");
        jLabel23.setOpaque(true);

        jLabel32.setBackground(new java.awt.Color(205, 193, 180));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("00");
        jLabel32.setOpaque(true);

        jLabel33.setBackground(new java.awt.Color(205, 193, 180));
        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("00");
        jLabel33.setOpaque(true);
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelBottomLayout = new javax.swing.GroupLayout(jPanelBottom);
        jPanelBottom.setLayout(jPanelBottomLayout);
        jPanelBottomLayout.setHorizontalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel00, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        jPanelBottomLayout.setVerticalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBottomLayout.createSequentialGroup()
                        .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBottomLayout.createSequentialGroup()
                        .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBottomLayout.createSequentialGroup()
                        .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBottomLayout.createSequentialGroup()
                        .addComponent(jLabel00, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jPanelTop.setBackground(new java.awt.Color(251, 248, 239));

        jLabel2048Title.setBackground(new java.awt.Color(224, 186, 1));
        jLabel2048Title.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2048Title.setForeground(new java.awt.Color(254, 253, 249));
        jLabel2048Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2048Title.setText("2048");
        jLabel2048Title.setOpaque(true);

        jLabelScore.setBackground(new java.awt.Color(187, 173, 160));
        jLabelScore.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelScore.setForeground(new java.awt.Color(255, 255, 255));
        jLabelScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelScore.setText("Score");
        jLabelScore.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelScore.setOpaque(true);

        jLabelScoreTitle.setBackground(new java.awt.Color(187, 173, 160));
        jLabelScoreTitle.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabelScoreTitle.setForeground(new java.awt.Color(205, 193, 180));
        jLabelScoreTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelScoreTitle.setText("Score");
        jLabelScoreTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelScoreTitle.setOpaque(true);

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2048Title, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelScoreTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTopLayout.createSequentialGroup()
                        .addComponent(jLabel2048Title, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTopLayout.createSequentialGroup()
                        .addComponent(jLabelScoreTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        boolean moved = false;
        
        if (!gameOver && !won) {
            
            System.out.print("KEY PRESSED: ");
            
            switch (evt.getKeyCode()) {
                
                case KeyEvent.VK_UP:
                    
                    System.out.println("UP");
                    
                    moved = shiftUp();
                    moved = mergeUp() || moved;
                    shiftUp();

                    break;
                    
                case KeyEvent.VK_DOWN:
                    
                    System.out.println("DOWN");
                    
                    moved = shiftDown();
                    moved = mergeDown() || moved;
                    shiftDown();

                    break;
                    
                case KeyEvent.VK_LEFT:
                    
                    System.out.println("LEFT");
                    
                    moved = shiftLeft();
                    moved = mergeLeft() || moved;
                    shiftLeft();

                    break;
                    
                case KeyEvent.VK_RIGHT:
                    
                    System.out.println("RIGHT");
                    
                    moved = shiftRight();
                    moved = mergeRight() || moved;
                    shiftRight();

                    break;
            }
        }
        
        if (moved) {
                placeRandomTwoOrFour();
                updateGameBoard();
        }
        
        
        

    }//GEN-LAST:event_formKeyPressed

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        
        updateGameBoard();
        
    }//GEN-LAST:event_jLabel33MouseClicked

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
            java.util.logging.Logger.getLogger(Game2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game2048().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel00;
    private javax.swing.JLabel jLabel01;
    private javax.swing.JLabel jLabel02;
    private javax.swing.JLabel jLabel03;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel2048Title;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabelScore;
    private javax.swing.JLabel jLabelScoreTitle;
    private javax.swing.JPanel jPanelBottom;
    private javax.swing.JPanel jPanelTop;
    // End of variables declaration//GEN-END:variables
}
