import java.util.List;

public class S120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int height = triangle.size();
		for (int i = 1; i != height; i++)
		{
			int width = triangle.get(i).size();
			triangle.get(i).set(0, triangle.get(i - 1).get(0) + triangle.get(i).get(0));
			triangle.get(i).set(width - 1, triangle.get(i - 1).get(width - 2) + triangle.get(i).get(width - 1));
			for (int j = 1; j != width - 1; j++)
				triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
		}
		int ans = Integer.MAX_VALUE;
		int width = triangle.get(height - 1).size();
		for (int j = 0; j != width; j++)
			if (triangle.get(height - 1).get(j) < ans)
				ans = triangle.get(height - 1).get(j);
		return ans;
	}
}
