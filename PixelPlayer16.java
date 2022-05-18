import java.awt.*;
import java.util.Random;

public class PixelPlayer16 extends Player {
	PixelPlayer16(int[][] map) {  //이 생성자 이름은 자신의 클래스명과 동일하게 변경할 것
		super(map);
	}

	public Point nextPosition(Point lastPosition) {  
		int x = (int)lastPosition.getX(), y = (int)lastPosition.getY();
		int cx = (int)currentPosition.getX(), cy = (int)currentPosition.getY();
		int direction, count = 0;
		int myNum = map[(int)currentPosition.getX()][(int)currentPosition.getY()];
		int checkPositionX;
		int checkPositionY;
		int danger1, danger2; // 위험요인 변수
		int attack1, attack2; // 공격 변수
		Point nextPosition;
		Random random = new Random();
    

		for( int n = 0; n < 8; n++ )
		{
			for( int m = 0; m < 8; m++ )
			{
				if( myNum == map[n][m] )
				{
					for(int i = 0; i < PixelTester.SIZE_OF_BOARD; i++)
					{
					  attack1 = 0;
					  danger1 = 0;
					  
					  // 가로 공격 (선공일땐 방어)
					  if ( map[i][y] == 1 && ( i == n || y == m)) {
					    if (i < 7 && (map[i+1][y] == 1)) {
					        attack1++; // 자신의 돌이 있다면 attack 지수 증가
					        }
					    if (i < 7 && (map[i+1][y] == 2)) {
					        attack1--; // 상대의 돌이 있다면 attack 지수 하락
					        }   
					    }
					  
					  // attack 지수가 1이상이면서
					  if (attack1 >= 0) {
					     if (i > 0 && map[i-1][y] == 0) { // 옆의 좌표에 돌이 없다면 돌을 둔다.
					       nextPosition = new Point(i-1, y);
							System.out.println(nextPosition); //
							return nextPosition;					       
					    }
					    else if (i < 7 && map[i+1][y] == 0) {
					      nextPosition = new Point (i+1,y);
					      System.out.println(nextPosition);
							  return nextPosition;
							  }
							}
					  
					  
					  // 위험지수 (선공일땐 공격)
					  // 상대의 돌을 발견하고 지수를 검사해서 해결
					  if ( map[i][y] == 2 && ( i == n || y == m)) {
					    if (i < 7 && (map[i+1][y] == 2)) { // 상대의 돌이 있다면 위험지수 증가
					        danger1++;
					        }
					    if (i < 7 && (map[i+1][y] == 1)) { // 자신의 돌이 있다면 위험지수 하락
					        danger1--;
					        }   
					    }
					  
					  if (danger1 >= 0) {
					     if (i > 0 && map[i-1][y] == 0) {
					       nextPosition = new Point(i-1, y);
							System.out.println(nextPosition);
							return nextPosition;					       
					    }
					    else if (i < 7 && map[i+1][y] == 0) {
					      nextPosition = new Point (i+1,y);
					      System.out.println(nextPosition);
							  return nextPosition;
							  }
							}
					}
					
					
					for(int i = 0; i < PixelTester.SIZE_OF_BOARD; i++)
					{
					  attack2 = 0;
					   danger2 = 0;
					   // 세로 공격(선공일땐 방어)
					   if ( map[x][i] == 1 && ( i == n || y == m)) { // 자신의 돌이 있다면 attack 증가
					    if (i < 7 && (map[x][i+1] == 1)) {
					        attack2++;
					        }
					  if (i < 7 && (map[x][i+1] == 2)) { // 상대의 돌이 있다면 attack 감소
					        attack2--;
					        }        
					    }
					  
					  if (attack2 >= 0) {
					     if (i > 0 && map[x][i-1] == 0) {
					       nextPosition = new Point(x, i-1);
							System.out.println(nextPosition);
							return nextPosition;					       
					    }
					    else if (i < 7 && map[x][i+1] == 0) {
					      nextPosition = new Point (x, i+1);
					      System.out.println(nextPosition);
							  return nextPosition;
							  }
							} 
					   
					   // 세로 방어(선공일땐 공격)
					  if ( map[x][i] == 2 && ( i == n || y == m)) {
					    if (i < 7 && (map[x][i+1] == 2)) { // 상대의 돌이 있다면 위험지수 증가
					        danger2++;
					        }
					  if (i < 7 && (map[x][i+1] == 1)) {  // 자신의 돌이 있다면 위험지수 감소
					        danger2--;
					        }        
					    }
					  
					  if (danger2 >= 0) {
					     if (i > 0 && map[x][i-1] == 0) {
					       nextPosition = new Point(x, i-1);
							System.out.println(nextPosition);
							return nextPosition;					       
					    }
					    else if (i < 7 && map[x][i+1] == 0) {
					      nextPosition = new Point (x, i+1);
					      System.out.println(nextPosition);
							  return nextPosition;
							  }
							}
						
					}
				}
			}
		}

		nextPosition = new Point(x, y);
		return nextPosition;
	}
}