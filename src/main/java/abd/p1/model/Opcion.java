package abd.p1.model;

import javax.persistence.*;

@Entity
@Table(name = "answers", uniqueConstraints = @UniqueConstraint(columnNames = {"questionId", "questionOrder"}))
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="answerId")
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "questionId", foreignKey = @ForeignKey(name = "ANSWER_QUESTION_ID_FK"))
    private Pregunta preguntaMadre;

    @Column(name = "questionOrder", nullable = false)
    private int numeroOrden;

    @Column(name = "content", nullable = false, length = 500)
    private String texto;

    public Opcion() {}

    public Pregunta getPreguntaMadre() {
        return preguntaMadre;
    }

    public void setPreguntaMadre(Pregunta preguntaMadre) {
        this.preguntaMadre = preguntaMadre;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "(" + numeroOrden + ") " + texto;
    }
}
