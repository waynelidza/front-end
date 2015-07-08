package dto;

import java.util.List;

/**
 * Created by CodeTribe1 on 7/8/2015.
 */
public class ResponseDTO {
    private int statusCode;
    private Integer adminid;
    private Integer eventID;
    private String SessionID ;
    private Integer memberID;
    private Integer messageid;
    private Integer idPhotos;
    private Integer photoid;
    private AdminDTO  admin;
    private EventsDTO events;
    private MembersDTO members;
    private MessagewallDTO walltext  ;
    private PhotosDTO memberph;
    private PhotowallDTO photowall ;
    private List<MembersDTO> memberslist;
    private List<MessagewallDTO> messagewallList ;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
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

    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String sessionID) {
        SessionID = sessionID;
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

    public MessagewallDTO getWalltext() {
        return walltext;
    }

    public void setWalltext(MessagewallDTO walltext) {
        this.walltext = walltext;
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

    public List<MembersDTO> getMemberslist() {
        return memberslist;
    }

    public void setMemberslist(List<MembersDTO> memberslist) {
        this.memberslist = memberslist;
    }

    public List<MessagewallDTO> getMessagewallList() {
        return messagewallList;
    }

    public void setMessagewallList(List<MessagewallDTO> messagewallList) {
        this.messagewallList = messagewallList;
    }
}
