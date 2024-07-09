package Models;

import java.util.Date;

public class BaseModel {
    private Long id;
    private Date CreatedAt;
    private Date LastModifiedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getLastModifiedAt() {
        return LastModifiedAt;
    }

    public void setLastModifiedAt(Date lastModifiedAt) {
        LastModifiedAt = lastModifiedAt;
    }



}
