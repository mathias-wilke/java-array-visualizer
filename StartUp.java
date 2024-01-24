
public class StartUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayVisualizer visualizer = new ArrayVisualizer(800, 800);

		visualizer.setVisible(true);

        // Testen der drawIntArray-Methode
        int[] intArray = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        visualizer.drawIntArray(intArray);

        // Warten für 2 Sekunden, bevor das boolArray gezeichnet wird
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Testen der drawBoolArray-Methode
        boolean[][] boolArray = {
            {true, false, true},
            {false, true, false},
            {true, false, true}
        };
        visualizer.drawBoolArray(boolArray);
	}

}
