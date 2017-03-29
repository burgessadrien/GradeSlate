package com.gradeslate.gradeslate.backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Team implements Serializable {
    private ArrayList<Student> members;

    Team() {
        this.members = new ArrayList();
    }

    public void addMem(String name) {
        this.members.add(new Student());
    }

    public void remMem(String name) {
        int count = 0;
        Iterator it = this.members.iterator();
        while (it.hasNext()) {
            if (((Student) it.next()).getName() == name) {
                this.members.remove(count);
            } else {
                count++;
            }
        }
    }

    public String getMem(String name) {
        Iterator it = this.members.iterator();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            if (student.getName() == name) {
                return student.getName();
            }
        }
        return "Student is not part of this team";
    }
}
