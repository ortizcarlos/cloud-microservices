/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.productcomposite.rest.clients;

import java.util.Date;

/**
 *
 * @author Carlos
 */
public class Review {
    private String id;

    private Long productId;

    private String title;

    /*contenido del review*/
    private String content;

    /*timestamp  creacion*/
    private Date created;
    
    private int starts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setStarts(int starts) {
        this.starts = starts;
    }

    public int getStarts() {
        return starts;
    }
    
}
