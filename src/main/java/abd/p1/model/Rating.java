package abd.p1.model;

import javax.persistence.*;

@Entity
@Table(name = "user_questions", uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "answerId"}))
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "RATING_USER_ID_FK"))
    private User rater;

    @Column(nullable = false)
    private Integer rating;

    @ManyToOne(optional = false)
    @JoinColumn(name = "answerId", foreignKey = @ForeignKey(name = "RATING_QUESTION_ID_FK"))
    private Opcion answer;

    protected Rating() {}

    public Rating(User rater, Integer rating, Opcion answer) {
        this.rater = rater;
        this.rating = rating;
        this.answer = answer;
    }

    public void rate(Integer r) {
        this.rating = r;
    }
}
