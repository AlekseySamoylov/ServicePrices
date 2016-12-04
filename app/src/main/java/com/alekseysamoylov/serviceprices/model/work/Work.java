package com.alekseysamoylov.serviceprices.model.work;

import java.math.BigDecimal;

/**
 * Работа
 * Pattern Builder
 */
public class Work implements Comparable<Work> {
    private Long id;
    private String title;
    private BigDecimal price;
    private String details;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public static class Builder {
        private Long id = 0L;
        private String title = "";
        private BigDecimal price = BigDecimal.ZERO;
        private String details = "";

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder details(String details) {
            this.details = details;
            return this;
        }

        public Work build() {
            return new Work(this);
        }
    }

    private Work(Builder builder) {
        id = builder.id;
        title = builder.title;
        price = builder.price;
        details = builder.details;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Work work = (Work) o;

        if (id != null ? !id.equals(work.id) : work.id != null) return false;
        if (title != null ? !title.equals(work.title) : work.title != null) return false;
        if (price != null ? !price.equals(work.price) : work.price != null) return false;
        return details != null ? details.equals(work.details) : work.details == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Work another) {
        return this.title.compareTo(another.title);
    }
}
