package sec04;

/**
 * Created by robertstjacquesjr on 3/1/17.
 */
public class SpacePirate {
    public enum Rank {
        CAPTAIN (1),
        FIRST_MATE (2),
        SECOND_MATE (3),
        SWABBY (4),
        CROWS_NEST_GUY (5),
        LAND_LUBBER (1000);

        private int rank;

        Rank(int rank) {
            this.rank = rank;
        }

        public int getNumericRank() {
            return rank;
        }
    }

    private String shipName;
    private Rank rank;
    private String nickName;
    private boolean eyePatch;
    private int numberOfMissingLimbs;
    private boolean beparrotted;

    public SpacePirate(String shipName, Rank rank,
                       String nickName, boolean eyePatch,
                       int numberOfMissingLimbs,
                       boolean beparrotted) {
        this.shipName = shipName;
        this.rank = rank;
        this.nickName = nickName;
        this.eyePatch = eyePatch;
        this.numberOfMissingLimbs = numberOfMissingLimbs;
        this.beparrotted = beparrotted;
    }

    public String getShipName() {
        return shipName;
    }

    public Rank getRank() {
        return rank;
    }

    public String getNickName() {
        return nickName;
    }

    public boolean isEyePatch() {
        return eyePatch;
    }

    public int getNumberOfMissingLimbs() {
        return numberOfMissingLimbs;
    }

    public boolean isBeparrotted() {
        return beparrotted;
    }

    public void printPirate() {
        System.out.println(rank.toString() + " " +
                nickName + ", parrot: " + beparrotted);
    }
}
