package Language;

import java.util.Scanner;

public class Say {
    static Scanner input=new Scanner(System.in);
    //通用输出模块
    String mainmenu;
    String pleasechoose;
    String[] gamelist=new String[3];
    String newgame;
    String ranklist;
    String exit;
    String backto;
    String inputerror;
    String pleaseinput;
    String score;
    String record;
    String norecord;
    String pressenter;

    public Say(byte i){
        switch (i) {
            case 1 -> English.Load(this);
            case 0 -> Chinese.Load(this);
        }
    }
    public Say(){
        this((byte) 0);
    }
    public void ChooseMenu(){
        System.out.println("Choose language/选择语言");
        System.out.println("0：中文");
        System.out.println("1：English");
        System.out.print("Please choose/请选择:");
        String s=input.next();
         switch (s) {
             case "1" -> English.Load(this);
             case "0" -> Chinese.Load(this);
             default -> Inputerror();
         }
    }
    public void Mainmenu(){
        System.out.println(gamelist[0]+mainmenu);
        System.out.println("=================");
        for (int i=1;i<gamelist.length;i++) {
            System.out.println(i+":" + gamelist[i]);
        }
        System.out.println("0:" + exit);
        System.out.print(pleasechoose);
    }

    public void Inputerror() {
        System.out.print(inputerror);
        Pressenter();
    }

    public void Ranklist(String[] name,int[] score) {
        System.out.println(ranklist);
        System.out.println("=================");
        for (int i=0;i<name.length;i++){
            System.out.println(name[i]+"\t"+score[i]);
        }
        Pressenter();
    }

    private void Pressenter() {
        System.out.print(pressenter);
        String t=input.nextLine();
    }

    public void Gamemenu(byte num) {
        System.out.println(gamelist[num]+mainmenu);
        System.out.println("=================");
        System.out.println("1:"+newgame);
        System.out.println("2:"+ranklist);
        System.out.println("0:"+backto+gamelist[0]);
        System.out.print(pleasechoose);
    }
    public void Score(int score0) {
        System.out.print(score+score0);
    }
    public void Record() {
        System.out.print(record);
    }

    public void Norecord() {
        System.out.println(norecord);
        Pressenter();
    }
    //猜拳模块
    public FingerGuess FG=new FingerGuess();
    public class FingerGuess{
        String[] hand=new String[3];
        String[] result=new String[3];
        String other;
        String showhand;
        String you;
        String me;

        public void Showhand() {
            for(int i=0;i<3;i++){
                System.out.print(i+"->"+hand[i]+",");
            }
            System.out.print(other+showhand);
        }

        public void Result(byte yhand, byte mhand, byte i) {
            System.out.println(you+hand[yhand]+me+hand[mhand]+result[i]);
        }
    }


        //猜数字游戏输出模块
    public NumberGuess NG=new NumberGuess();
    public class NumberGuess{
        String max;
        String min;
        String exchange;
        String guessnum;
        String giveup;
        String bigger;
        String smaller;
        String right;
        String trynum;
        String times;
        String bad;



        public void InputMax(){
            System.out.print(pleaseinput+max+":");
        }
        public void InputMin(){
            System.out.print(pleaseinput+min+":");
        }
        public void Exchange(){
            System.out.println(exchange);
        }
        public void InputGuessnum(int a,int b){
            System.out.print(pleaseinput+guessnum+"["+a+","+b+"]"+giveup+":");
        }
        public void Bigger() {
            System.out.println(bigger);
        }
        public void Smaller() {
            System.out.println(smaller);
        }
        public void Bad(int t, int a) {
            System.out.println(trynum+t+times+bad+a);
        }
        public void Good(int t) {
            System.out.println(trynum+t+times+right);
        }



    }



}
