package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class Student {
    private int Id;
    private String name;
    private String dateOfBirth;
    private String telephone;
    private String city;
    private String country;
    private String groupName;

    public void DataInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Student Information");
        System.out.println("");
        System.out.printf("Input Id: ");
        setId(Integer.parseInt(sc.nextLine()));
        System.out.printf("Input Name: ");
        setName(sc.nextLine());
        System.out.printf("Input Date of Birth(dd-mm-yyyy): ");
        setDateOfBirth(sc.nextLine());
        System.out.printf("Input Telephone(+xxx xx xxx xxx): ");
        setTelephone(sc.nextLine());
        System.out.printf("Input City: ");
        setCity(sc.nextLine());
        System.out.printf("Input Country: ");
        setCountry(sc.nextLine());
        System.out.printf("Input Group Name(ex: I4A,T2B,...): ");
        setGroupName(sc.nextLine());

        System.out.println("Successfully Input");
        System.out.println(DataOutput());
    }
    public String DataOutput(){
        return "Student's Name: " + getName()+
                "ID: " + getId()+
                "Date of Birth: " + getDateOfBirth()+
                "Telephone: " + getTelephone()+
                "City: " + getCity()+
                "Country: " + getCountry()+
                "Group: " + getGroupName();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        String date = dateOfBirth; //"18-4-1999"
        int year = Integer.parseInt(date.substring(6));
        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();
        Boolean checkYear = currentYear - year >= 15;
        if(checkYear){
            this.dateOfBirth = dateOfBirth;
        }else{
            this.dateOfBirth = null;
            throw new ArithmeticException("Access denied - You must be at least 15 years old.");
        }

    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        String teleFormat = telephone.substring(0,4);
        if(teleFormat.equalsIgnoreCase("+855")){
            this.telephone = telephone;
        }else{
            throw new ArithmeticException("Access denied - You must be Cambodia's phone number");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        String start = groupName.substring(0,1);
        int middle = Integer.parseInt(groupName.substring(1,2));
        String end = groupName.substring(2);

        if(start.equalsIgnoreCase("I") || start.equalsIgnoreCase("T")){
            if(start.equalsIgnoreCase("I")){
                if(middle >=1 && middle<=5){
                    if(end.matches("\\w+")){
                        this.groupName = groupName;
                    }else {
                        throw new ArithmeticException("Label must be Latin Alphabets");
                    }
                }else{
                    throw new ArithmeticException("Engineering must be number from 1-5");
                }
            }
            if(start.equalsIgnoreCase("T")){
                if(middle >=1 && middle<=2){
                    if(end.matches("\\w+")){
                        this.groupName = groupName;
                    }else {
                        throw new ArithmeticException("Label must be Latin Alphabets");
                    }
                }else{
                    throw new ArithmeticException("Technician must be number from 1-2");
                }
            }
        }else {
            throw new ArithmeticException("Access Denies");
        }

    }

}
