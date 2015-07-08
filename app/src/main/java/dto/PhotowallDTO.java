package dto;

import java.util.Date;

/**
 * Created by CodeTribe1 on 7/8/2015.
 */
public class PhotowallDTO {
    private Integer photoid;
    private String comment;
    private Date date;
    private String location;
    private Integer member;

    public Integer getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Integer photoid) {
        this.photoid = photoid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }
}
