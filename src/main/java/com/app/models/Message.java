package com.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 100000)
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "message")
    private Set<MessageRecipient> messageRecipientSet = new HashSet<>();

    public Set<MessageRecipient> getMessageRecipientSet() {
        return messageRecipientSet;
    }

    public void setMessageRecipientSet(Set<MessageRecipient> messageRecipientSet) {
        this.messageRecipientSet = messageRecipientSet;
    }

    public Message(Long id, @Size(max = 100000) String text, User user) {
        this.id = id;
        this.text = text;
        this.user = user;
    }

    public Message() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
