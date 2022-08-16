import java.io. * ;
import java.util.Scanner;

import javax.swing.*;

public class Main extends JFrame{
	static double[][] set;
	static int[] set_label;

	public static void main(String[] args) throws FileNotFoundException{
		set = load_mnist(50);
		set_label = load_mnist_label(50);
		//MyFrame x = new MyFrame(set,set_label);

		int[] size_nn = {784, 16, 10};
		double[] input = new double[784];
		int label = 0;

		for(int i = 0; i<set[0].length; i++){
			input[i] = set[1][i];
			label = set_label[1];
		}
		NN neural = new NN(size_nn);
		double [] out = neural.CalcOut(input, label);
		
	}



	//mnist dataset wird von .csv datei auf 3D array übertragen
	public static double[][] load_mnist(int data) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("../data/mnist_train.csv"));
		sc.useDelimiter(",");
		//mnist[Id][Data]
		double[][] mnist = new double[data][784];

		for(int i = 0; i<mnist.length; i++){
			sc.next();			//index column wird geskippt
			for (int j = 0; j<784; j++) {
				String x = sc.next();
				if (isNumeric(x)) {
					int val = Integer.valueOf(x);
					mnist[i][j] = val/255.0;	
					System.out.println(mnist[i][j]);
				}	
			}
		}
		sc.close();

		return mnist;	
	}

	//mnist dataset labels werden von .csv datei auf array übertragen
	public static int[] load_mnist_label(int data) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("../data/mnist_train.csv"));
		sc.useDelimiter(",");
		int pixels = 784;
		int[] label = new int[data];

		for (int i = 0; i<label.length; i++) {
			label[i] = Integer.valueOf(sc.next());
			for (int j = 0; j<pixels; j++) {
				sc.next();		
			}
		}
		sc.close();

		return label;
	}

	private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
   }
}