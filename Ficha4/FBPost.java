import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class FBPost {
    private int id;
    private String username;
    private LocalDateTime creation_date;
    private String conteudo;
    private int likes;
    private List<String> comentarios;
    static private int lastID = 0;

    // Constructores para debugging (Não devem ser usados):
    public FBPost() {
        this.id = lastID;
        this.username = "debug only";
        this.creation_date = LocalDateTime.now();
        this.conteudo = "debug only";
        this.likes = 0;
        this.comentarios = new ArrayList<>();
        FBPost.lastID++;
    }

    public FBPost(int id,
                String username,
                LocalDateTime creation_date,
                String conteudo,
                int likes,
                List<String> comentarios) {
        this.id = id;
        this.username = username;
        this.creation_date = creation_date;
        this.conteudo = conteudo;
        this.likes = likes;
        this.comentarios = comentarios;
    }

    // Construtor realistas
    public FBPost(String username, String conteudo) {
        this.id = FBPost.lastID;
        this.username = username;
        this.creation_date = LocalDateTime.now();
        this.conteudo = conteudo;
        this.likes = 0;
        this.comentarios = new ArrayList<String>();
        FBPost.lastID++;
    }
    
    // Construtor cópia (comentarios incompleto)
    public FBPost(FBPost outro) {
        this.id = FBPost.lastID;
        this.username = outro.username;
        this.creation_date = outro.getCreation_date();
        this.conteudo = outro.getConteudo();
        this.likes = outro.getLikes();
        this.comentarios = outro.getComentarios();
    }

    public void addLike() {
        this.likes++;
    }

    public void addComentario(String comentario) {
        this.comentarios.add(comentario);
    }

    // TODO: complete this
    public String toString() {
        String output = "User name: " + this.username + "\n"
                      + "Data do post: " + this.creation_date.toString() + "\n"
                      + "Conteudo: " + this.conteudo + "\n"
                      + "Likes: " + this.likes + "\n"
                      + "Comentários:\n"
                      + this.comentarios.toString();
        return output;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (this.getClass() != o.getClass() || o == null) {
            return false;
        } else {
            FBPost obj = (FBPost) o;
            if (obj.getId() == this.id) {
                return true;
            } else {
                return false;
            }
        }
    }

    public FBPost clone() {
        return new FBPost(this);
    }

    // Getters + Setters
    /**
     * Get id.
     *
     * @return id as int.
     */
    public int getId() {
        return id;
    }

    /**
     * Set id.
     *
     * @param id the value to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get username.
     *
     * @return username as String.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username.
     *
     * @param username the value to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get creation_date.
     *
     * @return creation_date as LocalDateTime.
     */
    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    /**
     * Set creation_date.
     *
     * @param creation_date the value to set.
     */
    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    /**
     * Get conteudo.
     *
     * @return conteudo as String.
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Set conteudo.
     *
     * @param conteudo the value to set.
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * Get likes.
     *
     * @return likes as int.
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Set likes.
     *
     * @param likes the value to set.
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    /**
     * Get comentarios.
     *
     * @return comentarios as List<String>.
     */
    public List<String> getComentarios() {
        return comentarios;
    }

    /**
     * Set comentarios.
     *
     * @param comentarios the value to set.
     */
    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Get lastID.
     *
     * @return lastID as int.
     */
    public static int getLastID() {
        return lastID;
    }
}
