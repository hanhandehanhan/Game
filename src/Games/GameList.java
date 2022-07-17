package Games;

import Language.Say;

import java.util.Scanner;

public class GameList {
    static Scanner input=new Scanner(System.in);
    static Figguess g1;
    static Numguess g2;
    public static void MainMenu(Say say) {
        while (true) {
            say.Mainmenu();
            String s=input.next();
            switch (s) {
                case"0":
                    return;
                case "1":{
                    if (g1==null){
                        g1=new Figguess(say);
                    }
                    g1.GameMenu();
                    break;
                }
                case "2":{
                    if (g2==null){
                        g2=new Numguess(say);
                    }
                    g2.GameMenu();
                    break;
                }
                default:
                    say.Inputerror();

            }
        }
    }
}
