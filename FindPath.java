package DFSearch;

import java.util.Scanner;

public class FindPath {
	//人质所在迷宫的位置
	static int fx,fy;
	//迷宫为5*5
	static int n=5;
	//上下左右移动
	static int[][] temp ={{0,1},{1,0},{0,-1},{-1,0}};
	//迷宫数组
	static int [][] squera = new int [n][n];
	//标记数组，走过就标记为1
	static int [][] book = new int [n][n];
	//最短步数
	static int min = 9999999;
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scan  = new Scanner(System.in);
		
		System.out.println("请输入迷宫5*5：");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				squera[i][j] = scan.nextInt();
			}
		}
		System.out.println("请输入人质所在位置：");
		fx = scan.nextInt();
		fy = scan.nextInt();
		book[0][0] = 1;
		dfs(0,0,0);
		System.out.println("最少需要走："+min+"步");
		/*for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(book[i][j]==1){
					System.out.println("<"+i+","+j+">->");
				}
			}
		}*/
	}
	public static void dfs(int x,int y,int step){
		//如果到达地点，结束
		if(x==fx&&y==fy){
			if(step<min){
				min = step;
			}
			return;
		}
		//循环移动到四个方向
		for(int i=0;i<4;i++){
			int tx = temp[i][0];
			int ty = temp[i][1];
			//如果该方向越界了，改变到另一个方向
			if(x+tx<0||x+tx>=n)
				continue;
			if(y+ty<0||y+ty>=n)
				continue;
			//如果该位置没有障碍物并且也没有走过，走
			if(squera[x+tx][y+ty]==0 && book[x+tx][y+ty]==0){
					//标记为走过
					book[x+tx][y+ty] = 1;
					//搜索过程
					//System.out.println(""+(x+tx)+","+(y+ty)+"->");
					//往下一层递归
					dfs(x+tx,y+ty,step+1);
					//取消标记，回到上一层
					book[x+tx][y+ty] = 0;
				}
			}
		return;
	}
}
