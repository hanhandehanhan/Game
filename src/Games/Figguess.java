package Games;

import Language.Say;

public class Figguess extends Game0{
    private static byte[][] rule={{0,1,-1},{-1,0,1},{1,-1,0}};
    public Figguess(Say s) {
        say=s;
        gameno=1;
    }
    public  void GameMenu() {
        while (true) {
            say.Gamemenu(gameno);
            String s = input.next();
            switch (s) {
                case "1" -> NewGame();
                case "2" -> say.Ranklist(name, score);
                case "0" -> {
                    return;
                }
                default -> say.Inputerror();
            }
        }
    }
    private void NewGame() {
            int score0 = 0;
            boolean over = false;
            byte hand, rand;
            do {
                say.FG.Showhand();
                hand = input.nextByte();
                if ((hand <= 2) && (hand >= 0)) {
                    rand = (byte) (Math.random() * 3);
                    say.FG.Result(hand, rand, (byte) (rule[hand][rand] + 1));
                    score0 += rule[hand][rand];
                } else over = true;
            } while (!over);
            Ranklist(score0);
        }

}