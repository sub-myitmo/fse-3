package org.viacheslav;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@Named("pointBean")
@ApplicationScoped
@Table(name = "points")
public class Point implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="id", nullable=false, unique=true)
    private int id;

    @Column(name="x", nullable=false)
    private double x;

    @Column(name="y", nullable=false)
    private double y;

    @Column(name="r", nullable=false)
    private double r;

    @Column(name="date", nullable=false)
    private Date date;

    @Column(name="result", nullable=false)
    private boolean result;

    @Column(name="session")
    private String session;

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        check();
    }

    public void check() {
        date = new Date(System.currentTimeMillis());;
        result = (x >= 0 && y >= 0 && (y <= r / 2 - 0.5 * x)) ||
                (x < 0 && y <= 0 && (Math.sqrt(x * x + y * y) <= r)) ||
                (x < 0 && y >= 0 && (x >= -r) && (y <= r));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean isResult() {
        return result;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y + ", r = " + r + ", date = " + date + ", isHit = " + result;
    }
}
