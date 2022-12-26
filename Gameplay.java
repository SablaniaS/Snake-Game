
package snake2d;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.*;


public class Gameplay extends JPanel implements KeyListener, ActionListener{
    
    private int[] snakexlength= new int[750];
    private int[] snakeylength= new int[750];
    
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private boolean high=false;
   
    private ImageIcon rightmouth;
    private ImageIcon leftmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    
    private Timer timer;
    private int delay = 150;
    private ImageIcon SnakeImage;
    private ImageIcon obs;
    private ImageIcon obs2;
    
    private int lengthofsnake=1;
    private int moves=0;
    
    private int score=0;
    private int level=1;
    
    private int enemyxpos[]={75,100,125,150,175,200,225,250,275,300,325,350,375,400,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800};
    private int enemyypos[]={125,150,175,200,225,250,275,300,350,375,400,425,450,475,500,525,550,575};
    
    private ImageIcon enemyimage;
    
    private Random random = new Random();
    
    private int xpos = random.nextInt(29);
    private int ypos = random.nextInt(18);
    
    private ImageIcon titleImage;
    public Gameplay()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }
    
    public void paint(Graphics g)
    {
        
        if(moves==0)
        {
            snakexlength[2]=50;
            snakexlength[1]=75;
            snakexlength[0]=100;
                    
            snakeylength[2]=125;
            snakeylength[1]=125;
            snakeylength[0]=125;
        }
        

        //title image border
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);
        
        //title image
        titleImage = new ImageIcon("C:\\Users\\Pangs\\Downloads\\Compressed\\assets\\snake.jpg");
        titleImage.paintIcon(this, g, 25, 11);
        
        
        
        //draw border for gameplay
        g.setColor(Color.white);
        g.drawRect(24, 74, 851, 577);
        
        //draw background gameplay
        g.setColor(Color.blue);
        g.fillRect(25, 75, 850, 575);
        
        //draw score
        g.setColor(Color.white);
        g.setFont(new Font("Helvetica",Font.BOLD,14));
        g.drawString("SCORE: "+score, 780, 33);
       
        g.drawString("LENGTH: "+lengthofsnake, 780, 53);
        

        g.drawString("SPACE to RESTART",26,26);
        
        
        g.drawString("LEVEL= "+level,26,40);
        g.drawString("NUM0- PREV LEV || NUM1- NEXT LEV",26,54);
        
        if(level>=2)
        {
        obs = new ImageIcon("C:\\Users\\Pangs\\Desktop\\aa.png");
        obs.paintIcon(this, g, 425, 400);
        obs.paintIcon(this, g, 425, 450);   
        obs.paintIcon(this, g, 425, 225);
        obs.paintIcon(this, g, 425, 175);
        obs2=new ImageIcon("C:\\Users\\Pangs\\Desktop\\aa2.png");
        obs2.paintIcon(this, g, 525, 325);
        obs2.paintIcon(this, g, 575, 325);
        obs2.paintIcon(this, g, 250, 325);
        obs2.paintIcon(this, g, 200, 325);
        }
        
        if(level==3)
        {
             obs = new ImageIcon("C:\\Users\\Pangs\\Desktop\\aa3.png");
             obs.paintIcon(this, g, 50, 100);
             obs.paintIcon(this, g, 50, 150);
             obs.paintIcon(this, g, 50, 225);
             obs.paintIcon(this, g, 50, 300);
             obs.paintIcon(this, g, 50, 375);
             obs.paintIcon(this, g, 50, 450);
             obs.paintIcon(this, g, 50, 525);
             obs.paintIcon(this, g, 50, 550);
             obs.paintIcon(this, g, 825, 100);
             obs.paintIcon(this, g, 825, 150);
             obs.paintIcon(this, g, 825, 225);
             obs.paintIcon(this, g, 825, 300);
             obs.paintIcon(this, g, 825, 375);
             obs.paintIcon(this, g, 825, 450);
             obs.paintIcon(this, g, 825, 525);
             obs.paintIcon(this, g, 825, 550);
             obs2 = new ImageIcon("C:\\Users\\Pangs\\Desktop\\aa4.png");
             obs2.paintIcon(this, g, 50, 100);
             obs2.paintIcon(this, g, 125, 100);
             obs2.paintIcon(this, g, 200, 100);
             obs2.paintIcon(this, g, 275, 100);
             obs2.paintIcon(this, g, 350, 100);
             obs2.paintIcon(this, g, 425, 100);
             obs2.paintIcon(this, g, 500, 100);
             obs2.paintIcon(this, g, 575, 100);
             obs2.paintIcon(this, g, 650, 100);
             obs2.paintIcon(this, g, 725, 100);
             obs2.paintIcon(this, g, 750, 100);
             obs2.paintIcon(this, g, 50, 600);
             obs2.paintIcon(this, g, 125, 600);
             obs2.paintIcon(this, g, 200, 600);
             obs2.paintIcon(this, g, 275, 600);
             obs2.paintIcon(this, g, 350, 600);
             obs2.paintIcon(this, g, 425, 600);
             obs2.paintIcon(this, g, 500, 600);
             obs2.paintIcon(this, g, 575, 600);
             obs2.paintIcon(this, g, 650, 600);
             obs2.paintIcon(this, g, 725, 600);
             obs2.paintIcon(this, g, 750, 600);
        }
        
        //draw snake
        rightmouth = new ImageIcon("C:\\Users\\Pangs\\Downloads\\Compressed\\assets\\rightmouth.png");
        rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);

        for(int a=0;a<lengthofsnake;a++)
        {
            if(a==0 && right)
            {
                rightmouth = new ImageIcon("C:\\Users\\Pangs\\Downloads\\Compressed\\assets\\rightmouth.png");
                rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if(a==0 && left)
            {
                leftmouth = new ImageIcon("C:\\Users\\Pangs\\Downloads\\Compressed\\assets\\leftmouth.png");
                leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if(a==0 && down)
            {
                downmouth = new ImageIcon("C:\\Users\\Pangs\\Downloads\\Compressed\\assets\\downmouth.png");
                downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if(a==0 && up)
            {
                upmouth = new ImageIcon("C:\\Users\\Pangs\\Downloads\\Compressed\\assets\\upmouth.png");
                upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if(a!=0)
            {
                SnakeImage = new ImageIcon("C:\\Users\\Pangs\\Downloads\\Compressed\\assets\\snakeimage.png");
                SnakeImage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }    
        }
        
        enemyimage = new ImageIcon("C:\\Users\\Pangs\\Downloads\\Compressed\\assets\\enemy.png");
        
        if(enemyxpos[xpos]==snakexlength[0]&&enemyypos[ypos]==snakeylength[0])
        {
            score++;
            lengthofsnake++;
            xpos=random.nextInt(29);
            ypos=random.nextInt(18);
        }
        
        enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
        
       if(score==10&&level==1)
        {
            level++;
            lengthofsnake=1;
            moves=0;
            timer.stop();
            g.setColor(Color.white);
            g.setFont(new Font("Candy Round BTN",Font.TRUETYPE_FONT,80));
            g.drawString("LEVEL 2",350,300);
                
            g.setColor(Color.white);
            g.setFont(new Font("Candy Round BTN",Font.BOLD,40));
            g.drawString("PRESS N to CONTINUE",300,350);
           
            if(moves==0)
        {
            snakexlength[2]=50;
            snakexlength[1]=75;
            snakexlength[0]=100;
                    
            snakeylength[2]=100;
            snakeylength[1]=100;
            snakeylength[0]=100;
        }
        }
        if(score==15&&level==2)
        {
            level++;
            lengthofsnake=1;
            moves=0;
            timer.stop();
            g.setColor(Color.white);
            g.setFont(new Font("Candy Round BTN",Font.TRUETYPE_FONT,80));
            g.drawString("LEVEL 3",350,300);
                
            g.setColor(Color.white);
            g.setFont(new Font("Candy Round BTN",Font.BOLD,40));
            g.drawString("PRESS N to CONTINUE",300,350);
           
            if(moves==0)
        {
            snakexlength[2]=75;
            snakexlength[1]=100;
            snakexlength[0]=125;
                    
            snakeylength[2]=125;
            snakeylength[1]=125;
            snakeylength[0]=125;
        }
        }

        //middle walls
        if(level>1)
        {
            if(snakexlength[0]==425&&snakeylength[0]==400||snakexlength[0]==425&&snakeylength[0]==425||snakexlength[0]==425&&snakeylength[0]==450||snakexlength[0]==425&&snakeylength[0]==475||snakexlength[0]==425&&snakeylength[0]==500||snakexlength[0]==425&&snakeylength[0]==175||snakexlength[0]==425&&snakeylength[0]==200||snakexlength[0]==425&&snakeylength[0]==225||snakexlength[0]==425&&snakeylength[0]==250||snakexlength[0]==425&&snakeylength[0]==275||snakexlength[0]==525&&snakeylength[0]==325||snakexlength[0]==550&&snakeylength[0]==325||snakexlength[0]==575&&snakeylength[0]==325||snakexlength[0]==600&&snakeylength[0]==325||snakexlength[0]==625&&snakeylength[0]==325||snakexlength[0]==200&&snakeylength[0]==325||snakexlength[0]==225&&snakeylength[0]==325||snakexlength[0]==250&&snakeylength[0]==325||snakexlength[0]==275&&snakeylength[0]==325||snakexlength[0]==300&&snakeylength[0]==325)
            {
                           
                right=false;
                left=false;
                up=false;
                down=false;
                
                obs=new ImageIcon("C:\\Users\\Pangs\\Desktop\\cr.png");
                obs.paintIcon(this, g, snakexlength[0], snakeylength[0]);
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD,50));
                g.drawString("GAME OVER",300,300);
                
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD,20));
                g.drawString("SPACE to RESTART",350,340);
             
                
                timer.stop();
                
            }
        }
        //lev3 walls
        if(level==3)
        {
            //upper wall
            if(snakexlength[0]==50&&snakeylength[0]==100||snakexlength[0]==75&&snakeylength[0]==100||snakexlength[0]==100&&snakeylength[0]==100||snakexlength[0]==125&&snakeylength[0]==100||snakexlength[0]==150&&snakeylength[0]==100||snakexlength[0]==175&&snakeylength[0]==100||snakexlength[0]==200&&snakeylength[0]==100||snakexlength[0]==225&&snakeylength[0]==100||snakexlength[0]==250&&snakeylength[0]==100||snakexlength[0]==275&&snakeylength[0]==100||snakexlength[0]==300&&snakeylength[0]==100||snakexlength[0]==325&&snakeylength[0]==100||snakexlength[0]==350&&snakeylength[0]==100||snakexlength[0]==375&&snakeylength[0]==100||snakexlength[0]==400&&snakeylength[0]==100||snakexlength[0]==425&&snakeylength[0]==100||snakexlength[0]==450&&snakeylength[0]==100||snakexlength[0]==475&&snakeylength[0]==100||snakexlength[0]==500&&snakeylength[0]==100||snakexlength[0]==525&&snakeylength[0]==100||snakexlength[0]==550&&snakeylength[0]==100||snakexlength[0]==575&&snakeylength[0]==100||snakexlength[0]==600&&snakeylength[0]==100||snakexlength[0]==625&&snakeylength[0]==100||snakexlength[0]==650&&snakeylength[0]==100||snakexlength[0]==675&&snakeylength[0]==100||snakexlength[0]==700&&snakeylength[0]==100||snakexlength[0]==725&&snakeylength[0]==100||snakexlength[0]==750&&snakeylength[0]==100||snakexlength[0]==775&&snakeylength[0]==100||snakexlength[0]==800&&snakeylength[0]==100||snakexlength[0]==825&&snakeylength[0]==100)
            {
                try
                {
                    file();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                
                right=false;
                left=false;
                up=false;
                down=false;
                
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD,50));
                g.drawString("GAME OVER",300,300);
                
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD,20));
                g.drawString("SPACE to RESTART",350,340);
                // print high score
                if(high)
                {
                    g.setColor(Color.green);
                    g.setFont(new Font("arial",Font.ITALIC,30));
                    g.drawString("Congratulations !! High Score",260,390);
                }
                timer.stop();
            }
            //left wall
             if(snakexlength[0]==50&&snakeylength[0]==125||snakexlength[0]==50&&snakeylength[0]==150||snakexlength[0]==50&&snakeylength[0]==175||snakexlength[0]==50&&snakeylength[0]==200||snakexlength[0]==50&&snakeylength[0]==225||snakexlength[0]==50&&snakeylength[0]==250||snakexlength[0]==50&&snakeylength[0]==275||snakexlength[0]==50&&snakeylength[0]==300||snakexlength[0]==50&&snakeylength[0]==325||snakexlength[0]==50&&snakeylength[0]==350||snakexlength[0]==50&&snakeylength[0]==375||snakexlength[0]==50&&snakeylength[0]==400||snakexlength[0]==50&&snakeylength[0]==425||snakexlength[0]==50&&snakeylength[0]==450||snakexlength[0]==50&&snakeylength[0]==475||snakexlength[0]==50&&snakeylength[0]==500||snakexlength[0]==50&&snakeylength[0]==550||snakexlength[0]==50&&snakeylength[0]==575)
            {
                 try
                {
                    file();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                
                right=false;
                left=false;
                up=false;
                down=false;
                
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD,50));
                g.drawString("GAME OVER",300,300);
                
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD,20));
                g.drawString("SPACE to RESTART",350,340);
                // print high score
                if(high)
                {
                    g.setColor(Color.green);
                    g.setFont(new Font("arial",Font.ITALIC,30));
                    g.drawString("Congratulations !! High Score",260,390);
                }
                timer.stop();
            }
             
            //right wall
            if(snakexlength[0]==825&&snakeylength[0]==125||snakexlength[0]==825&&snakeylength[0]==150||snakexlength[0]==825&&snakeylength[0]==175||snakexlength[0]==825&&snakeylength[0]==200||snakexlength[0]==825&&snakeylength[0]==225||snakexlength[0]==825&&snakeylength[0]==250||snakexlength[0]==825&&snakeylength[0]==275||snakexlength[0]==825&&snakeylength[0]==300||snakexlength[0]==825&&snakeylength[0]==325||snakexlength[0]==825&&snakeylength[0]==350||snakexlength[0]==825&&snakeylength[0]==375||snakexlength[0]==825&&snakeylength[0]==400||snakexlength[0]==825&&snakeylength[0]==425||snakexlength[0]==825&&snakeylength[0]==450||snakexlength[0]==825&&snakeylength[0]==475||snakexlength[0]==825&&snakeylength[0]==500||snakexlength[0]==825&&snakeylength[0]==550||snakexlength[0]==825&&snakeylength[0]==575)
            {
               try
                {
                    file();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                
                right=false;
                left=false;
                up=false;
                down=false;
                
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD,50));
                g.drawString("GAME OVER",300,300);
                
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD,20));
                g.drawString("SPACE to RESTART",350,340);
                // print high score
                if(high)
                {
                    g.setColor(Color.green);
                    g.setFont(new Font("arial",Font.ITALIC,30));
                    g.drawString("Congratulations !! High Score",260,390);
                }
                timer.stop();
            }
            
            //lower wall
            if(snakexlength[0]==50&&snakeylength[0]==600||snakexlength[0]==75&&snakeylength[0]==600||snakexlength[0]==100&&snakeylength[0]==600||snakexlength[0]==125&&snakeylength[0]==600||snakexlength[0]==150&&snakeylength[0]==600||snakexlength[0]==175&&snakeylength[0]==600||snakexlength[0]==200&&snakeylength[0]==600||snakexlength[0]==225&&snakeylength[0]==600||snakexlength[0]==250&&snakeylength[0]==600||snakexlength[0]==275&&snakeylength[0]==600||snakexlength[0]==300&&snakeylength[0]==600||snakexlength[0]==325&&snakeylength[0]==600||snakexlength[0]==350&&snakeylength[0]==600||snakexlength[0]==375&&snakeylength[0]==600||snakexlength[0]==400&&snakeylength[0]==600||snakexlength[0]==425&&snakeylength[0]==600||snakexlength[0]==450&&snakeylength[0]==600||snakexlength[0]==475&&snakeylength[0]==600||snakexlength[0]==500&&snakeylength[0]==600||snakexlength[0]==525&&snakeylength[0]==600||snakexlength[0]==550&&snakeylength[0]==600||snakexlength[0]==575&&snakeylength[0]==600||snakexlength[0]==600&&snakeylength[0]==600||snakexlength[0]==625&&snakeylength[0]==600||snakexlength[0]==650&&snakeylength[0]==600||snakexlength[0]==675&&snakeylength[0]==600||snakexlength[0]==700&&snakeylength[0]==600||snakexlength[0]==725&&snakeylength[0]==600||snakexlength[0]==750&&snakeylength[0]==600||snakexlength[0]==775&&snakeylength[0]==600||snakexlength[0]==800&&snakeylength[0]==600||snakexlength[0]==825&&snakeylength[0]==600)
            {
                 try
                {
                    file();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                
                right=false;
                left=false;
                up=false;
                down=false;
                
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD,50));
                g.drawString("GAME OVER",300,300);
                
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD,20));
                g.drawString("SPACE to RESTART",350,340);
                // print high score
                if(high)
                {
                    g.setColor(Color.green);
                    g.setFont(new Font("arial",Font.ITALIC,30));
                    g.drawString("Congratulations !! High Score",260,390);
                }
                timer.stop();
            }
        }
                
        for(int b=1; b<lengthofsnake;b++)
        {
            if(snakexlength[b]==snakexlength[0]&&snakeylength[b]==snakeylength[0])
            {
                 try
                {
                    file();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                
                right=false;
                left=false;
                up=false;
                down=false;
                
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD,50));
                g.drawString("GAME OVER",300,300);
                
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD,20));
                g.drawString("SPACE to RESTART",350,340);
                // print high score
                if(high)
                {
                    g.setColor(Color.green);
                    g.setFont(new Font("arial",Font.ITALIC,30));
                    g.drawString("Congratulations !! High Score",260,390);
                }
                timer.stop();
                
            }
               
        }
        
                
            
        
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
         if(e.getKeyCode() == KeyEvent.VK_NUMPAD0)
       {
           if(level>1)
           {
           level--;
           lengthofsnake=1;
           moves=0;
           score=0;
           repaint();
           timer.start();         
           }
       }
         if(e.getKeyCode() == KeyEvent.VK_NUMPAD1)
       {
           if(level<3)
           {
           level++;
           lengthofsnake=1;
           moves=0;
           score=0;
           repaint();
           timer.start();
           }
       }
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
       {
           moves=0;
           score=0;
           level=1;
           lengthofsnake=1;
           high=false;
           repaint();
           timer.start();
       }
       
       if(e.getKeyCode()==KeyEvent.VK_N)
       {
           repaint();  
           timer.start();
       }
          
       if(e.getKeyCode() == KeyEvent.VK_RIGHT)
       {
           moves++;
           right=true;
           if(!left)
           {
               right=true;
           }
           else
           {
               right=false;
               left=true;
           }
           up = false;
           down = false;
       }
       if(e.getKeyCode()== KeyEvent.VK_LEFT)
       {
           moves++;
           left=true;
           if(!right)
           {
               left=true;
           }
           else
           {
               left=false;
               right=true;
           }
           up = false;
           down = false;
       }
       if(e.getKeyCode()== KeyEvent.VK_UP)
       {
           moves++;
           up=true;
           if(!down)
           {
               up=true;
           }
           else
           {
               up=false;
               down=true;
           }
           left = false;
           right = false;
       }if(e.getKeyCode()== KeyEvent.VK_DOWN)
       {
           moves++;
           down=true;
           if(!up)
           {
               down=true;
           }
           else
           {
               down=false;
               up=true;
           }
           left = false;
           right = false;
       }
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(right)
        {
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                snakeylength[r+1]=snakeylength[r];
            }
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                if(r==0)
                {
                    snakexlength[r]=snakexlength[r]+25;
                }
                else
                {
                    snakexlength[r]=snakexlength[r-1];
                }
                if(snakexlength[r]>850)
                {
                    snakexlength[r]=25;
                }
            }    
            repaint();
        }
        if(left)
        {
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                snakeylength[r+1]=snakeylength[r];
            }
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                if(r==0)
                {
                    snakexlength[r]=snakexlength[r]-25;
                }
                else
                {
                    snakexlength[r]=snakexlength[r-1];
                }
                if(snakexlength[r]<25)
                {
                    snakexlength[r]=850;
                }
            }    
            repaint();
        }
        if(up)
        {
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                snakexlength[r+1]=snakexlength[r];
            }
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                if(r==0)
                {
                    snakeylength[r]=snakeylength[r]-25;
                }
                else
                {
                    snakeylength[r]=snakeylength[r-1];
                }
                if(snakeylength[r]<75)
                {
                    snakeylength[r]=625;
                }
            }    
            repaint();
        }
        if(down)
        {
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                snakexlength[r+1]=snakexlength[r];
            }
            for(int r=lengthofsnake-1;r>=0;r--)
            {
                if(r==0)
                {
                    snakeylength[r]=snakeylength[r]+25;
                }
                else
                {
                    snakeylength[r]=snakeylength[r-1];
                }
                if(snakeylength[r]>625)
                {
                    snakeylength[r]=75;
                }
            }    
            repaint();
        }
    }
    
    public void file()throws IOException
    {
        String str="";
        int max=0,num=0;
        // File Handling
        FileReader file_r = new FileReader("C:\\Users\\Pangs\\Desktop\\scores.txt");
        BufferedReader ob = new BufferedReader(file_r);
        while((str=ob.readLine())!=null)
        {
            num = Integer.parseInt(str);
            if(num > max)
                max=num;
        }
        if(score > max)
            high=true;
        ob.close();
        
        FileWriter file_w = new FileWriter("C:\\Users\\Pangs\\Desktop\\scores.txt",true);
        PrintWriter pw = new PrintWriter(file_w);
        if(score > 0)
           pw.println(score);
        pw.close();
    }
    
}
