package Games;

import Language.Say;

public class Numguess extends Game0 {
    public Numguess(Say s) {
        say = s;
        gameno = 2;
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
            //确定随机数上下限
            say.NG.InputMax();
            int max = input.nextInt();
            say.NG.InputMin();
            int min = input.nextInt();
            //如果上下限颠倒，则交换
            if (max < min) {
                int t = min;
                min = max;
                max = t;
                say.NG.Exchange();
            }
            //生成随机数
            int answer = (int) (Math.random() * (max - min + 1)) + min;
            boolean giveup = false;
            int guessnum = 0;
            int times = 0;
            //开始猜数
            do {
                say.NG.InputGuessnum(min, max);
                guessnum = input.nextInt();
                if (guessnum == 0) {
                    giveup = true;
                } else if (guessnum > answer) {
                    say.NG.Bigger();
                } else if (guessnum < answer) {
                    say.NG.Smaller();
                }
                times++;
            } while ((guessnum != answer) && (!giveup));
            //结算
            if (giveup) {
                say.NG.Bad(times, answer);
            } else {
                say.NG.Good(times);
                int i = max - min + 1;
                int score0 = (int)(Math.log(i) /times)*i;//计算分数
                Ranklist(score0);

            }

        }

}
