package sec07;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by robertstjacquesjr on 3/1/17.
 */
public class NinjaTester {

    public static void main(String[] args) {
        List<Ninja> ninjas = new ArrayList<>(5);
        ninjas.add(new Ninja("Shadow Fiends",
                "Curly", Ninja.FightingStyle.BOXING,
                "nunchucks", true));
        ninjas.add(new Ninja("Shadow Fiends",
                "Larry", Ninja.FightingStyle.DRUNKEN,
                "sai", false));
        ninjas.add(new Ninja("Shadow Fiends",
                "Moe", Ninja.FightingStyle.RUNNING_AWAY,
                "smoke bomb", true));
        ninjas.add(new Ninja("Shadow Fiends",
                "Sam", Ninja.FightingStyle.NINJITSU,
                "fists of fury", true));
        ninjas.add(new Ninja("Hoocheeha",
                "Joe", Ninja.FightingStyle.DRUNKEN,
                "cup of coffee", false));
        ninjas.add(new Ninja("Shadow Fiends",
                "Buttercup", Ninja.FightingStyle.RUNNING_AWAY,
                "cuteness", true));

        printNinjas(ninjas);
        printDivider();

        printAwesomeNinjas(ninjas);
        printDivider();

        printNinjasWithChecker(ninjas, new AwesomeNinjaChecker());
        printDivider();

        printNinjasWithChecker(ninjas, new DrunkenNinjaChecker());
        printDivider();

        printNinjasWithChecker(ninjas, new RunningAwesomeNinjaChecker());
        printDivider();

        printNinjasWithChecker(ninjas,
                new NinjaChecker() {
                    @Override
                    public boolean test(Ninja n) {
                        return !n.getClan().startsWith("Shadow");
                    }
                });
        printDivider();

        printWithConsumer(ninjas,
                new Consumer<Ninja>() {
                    @Override
                    public void accept(Ninja ninja) {
                        ninja.printNinja();
                    }
                });
        printDivider();

        printWithConsumer(ninjas,
                Ninja::printNinja);
        printDivider();

        printWithPredicate(ninjas,
                new Predicate<Ninja>() {
                    @Override
                    public boolean test(Ninja ninja) {
                        return ninja.isAwesome();
                    }
                },
                new Consumer<Ninja>() {
                    @Override
                    public void accept(Ninja ninja) {
                        ninja.printNinja();
                    }
                });
        printDivider();

        printWithPredicate(ninjas,
                n -> n.isAwesome(),
                n -> n.printNinja());
        printDivider();

        printWithPredicate(ninjas,
                Ninja::isAwesome,
                Ninja::printNinja);
        printDivider();

        printWithFunction(ninjas,
                n -> n.isAwesome(),
                n -> n.getClanNickname(),
                s -> System.out.println(s));

        ninjas.stream()
                .filter(n -> n.isAwesome())
                .map(n -> n.getClanNickname())
                .forEach(s -> System.out.println(s));

        ninjas.stream()
                .filter(Ninja::isAwesome)
                .map(Ninja::getClanNickname)
                .forEach(System.out::println);

    }

    public static void printDivider() {
        System.out.println("*****************************");
    }

    public static void printNinjas(List<Ninja> ninjas) {
        for(Ninja n : ninjas) {
            n.printNinja();
        }
    }

    public static void printAwesomeNinjas(List<Ninja> ninjas) {
        for(Ninja n : ninjas) {
            if(n.isAwesome()) {
                n.printNinja();
            }
        }
    }

    public static void printNinjasWithChecker(List<Ninja> ninjas,
                                              NinjaChecker checker) {
        for(Ninja n : ninjas) {
            if(checker.test(n)) {
                n.printNinja();
            }
        }
    }

    public static void printWithConsumer(List<Ninja> ninjas,
                                         Consumer<Ninja> block) {
        for(Ninja n : ninjas) {
            block.accept(n);
        }
    }

    public static void printWithPredicate(List<Ninja> ninjas,
                                          Predicate<Ninja> checker,
                                          Consumer<Ninja> block) {
        for(Ninja n : ninjas) {
            if(checker.test(n)) {
                block.accept(n);
            }
        }
    }

    public static void printWithFunction(List<Ninja> ninjas,
                                         Predicate<Ninja> checker,
                                         Function<Ninja,String> map,
                                         Consumer<String> block) {
        for(Ninja n : ninjas) {
            if(checker.test(n)) {
                String result = map.apply(n);
                block.accept(result);
            }
        }
    }

}
