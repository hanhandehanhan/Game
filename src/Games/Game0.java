package Games;

import Language.Say;

import java.util.Scanner;

public abstract class Game0 {
    static Scanner input = new Scanner(System.in);
    protected byte gameno;
    protected String[] name={"LYF", "LYF", "LYF", "LYF", "LYF"};
    protected int[] score={0,0,0,0,0};
    static Say say;
    public Game0(){

    }
    public Game0(Say s,byte n){
        say=s;
        gameno=n;
    }
    protected void Ranklist(int score0){
        say.Score(score0);
        if (score0>score[4]){
            say.Record();
            String name0=input.next();
            UpdateRanklist(name0,score0);
        }else{
            say.Norecord();
        }
    }
    protected void UpdateRanklist(String name0, int score0){
        int i=name.length-1;
        while ((i>0)&&(score[i-1]<score0)){
            name[i]=name[i-1];
            score[i]=score[i-1];
            i--;
        }
        name[i]=name0;
        score[i]=score0;
        say.Ranklist(name,score);
    }

}