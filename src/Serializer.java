import java.io.*;
import java.util.Arrays;

public class Serializer {
    public static void main(String[] args) {
        int[] array = new int[200];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 999);
        }
        WriteArray.writeArray(array);
        ReadArray.readArray();
    }

    public static class WriteArray {
        public static void writeArray(int[] array) {
            try {
                FileOutputStream fos = new FileOutputStream("array.bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(array);
                oos.close();
                System.out.println("Массив чисел сериализован.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

     public static class ReadArray {
        public static void readArray()  {
            try {
                FileInputStream fis = new FileInputStream("array.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);
                int[] array = (int[]) ois.readObject();
                System.out.println("Массив чисел десериализован :");
                System.out.println(Arrays.toString(array));
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
