import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * This class encapsulates store of laptops
 */
public class StoreLaptops {
    private HashSet<Laptop> laptops;
    private Laptop filter;

    /**
     * Constructor
     */
    public StoreLaptops() {
        laptops = new HashSet<>();
        filter = new Laptop();
    }

    /**
     * Adds instance of Laptop to this.laptops
     * @param laptop instance of Notebook
     */
    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    /**
     * Gets list with all colors of this.laptops
     * @return LinkedHashSet<String>
     */
    public LinkedHashSet<String> getColors() {
        LinkedHashSet<String> list = new LinkedHashSet<>();
        for (Laptop laptop : laptops) {
            list.add(laptop.getColour());
        }
        return list;
    }

    /**
     * Gets list with all OS types of this.laptops
     * @return LinkedHashSet<String>
     */
    public LinkedHashSet<String> getTypesOS() {
        LinkedHashSet<String> list = new LinkedHashSet<>();
        for (Laptop laptop : laptops) {
            list.add(laptop.getTypeOS());
        }
        return list;
    }

    /**
     * Adds demo laptops to this.laptops
     */
    public void loadDemo() {
        laptops = new HashSet<>();
        laptops.add(new Laptop("ASUS 2G Surf",
                "Windows Home",
                "Красный",
                1, 256));
        laptops.add(new Laptop("Echips Joy",
                "Windows Pro",
                "Серый",
                6, 128));
        laptops.add(new Laptop("Echips Envy",
                "Windows Pro",
                "Серый",
                8, 256));
        laptops.add(new Laptop("Echips Next",
                "Windows Pro",
                "Чёрный",
                12, 512));
        laptops.add(new Laptop("Digma Pro ",
                "Windows Pro",
                "Чёрный",
                8, 256));
        laptops.add(new Laptop("Digma EVE ",
                "Windows Pro",
                "Чёрный",
                4, 128));
        laptops.add(new Laptop("ZSC-i7-9750H",
                "Windows Home",
                "Белый",
                16, 1024));
        laptops.add(new Laptop("Apple MacBook Pro",
                "macOS",
                "Серый",
                32, 1024));
        laptops.add(new Laptop("Apple MacBook Air",
                "macOS",
                "Серый",
                8, 256));
        laptops.add(new Laptop("Lenovo",
                "Windows Home",
                "Чёрный",
                64, 2048));

    }

    /**
     * Gets set of filtered laptops
     * @param filter instance of Laptop
     * @return HashSet<Laptop>
     */
    public HashSet<Laptop> getFiltered(Laptop filter) {
        HashSet<Laptop> set = new HashSet<>();
        for (Laptop laptop: laptops) {
            if (laptop.getCapacityHD() >= filter.getCapacityHD() &&
                    laptop.getCapacityRAM() >= filter.getCapacityRAM() &&
                    (laptop.getColour().equals(filter.getColour()) || filter.getColour().equals("")) &&
                    (laptop.getTypeOS().equals(filter.getTypeOS()) || filter.getTypeOS().equals(""))){
                set.add(laptop);
            }
        }
        return set;
    }

}
