package Fight;

public class ContainerWithMostWater {

	// time exceed
	public int maxArea(int[] height) {
		int max = 0;

		for (int i = 0; i <= height.length - 2; i++) {
			for (int j = i + 1; j <= height.length - 1; j++) {
				int tmpArea = Math.min(height[i], height[j]) * (j - i);
				if (tmpArea > max) {
					max = tmpArea;
				}
			}
		}

		return max;
	}

	// Min(ai,aj)*(j-i),得到在i左边，任何一个值都小于ai;在j右边，任何一个值都小于aj

	// 解法：因为只能为整数,因此只要有更大的height,就可以替换(差值必须大于x的减少值)
	public int maxArea2(int[] height) {
		int max = 0;
		int i = 0;
		int j = height.length - 1;

		while (i < j) {
			max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
