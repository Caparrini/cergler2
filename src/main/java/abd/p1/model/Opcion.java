package abd.p1.model;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Transient private Pregunta preguntaMadre;

    @Column(name = "questionOrder", nullable = false)
    private int numeroOrden;

    @Column(name = "content", nullable = false)
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
