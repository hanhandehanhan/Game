import Games.GameList;
import Language.Say;

public class Run {
    public static void Main(String[] args) {
        Say say = new Say();
        say.ChooseMenu();
        GameList.MainMenu(say);
        System.out.println("GG!");
    }
}

