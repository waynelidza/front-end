package dto;

import java.io.Serializable;

/**
 * Created by CodeTribe1 on 7/8/2015.
 */
public class RequestDTO implements Serializable {
    private int requestType;
    private Integer adminid;
    private Integer eventID;
    private Integer memberID;
    private Integer messageid;
    private Integer idPhotos;
    private Integer photoid;
    private AdminDTO  admin;
    private EventsDTO events;
    private MembersDTO members;
    private MessagewallDTO messagewall  ;
    private PhotosDTO memberph;
    private PhotowallDTO photowall ;
    public final static int REGISTERMB = 1;
    public final static int GETALLMSG= 200;

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public Integer getIdPhotos() {
        return idPhotos;
    }

    public void setIdPhotos(Integer idPhotos) {
        this.idPhotos = idPhotos;
    }

    public Integer getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Integer photoid) {
        this.photoid = photoid;
    }

    public AdminDTO getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDTO admin) {
        this.admin = admin;
    }

    public EventsDTO getEvents() {
        return events;
    }

    public void setEvents(EventsDTO events) {
        this.events = events;
    }

    public MembersDTO getMembers() {
        return members;
    }

    public void setMembers(MembersDTO members) {
        this.members = members;
    }

    public MessagewallDTO getMessagewall() {
        return messagewall;
    }

    public void setMessagewall(MessagewallDTO messagewall) {
        this.messagewall = messagewall;
    }

    public PhotosDTO getMemberph() {
        return memberph;
    }

    public void setMemberph(PhotosDTO memberph) {
        this.memberph = memberph;
    }

    public PhotowallDTO getPhotowall() {
        return photowall;
    }

    public void setPhotowall(PhotowallDTO photowall) {
        this.photowall = photowall;
    }

    public static int getREGISTERMB() {
        return REGISTERMB;
    }

    public static int getGETALLMSG() {
        return GETALLMSG;
    }
}
