import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileManager {
	
	private String datasetPath = "animale.csv";

	// Read input dataset and return a list of Points
	public ArrayList<Point> readDataset() {
		ArrayList<Point> result = new ArrayList<Point>();
		
		try {
			FileReader fr = new FileReader(datasetPath);
			BufferedReader br = new BufferedReader(fr);
		
			String currentLine;
			boolean FirstRow = false;
			while((currentLine = br.readLine()) != null) {
				// Skip first row (header)
				if(!FirstRow) 				{
					FirstRow = true;
					continue;
				}
				Point p = new Point(currentLine);
				result.add(p);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Collections.shuffle(result); 
		return result;
	}

	// Write output dataset with clusterized info in column named "LABEL"
	public void writeDataset(ArrayList<Point> dataset) {
		final String firstRow = "animal,id,time,x,y,LABEL";
		final String outputFile = "animaleOut.csv";
		
		try {
				FileWriter fw = new FileWriter(new File(outputFile));
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write(firstRow);
				bw.newLine();
				for(Point p : dataset) {
					bw.write(p.toString());
					bw.newLine();
				}
				
				bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}