package com.database.madhusoodhan.database;

/**
 * Created by madhusoodhan on 25-Feb-15.
 */
public class EventEntity {

    private int id;
    private String description;
    private String priority;
    private String planDate;


    public EventEntity(){

    }

    public EventEntity(String description, String priority, String planDate) {
        this.description = description;
        this.priority = priority;
        this.planDate = planDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }
}
