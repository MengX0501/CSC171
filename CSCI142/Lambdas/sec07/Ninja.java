package sec07;

/**
 * Created by robertstjacquesjr on 3/1/17.
 */
public class Ninja {

    public enum FightingStyle {
        NINJITSU,
        BOXING,
        DRUNKEN,
        RUNNING_AWAY
    }

    private String clan;
    private String clanNickname;
    private FightingStyle style;
    private String weapon;
    private boolean isAwesome;

    public Ninja(String clan, String clanNickname,
                 FightingStyle style, String weapon,
                 boolean isAwesome) {
        this.clan = clan;
        this.clanNickname = clanNickname;
        this.style = style;
        this.weapon = weapon;
        this.isAwesome = isAwesome;
    }

    public String getClan() {
        return clan;
    }

    public String getClanNickname() {
        return clanNickname;
    }

    public FightingStyle getStyle() {
        return style;
    }

    public String getWeapon() {
        return weapon;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public void printNinja() {
        System.out.println(clanNickname + " of clan " + clan +
        " who uses the fighting style " + style.toString());
    }
}
