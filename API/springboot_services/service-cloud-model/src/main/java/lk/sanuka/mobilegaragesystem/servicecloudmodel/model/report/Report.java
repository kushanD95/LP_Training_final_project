package lk.sanuka.mobilegaragesystem.servicecloudmodel.model.report;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "report")
public class Report {

    public Report() {
    }

    public Report(int id, int task_id, String reason, boolean is_fixed, Set<Evidence> evidences) {
        this.id = id;
        this.task_id = task_id;
        this.reason = reason;
        this.is_fixed = is_fixed;
        this.evidences = evidences;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int task_id;
    private String reason;
    private boolean is_fixed;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id")
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
}
