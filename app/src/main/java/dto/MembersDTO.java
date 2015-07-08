package dto;

import java.util.List;

/**
 * Created by CodeTribe1 on 7/8/2015.
 */
public class MembersDTO {
    private Integer memberID;
    private String name;
    private String surname;
    private String nickname;
    private String ambition;
    private String email;
    private String password;
    private String cellphone;
    private String profession;
    private List<MessagewallDTO> messagewallList;
    private List<MembersDTO> members ;

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAmbition() {
        return ambition;
    }

    public void setAmbition(String ambition) {
        this.ambition = ambition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<MessagewallDTO> getMessagewallList() {
        return messagewallList;
    }

    public void setMessagewallList(List<MessagewallDTO> messagewallList) {
        this.messagewallList = messagewallList;
    }

    public List<MembersDTO> getMembers() {
        return members;
    }

    public void setMembers(List<MembersDTO> members) {
        this.members = members;
    }
}
