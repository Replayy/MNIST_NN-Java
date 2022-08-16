import java.util.Random;
import java.lang.*;


public class Layer{
	private int in, out;
	private double[][] weights;
	private double[] biases;
 
 	//Layer mit rndm weights und biases auf 0
	public Layer(int nIn, int nOut){
		in = nIn;
		out = nOut;
		weights = new double [in][out];
		rndmWeight();
		biases = new double[out];
		for(int i = 0; i<out; i++){
			biases[i] = 0;
		}
	}

	//Berechnung eines Layers
	public double[] CalcOut(double[] input){
		double[] activation = new double[out];
		for(int i = 0; i<out; i++){
			double output = biases[i];
			for(int j = 0; j<in; j++){
				output += input[j]*weights[j][i];
			}
			activation[i] = sigmoid(output);
		}
		return activation;
	}

	public double sigmoid(double in){
		return 1/(1+ Math.exp(-in));
	}


	public void rndmWeight(){
		Random rng = new Random();
		for(int i = 0; i<in; i++){
			for(int j = 0; j<out; j++){
				weights[i][j] = rng.nextDouble(2) - 1;
			}
		}
	}
}