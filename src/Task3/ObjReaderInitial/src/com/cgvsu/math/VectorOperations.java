package Task3.ObjReaderInitial.src.com.cgvsu.math;

import static java.lang.Math.sqrt;

public class VectorOperations {

    public static Vector3f calculateVector(Vector3f vertex_1, Vector3f vertex_2) {
        return new Vector3f(vertex_2.getX() - vertex_1.getX(), vertex_2.getY() - vertex_1.getY(),
                vertex_2.getZ() - vertex_1.getZ());
    }

    // Возвращает вектор, перпендикулярный двум переданным векторам (плоскости)
    public static Vector3f calculateCrossVector(Vector3f vVector1, Vector3f vVector2) {
        float x = ((vVector1.getY() * vVector2.getZ()) - (vVector1.getZ() * vVector2.getY()));
        float y = ((vVector2.getZ() * vVector1.getX()) - (vVector2.getX() * vVector1.getZ()));
        float z = ((vVector1.getX() * vVector2.getY()) - (vVector1.getY() * vVector2.getX()));
        return new Vector3f(x, y, z);
    }


    // Возвращает нормализованный вектор (его длина становится равной 1)
    public static Vector3f normalizeVector(Vector3f vNormal) {
        Vector3f newV = new Vector3f(0, 0, 0);
        float m = calculateMagnitude(vNormal);
        newV.setX(vNormal.getX() / m);
        newV.setY(vNormal.getY() / m);
        newV.setZ(vNormal.getZ() / m);

        return newV;
    }

    private static float calculateMagnitude(Vector3f vNormal)
    {
        return (float)sqrt( (vNormal.getX() * vNormal.getX()) +
                (vNormal.getY() * vNormal.getY()) +
                (vNormal.getZ() * vNormal.getZ()) );
    }

    public static Vector3f calculateSumOfVectors(Vector3f vector_1, Vector3f vector_2) {
        return new Vector3f(vector_1.getX() + vector_2.getX(),
                vector_1.getY() + vector_2.getY(),
                vector_1.getZ() + vector_2.getZ());
    }

    public static Vector3f divideVectorByNumber(Vector3f vector, int num) {
        return new Vector3f(vector.getX() / num,
                vector.getY() / num,
                vector.getZ() / num);
    }

}
