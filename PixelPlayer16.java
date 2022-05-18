import java.awt.*;
import java.util.Random;

public class PixelPlayer16 extends Player {
	PixelPlayer16(int[][] map) {  //�� ������ �̸��� �ڽ��� Ŭ������� �����ϰ� ������ ��
		super(map);
	}

	public Point nextPosition(Point lastPosition) {  
		int x = (int)lastPosition.getX(), y = (int)lastPosition.getY();
		int cx = (int)currentPosition.getX(), cy = (int)currentPosition.getY();
		int direction, count = 0;
		int myNum = map[(int)currentPosition.getX()][(int)currentPosition.getY()];
		int checkPositionX;
		int checkPositionY;
		int danger1, danger2; // ������� ����
		int attack1, attack2; // ���� ����
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
					  
					  // ���� ���� (�����϶� ���)
					  if ( map[i][y] == 1 && ( i == n || y == m)) {
					    if (i < 7 && (map[i+1][y] == 1)) {
					        attack1++; // �ڽ��� ���� �ִٸ� attack ���� ����
					        }
					    if (i < 7 && (map[i+1][y] == 2)) {
					        attack1--; // ����� ���� �ִٸ� attack ���� �϶�
					        }   
					    }
					  
					  // attack ������ 1�̻��̸鼭
					  if (attack1 >= 0) {
					     if (i > 0 && map[i-1][y] == 0) { // ���� ��ǥ�� ���� ���ٸ� ���� �д�.
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
					  
					  
					  // �������� (�����϶� ����)
					  // ����� ���� �߰��ϰ� ������ �˻��ؼ� �ذ�
					  if ( map[i][y] == 2 && ( i == n || y == m)) {
					    if (i < 7 && (map[i+1][y] == 2)) { // ����� ���� �ִٸ� �������� ����
					        danger1++;
					        }
					    if (i < 7 && (map[i+1][y] == 1)) { // �ڽ��� ���� �ִٸ� �������� �϶�
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
					   // ���� ����(�����϶� ���)
					   if ( map[x][i] == 1 && ( i == n || y == m)) { // �ڽ��� ���� �ִٸ� attack ����
					    if (i < 7 && (map[x][i+1] == 1)) {
					        attack2++;
					        }
					  if (i < 7 && (map[x][i+1] == 2)) { // ����� ���� �ִٸ� attack ����
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
					   
					   // ���� ���(�����϶� ����)
					  if ( map[x][i] == 2 && ( i == n || y == m)) {
					    if (i < 7 && (map[x][i+1] == 2)) { // ����� ���� �ִٸ� �������� ����
					        danger2++;
					        }
					  if (i < 7 && (map[x][i+1] == 1)) {  // �ڽ��� ���� �ִٸ� �������� ����
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