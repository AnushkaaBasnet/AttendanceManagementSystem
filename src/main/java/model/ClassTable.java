package model;

public class ClassTable {
    int class_id;
    String classname;

    public ClassTable(int class_id, String classname) {
        this.class_id = class_id;
        this.classname = classname;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
