package model;

public class AttendanceTable {
    int id;
    int classId;
    int userId;

    public AttendanceTable(int id, int classId, int userId) {
        this.id = id;
        this.classId = classId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
