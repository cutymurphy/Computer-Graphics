package Task3.ObjReaderInitial.src.com.cgvsu;

import Task3.ObjReaderInitial.src.com.cgvsu.math.Vector3f;
import Task3.ObjReaderInitial.src.com.cgvsu.model.Model;
import Task3.ObjReaderInitial.src.com.cgvsu.objreader.ObjReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        Path fileName = Path.of("src/Task3/ObjReaderInitial/obj_files/square.obj");
        String fileContent = Files.readString(fileName);

        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);

        model.calculateNormalsForVertexes();

        System.out.println("Vertices: " + model.vertices.size());
        System.out.println("Texture vertices: " + model.textureVertices.size());
        System.out.println("Normals: " + model.normals.size());
        System.out.println("Polygons: " + model.polygons.size());
        System.out.println("Normals for Polygons: " + model.normalsForPolygons.size());

        System.out.println();
        System.out.println("Normals for vertexes: ");
        for (int i = 0; i < model.vertices.size(); i++) {
            Vector3f v = model.vertices.get(i);
            Vector3f n = model.normals.get(i);

            System.out.println(v.getX() + " " + v.getY() + " " + v.getZ());
            System.out.println(n.getX() + " " + n.getY() + " " + n.getZ());
            System.out.println();
        }
    }
}
