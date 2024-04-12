public class SimpleNeuralNetwork {

    private double[][] weights;
    private double[] biases;

    public SimpleNeuralNetwork(int numInputs, int numHiddenNeurons, int numOutputs) {
        this.weights = new double[numHiddenNeurons][numInputs];
        this.biases = new double[numHiddenNeurons];

        // Произвольно инициализируйте веса и смещения
        for (int i = 0; i < numHiddenNeurons; i++) {
            biases[i] = Math.random();
            for (int j = 0; j < numInputs; j++) {
                weights[i][j] = Math.random();
            }
        }
    }

    public double[] feedForward(double[] inputs) {
        double[] hiddenLayerOutputs = new double[weights.length];

        // Вычисление выходных данных скрытого слоя
        for (int i = 0; i < weights.length; i++) {
            double sum = biases[i];
            for (int j = 0; j < weights[i].length; j++) {
                sum += weights[i][j] * inputs[j];
            }
            hiddenLayerOutputs[i] = activate(sum);
        }

        return hiddenLayerOutputs;
    }

    private double activate(double sum) {
        // Sigmoid activation function
        return 1 / (1 + Math.exp(-sum));
    }

    public void train(double[] inputs, double learningRate) {
        // Алгоритм обучения - обратное распростронение
    }

    public static void main(String[] args) {
        int numInputs = 2;
        int numHiddenNeurons = 3;
        int numOutputs = 1;

        SimpleNeuralNetwork nn = new SimpleNeuralNetwork(numInputs, numHiddenNeurons, numOutputs);

        // Пример ввода
        double[] input = {0.5, 0.3};

        // Процесс прямой связи
        double[] output = nn.feedForward(input);

        // Обучающий процесс
        double learningRate = 0.1;
        nn.train(input, learningRate);

        // Вывод после обучения
        double[] newOutput = nn.feedForward(input);
        System.out.println("Output after training: " + newOutput[0]);
    }
}
