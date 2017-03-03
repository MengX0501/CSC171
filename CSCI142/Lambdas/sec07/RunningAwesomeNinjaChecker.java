package sec07;

/**
 * Created by robertstjacquesjr on 3/1/17.
 */
public class RunningAwesomeNinjaChecker implements NinjaChecker {

    @Override
    public boolean test(Ninja n) {
        return n.getStyle() == Ninja.FightingStyle.RUNNING_AWAY &&
                n.isAwesome();
    }
}
