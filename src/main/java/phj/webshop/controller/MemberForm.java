package phj.webshop.controller;

public class MemberForm {
    private String name;
    private String id;
    private String pw;
    private String tel;
    private String address;

    //자바 스크립트를 이용해 회원정보 5가지 모두 기입할 수 있도록 해야함!!!
    public String getName() {
        return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
