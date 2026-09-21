public class WEEK1_PlaylistManager{
    public static void main(String[] args) {
        System.out.println("--- Music Playlist Inventory ---");

        int durationPop = 210;
        int durationRock = 354;
        int durationJazz = 180;

        int totalUnits = durationPop + durationRock + durationJazz;

        System.out.println("Pop Track Duration: " + durationPop + " seconds");
        System.out.println("Rock Track Duration: " + durationRock + " seconds");
        System.out.println("Jazz Track Duration: " + durationJazz + " seconds");
        System.out.println("Total Playlist Runtime: " + totalUnits + " seconds");
    }
}
