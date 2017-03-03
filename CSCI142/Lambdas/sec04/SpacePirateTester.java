package sec04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by robertstjacquesjr on 3/1/17.
 */
public class SpacePirateTester {

    public static void main(String[] args) {
        int q;
        System.out.println(q = 5);

        List<SpacePirate> arrrrr = new ArrayList<>(10);
        arrrrr.add(new SpacePirate("The Dainty Lady",
                SpacePirate.Rank.CAPTAIN, "Spacebeard",
                true, 2, true));
        arrrrr.add(new SpacePirate("The Dainty Lady",
                SpacePirate.Rank.FIRST_MATE, "Lefty",
                false, 1, false));
        arrrrr.add(new SpacePirate("The Dainty Lady",
                SpacePirate.Rank.SECOND_MATE, "Righty",
                true, 1, true));
        arrrrr.add(new SpacePirate("The Dainty Lady",
                SpacePirate.Rank.SWABBY, "No one cares",
                true, 6, false));
        arrrrr.add(new SpacePirate("The Dainty Lady",
                SpacePirate.Rank.CROWS_NEST_GUY, "Smee",
                true, 0, false));
        arrrrr.add(new SpacePirate("The Dainty Lady",
                SpacePirate.Rank.LAND_LUBBER, "Briggy",
                true, 1, true));

        printPirates(arrrrr);
        printDivider();

        printPiratesWithParrots(arrrrr);
        printDivider();

        printPiratesWithChecker(arrrrr, new NoParrotPirateChecker());
        printDivider();

        printPiratesWithChecker(arrrrr, new ParrotPirateChecker());
        printDivider();

        printPiratesWithChecker(arrrrr, new PirateChecker() {
            @Override
            public boolean test(SpacePirate p) {
                return p.getRank().getNumericRank() <= 2;
            }
        });
        printDivider();

        PirateChecker checker = new PirateChecker() {
            @Override
            public boolean test(SpacePirate p) {
                return p.getNumberOfMissingLimbs() >= 2;
            }
        };

        printPiratesWithChecker(arrrrr, checker);
        printDivider();

        printWithConsumer(arrrrr,
                sp -> sp.getRank() == SpacePirate.Rank.SWABBY,
                sp -> System.out.println(sp.getNickName())
                );
        printDivider();

        printWithConsumer(arrrrr,
                sp -> sp.getRank() == SpacePirate.Rank.SWABBY,
                System.out::println
        );
        printDivider();

        printWithFunction(arrrrr,
                sp -> sp.isBeparrotted() && sp.getNumberOfMissingLimbs() <= 2,
                SpacePirate::getNickName,
                System.out::println);
        printDivider();

        arrrrr.stream()
                .filter(sp -> sp.isBeparrotted() &&
                        sp.getNumberOfMissingLimbs() <= 2)
                .map(SpacePirate::getNickName)
                .map(name -> name.startsWith("S") ? "REDACTED" : name)
                .forEach(System.out::println);

        blah(Integer::compare);

    }

    public static void printDivider() {
        System.out.println("**********************************");
    }

    public static void printPirates(List<SpacePirate> pirates) {
        for(SpacePirate sp : pirates) {
            sp.printPirate();
        }
    }

    public static void printPiratesWithParrots(List<SpacePirate> pirates) {
        for(SpacePirate sp : pirates) {
            if(sp.isBeparrotted()) {
                sp.printPirate();
            }
        }
    }

    public static void printPiratesWithChecker(List<SpacePirate> pirates,
                                               PirateChecker checker) {
        for(SpacePirate sp : pirates) {
            if(checker.test(sp)) {
                sp.printPirate();
            }
        }
    }

    public static void printWithConsumer(List<SpacePirate> pirates,
                                         Predicate<SpacePirate> checker,
                                         Consumer<SpacePirate> consumer) {
        for(SpacePirate sp : pirates) {
            if(checker.test(sp)) {
                consumer.accept(sp);
            }
        }
    }

    public static void printWithFunction(List<SpacePirate> pirates,
                                         Predicate<SpacePirate> checker,
                                         Function<SpacePirate, String> map,
                                         Consumer<String> consumer) {
        for(SpacePirate sp : pirates) {
            if(checker.test(sp)) {
                String string = map.apply(sp);
                consumer.accept(string);
            }
        }
    }

    public static void blah(TwoParameters params) {
        params.method(1, 2);
    }

}
