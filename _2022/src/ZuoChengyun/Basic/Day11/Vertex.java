package ZuoChengyun.Basic.Day11;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    public int name;
    public int in;
    public int out;
    public List<Edge> edges;
    public List<Vertex> next;

    public Vertex(int name) {
        this.name = name;
        in = 0;
        out = 0;
        edges = new ArrayList<>();
        next = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
