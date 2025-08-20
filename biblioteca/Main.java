import java.util.*;

class Libro {
    private String titulo;
    private String autor;
    private String codigo;
    private boolean disponible;

    public Libro(String titulo, String autor, String codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.disponible = true;
    }

    public String getCodigo() { return codigo; }
    public boolean isDisponible() { return disponible; }
    public void marcarPrestado() { disponible = false; }
    public void marcarDisponible() { disponible = true; }

    public void mostrarDatos() {
        System.out.println("Codigo: " + codigo + " | Titulo: " + titulo +
                " | Autor: " + autor +
                " | Disponible: " + (disponible ? "Si" : "No"));
    }
}

class Usuario {
    private String nombre;
    private String idUsuario;
    private List<Libro> librosPrestados;

    public Usuario(String nombre, String idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.librosPrestados = new ArrayList<>();
    }

    public String getIdUsuario() { return idUsuario; }
    public List<Libro> getLibrosPrestados() { return librosPrestados; }

    public void mostrarDatos() {
        System.out.println("Usuario: " + nombre + " | ID: " + idUsuario +
                " | Libros prestados: " + librosPrestados.size());
    }

    public boolean agregarPrestamo(Libro libro) {
        if (librosPrestados.size() < 3) {
            librosPrestados.add(libro);
            return true;
        } else {
            return false;
        }
    }

    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
    }
}

class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Date fechaInicio;
    private Date fechaLimite;

    public Prestamo(Libro libro, Usuario usuario, Date fechaInicio, Date fechaLimite) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
    }

    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }
    public Date getFechaLimite() { return fechaLimite; }

    public void mostrarDatos() {
        System.out.println("Prestamo - Usuario: " + usuario.getIdUsuario() +
                " | Libro: " + libro.getCodigo() +
                " | Fecha inicio: " + fechaInicio +
                " | Fecha limite: " + fechaLimite);
    }
}

class Biblioteca {
    private List<Libro> listaLibros;
    private List<Usuario> listaUsuarios;
    private Map<String, Prestamo> registroPrestamos;

    public Biblioteca() {
        listaLibros = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
        registroPrestamos = new HashMap<>();
    }

    public void registrarLibro(String titulo, String autor, String codigo) {
        listaLibros.add(new Libro(titulo, autor, codigo));
        System.out.println("Libro registrado con exito.");
    }

    public void registrarUsuario(String nombre, String idUsuario) {
        listaUsuarios.add(new Usuario(nombre, idUsuario));
        System.out.println("Usuario registrado con exito.");
    }

    private Libro buscarLibro(String codigo) {
        for (Libro l : listaLibros) {
            if (l.getCodigo().equals(codigo)) return l;
        }
        return null;
    }

    private Usuario buscarUsuario(String idUsuario) {
        for (Usuario u : listaUsuarios) {
            if (u.getIdUsuario().equals(idUsuario)) return u;
        }
        return null;
    }

    public void prestarLibro(String codigo, String idUsuario) {
        Libro libro = buscarLibro(codigo);
        Usuario usuario = buscarUsuario(idUsuario);

        if (libro == null || usuario == null) {
            System.out.println("Libro o usuario no encontrado.");
            return;
        }

        if (!libro.isDisponible()) {
            System.out.println("El libro ya esta prestado.");
            return;
        }

        if (!usuario.agregarPrestamo(libro)) {
            System.out.println("El usuario ya tiene 3 libros prestados.");
            return;
        }

        libro.marcarPrestado();
        Date fechaInicio = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaInicio);
        cal.add(Calendar.DATE, 7);
        Date fechaLimite = cal.getTime();

        Prestamo prestamo = new Prestamo(libro, usuario, fechaInicio, fechaLimite);
        registroPrestamos.put(libro.getCodigo(), prestamo);

        
        System.out.println("Libro prestado con exito. Fecha limite: " + fechaLimite);
    }

    public void devolverLibro(String codigo, String idUsuario) {
        Prestamo prestamo = registroPrestamos.get(codigo);
        if (prestamo == null) {
            System.out.println("No se encontró el prestamo.");
            return;
        }

        Libro libro = prestamo.getLibro();
        Usuario usuario = prestamo.getUsuario();

        if (!usuario.getIdUsuario().equals(idUsuario)) {
            System.out.println("Este usuario no tiene ese libro prestado.");
            return;
        }

        libro.marcarDisponible();
        usuario.devolverLibro(libro);

        Date hoy = new Date();
        long diasRetraso = (hoy.getTime() - prestamo.getFechaLimite().getTime()) / (1000 * 60 * 60 * 24);

        if (diasRetraso > 0) {
            long multa = diasRetraso * 500;
            System.out.println("El libro se devolvio con " + diasRetraso +
                    " dias de retraso. Multa: $" + multa);
        } else {
            System.out.println("Libro devuelto a tiempo, sin multa.");
        }

        registroPrestamos.remove(codigo);
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles:");
        for (Libro l : listaLibros) {
            if (l.isDisponible()) l.mostrarDatos();
        }
    }

    public void mostrarUsuarios() {
        System.out.println("Usuarios registrados:");
        for (Usuario u : listaUsuarios) {
            u.mostrarDatos();
        }
    }

    public void mostrarHistorialPrestamos() {
        System.out.println("Historial de prestamos activos:");
        for (Prestamo p : registroPrestamos.values()) {
            p.mostrarDatos();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcion;
        do {
            System.out.println("\n    MENU    ");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Mostrar libros disponibles");
            System.out.println("6. Mostrar usuarios");
            System.out.println("7. Mostrar historial de prestamos");
            System.out.println("0. Salir");
            System.out.print("Elija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Codigo: ");
                    String codigo = sc.nextLine();
                    biblioteca.registrarLibro(titulo, autor, codigo);
                }
                case 2 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("ID Usuario: ");
                    String id = sc.nextLine();
                    biblioteca.registrarUsuario(nombre, id);
                }
                case 3 -> {
                    System.out.print("Codigo del libro: ");
                    String codigo = sc.nextLine();
                    System.out.print("ID Usuario: ");
                    String id = sc.nextLine();
                    biblioteca.prestarLibro(codigo, id);
                }
                case 4 -> {
                    System.out.print("Codigo del libro: ");
                    String codigo = sc.nextLine();
                    System.out.print("ID Usuario: ");
                    String id = sc.nextLine();
                    biblioteca.devolverLibro(codigo, id);
                }
                case 5 -> biblioteca.mostrarLibrosDisponibles();
                case 6 -> biblioteca.mostrarUsuarios();
                case 7 -> biblioteca.mostrarHistorialPrestamos();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
