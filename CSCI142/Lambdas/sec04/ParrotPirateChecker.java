package sec04;

/**
 * Created by robertstjacquesjr on 3/1/17.
 */
public class ParrotPirateChecker implements PirateChecker {
    @Override
    public boolean test(SpacePirate p) {
        return p.isBeparrotted();
    }
}
