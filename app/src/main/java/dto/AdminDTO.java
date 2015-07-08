package dto;

import java.util.List;

/**
 * Created by CodeTribe1 on 7/8/2015.
 */
public class AdminDTO {
    private Integer adminid;
    private String email;
    private String password;
    private String theme;
    private List<MessagewallDTO> messagewallList;

    public Integer getAdminid() {
        return adminid;
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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<MessagewallDTO> getMessagewallList() {
        return messagewallList;
    }

    public void setMessagewallList(List<MessagewallDTO> messagewallList) {
        this.messagewallList = messagewallList;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }
}
