import java.util.Comparator;

public class FBPostComparator implements Comparator<FBPost> {
    public int compare(FBPost p1, FBPost p2) {
        int n1 = p1.getComentarios().size();
        int n2 = p2.getComentarios().size();
        if (n1 < n2) return 1;
        if (n1 > n2) return -1;
        return 0;
    }
}
