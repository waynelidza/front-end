package dto;

/**
 * Created by CodeTribe1 on 7/8/2015.
 */
public class PhotosDTO {
    private Integer idPhotos;
    private String uri;
    private Integer member;

    public Integer getIdPhotos() {
        return idPhotos;
    }

    public void setIdPhotos(Integer idPhotos) {
        this.idPhotos = idPhotos;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }
}
