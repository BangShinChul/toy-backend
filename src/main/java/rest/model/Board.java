package rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "board")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // id값 자동 할당
    @Column(name = "board_id")
    private int id;

    @Column(name = "board_status")
    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Account account;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "subject")
    private String subject;

    @Column(name = "contents")
    private String contents;

    @Column(name = "hits")
    private int hits;

    @Column(name = "comments")
    private int comments;

    @Column(name = "reg_date")
    private Date reg_date;
}
