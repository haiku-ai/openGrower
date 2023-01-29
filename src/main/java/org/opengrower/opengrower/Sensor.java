package org.opengrower.opengrower;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Calendar;
import java.util.Date;

public class Sensor {
    @Id
    private String id;
    @Indexed
    private String name;

    private Date creationDate;

    public Sensor(String name) {
        this.name = name;
        this.creationDate = Calendar.getInstance().getTime();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(Date creationDate) {this.creationDate = creationDate; }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }


    @Override
    public String toString() {
        return String.format(
                "SensorMasurement[id=%s, name='%s', creationDate='%s']",
                id, name, creationDate);
    }

}
