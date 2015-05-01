package camt.se331.shoppingcart.entity;




import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Punjasin on 30/4/2558.
 */

@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;

    String fileName;
    @Lob
    byte[] content;
    String contentType;

    @Temporal(TemporalType.TIME)
    Date created;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;

        Image image = (Image) o;

        if (id != null ? !id.equals(image.id) : image.id != null) return false;
        if (fileName != null ? !fileName.equals(image.fileName) : image.fileName != null) return false;
        if (!Arrays.equals(content, image.content)) return false;
        if (contentType != null ? !contentType.equals(image.contentType) : image.contentType != null) return false;
        return !(created != null ? !created.equals(image.created) : image.created != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (content != null ? Arrays.hashCode(content) : 0);
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }

    public Image(String fileName, byte[] content, String contentType, Date created) {
        this.fileName = fileName;
        this.content = content;
        this.contentType = contentType;
        this.created = created;
    }

    public Image() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}