package into;

import java.util.Objects;

public class Smartphone {
    String name;
    int ram;
    String storage;
    double screensSize;


    public Smartphone(String name, int ram, String storage, double screensSize) {
        this.name = name;
        this.ram = ram;
        this.storage = storage;
        this.screensSize = screensSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smartphone)) return false;
        Smartphone that = (Smartphone) o;
        return ram == that.ram && Double.compare(screensSize, that.screensSize) == 0 && Objects.equals(name, that.name) && Objects.equals(storage, that.storage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ram, storage, screensSize);
    }



    @Override
    public String toString() {
        return "into.Smartphone details \n" +
                "name='" + name + '\'' +
                ", ram=" + ram +
                ", storage='" + storage + '\'' +
                ", screensSize=" + screensSize +
                "\n";
    }


}
