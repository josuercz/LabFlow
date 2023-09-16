    package Music;

    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;
    import java.io.Serializable;
    import java.util.ArrayList;

    public class Music implements Serializable {
        String Nombre;
        String Autor;
        String Album;
        String data;
        Long tiempo;
        String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Music(String Nombre, String Autor, String Album, String data, Long tiempo, String path) {
            this.Nombre = Nombre;
            this.Autor = Autor;
            this.Album = Album;
            this.data = data;
            this.tiempo = tiempo;
        }

        public Music() {}

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String Nombre) {
            this.Nombre = Nombre;
        }

        public String getAutor() {
            return Autor;
        }

        public void setAutor(String Autor) {
            this.Autor = Autor;
        }

        public String getAlbum() {
            return Album;
        }

        public void setAlbum(String Album) {
            this.Album = Album;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Long getTiempo() {
            return tiempo;
        }

        public void setTiempo(Long tiempo) {
            this.tiempo = tiempo;
        }

        public String toString()
        {
        return "Musica{Nombre=" + Nombre + ", Autor=" + Autor + ", Album=" + Album + ", data=" + data + ", tiempo=" + tiempo + '}';
        }



        public void serializaListaMusica(ArrayList<Music> listaMusica, String archivo) {
            FileOutputStream arq = null;
            ObjectOutputStream out = null;
            try {
                arq = new FileOutputStream(archivo);
                out = new ObjectOutputStream(arq);
                out.writeObject(listaMusica); return;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } finally {
                try {
                    arq.close();
                    out.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        public ArrayList<Music> deserializaListaMusica(String archivo) {
            FileInputStream arqLeitura = null;
            ObjectInputStream in = null;
            ArrayList lista = new ArrayList();
            try  {
                arqLeitura = new FileInputStream(archivo);
                in = new ObjectInputStream(arqLeitura);
                return (ArrayList)in.readObject();
            } catch (ClassNotFoundException|IOException ex) {
                System.out.println(ex.getMessage());
            } finally {
                try {
                    arqLeitura.close();
                    in.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            return null;
        }
    }
