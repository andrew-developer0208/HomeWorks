/**
 * This class encapsulated notebook parameters
 */
public class Laptop {
    private String name;
    private int capacityRAM;
    private int capacityHD;
    private String typeOS;
    private String colour;

    /**
     * Constructor without parameters
     */
    public Laptop() {
        this.name = "";
        this.capacityHD = 0;
        this.capacityRAM = 0;
        this.typeOS = "";
        this.colour = "";

    }
    /**
     * Constructor with five parameters
     * @param name notebook name
     * @param typeOS OS type
     * @param colour notebook colour
     * @param capacityRAM capacity notebook RAM
     * @param capacityHD capacity notebook HD
     */
    public Laptop(String name,
                  String typeOS,
                  String colour,
                  int capacityRAM,
                  int capacityHD) {
        this.name = name;
        this.typeOS = typeOS;
        this.colour = colour;
        this.capacityRAM = capacityRAM;
        this.capacityHD = capacityHD;
    }

    /**
     * Gets this.name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Gets this.capacityRAM
     * @return int
     */
    public int getCapacityRAM() {
        return capacityRAM;
    }

    /**
     * Gets this.capacityHD
     * @return int
     */
    public int getCapacityHD() {
        return capacityHD;
    }

    /**
     * Gets this.typeOS
     * @return String
     */
    public String getTypeOS() {
        return typeOS;
    }

    /**
     * Gets this.colour
     * @return String
     */
    public String getColour() {
        return colour;
    }

    /**
     * Sets this.name
     * @param name String notebook name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets this.capacityRAM
     * @param capacityRAM int capacity RAM
     */
    public void setCapacityRAM(int capacityRAM) {
        this.capacityRAM = capacityRAM;
    }

    /**
     * Sets this.capacityHD
     * @param capacityHD int capacity HD
     */
    public void setCapacityHD(int capacityHD) {
        this.capacityHD = capacityHD;
    }

    /**
     * Sets this.typeOS
     * @param typeOS String type OS
     */
    public void setTypeOS(String typeOS) {
        this.typeOS = typeOS;
    }

    /**
     * Sets this.colour
     * @param colour String colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Название: " + name + "\tOC: " + typeOS + "\tОбъём ОЗУ, ГБ: " + capacityRAM +
                "\tОбъем HD, ГБ: " + capacityHD + "\tЦвет: " + colour ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Laptop laptop)) return false;
        return name.equals(laptop.getName()) &&
                typeOS.equals(laptop.getTypeOS()) &&
                colour.equals(laptop.getColour()) &&
                capacityHD == laptop.getCapacityHD() &&
                capacityRAM == laptop.getCapacityRAM();
    }

    @Override
    public int hashCode() {
        return name.hashCode() + typeOS.hashCode() + colour.hashCode() + capacityRAM + capacityHD;
    }
}
