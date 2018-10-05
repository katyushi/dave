/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPacage;
import java.util.Scanner;//import scanner
import java.util.Random;//import random
/**
 *
 * @author HugoLazzari
 */
public class MainClass {
    
    static int ataqueJogador(){//abaixo as escolhas de ataques do player
        Scanner leitor = new Scanner(System.in);//scanner to catch data
        System.out.println("escolha seu ataque: ");
        System.out.println("(1)-soco");
        System.out.println("(2)-especial");
            return leitor.nextInt();
    }//fecha ataquejogador
    
    static int ataqueComputador(){
        Random gerador = new Random(); //randomiza a escolha de ataque do computador
            return gerador.nextInt(4)+1;  //retorna numero entre 1 e 4 
    
    }//fecha ataque computador
    
    static void imprimeHP(int hpUser, int hpPC, int contagemEspecials){//metodo para imprimir os hp's e especial
        System.out.println("==================");
        System.out.println("- HP Usuario: "+ hpUser);
        System.out.println("- HP Computador: "+ hpPC);
        System.out.println("* Contagem Especiais: "+ contagemEspecials);
        System.out.println("==================");
    }//fecha imprime hp
    
    static int battle(){//comandos da batalha do jogo 
        int hpUser=150;//nivel de hp do usuario
        int hpPC=11;//nivel de hp do pc
        int contagemEspecial=5;//contagem de ataques especiais que o player tem
        int escolhaAtaque;
        int i = 1;
    
    while (hpUser > 0){
        hpPC = 10 + i; 
        System.out.println("=-=-=-=-=-=-=-=");
        System.out.println("INIMIGO "+i);
        System.out.println("=-=-=-=-=-=-=-=");
    
        while (hpUser > 0 && hpPC >0){
        imprimeHP(hpUser, hpPC, contagemEspecial);//mostra na tela o hp do usuario, o do pc e a contagem de especiais
        escolhaAtaque = ataqueJogador();
        switch(escolhaAtaque){
            case 1://caso o usuario escolha soco
                System.err.println("Usuario aplicou um soco. ");
                hpPC -= 7;
                break;
            case 2://caso o usuario escolha especial
                if (contagemEspecial>0) {
                System.err.println("Usuario aplicou um ataque especial. ");
                hpPC -= 20;
                contagemEspecial--;
                break;}//fechaifelse
                else{
                System.err.println("nao ha especiais restantes. ");
                break;
                }//fechaiffinal
            default://caso escolha qualquer outra coisa
                System.err.println("Opcao Invalida.");
        }//fecha switch
        if(hpPC > 0){
            escolhaAtaque = ataqueComputador();
            switch(escolhaAtaque){
                case 1://soco do pc
                    System.err.println("Computador aplicou um soco. ");
                    hpUser -= 2 + (int)(i/10);
                    break;
                case 2://chute do pc
                    System.err.println("Computador aplicou um chute. ");
                    hpUser -= 3 + (int)(i/10);
                    break;
                case 3://especial do pc
                    System.err.println("Computador aplicou um ataque especial. ");
                    hpUser -= 4 + (int)(i/20);
                    break;
                case 4://supremo
                    System.err.println("Computador Deu um Ataque supremo. ");
                    hpUser -= 138 + (int)(i/20);
                    break;
            }
        }//fecha if 1
        else{
            System.out.println("Inimigo Derrotado. ");
            }//fecha else
       }//fecha while hpUser > 0 && hpPC > 0
        if(hpUser >0){//if 1
            hpUser += 5;//recupera 5 hp a cada inimigo derrotado 
            if(hpUser > 150){//if 2
                hpUser = 150;//não deixa a vida passar de 150
            }//fecha if 2
            if(i % 10 == 0){//if 3
                contagemEspecial++;//quando 10 inimigos forem derrotados voce ganha um especial
            }//fecha if 3
            if (contagemEspecial > 5) {//if 4
                contagemEspecial = 5;//não deixa o especial passar de 5
            }//fecha if 4
        }//fecha if 1
        i++;
      }//fecha while hpUser > 0
       return i;//retorna o score
    }//fecha battle();
    
   public static void main (String [] args){
   Scanner leitor = new Scanner (System.in);
       int continua = 1;
       int recorde = 0;//recorde padrão
       while(continua == 1){
       
          int pontos = battle();
           System.out.println("Usuario chegou a "+ pontos +" pontos. ");//recorde 
           if (pontos > recorde ) {
               recorde = pontos; //sistema de recorde
           }//fecha if
           System.out.println("RECORDE ATUAL: "+ recorde);//mostra recorde
           
       System.out.println("Fim de Jogo.Deseja Continuar? (1)Sim (2)Nao ");//pergunta de deseja continuar
       continua = leitor.nextInt();//pega as information da pergunta
       
       }//fecha while 
   
   }//fecha o main 
}//fecha a classe 