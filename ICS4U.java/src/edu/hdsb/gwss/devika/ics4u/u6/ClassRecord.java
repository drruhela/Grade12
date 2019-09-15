/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u6;

/**
 *
 * @author drruh
 */
public class ClassRecord {
    
    
    //Class Constants
    private static final int REC_SIZE = 58;
    private static final int TEACHER_LENGTH = 12;
    private static final int SUBJECT_LENGTH = 15;
    private static final int SIZE_LENGTH = 4;
    
    //instance variables
    private int id;
    private String teacher;
    private String subject;
    private int size;
    
    //constructors
    public ClassRecord () {
        
        this.id = -1;
        
    }
    
    public ClassRecord( int id) {
        
        this.id = id;
        
    }
    
    public ClassRecord (String teacher, String subject, int size) {
        
        this.id = -1;
        this.teacher = teacher;
        this.subject = subject;
        this.size = size;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ClassRecord{" + "id=" + id + ", teacher=" + teacher + ", subject=" + subject + ", size=" + size + '}';
    }
    
    
}
