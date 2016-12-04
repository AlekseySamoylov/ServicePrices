package com.alekseysamoylov.serviceprices.model.work;

/**
 * Created by alekseysamoylov on 11/26/16.
 */

public class WorkGroup {
    private Long id;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkGroup workGroup = (WorkGroup) o;

        if (id != null ? !id.equals(workGroup.id) : workGroup.id != null) return false;
        return title != null ? title.equals(workGroup.title) : workGroup.title == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WorkGroup{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
