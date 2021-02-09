package com.digitalcreative.librarymodel;

public enum EnumRole {

    ADMINISTRATEUR(1,"Administrateur"),
    EMPLOYER(2,"Employé"),
    UTILISATEUR(3,"Utilisateur");


    private Integer id;
    private String designation;

    EnumRole(Integer id){
        this.id=id;
    }

    EnumRole(Integer id,String designation){
        this.id=id;
        this.designation=designation;
    }

    public Integer getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "EnumRole{" +
                "code=" + id +
                ", designation='" + designation;
    }

}
