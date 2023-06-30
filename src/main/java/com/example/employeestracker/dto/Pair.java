package com.example.employeestracker.dto;

public class Pair {
    private int firstEmployeeId;
    private int secondEmployeeId;
    private int projectId;
    private int durationWorkingTogether;

    public Pair(int firstEmployeeId, int secondEmployeeId, int projectId, int durationWorkingTogether) {
        this.setFirstEmployeeId(firstEmployeeId);
        this.setSecondEmployeeId(secondEmployeeId);
        this.setProjectId(projectId);
        this.setDurationWorkingTogether(durationWorkingTogether);
    }

    public int getProjectId() {
        return projectId;
    }

    private void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getDurationWorkingTogether() {
        return durationWorkingTogether;
    }

    public void setDurationWorkingTogether(int durationWorkingTogether) {
        this.durationWorkingTogether = durationWorkingTogether;
    }

    public int getFirstEmployeeId() {
        return firstEmployeeId;
    }

    public void setFirstEmployeeId(int firstEmployeeId) {
        this.firstEmployeeId = firstEmployeeId;
    }

    public int getSecondEmployeeId() {
        return secondEmployeeId;
    }

    public void setSecondEmployeeId(int secondEmployeeId) {
        this.secondEmployeeId = secondEmployeeId;
    }

}
