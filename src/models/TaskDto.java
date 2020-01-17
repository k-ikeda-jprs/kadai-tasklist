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
    // column id
    // 連番かつユニークに自動生成
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // column create_date
    // 生成時間を格納
    @Column(name = "create_date", length = 255, nullable = false)
    private Timestamp create_date;

    // column update_date
    // 更新時間を格納
    @Column(name = "update_date", length = 255, nullable = false)
    private Timestamp update_date;

    // column content
    // タスク内容を格納
    @Column(name = "content", length = 255, nullable = false)
    private String content;

    // 以下、getterとsetter
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
