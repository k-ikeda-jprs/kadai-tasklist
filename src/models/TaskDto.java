package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
            name = "getAllMessages",
            query = "SELECT m FROM TaskDto AS m ORDER BY m.id DESC"
            )
})
@Table(name = "tasks")
public class TaskDto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_date", length = 255, nullable = false)
    private Timestamp create_date;

    @Column(name = "update_date", length = 255, nullable = false)
    private Timestamp update_date;

    @Column(name = "content", length = 255, nullable = false)
    private String content;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Timestamp getCreate_date(){
        return create_date;
    }

    public void setCreate_date(Timestamp create_date){
        this.create_date = create_date;
    }

    public Timestamp getUpdate_date(){
        return update_date;
    }

    public void setUpdate_date(Timestamp update_date){
        this.update_date = update_date;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }
}
