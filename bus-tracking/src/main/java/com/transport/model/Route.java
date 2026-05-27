package com.transport.model;
import jakarta.persistence.*;
@Entity
public class Route {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    private String startPoint;
    private String endPoint;
    public Route() {}

    public Long getId() {
        return id;
    }
    public String getStartPoint() {
        return startPoint;
    }
    
    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }
    public String getEndPoint() {
        return endPoint;
    }
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}

