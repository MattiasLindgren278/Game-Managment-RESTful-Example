package domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Console implements Serializable {

    @Id
    private String name;

    private String cpuName;
    private int cpuGhz;
    private String graphicsCard;
    private int storageSpace;

    public Console() {
    }

    public Console(String name, String cpuName, int cpuGhz, String graphicsCard, int storageSpace) {
        this.name = name;
        this.cpuName = cpuName;
        this.cpuGhz = cpuGhz;
        this.graphicsCard = graphicsCard;
        this.storageSpace = storageSpace;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public int getCpuGhz() {
        return cpuGhz;
    }

    public void setCpuGhz(int cpuGhz) {
        this.cpuGhz = cpuGhz;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public int getStorageSpace() {
        return storageSpace;
    }

    public void setStorageSpace(int storageSpace) {
        this.storageSpace = storageSpace;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Console other = (Console) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Console{" + "name=" + name + ", cpuName=" + cpuName + ", cpuGhz=" + cpuGhz + ", graphicsCard=" + graphicsCard + ", storageSpace=" + storageSpace + '}';
    }

}
