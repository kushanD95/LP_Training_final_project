package lk.sanuka.mobilegaragesystem.servicecloudmodel.dto.report;

import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.report.Evidence;
import lk.sanuka.mobilegaragesystem.servicecloudmodel.model.report.Report;

import java.util.Set;

public class ReportDto {

    public ReportDto() {
    }

    public ReportDto(Report report) {
        this.id = report.getId();
        this.task_id = report.getTask_id();
        this.reason = report.getReason();
        this.is_fixed = report.isIs_fixed();
    }

    public ReportDto(Set<Evidence> evidences) {
        this.evidences = evidences;
    }

    public ReportDto(int id, Set<Evidence> evidences) {
        this.id = id;
        this.evidences = evidences;
    }

    public ReportDto(int id, int task_id, String reason, boolean is_fixed, Set<Evidence> evidences) {
        this.id = id;
        this.task_id = task_id;
        this.reason = reason;
        this.is_fixed = is_fixed;
        this.evidences = evidences;
    }

    private int id;
    private int task_id;
    private String reason;
    private boolean is_fixed;
    Set<Evidence> evidences;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isIs_fixed() {
        return is_fixed;
    }

    public void setIs_fixed(boolean is_fixed) {
        this.is_fixed = is_fixed;
    }

    public Set<Evidence> getEvidences() {
        return evidences;
    }

    public void setEvidences(Set<Evidence> evidences) {
        this.evidences = evidences;
    }
}
