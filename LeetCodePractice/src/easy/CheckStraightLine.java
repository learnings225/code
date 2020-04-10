package easy;

/**
 * TODO need to fully implement
 * 
 * @author srimeda
 *
 */
public class CheckStraightLine {
	public static boolean checkStraightLine(int[][] coordinates) {
        for(int i=0; i < coordinates.length-1; i++) {
            for(int j=0; j < coordinates[0].length-1; j++) {
                if(coordinates[i+1][j] - coordinates[i][j]  != coordinates[i+1][j+1] - coordinates[i][j+1]) {
                    return false;
                }
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
		System.out.println(checkStraightLine(coordinates));
	}
}
