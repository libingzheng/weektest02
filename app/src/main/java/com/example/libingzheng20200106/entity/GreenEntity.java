package com.example.libingzheng20200106.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
//GreenDao实体类
@Entity
public class GreenEntity {
    @Id(autoincrement = true)
    public Long id;
    public String json;
    public String key;
    @Generated(hash = 975165076)
    public GreenEntity(Long id, String json, String key) {
        this.id = id;
        this.json = json;
        this.key = key;
    }
    @Generated(hash = 1875989347)
    public GreenEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getJson() {
        return this.json;
    }
    public void setJson(String json) {
        this.json = json;
    }
    public String getKey() {
        return this.key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
