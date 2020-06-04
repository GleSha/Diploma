package com.app.models;

import javax.persistence.*;

@Entity
@Table(name = "message_recipient")
public class MessageRecipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public MessageRecipient(Long id, Message message, User user) {
        this.id = id;
        this.message = message;
        this.user = user;
    }

    public MessageRecipient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
