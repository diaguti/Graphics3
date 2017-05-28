package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private final Image fondo1 = loadImage("selva.jpg");    
    private final Image[] pajaroVolando = new Image[16];
    private int imgDibujada = 0;
    private int estado = 0;
    private int aux = 0;
    private int posX = 50;
    private int posY = 400;
    private final int DELAY = 80;
    private Timer timer;    

    public Board() {        
        //[0-3]-Despegar/Aterrizar [4-9]-Volar [9-15]-Taladrar
        for(int i=0;i<16;i++){
            pajaroVolando[i] = loadImage(""+i+".png");            
        }
        initBoard();
    }

    private void initBoard() {
        setBackground(Color.white);
        //Fires one or more ActionEvents at specified intervals.
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //DibujarFondo
        g.drawImage(fondo1, 0, 0, this);
        //DibujarPajaroCarpintero 
        g.drawImage(pajaroVolando[imgDibujada], posX, posY, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Estado: 0-Despegar 1-Volar 2-Aterrizar 3-Taladrar
        switch (estado) {
            case 0:   
                actualizarFrameDibujado(0,3);
                if(aux == 60){
                    estado = 1;
                }else{
                    posY=posY-6;
                }
                aux++;                
                break;
            case 1:
                actualizarFrameDibujado(4,9);
                if(aux == 165){
                    estado = 2;
                    imgDibujada = 0;
                }else{
                    posX=posX+6;
                }
                aux++;
                break;
            case 2:
                actualizarFrameDibujado(0,3);
                if(aux == 210){
                    estado = 3;
                    imgDibujada = 10;
                }else{
                    posY=posY+6;
                }
                aux++;
                break;
            case 3:
                actualizarFrameDibujado(10,15);
                //Permanece en este estado hasta cerrar.
                break;
            default:
                break;
        }              
        repaint();
    }
    public void actualizarFrameDibujado(int imgInicial,int imgFinal){
        if (imgDibujada == imgFinal) {
            imgDibujada = imgInicial;
        } else {
            imgDibujada++;
        }  
    }
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
