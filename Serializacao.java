
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacao {    
    private final File ficheiro;

    public Serializacao(String ficheiro) {
        this.ficheiro = new File(ficheiro);
    }

    public File getFicheiro() {
        return ficheiro;
    }          
    
/**
 * Loads a Sistema object from a file.
 *
 * @return the Sistema object loaded from the file
 */
public Sistema carregar() {
    try (FileInputStream fileIn = new FileInputStream(ficheiro);
         ObjectInputStream in = new ObjectInputStream(fileIn)) {
        return (Sistema) in.readObject();
    } catch (IOException | ClassNotFoundException ex) {
        throw new RuntimeException(String.format("Ocorreu um erro ao ler o ficheiro de dados: %s", ex.getLocalizedMessage()), ex);
    }
}
    
//Guarda o sistema em ficheiro
public void guardar(Sistema sistema) {
    try (FileOutputStream fileOut = new FileOutputStream(ficheiro);
         ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
        out.writeObject(sistema);
    } catch (IOException ex) {
        throw new RuntimeException(String.format(
                "Ocorreu um erro ao guardar o ficheiro de dados: %s",
                ex.getLocalizedMessage()), ex);
    }
}
    
    
}
