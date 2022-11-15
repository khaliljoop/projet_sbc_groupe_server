package com.sbc.groupe.sbc_backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User_message {
    @Id
    @Column(name = "id",length = 32)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String uid;
    private Date _date;
    private String sender_message_id ;
    private String receiver_message_id;
    @Column(length = 500)
    private String message;
    private Integer isBlocked;// vrai si 1 sinon -1
}