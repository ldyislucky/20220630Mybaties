package com.ldy.pojo;


import java.util.Date;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Person {
    private  int         id        ;
    private  String      name      ;
    private Date         birthday  ;
    private  char        sex       ;
    private  String      address   ;

    public Person() {
    }

    public Person(String name, Date birthday, char sex, String address) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public char getSex() {
        return sex;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
