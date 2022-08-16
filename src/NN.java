import java.lang.*;

public class NN{
	private Layer[] layers;

	//size -> [input, hidden, out]
	public NN(int[] size){
		layers = new Layer[size.length - 1];
		for(int i = 0; i < layers.length; i++){
			layers[i] = new Layer(size[i],size[i+1]);
		}
	}


	//Forward Propagation
	public double[] CalcOut(double[] input, int label){
		for(Layer layer : layers){
			input = layer.CalcOut(input);
		}
		double[] output = softmax(input);

		for (int i = 0; i<output.length; i++) {
			System.out.println(i+": "+output[i]);	
		}

		System.out.println("Expected: "+label);

		double loss = cross_entropy(output, label);
		System.out.println("Loss: " +loss);
		
		return output;
	}

	//softmax -> e^(input)/sum(e^(inputs))
	public double[] softmax(double[]input){
		double total = 0.0;
		double[] output = new double[input.length];
		for(int i = 0; i<input.length; i++){
			total += Math.exp(input[i]);
		}

		for(int j = 0; j<input.length; j++){
			output[j] = Math.exp(input[j])/total;
		}
		return output;
	}

	//moeglichkeit von CEL, wenn immer nur ein neuron feuern soll
	//ref:https://gombru.github.io/2018/05/23/cross_entropy_loss/
	public double cross_entropy(double[] input, int expected){
		double output = input[expected];
		return -Math.log(output);
	}


	////Multi Class Cross-Entropy loss (Eigentliche Formel)
	// public double xcross_entropy(double[] input, int expected){
	// 	double output = 0.0;
	// 	for(int i = 0; i<input.length; i++){
	// 		if (expected == i) {
	// 			output += -(1*Math.log(input[i]));
	// 		}
	// 		else{
	// 			output += -(0*Math.log(input[i]));
	// 		}
	// 	}
	// 	return output;
	// }

}