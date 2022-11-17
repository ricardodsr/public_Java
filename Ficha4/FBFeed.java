import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;
import java.util.Iterator;
import java.time.LocalDateTime;

public class FBFeed {
    public List<FBPost> timeline;

    // Construtores
    public FBFeed() {
        this.timeline = new ArrayList<>();
    }

    public void addFBPost(FBPost post) {
        this.timeline.add(post); // post.clone() ???
    }

    public List<FBPost> postsOf(String user){
        List<FBPost> feedUser =
            this.timeline.stream()
                         .filter(post -> post.getUsername().equals(user))
                         .collect(Collectors.toList());
                         // .clone(); 
        return (ArrayList<FBPost>) feedUser; // Casting necessário ???
    }
    
    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim){
        List<FBPost> feedUser =
            this.timeline.stream()
                         .filter(post -> post.getUsername().equals(user))
                         .filter(post -> post.getCreation_date().isAfter(inicio))
                         .filter(post -> post.getCreation_date().isBefore(fim))
                         .collect(Collectors.toList());
                         // .clone(); 
                         //
        return (ArrayList<FBPost>) feedUser; // Casting necessário ???
    }

    public int nrPosts(String user) {
        int contador;
        contador = (int) this.timeline.stream()
                                      .filter(post -> post.getUsername().equals(user))
                                      .count();
        return contador;
    }

    // Dúvida: Existe alguma maneira de tendo uma stream de 1 elemento retornar
    // diretamente o primeiro elemento sem passar primeiro para lista?
    public FBPost getPost(int idPost) {
        FBPost output;
        output = this.timeline.stream()
                              .filter(post -> post.getId() == idPost)
                              .collect(Collectors.toList())
                              .get(0);
        return output;
    }

    public void comment(FBPost post, String comentario) {
        post.addComentario(comentario);
    }

    public void like(FBPost post) {
        post.addLike();
    }

    public void like(int postId) {
        this.getPost(postId).addLike();
    }

    // Isto funciona
    public List<Integer> topNCommentsInternal(int N) {
        List<Integer> output;
        FBPostComparator cmp = new FBPostComparator();

        output = this.timeline.stream() // Transform timeline into a stream
                              .sorted((s1, s2) -> cmp.compare(s1, s2))
                                                // Sort por ordem decresencente
                              // .limit(N) // Get the first N elements
                              .map(post -> post.getId()) // Map from post to its ID
                              .collect(Collectors.toList()); // Convert it to a list
        return output;
    }

    // TODO: Fix this
    // Peço perdão a quem tenha de ler esta aberração de código, foi feito demasiado à pressa e nem sequer funciona
    public List<Integer> topNCommentsExternal(int N) {
        int sizeClone = this.timeline.size();
        ArrayList<FBPost> clone = new ArrayList<>(sizeClone);
        for (int i = 0; i < sizeClone; i++) {
            clone.add(this.timeline.get(i).clone());
        }

        List<Integer> output = new ArrayList<>(N);

        Iterator<FBPost> it = clone.iterator();
        FBPost current;
        int maxSize = -1;
        int maxId = -1;
        for (int i = 0; i < N; i++) {
            while (it.hasNext()) {
                current = it.next();
                if (current.getComentarios().size() > maxSize) {
                    maxSize = current.getComentarios().size(); 
                    maxId = current.getId();
                }
            }
            it = clone.iterator();
            while (maxId != it.next().getId());
            it.remove();
            it = clone.iterator();
            output.add(maxId);
            maxSize = -1;
            maxId = -1;
        }
        return output;
    }

    public List<Integer> top5Comments() {
        return topNCommentsInternal(5);
        // return top5NCommentsExternal(5);
    }

    // Testing only
    public static void main (String[] args) {
        FBFeed feedTest = new FBFeed();

        // LocalDateTime beginning = LocalDateTime.now();
        FBPost post0 = new FBPost("Joao", "Eu gosto de gatos");
        FBPost post1 = new FBPost("Maria", "Eu gosto de gatos");
        FBPost post2 = new FBPost("Joao", "Eu gosto de cães fofinhos");
        // LocalDateTime middle = LocalDateTime.now();
        FBPost post3 = new FBPost("Joao", "Ja nao gosto de gatos");
        FBPost post4 = new FBPost("Joao", "Mas os bombeiros sao fixes");
        // LocalDateTime end = LocalDateTime.now();
        
        feedTest.addFBPost(post0);
        feedTest.addFBPost(post1);
        feedTest.addFBPost(post2);
        feedTest.addFBPost(post3);
        feedTest.addFBPost(post4);

        // Teste variavel estatica:
        // System.out.printf("Número de posts: %d\n", FBPost.getLastID());
        // System.out.printf("----------------------------------\n");

        // Teste postsOf(user) + nrPosts(user)
        // System.out.printf("Número de posts do João: %d\n", feedTest.nrPosts("Joao"));
        // System.out.println(feedTest.postsOf("Joao").toString());
        // System.out.printf("----------------------------------\n");

        // Test postsOF(user, begin, end)
        // System.out.println(feedTest.postsOf("Joao", beginning, middle));
        // System.out.println(feedTest.postsOf("Joao", middle, end));
        // System.out.printf("----------------------------------\n");
        
        // Teste getPost(id)
        // System.out.println("O primeiro post a ser criado foi: ");
        // System.out.println(feedTest.getPost(0).toString());

        // Teste comment(post, string) + Teste likes
        feedTest.comment(post0, "Cães > gatos, fight me bro");
        feedTest.comment(post0, "Tens razão João!");
        feedTest.like(post0);
        feedTest.like(post0);
        feedTest.like(0);
        feedTest.like(0);
        // System.out.println(post0.toString());

        feedTest.comment(post1, "Tens razão João!");
        feedTest.comment(post4, "Tens razão João!");
        feedTest.comment(post4, "Tens razão João!");
        feedTest.comment(post4, "Tens razão João!");
        // post0: 2 comments
        // post1: 1 comments
        // post2: 0 comments
        // post3: 0 comments
        // post4: 3 comments

        System.out.println("External: ");
        System.out.println(feedTest.topNCommentsExternal(3).toString());
        System.out.println("------------\n");
        System.out.println("Internal: ");
        System.out.println(feedTest.topNCommentsInternal(3).toString());
        System.out.println("Comment count: ");
        for (int i = 0; i < feedTest.timeline.size(); i++) {
            System.out.printf("%d ", feedTest.timeline.get(i).getComentarios().size());
        }
    }

    // Getter + setters
    /**
     * Get timeline.
     *
     * @return timeline as List<FBPost>.
     */
    public List<FBPost> getTimeline() {
        return timeline;
    }

    /**
     * Set timeline.
     *
     * @param timeline the value to set.
     */
    public void setTimeline(List<FBPost> timeline) {
        this.timeline = timeline;
    }
}
