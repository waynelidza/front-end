package dto;

import java.util.List;

/**
 * Created by CodeTribe1 on 7/8/2015.
 */
public class MessagewallDTO {
    private Integer messageid;
    private String status;
    private Long updatetime;
    private Integer member;
    private List<MessagewallDTO> messagewallList;

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    public List<MessagewallDTO> getMessagewallList() {
        return messagewallList;
    }

    public void setMessagewallList(List<MessagewallDTO> messagewallList) {
        this.messagewallList = messagewallList;
    }
}
