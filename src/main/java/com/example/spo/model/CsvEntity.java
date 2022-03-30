package com.example.spo.model;

import javax.persistence.*;

@Entity
@Table(name = "csv", schema = "spo")
public class CsvEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "filename")
    private String filename;
    @Basic
    @Column(name = "version")
    private String version;
    @Basic
    @Column(name = "creation")
    private String creation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CsvEntity csvEntity = (CsvEntity) o;

        if (id != null ? !id.equals(csvEntity.id) : csvEntity.id != null) return false;
        if (filename != null ? !filename.equals(csvEntity.filename) : csvEntity.filename != null) return false;
        if (version != null ? !version.equals(csvEntity.version) : csvEntity.version != null) return false;
        if (creation != null ? !creation.equals(csvEntity.creation) : csvEntity.creation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (creation != null ? creation.hashCode() : 0);
        return result;
    }
}
