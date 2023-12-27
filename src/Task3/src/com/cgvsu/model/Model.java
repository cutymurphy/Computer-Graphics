package Task3.src.com.cgvsu.model;

import Task3.src.com.cgvsu.math.Vector2f;
import Task3.src.com.cgvsu.math.Vector3f;
import Task3.src.com.cgvsu.math.VectorOperations;

import java.util.ArrayList;

public class Model {

    public ArrayList<Vector3f> vertices = new ArrayList<>();
    public ArrayList<Vector2f> textureVertices = new ArrayList<>();
    public ArrayList<Vector3f> normals = new ArrayList<>();
    public ArrayList<Polygon> polygons = new ArrayList<>();
    public ArrayList<Vector3f> normalsForPolygons = new ArrayList<>();

    public void calculateNormalsForVertexes() {
        calculateNormalsForPolygons();

        for (int i = 0; i < vertices.size(); i++) {
            Vector3f sumOfVectors = new Vector3f(0, 0, 0);
            int num = 0;

            for (int j = 0; j < polygons.size(); j++) {
                Polygon currPolygon = polygons.get(j);
                ArrayList<Integer> vertexIndexes = currPolygon.getVertexIndices();

                if (vertexIndexes.contains(i)) {

                    sumOfVectors = VectorOperations.calculateSumOfVectors(sumOfVectors, normalsForPolygons.get(j));
                    num += 1;
                }
            }
            Vector3f normalForVertex = VectorOperations.divideVectorByNumber(sumOfVectors, num);
            Vector3f normalizeVector = VectorOperations.normalizeVector(normalForVertex);

            normals.add(i, normalizeVector);
        }
    }

    public void calculateNormalsForPolygons() {

        for (int i = 0; i < polygons.size(); i++) {
            Polygon polygon = polygons.get(i);
            ArrayList<Integer> vertexes = polygon.getVertexIndices();

            //берем 3 вершины полигона
            Vector3f vertex_1 = vertices.get(vertexes.get(0));
            Vector3f vertex_2 = vertices.get(vertexes.get(1));
            Vector3f vertex_3 = vertices.get(vertexes.get(2));

            //вычисляем 2 вектора
            Vector3f vector_1 = VectorOperations.calculateVector(vertex_2, vertex_1);
            Vector3f vector_2 = VectorOperations.calculateVector(vertex_2, vertex_3);

            //вычисляем векторное произведение двух векторов
            Vector3f crossVector = VectorOperations.calculateCrossVector(vector_2, vector_1);

            //добавляем в список нормализованный вектор к полигону
            normalsForPolygons.add(i, VectorOperations.normalizeVector(crossVector));
        }
    }

}
